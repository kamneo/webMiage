package com.model;

import java.util.HashMap;

public class Categorie {
	private String nomCat;
	private HashMap<String,Escalier> escalier;
	
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
	public HashMap<String, Escalier> getEscalier() {
		return escalier;
	}
	public void setEscalier(HashMap<String, Escalier> escalier) {
		this.escalier = escalier;
	}
}
