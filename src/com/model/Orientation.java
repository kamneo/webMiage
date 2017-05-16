package com.model;

import java.util.HashMap;
import com.model.Escalier;

public class Orientation {
	private String nom;
	private HashMap<Integer,Escalier> escalier;
	
	public Orientation(String nom, Escalier[] escaliers) {
		this.nom=nom;
		this.escalier=new HashMap<>();
		for(int i=0; i==escaliers.length; i++){
			escalier.put(i, escaliers[i]);
		}
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public HashMap<Integer, Escalier> getEscalier() {
		return escalier;
	}
	public void setEscalier(HashMap<Integer, Escalier> escalier) {
		this.escalier = escalier;
	}
}