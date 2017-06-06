package com.model;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rang")
public class Rang {
	private HashMap<Integer, Place> places;
	private int numeroRang;
	
	/**
	 * constructeur par défault
	 */
	public Rang(){
		places=new HashMap<Integer, Place>();
	}
	
	/**
	 * Constructeur
	 * @param numeroRang - nomero du rang
	 * @param p - Liste des places qui compose le rang
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
	 * @return places - liste des places 
	 * getPlaces renvoi les couple 'id/place 
	 */
	public HashMap<Integer, Place> getPlaces() {
		return places;
	}

	/**
	 * @param places - nouvelle liste de places
	 * setPlaces permet d'attribuer de nouveau couple id/place
	 */
	public void setPlaces(HashMap<Integer, Place> places) {
		this.places = places;
	}

	/**
	 * @return numeroRang - numero du rang
	 * getNumeroRang retourne le numéro du rang
	 */
	@XmlAttribute
	public int getNumeroRang() {
		return numeroRang;
	}

	/**
	 * @param numeroRang - numéro du rang
	 * setNumeroRang permet de changer le numero du rang
	 */
	public void setNumeroRang(int numeroRang) {
		this.numeroRang = numeroRang;
	}

	public Object clone() {
		@SuppressWarnings("unchecked")
		HashMap<Integer, Place> pc = (HashMap<Integer, Place>) places.clone();
		
		Rang r = new Rang(numeroRang, (Place[]) pc.values().toArray());
		
		return r;
	}
	

}