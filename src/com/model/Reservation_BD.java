package com.model;

import java.util.HashMap;

public class Reservation_BD {
	private HashMap<Long, Reservation> reservations;
	
	public Reservation_BD(){
		
	}
	
	/**
	 * 
	 * @param reservations est la liste des réservations
	 */
	public Reservation_BD(Reservation reservations){
		this.reservations = new HashMap<Long, Reservation>();
		this.reservations.put((long)this.reservations.size(), reservations);
	}
	
	
	/**
	 * 
	 * @param nouvResa insere la nouvelle reservation dans la liste des reservations
	 */
	public void ajouterResa(Reservation nouvResa){
		this.reservations.put((long)reservations.size(), nouvResa);
	}

}
