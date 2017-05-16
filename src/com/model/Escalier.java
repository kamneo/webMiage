package com.model;

import java.util.HashMap;
import com.model.Rang;

public class Escalier {
	private String nom;
	private HashMap<Integer,Rang> rang;
	
	public Escalier(String nom, Rang[] rangs) {
		this.nom=nom;
		this.rang=new HashMap<>();
		for(int i=0; i==rangs.length; i++){
			this.rang.put(i, rangs[i]);
		}
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public HashMap<Integer, Rang> getEscalier() {
		return rang;
	}
	public void setEscalier(HashMap<Integer, Rang> rangs) {
		this.rang = rangs;
	}
}