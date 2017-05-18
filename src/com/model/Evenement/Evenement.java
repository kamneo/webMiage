package com.model.Evenement;

import java.util.Date;
import java.util.HashMap;

public abstract class Evenement {
	protected HashMap<String, Double> tarif;
	protected Date date;
	protected String nomEv;
	protected String[] catAccessibles;
	protected String[] orientationAccessibles;
	protected int typeEv;

	/**
	 * Constructeur
	 * 
	 * @param tarif
	 * @param date
	 * @param nomEv
	 * @param catAccessibles
	 * @param orientationAccessibles
	 * @param typeEv
	 *            Crée un evenement avec pour premier parametre une liste de
	 *            tarif, une date, un nom, la liste des catégories accessibles
	 *            et la liste des orientations accessibles en fonction de s
	 */
	public Evenement(HashMap<String, Double> tarif, Date date, String nomEv) {
		this.tarif = tarif;
		this.date = date;
		this.nomEv = nomEv;
	}

	/**
	 * @return the tarif
	 */
	public HashMap<String, Double> getTarif() {
		return tarif;
	}

	/**
	 * @param tarif the tarif to set
	 */
	public void setTarif(HashMap<String, Double> tarif) {
		this.tarif = tarif;
	}

	/**
	 * @return the catAccessibles
	 */
	public String[] getCatAccessibles() {
		return catAccessibles;
	}

	/**
	 * @param catAccessibles the catAccessibles to set
	 */
	public void setCatAccessibles(String[] catAccessibles) {
		this.catAccessibles = catAccessibles;
	}

	/**
	 * @return the orientationAccessibles
	 */
	public String[] getOrientationAccessibles() {
		return orientationAccessibles;
	}

	/**
	 * @param orientationAccessibles the orientationAccessibles to set
	 */
	public void setOrientationAccessibles(String[] orientationAccessibles) {
		this.orientationAccessibles = orientationAccessibles;
	}

	/**
	 * @return the typeEv
	 */
	public int getTypeEv() {
		return typeEv;
	}

	/**
	 * @param typeEv the typeEv to set
	 */
	public void setTypeEv(int typeEv) {
		this.typeEv = typeEv;
	}

	public Evenement() {
	}

	public double getPrixCat(String idCat) {
		return tarif.get(idCat);
	}

	public String getNomEv() {
		return nomEv;
	}

	public void setNomEv(String nomEv) {
		this.nomEv = nomEv;
	}

	public HashMap<String, Double> getPrixCat() {
		return tarif;
	}

	public void setPrixCat(HashMap<String, Double> tarif) {
		this.tarif = tarif;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date nouvDate) {
		date = nouvDate;
	}
}
