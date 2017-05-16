package com.model;

import java.util.HashMap;

public class Rang {
	private HashMap<Integer, Place> places;
	private int numeroRang;
	
	public Rang(int numeroRang, Place[] p){
		this.setnumeroRang(numeroRang);
		places = new HashMap<Integer, Place>();
		
		for(int i = 0; i<p.length; i++){
			places.put(p[i].getNumero(), p[i]);
		}
		
	}

	public void setnumeroRang(int numeroRang) {
	
		this.setNumeroRang(numeroRang);
	}

	public int getNumeroRang() {
		return numeroRang;
	}

	public void setNumeroRang(int numeroRang) {
		this.numeroRang = numeroRang;
	}

}