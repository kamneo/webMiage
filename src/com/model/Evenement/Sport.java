package com.model.Evenement;

import java.text.ParseException;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement
public class Sport extends Evenement {
	private String equipe1 = "";
	private String equipe2 = "";

	/**
	 * Constructeur par defaut
	 */
	public Sport() {
		super();
		this.catAccessibles = new String[3];
		this.catAccessibles[0] = "Or";
		this.catAccessibles[1] = "Argent";
		this.catAccessibles[2] = "Bronze";
		this.orientationAccessibles = new String[4];
		this.orientationAccessibles[0] = "Nord";
		this.orientationAccessibles[1] = "Sud";
		this.orientationAccessibles[2] = "Est";
		this.orientationAccessibles[3] = "Ouest";
		this.typeEv = 0;
	}

	/**
	 * Constructeur evenement sportif
	 * 
	 * @param nomEv
	 *            Nom de l'evenement
	 * @param date
	 *            - String au format "AAAA-MM-JJ HH:mm"
	 * @param tarif
	 *            liste des tarifs de l'evenement
	 * @param equipe1
	 *            equipe domicile
	 * @param equipe2
	 *            equipe exterieure
	 * @param description
	 *            commentaires sur l'evenement
	 * @throws ParseException
	 */
	public Sport(String nomEv, String date, HashMap<String, Double> tarif, String equipe1, String equipe2,
			String description) throws ParseException {
		super(tarif, formatter.parse(date), nomEv, description);
		this.catAccessibles = new String[3];
		this.catAccessibles[0] = "Or";
		this.catAccessibles[1] = "Argent";
		this.catAccessibles[2] = "Bronze";
		this.orientationAccessibles = new String[4];
		this.orientationAccessibles[0] = "Nord";
		this.orientationAccessibles[1] = "Sud";
		this.orientationAccessibles[2] = "Est";
		this.orientationAccessibles[3] = "Ouest";
		this.typeEv = 0;
		this.setEquipe1(equipe1);
		this.equipe2 = equipe2;
	}

	/**
	 * Getter equipe domicile
	 * 
	 * @return
	 */
	@XmlElement
	public String getEquipe1() {
		return equipe1;
	}

	/**
	 * Setter equipe domicile
	 * 
	 * @param equipe1
	 *            nom equipe domicile
	 */
	public void setEquipe1(String equipe1) {
		this.equipe1 = equipe1;
	}

	/**
	 * Getter equipe exterieure
	 * 
	 * @return
	 */
	@XmlElement
	public String getEquipe2() {
		return equipe2;
	}

	/**
	 * Setter equipe exterieure
	 * 
	 * @param equipe2
	 *            Nom equipe exterieure
	 */
	public void setEquipe2(String equipe2) {
		this.equipe2 = equipe2;
	}

}
