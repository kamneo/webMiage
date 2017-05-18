package com.model;

import java.util.ArrayList;
import java.text.ParseException;
import java.util.HashMap;

import com.model.Evenement.*;

public class Billeterie {
	private Stade_Impl stade;
	private static HashMap<Integer, Evenement> evenements;
	private HashMap<Integer, Double> reduction;
	
	public Billeterie(){
		setStade(new Stade_Impl());
		evenements = new HashMap<Integer, Evenement>();
	}
	
	public double acheterPlace(int idEvent, String idCat, int idReduction){
		double prixPlace = evenements.get((Integer)idEvent).getPrixCat(idCat) * reduction.get((Integer)idReduction);
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
		for(Evenement ev : evenements.values())
			events.add(ev);
		
		return events;
	}

	public static HashMap<Integer, Evenement> getEvenements() {
		return evenements;
	}
}
