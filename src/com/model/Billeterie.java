package com.model;

import java.text.ParseException;
import java.util.HashMap;

import com.model.Evenement.Evenement;
import com.model.Evenement.Musique;
import com.model.Evenement.Sport;

public class Billeterie {
	private Stade_Impl stade;
	private HashMap<Integer, Evenement> evenements;
<<<<<<< HEAD
	private HashMap<Integer, Double> reduction;
	
	/**
	 * Constructeur par défaut
	 * Crée une billéterie avec un liste vide 
	 */
	public Billeterie(){
=======
	private HashMap<String, Double> reduction;

	public Billeterie() {
>>>>>>> 1288926f4df07119eedf2c0721b9ea551ec3d5fd
		setStade(new Stade_Impl());
		evenements = new HashMap<Integer, Evenement>();
		reduction = new HashMap<String, Double>();
		reduction.put("Adulte", 1.00);
		reduction.put("Senior", 0.80);
		reduction.put("Etudiant", 0.90);
		reduction.put("Enfant", 0.50);
		reduction.put("Partenaire", 0.75);
	}
	
<<<<<<< HEAD
	/**
	 * @param idEvent - id de l'event concerné
	 * @param idCat - id de la catégorie concerné
	 * @param idReduction - id de la 
	 * @return le prix de la prix d'une catégorie pour un evenement donné et une réduction donnée
	 */
	public double CalculerPrix(int idEvent, String idCat, String categoriePersonne){
=======

	public double CalculerPrix(int idEvent, String idCat, String categoriePersonne) {
>>>>>>> 1288926f4df07119eedf2c0721b9ea551ec3d5fd
		double prixPlace = evenements.get(idEvent).getPrixCat(idCat) * reduction.get(categoriePersonne);
		return prixPlace;
	}

	/**
	 * @return stade attacher à la Billeterie
	 */
	public Stade_Impl getStade() {
		return stade;
	}

	/**
	 * @param stade - nouveau stade à lier a la Billeterie
	 * permet de changer le stade lié à la Billeterie
	 */
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