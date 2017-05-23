package com.model;

public class Client {
	private String mail; //identifiant du client
	private String mdp; // mot de passe du client
	private String nom; // nom du client
	private String prenom; // prenom du client
	private boolean estAdmin;

	public Client(){ //contructeur par defaut
		
	}

	public Client(String mail, String mdp, String nom, String prenom){ //contructeur client non administrateur
		this.setMail(mail);
		this.setMdp(mdp);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdmin(false);
		
	}
	public Client(String mail, String mdp, String nom, String prenom, boolean admin){ //contructeur client administrateur
		this.setMail(mail);
		this.setMdp(mdp);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdmin(admin);
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
}

