package com.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.model.Evenement.*;

public class Billeterie {
	private static Stade_Impl stade;
	private static HashMap<Integer, Evenement> evenements;
	private HashMap<Integer, Double> reduction;

	public Billeterie() {
		setStade(new Stade_Impl());
		evenements = new HashMap<Integer, Evenement>();
	}

	public double acheterPlace(int idEvent, String idCat, int idReduction) {
		double prixPlace = evenements.get((Integer) idEvent).getPrixCat(idCat) * reduction.get((Integer) idReduction);
		return prixPlace;
	}

	public Stade_Impl getStade() {
		return stade;
	}

	public void setStade(Stade_Impl stade) {
		this.stade = stade;
	}

	public static ArrayList<Evenement> getAllEvenements() {
		ArrayList<Evenement> events = new ArrayList<Evenement>();
		for (Evenement ev : evenements.values())
			events.add(ev);

		return events;
	}

	public static HashMap<Integer, Evenement> getEvenements() {
		return evenements;
	}

	public static ArrayList<Place> getPlacesLibre(Evenement ev) {
		ArrayList<Place> res = new ArrayList<Place>();

		for (Orientation o : stade.getOrientations()) {
			res.addAll(getPlacesLibre(ev, o.getNom()));
		}
		return res;
	}

	public static ArrayList<Place> getPlacesLibre(Evenement ev, String idOrientation) {
		ArrayList<Place> res = new ArrayList<Place>();
		int index = stade.getOrientations().indexOf(idOrientation);
		for (Escalier e : stade.getOrientations().get(index).getEscalier().values()) {
			if (myContains(ev.getOrientationAccessibles(), idOrientation)) {
				res.addAll(getPlacesLibre(ev, idOrientation, e.getNomEsc()));
			}
		}
		return res;
	}

	public static ArrayList<Place> getPlacesLibre(Evenement ev, String idOrientation, String idEscalier) {
		ArrayList<Place> res = new ArrayList<Place>();
		int index = stade.getOrientations().indexOf(idOrientation);
		for (Rang r : stade.getOrientations().get(index).getEscalier().get(idEscalier).getRang().values()) {
			if (myContains(ev.getOrientationAccessibles(), idOrientation)) {
				res.addAll(getPlacesLibre(ev, idOrientation, idEscalier, r.getNumeroRang()));
			}
		}
		return res;
	}

	public static ArrayList<Place> getPlacesLibre(Evenement ev, String idOrientation, String idEscalier, int idRang) {
		ArrayList<Place> res = new ArrayList<Place>();
		int index = stade.getOrientations().indexOf(idOrientation);
		for (Place p : stade.getOrientations().get(index).getEscalier().get(idEscalier).getRang().get(idRang)
				.getPlaces().values()) {
			if (myContains(ev.getOrientationAccessibles(), idOrientation) && p.isEstLibre()) {
				res.add(p);
			}
		}
		return res;
	}

	private static boolean myContains(String[] op1, String op2) {
		for (int i = 0; i < op1.length; i++)
			if (op1[i].equals(op2))
				return true;

		return false;
	}

}
