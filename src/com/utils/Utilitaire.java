package com.utils;

import java.util.ArrayList;

import com.model.Categorie;

public class Utilitaire {
	public static final String CATEGORIE_FOSSE = "Fosse";

	/**
	 * 
	 * @return ArrayList - Retourne une ArrayList de String qui délimite toutes les catégories du stade
	 */
	public static ArrayList<String> getAllCategories(){
		ArrayList<String> res = new ArrayList<String>();
		res.add("Cat1");
		res.add("Cat2");
		res.add("Cat3");
		res.add("OR");
		return res;
	}
	
	/**
	 * 
	 * @return ArrayList - Retourne une ArrayList de String qui délimite toutes les orientations du stade
	 */
	public static ArrayList<String> getAllOrientation(){
		ArrayList<String> res = new ArrayList<String>();
		res.add("Fosse");
		res.add("Est");
		res.add("Ouest");
		res.add("Nord");
		res.add("Sud");
		return res;
	}
}
