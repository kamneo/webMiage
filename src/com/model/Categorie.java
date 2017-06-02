package com.model;

import java.util.ArrayList;

public class Categorie {
	private String nomCat;
	private ArrayList<String> escalier;
	
	/**
	 * constructeur par défault
	 */
	public Categorie(){
	
	}
	
	public Categorie(String nomCat, Escalier[] escaliers) {
		//Todo
		this.nomCat = nomCat;
		escalier=null;
	}
	
	public String getNomCat() {
		return nomCat;
	}
	public void setNom(String nomCat) {
		this.nomCat = nomCat;
	}
	public ArrayList<String> getEscalier() {
		return escalier;
	}
	public void setEscalier(ArrayList<String> escalier) {
		this.escalier = escalier;
	}
}
