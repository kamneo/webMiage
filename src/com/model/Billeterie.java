package com.model;

import java.util.HashMap;

import com.model.Evenement.*;

public class Billeterie {
	private Stade_Impl stade;
	private HashMap<Integer, Evenement> evenements;
	private HashMap<Integer, Double> reduction;
	
	/**
	 * Constructeur par défaut
	 * Crée une billéterie avec un liste vide 
	 */
	public Billeterie(){
		setStade(new Stade_Impl());
		evenements = new HashMap<Integer, Evenement>();
	}
	
	/**
	 * @param idEvent - id de l'event concerné
	 * @param idCat - id de la catégorie concerné
	 * @param idReduction - id de la 
	 * @return le prix de la prix d'une catégorie pour un evenement donné et une réduction donnée
	 */
	public double CalculerPrix(int idEvent, String idCat, String categoriePersonne){
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
}
