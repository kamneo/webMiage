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
	 * constructeur par défaut
	 */
	public Categorie() {
		escalier = new ArrayList<String>();
	}

	/**
	 * Constructeur categories
	 * 
	 * @param nomCat
	 *            nom de la categorie
	 * @param escaliers
	 *            liste des escaliers qu'elle contient
	 */
	public Categorie(String nomCat, Escalier[] escaliers) {
		// Todo
		this.nomCat = nomCat;
		escalier = null;
	}

	/**
	 * Getter du nom de la categorie
	 * 
	 * @return
	 */
	@XmlAttribute
	public String getNomCat() {
		return nomCat;
	}

	/**
	 * Setter du nom de la categorie
	 * 
	 * @param nomCat
	 *            nom de la categorie
	 */
	public void setNom(String nomCat) {
		this.nomCat = nomCat;
	}

	/**
	 * Getter liste des escaliers de la categorie
	 * 
	 * @return
	 */
	@XmlElement(name = "Escaliers")
	public ArrayList<String> getEscalier() {
		return escalier;
	}

	/**
	 * Setter liste des escaliers de la categorie
	 * 
	 * @param escalier
	 */
	public void setEscalier(ArrayList<String> escalier) {
		this.escalier = escalier;
	}
}
