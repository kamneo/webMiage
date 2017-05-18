package com.model;

import java.text.ParseException;
import java.util.HashMap;

import com.model.Evenement.Evenement;
import com.model.Evenement.Musique;
import com.model.Evenement.Sport;

public class Billeterie {
	private Stade_Impl stade;
	private HashMap<Integer, Evenement> evenements;
	private HashMap<String, Double> reduction;

	public Billeterie() {
		setStade(new Stade_Impl());
		evenements = new HashMap<Integer, Evenement>();
		reduction = new HashMap<String, Double>();
		reduction.put("Adulte", 1.00);
		reduction.put("Senior", 0.80);
		reduction.put("Etudiant", 0.90);
		reduction.put("Enfant", 0.50);
		reduction.put("Partenaire", 0.75);
	}
	

	public double CalculerPrix(int idEvent, String idCat, String categoriePersonne) {
		double prixPlace = evenements.get(idEvent).getPrixCat(idCat) * reduction.get(categoriePersonne);
		return prixPlace;
	}

	public Stade_Impl getStade() {
		return stade;
	}

	public void setStade(Stade_Impl stade) {
		this.stade = stade;
	}

	static Evenement creerMusique(HashMap<String, Double> tarif, String date, String nomEv) throws ParseException {
		Evenement evnt = new Musique(nomEv,date, tarif);
		return evnt;
	}
	static Evenement creerSport(HashMap<String, Double> tarif, String date, String nomEv) throws ParseException {
		Evenement evnt = new Sport(nomEv,date, tarif);
		return evnt;
	}
}