package com.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {
	private String mail; // identifiant du client
	private String mdp; // mot de passe du client
	private String nom; // nom du client
	private String prenom; // prenom du client
	private boolean estAdmin; // statut du client

	public Client() { // contructeur par defaut
		mail = null;
		mdp = null;
		nom = null;
		prenom = null;
		estAdmin = false;
	}

	/**
	 * 
	 * @param mail
	 *            - mail du client
	 * @param mdp
	 *            - mot de passe du client
	 * @param nom
	 *            - du client
	 * @param prenom
	 *            - prenom du client
	 */
	// constructeur client par defaut
	public Client(String mail, String mdp, String nom, String prenom) {
		this.setMail(mail);
		this.setMdp(mdp);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdmin(false);
	}

	/**
	 * 
	 * @param mail
	 *            - mail du client
	 * @param mdp
	 *            - mot de passe du client
	 * @param nom
	 *            - du client
	 * @param prenom
	 *            - prenom du client
	 * @param admin
	 *            - détermine s'il a les permissions administrateurs
	 */
	// constructeur client
	public Client(String mail, String mdp, String nom, String prenom, boolean admin) {
		this.setMail(mail);
		this.setMdp(mdp);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdmin(admin);
	}

	/**
	 * 
	 * @return mail - mail du client
	 */
	public String getMail() { // getter adresse mail
		return mail;

	}

	/**
	 * 
	 * @param mail
	 *            - nouveau mail du client
	 */
	@XmlElement
	public void setMail(String mail) { // setter adresse mail
		this.mail = mail;
	}

	/**
	 * 
	 * @return mdp - mot de passe du client
	 */
	public String getMdp() { // getter mot de passe
		return mdp;

	}

	/**
	 * 
	 * @param mdp
	 *            - nouveau mot de passe du client
	 */
	public void setMdp(String mdp) { // setter mot de passe
		this.mdp = mdp;
	}

	/**
	 * 
	 * @return nom - nom du client
	 */
	public String getNom() { // getter nom client
		return nom;

	}

	/**
	 * 
	 * @param nom
	 *            - nouveau nom du client
	 */
	@XmlElement
	public void setNom(String nom) { // setter prenom client
		this.nom = nom;
	}

	/**
	 * 
	 * @return prenom - prenom du client
	 */
	public String getPrenom() { // getter prenom client
		return prenom;

	}

	/**
	 * 
	 * @param prenom
	 *            - nouveau prenom du client
	 */
	@XmlElement
	public void setPrenom(String prenom) { // setter prenom client
		this.prenom = prenom;
	}

	/**
	 * 
	 * @return estAdmin - statue d'administrateur
	 */
	public boolean getAdmin() { // getter prenom statut admin vrai/faux
		return estAdmin;

	}

	/**
	 * 
	 * @param admin
	 *            - nouveau statue administrateur
	 */
	@XmlElement
	public void setAdmin(boolean admin) { // setter prenom statut admin
											// vrai/faux
		this.estAdmin = admin;
	}
}
