package com.model;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

import com.model.Billeterie;

@XmlRootElement
public class Reservation {
	private String nomEv; // nom unique de l'evenement
	private HashMap<Integer, Billet> billets; // liste des billets reserves
	private String mailClient; // client qui fais la reservation

	/**
	 * Constructeur par defaut
	 */
	public Reservation() {
		billets = new HashMap<Integer, Billet>();
	}

	/**
	 * Constructeur de la reservation
	 * 
	 * @param nomEv
	 *            Nom de l'evenemetn
	 * @param billets
	 *            Liste des billets reserves
	 * @param mailClient
	 *            identifiant du client qui reserve
	 */
	public Reservation(String nomEv, HashMap<Integer, Billet> billets, String mailClient) {
		this.setNomEv(nomEv);
		this.billets = billets;
		this.setMailClient(mailClient);
	}

	/**
	 * Constructeur de la reservation d'un billet
	 * 
	 * @param nomEv
	 *            Nom de l'evenement
	 * @param billet
	 *            Objet billet reserve
	 * @param mailClient
	 *            identifiant du client qui reserve
	 */
	public Reservation(String nomEv, Billet billet, String mailClient) {
		this.setNomEv(nomEv);
		this.billets = new HashMap<Integer, Billet>();
		this.billets.put(this.billets.size(), billet);
		this.setMailClient(mailClient);
	}

	/**
	 * Getter prix de la reservation
	 * 
	 * @return
	 */
	public double getPrixResa() {
		double prixResa = 0;
		for (Billet b : billets.values())
			prixResa += b.getPrix();
		return prixResa;
	}

	/**
	 * Getter du nom de l'evenement
	 * 
	 * @return
	 */
	public String getNomEv() {
		return nomEv;
	}

	/**
	 * Setter du nom de l'evenement
	 * 
	 * @param nomEv
	 */
	public void setNomEv(String nomEv) {
		this.nomEv = nomEv;
	}

	/**
	 * Getter identifiant du client
	 * 
	 * @return
	 */
	public String getMailClient() {
		return mailClient;
	}

	/**
	 * Setter indentifiant du client
	 * 
	 * @param mailClient
	 */
	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}

	/**
	 * 
	 * @return
	 */
	public boolean validerReservation() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Getter de la liste des billets
	 * 
	 * @return
	 */
	public HashMap<Integer, Billet> getBillets() {
		return billets;
	}
}
