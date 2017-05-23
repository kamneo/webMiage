package com.model;

import java.util.ArrayList;


public class Client {
	private String mail; //identifiant du client
	private String mdp; // mot de passe du client
	private String nom; // nom du client
	private String prenom; // prenom du client
	private boolean estAdmin; //statut du client
	private ArrayList<Reservation> reservations; //liste des reservations du client

	public Client(){ //contructeur par defaut
		
	}

	public Client(String mail, String mdp, String nom, String prenom){ //constructeur client non administrateur
		this.setMail(mail);
		this.setMdp(mdp);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdmin(false);
		this.reservations = new ArrayList<Reservation>();
		
	}
	public Client(String mail, String mdp, String nom, String prenom, boolean admin){ //constructeur client
		this.setMail(mail);
		this.setMdp(mdp);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdmin(admin);
		this.reservations = new ArrayList<Reservation>();
	}

	public Client(String mail, String mdp, String nom, String prenom, boolean admin, ArrayList<Reservation> reservations){ //constructeur client avec liste de reservations
		this.setMail(mail);
		this.setMdp(mdp);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdmin(admin);
		this.reservations = reservations;
		}
	public String getMail(){ //getter adresse mail
		return mail;
		
	}
	
	public void setMail(String mail){ //setter adresse mail
		this.mail = mail;
	}
	public String getMdp(){ //getter mot de passe
		return mdp;
		
	}
	
	public void setMdp(String mdp){ //setter mot de passe
		this.mdp = mdp;
	}
	
	public String getNom(){ //getter nom client
		return nom;
		
	}
	
	public void setNom(String nom){ //setter prenom client
		this.nom = nom;
	}
	
	public String getPrenom(){ //getter prenom client
		return prenom;
		
	}
	
	public void setPrenom(String prenom){ //setter prenom client
		this.prenom = prenom;
		}
	
	public boolean getAdmin(){ //getter prenom statut admin vrai/faux
		return estAdmin;
		
	}
	
	public void setAdmin(boolean admin){ //setter prenom statut admin vrai/faux
		this.estAdmin = admin;
	}

	public ArrayList<Reservation> getReservations() { //liste des reservations du client
		return reservations;
	}
	
	public ArrayList<Reservation> getReservations(String nomEv) { //liste des reservations du client pour un evenement
		ArrayList<Reservation> listeResa = new ArrayList<Reservation>();
		for(Reservation r : reservations)
			if(r.getNomEv().equals(nomEv))
				listeResa.add(r);
		return listeResa; 				
	}

	public void setReservations(ArrayList<Reservation> reservations) { //setter liste reservation client
		this.reservations = reservations;
	}
}

