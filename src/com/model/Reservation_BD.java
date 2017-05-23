package com.model;

import java.util.HashMap;

public class Reservation_BD {
	/** 
	 * Instance unique 
	 * 
	 */
	private static Reservation_BD INSTANCE = null;
	private HashMap<Long, Reservation> reservations;

	private Reservation_BD() {
	}

	/**
	 * 
	 * @param reservations - liste des réservations
	 */
	public void setReservations(HashMap<Long, Reservation> reservations) {
		this.reservations = reservations;
	}

	/**
	 * 
	 * @return la liste des reservations
	 */
	public HashMap<Long, Reservation> getReservations() {
		return this.reservations;
	}

	/**
	 * 
	 * @param nouvResa - nouvelle reservation a rajouter à la liste
	 */
	public void ajouterResa(Reservation nouvResa) {
		this.reservations.put((long) reservations.size(), nouvResa);
	}

	/**
	 * 
	 * Point d'accès pour l'instance unique du singleton
	 */
	public static synchronized Reservation_BD getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Reservation_BD();
		}
		return INSTANCE;
	}
}
