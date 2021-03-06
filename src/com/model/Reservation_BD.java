package com.model;

import java.util.Calendar;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Reservation_BD {

	private static Reservation_BD instance = null;
	private HashMap<Long, Reservation> reservations;

	/**
	 * Constructeur par defaut
	 */
	private Reservation_BD() {
		reservations = new HashMap<Long, Reservation>();
	}

	/**
	 * Setter des objets reservations
	 * 
	 * @param reservations
	 *            - liste des réservations
	 */
	public void setReservations(HashMap<Long, Reservation> reservations) {
		this.reservations = reservations;
	}

	/**
	 * Getter de la liste des reservations
	 * 
	 * @return la liste des reservations
	 */
	public HashMap<Long, Reservation> getReservations() {
		return this.reservations;
	}

	/**
	 * Methode pour ajouter une reservation a la liste
	 * 
	 * @param nouvResa
	 *            - nouvelle reservation a rajouter à la liste
	 */
	public void ajouterResa(Reservation nouvResa) {
		long id = Calendar.getInstance().getTime().getTime();
		this.reservations.put(id, nouvResa);
	}

	/**
	 * 
	 * Point d'accès pour l'instance unique du singleton
	 */
	public static synchronized Reservation_BD getInstance() {
		if (instance == null) {
			instance = new Reservation_BD();
		}
		return instance;
	}
}
