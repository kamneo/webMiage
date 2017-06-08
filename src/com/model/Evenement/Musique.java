package com.model.Evenement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Musique extends Evenement {
	/**
	 * Constructeur par defaut
	 */
	public Musique() {
		super();
		this.catAccessibles = new String[4];
		this.catAccessibles[0] = "Or";
		this.catAccessibles[1] = "Argent";
		this.catAccessibles[2] = "Bronze";
		this.catAccessibles[3] = "Terrain";
		this.orientationAccessibles = new String[4];
		this.orientationAccessibles[0] = "Nord";
		this.orientationAccessibles[1] = "Sud";
		this.orientationAccessibles[2] = "Est";
		this.orientationAccessibles[3] = "Fosse";
		this.typeEv = 1;
		this.description = "";
	}

	/**
	 * Constructeur Evenement musical
	 * 
	 * @param nomEv
	 *            Nom de l'evenement
	 * @param date
	 *            Date de l'evenement
	 * @param tarif
	 *            Liste des tarifs
	 * @param description
	 *            Commentaires sur l'environnement
	 * @throws ParseException
	 */
	public Musique(String nomEv, String date, HashMap<String, Double> tarif, String description) throws ParseException {

		super(tarif, formatter.parse(date), nomEv, description);
		this.catAccessibles = new String[4];
		this.catAccessibles[0] = "Or";
		this.catAccessibles[1] = "Argent";
		this.catAccessibles[2] = "Bronze";
		this.catAccessibles[3] = "Terrain";
		this.orientationAccessibles = new String[4];
		this.orientationAccessibles[0] = "Nord";
		this.orientationAccessibles[1] = "Sud";
		this.orientationAccessibles[2] = "Est";
		this.orientationAccessibles[3] = "Fosse";
		this.typeEv = 1;
	}

}
