package com.model;

import java.util.HashMap;
import com.model.Escalier;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Orientation")
public class Orientation {
	private String nom;
	private HashMap<Integer,Escalier> escalier;
	
	/**
	 * Constructeur par défaut
	 */
	public Orientation(){
		super();
	}
	
	/**
	 * Constructeur
	 * @param nom - le nom donnée à l'orientaiton
	 * @param escaliers - Liste des escaliers qui compose l'orientation
	 * Construit l'objet Orientation du nom du premier parametre et cree HashMap avec des couples id/Escalier
	 */
	public Orientation(String nom, Escalier[] escaliers) {
		this.nom=nom;
		this.escalier=new HashMap<>();
		for(int i=0; i<escaliers.length; i++){
			escalier.put(i, escaliers[i]);
		}
	}
	
	/**
	 * @return nom
	 * getNom renvoi le nom de l'orientation
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @param nom - Le nom à affecter à l'orientation
	 * setNom permet de changer le nom de l'orientation
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return escalier
	 * getEscalier renvoi la liste des Escaliers et de leur id
	 */
	public HashMap<Integer, Escalier> getEscalier() {
		return escalier;
	}
	
	/**
	 * @param escalier - liste des id/Escalier à affecter
	 * setNom permet de remplacer la liste des couples id/Escalier pour une autre liste de couple
	 */
	public void setEscalier(HashMap<Integer, Escalier> escalier) {
		this.escalier = escalier;
	}
}