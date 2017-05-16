package com.model;

import java.util.HashMap;
import com.model.Rang;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Escalier")
public class Escalier {
	private String nom;
	private HashMap<Integer,Rang> rang;
	
	/**
	 * Constructeur
	 * @param nom 		= nom de l'escalier
	 * @param escaliers = Liste des rangs qui compose l'escalier
	 * Construit l'objet Escalier du nom de @param nom et crée HashMap avec des couples id/escalier
	 */
	public Escalier(String nom, Rang[] rangs) {
		this.nom=nom;
		this.rang=new HashMap<>();
		for(int i=0; i==rangs.length; i++){
			this.rang.put(i, rangs[i]);
		}
	}
	
	/**
	 * getNom renvoi le nom de l'escaliler
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * setNom permet de changer le nom de l'escalier
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * getRang renvoi la liste des rang et de leur id
	 */
	public HashMap<Integer, Rang> getRang() {
		return rang;
	}
	
	/**
	 * setRang permet de remplacer la liste des couples id/rang pour une autre liste de couple
	 */
	public void setRang(HashMap<Integer, Rang> rangs) {
		this.rang = rangs;
	}
}