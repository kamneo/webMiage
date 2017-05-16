package com.model.Event;

import java.util.Date;
import java.util.HashMap;

abstract class Event {
	protected HashMap<String, Double> prixCat;
	protected Date date;
	protected String nomMach;
	protected String[] equipes;
	protected String[] catAccessibles;
	
	public Event(){
		
	}

	public double getPrixCat(String idCat) {
		return prixCat.get(idCat);
	}

	public String getNomMach() {
		return nomMach;
	}

	public void setNomMach(String nomMach) {
		this.nomMach = nomMach;
	}

	public HashMap<String, Double> getPrixCat() {
		return prixCat;
	}

	public void setPrixCat(HashMap<String, Double> prixCat) {
		this.prixCat = prixCat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date newDate) {
		date = newDate;
	}
}
