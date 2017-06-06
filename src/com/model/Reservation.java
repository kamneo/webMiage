package com.model;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

import com.model.Billeterie;

@XmlRootElement
public class Reservation {
	private String nomEv; //nom unique de l'evenement
	private HashMap<Integer, Billet> billets; //liste des billets reserves
	private String mailClient; //client qui fais la reservation
	
	public Reservation(){
		billets= new HashMap<Integer, Billet>();
	}
		
	public Reservation(String nomEv, HashMap<Integer, Billet> billets, String mailClient){
		this.setNomEv(nomEv);
		this.billets = billets;
		this.setMailClient(mailClient);
	}
	
	public Reservation(String nomEv, Billet billet, String mailClient){
		this.setNomEv(nomEv);
		this.billets = new HashMap<Integer, Billet>();
		this.billets.put(this.billets.size(), billet);
		this.setMailClient(mailClient);
	}

	public double getPrixResa(){
		double prixResa = 0;
		for(Billet b : billets.values())
			prixResa += b.getPrix();
		return prixResa;
	}

	public String getNomEv() {
		return nomEv;
	}

	public void setNomEv(String nomEv) {
		this.nomEv = nomEv;
	}

	public String getMailClient() {
		return mailClient;
	}

	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}

	public boolean validerReservation() {
		// TODO Auto-generated method stub
		return false;
	}

	public HashMap<Integer, Billet> getBillets() {
		return billets;
	}
}
