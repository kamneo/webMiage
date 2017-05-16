package com.model;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rang")
public class Rang {
	private HashMap<Integer, Place> places;
	private int numeroRang;
	
	/**
	 * Constructeur
	 * @param numeroRang 	= nomero du rang
	 * @param p 			= Liste des places qui compose le rang
	 * Construit l'objet Rang avec le numéro @param nom et crée HashMap avec des couples id/Place
	 */
	public Rang(int numeroRang, Place[] p){
		this.setNumeroRang(numeroRang);
		places = new HashMap<Integer, Place>();
		
		for(int i = 0; i<p.length; i++){
			places.put(p[i].getNumero(), p[i]);
		}
		
	}

	/**
	 * getPlaces retourne les combos 
	 **/
	public HashMap<Integer, Place> getPlaces() {
		return places;
	}

	public void setPlaces(HashMap<Integer, Place> places) {
		this.places = places;
	}

	public int getNumeroRang() {
		return numeroRang;
	}

	public void setNumeroRang(int numeroRang) {
		this.numeroRang = numeroRang;
	}
	

}