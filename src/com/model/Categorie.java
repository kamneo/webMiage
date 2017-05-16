package com.model;

import java.util.HashMap;
import com.model.Escalier;

public class Categorie {
	private String nom;
	private HashMap<String,Escalier> escalier;
	
	public Categorie(String nom, Integer nbPlace) {
		//Todo
		this.nom = nom;
		escalier=null;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public HashMap<String, Escalier> getEscalier() {
		return escalier;
	}
	public void setEscalier(HashMap<String, Escalier> escalier) {
		this.escalier = escalier;
	}
}
