package com.model;

import java.util.HashMap;
import com.model.Escalier;

public class Orientation {
	private String nom;
	private HashMap<Integer,Escalier> escalier;
	
	/**
	 * Constructeur
	 * @param nom 		= nom de l'oriantation : EST, OUEST, NORD, SUD
	 * @param escaliers = Liste des escaliers qui compose l'orientation
	 * Construit l'objet Oriantation du nom de @param nom et crée HashMap avec des couples id/Escalier
	 */
	public Orientation(String nom, Escalier[] escaliers) {
		this.nom=nom;
		this.escalier=new HashMap<>();
		for(int i=0; i<escaliers.length; i++){
			escalier.put(i, escaliers[i]);
		}
	}
	
	/**
	 * getNom renvoi le nom de l'orientation
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * setNom permet de changer le nom de l'orientation
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * getEscalier renvoi la liste des Escaliers et de leur id
	 */
	public HashMap<Integer, Escalier> getEscalier() {
		return escalier;
	}
	
	/**
	 * setNom permet de remplacer la liste des couples id/Escalier pour une autre liste de couple
	 */
	public void setEscalier(HashMap<Integer, Escalier> escalier) {
		this.escalier = escalier;
	}
}