package com.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Categorie {
	private String nomCat;
	private ArrayList<String> escalier;
	
	/**
	 * constructeur par défault
	 */
	public Categorie(){
		escalier = new ArrayList<String>();
	}
	
	public Categorie(String nomCat, Escalier[] escaliers) {
		//Todo
		this.nomCat = nomCat;
		escalier=null;
	}
	
	@XmlAttribute
	public String getNomCat() {
		return nomCat;
	}
	public void setNom(String nomCat) {
		this.nomCat = nomCat;
	}

	@XmlElement(name="Escaliers")
	public ArrayList<String> getEscalier() {
		return escalier;
	}
	public void setEscalier(ArrayList<String> escalier) {
		this.escalier = escalier;
	}
}
