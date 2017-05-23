package com.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

import com.model.Evenement.*;

public class Billeterie {
	private static HashMap<Integer, Evenement> evenements;
	private HashMap<Integer, Double> reduction;

	public Billeterie() {
		evenements = new HashMap<Integer, Evenement>();
	}

	public static ArrayList<Evenement> getAllEvenements() {
		ArrayList<Evenement> events = new ArrayList<Evenement>();
		for (Evenement ev : evenements.values())
			events.add(ev);

		return events;
	}

	public HashMap<Integer, Evenement> getEvenements() {
		return evenements;
	}

	public Evenement getEvenement(String nomEv) {
		for (Evenement e : evenements.values())
			if (e.getNomEv().equals(nomEv))
				return e;
		return null;
	}

	public Evenement getEvenement(int idEv) {
		return evenements.get(idEv);
	}

	public ArrayList<Place> getPlacesLibre(Evenement ev) {
		return ev.getPlacesLibre();
	}

	public ArrayList<Place> getPlacesLibre(Evenement ev, String idOrientation) {
		return ev.getPlacesLibre(idOrientation);
	}

	public ArrayList<Place> getPlacesLibre(Evenement ev, String idOrientation, String idEscalier) {
		return ev.getPlacesLibre(idOrientation, idEscalier);
	}

	public ArrayList<Place> getPlacesLibre(Evenement ev, String idOrientation, String idEscalier, int idRang) {
		return ev.getPlacesLibre(idOrientation, idEscalier, idRang);
	}

	public void creerSport(String nomEv, String date, HashMap<String, Double> tarif) throws ParseException {
		evenements.put(evenements.size(), new Sport(nomEv, date, tarif));
	}

	public void creerMusique(String nomEv, String date, HashMap<String, Double> tarif) throws ParseException {
		evenements.put(evenements.size(), new Musique(nomEv, date, tarif));
	}

	public void supprimerEvenement(String nomEv) {
		for (Evenement e : evenements.values())
			if (e.getNomEv().equals(nomEv)) {
				evenements.values().remove(e);
				return;
			}
	}

	public void ajouterEvenement(Evenement ev) {
		Integer i = 0;
		while (evenements.containsKey(i))
			i++;
		evenements.put(i, ev);
	}

	public void supprimerEvenement(int idEv) {
		evenements.remove(idEv);
	}

	public HashMap<Integer, Double> getReduction() {
		return reduction;
	}

	public void setReduction(HashMap<Integer, Double> reduction) {
		this.reduction = reduction;
	}

	public void acheterPlace(Reservation reservation) throws Exception {
		/*if(!reservation.validerReservation())
			throw new Exception("Reservation non valide");
		*/
		Reservation_BD rBD = Reservation_BD.getInstance();
		rBD.ajouterResa(reservation);

		// Changement à faux de la balise de disponibilité pour chaque place réservée
		for(Billet b : reservation.getBillets().values()){
			/*for(Orientation o :	getEvenement(reservation.getNomEv()).getStade().getOrientations())
				if(o.getNom().equals(b.getOr().getNom()))
						for(Escalier e : o.getEscalier().values())
							if(e.getNomEsc().equals(b.getEsc().getNomEsc()))
								for(Rang r : e.getRang().values())
									if(r.getNumeroRang() == b.getRang().getNumeroRang())
										for(Place p : r.getPlaces().values())
											if(p.getNumero() == b.getPl().getNumero())
												p.setEstLibre(false);*/
			b.getPl().setEstLibre(false);
		}
	}
}
