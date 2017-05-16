package com.model;

import java.util.HashMap;

public class Billeterie {
	private Stade_Impl stade;
	private HashMap<Integer, Event> events;
	private HashMap<Integer, Double> reduction;
	
	public Billeterie(){
		setStade(new Stade_Impl());
		events = new HashMap<Integer, Event>();
	}
	
	public double acheterPlace(int idEvent, String idCat, int idReduction){
		double prixPlace = events.get((Integer)idEvent).getPrixCat(idCat) * reduction.get((Integer)idReduction);
		return prixPlace;
	}

	public Stade_Impl getStade() {
		return stade;
	}

	public void setStade(Stade_Impl stade) {
		this.stade = stade;
	}
}
