package com.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.model.Evenement.*;

public class Billeterie {
	private static HashMap<Integer, Evenement> evenements;
	private HashMap<Integer, Double> reduction;
	private static Billeterie instance = null;

	private Billeterie() {
		evenements = new HashMap<Integer, Evenement>();
		reduction = new HashMap<Integer, Double>();
	}

	/**
	 * 
	 * Point d'accès pour l'instance unique du singleton
	 */
	public static synchronized Billeterie getInstance() {
		if (instance == null) {
			instance = new Billeterie();
		}
		return instance;
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

	public void supprimerEvenement(int idEv) {
		evenements.remove(idEv);
	}

	public HashMap<Integer, Double> getReduction() {
		return reduction;
	}

	public void setReduction(HashMap<Integer, Double> reduction) {
		this.reduction = reduction;
	}

	private boolean myContains(Object[] tab, Object o) {
		for (int i = 0; i < tab.length; i++)
			if (tab[i].equals(o))
				return true;
		return false;
	}

	public void acheterPlace(Reservation reservation) throws Exception {
		if(!reservation.validerReservation())
			throw new Exception("Reservation non valide");
		
		Reservation_BD rBD = Reservation_BD.getInstance();
		rBD.ajouterResa(reservation);
	}
}
