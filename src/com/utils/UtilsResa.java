package com.utils;

import java.util.ArrayList;

import com.model.Billeterie;
import com.model.Escalier;
import com.model.Orientation;
import com.model.Place;
import com.model.Rang;
import com.model.Stade_Impl;
import com.model.Evenement.Evenement;

public class UtilsResa {

	private Billeterie listeEvent = Billeterie.getInstance();
	private Stade_Impl stade = Stade_Impl.getInstance();

	public Evenement getEvt(long id) {
		for (Evenement evt : listeEvent.getAllEvenements()) {
			if (evt.getDate().getTime() == id) {
				return evt;
			}
		}
		return null;
	}

	public String[] getOrientation(long id) {
		return getEvt(id).getOrientationAccessibles();
	}

	public ArrayList<Escalier> getEscalier(long id, String orientation) {
		Evenement evt = getEvt(id);
		for (Orientation o : evt.getStade().getOrientations()) {
			if (o.getNom().equals(orientation)) {
				return o.getEscalier();
			}
		}
		return null;
	}

	public ArrayList<Rang> getRang(long id, String orient, String escalier) {
		ArrayList<Escalier> esc = getEscalier(id, orient);
		for (Escalier e : esc) {
			if (e.getNomEsc().equals(escalier)) {
				return e.getRang();
			}
		}
		return null;
	}

	public ArrayList<Place> getPlace(long id, String orient, String escalier, int rang) {
		ArrayList<Rang> rangs = getRang(id, orient, escalier);
		for (Rang r : rangs) {
			if (r.getNumeroRang() == rang) {
				return r.getPlaces();
			}
		}
		return null;
	}

	public ArrayList<Place> getPlaceLibre(ArrayList<Place> places) {
		ArrayList<Place> PlaceLibre= new ArrayList<>();
		for (Place p : places) {
			if (p.isEstLibre()) {
				PlaceLibre.add(p);
			}
		}
		return PlaceLibre;
	}

}
