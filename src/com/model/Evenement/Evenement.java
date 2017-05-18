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
	
	public Evenement(String nomEv, HashMap<String, Double> tarif, int typeEv, String[] catAccessibles, String[] orientationAccessibles ){
		
	}

	public double getPrixCat(String idCat) {
		return tarif.get(idCat);
	}

	public String getNomMach() {
		return nomEv;
	}

	public void setNomMach(String nomMach) {
		this.nomEv = nomMach;
	}

	public HashMap<String, Double> getPrixCat() {
		return tarif;
	}

	public void setPrixCat(HashMap<String, Double> prixCat) {
		this.tarif = prixCat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date nouvDate) {
		date = nouvDate;
	}
}
