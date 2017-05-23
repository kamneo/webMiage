package com.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

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
		for(Evenement e : evenements.values())
			if(e.getNomEv().equals(nomEv)){
				evenements.values().remove(e);
				return;
			}
	}
	
	public void acheterPlace(int idEvent, String idCat, int idReduction, Orientation or, Escalier esc, Rang r, Place p, String mailClient) throws Exception {
		// Vérifiaction que la place est toujours libre et si elle est accessible
		if(!p.isEstLibre() && myContains(evenements.get(idEvent).getCatAccessibles(), idCat) && myContains(evenements.get(idEvent).getOrientationAccessibles(), or.getNom()))
			throw new Exception("la place n'est pas disponible !");
		
		double prixPlace = evenements.get((Integer) idEvent).getPrixCat(idCat) * getReduction().get((Integer) idReduction);
		Billet b = new Billet(or, esc, r, p, prixPlace);
		p.setEstLibre(false);
		
		Reservation resa = new Reservation(evenements.get((Integer) idEvent).getNomEv(), b, mailClient);
		Reservation_BD rBD = Reservation_BD.getInstance();
		rBD.ajouterResa(resa);
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

	private boolean myContains(Object[] tab, Object o){
		for(int i = 0; i<tab.length; i++)
			if(tab[i].equals(o))
				return true;
		return false;
	}
}
