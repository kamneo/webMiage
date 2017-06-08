package com.model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rang")
public class Rang {
	private ArrayList<Place> places;
	private int numeroRang;

	/**
	 * constructeur par défault
	 */
	public Rang() {
		places = new ArrayList<Place>();
	}

	/**
	 * Constructeur
	 * 
	 * @param numeroRang
	 *            - nomero du rang
	 * @param p
	 *            - Liste des places qui compose le rang Construit l'objet Rang
	 *            avec le numéro @param nom et crée HashMap avec des couples
	 *            id/Place
	 */
	public Rang(int numeroRang, Place[] p) {
		this.setNumeroRang(numeroRang);
		places = new ArrayList<Place>();

		for (int i = 0; i < p.length; i++) {
			places.add(p[i]);
		}

	}

	/**
	 * @return places - liste des places getPlaces renvoi les couple 'id/place
	 */
	public ArrayList<Place> getPlaces() {
		return places;
	}

	/**
	 * @param places
	 *            - nouvelle liste de places setPlaces permet d'attribuer de
	 *            nouveau couple id/place
	 */
	public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}

	/**
	 * @return numeroRang - numero du rang getNumeroRang retourne le numéro du
	 *         rang
	 */
	@XmlAttribute
	public int getNumeroRang() {
		return numeroRang;
	}

	/**
	 * @param numeroRang
	 *            numéro du rang setNumeroRang permet de changer le numero du
	 *            rang
	 */
	public void setNumeroRang(int numeroRang) {
		this.numeroRang = numeroRang;
	}

	/**
	 * Methode pour cloner les rangs
	 */
	public Object clone() {
		@SuppressWarnings("unchecked")
		ArrayList<Place> pc = (ArrayList<Place>) places.clone();

		Rang r = new Rang(numeroRang, (Place[]) pc.toArray());

		return r;
	}

}