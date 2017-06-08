package com.model.Evenement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.construction.ConstructionStade;
import com.model.Escalier;
import com.model.Orientation;
import com.model.Place;
import com.model.Rang;
import com.model.Stade_Impl;
import com.sun.xml.internal.txw2.annotation.XmlAttribute;
import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlSeeAlso({ Sport.class, Musique.class })
/**
 *
 * @author jordanbazerque
 *
 */
@XmlRootElement
public abstract class Evenement {
	protected static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	protected HashMap<String, Double> tarif;
	protected Date date;
	protected String nomEv;
	protected String[] catAccessibles;
	protected String[] orientationAccessibles;
	protected int typeEv;
	protected static Stade_Impl stade;
	protected String description;

	public Evenement() {
		ConstructionStade cs = new ConstructionStade();

		stade = cs.getStade();
		date = new Date();
	}

	/**
	 * Constructeur
	 * 
	 * @param tarif
	 * @param date
	 * @param nomEv
	 * @param catAccessibles
	 * @param orientationAccessibles
	 * @param typeEv
	 *            Crée un evenement avec pour premier parametre une liste de
	 *            tarif, une date, un nom, la liste des catégories accessibles
	 *            et la liste des orientations accessibles en fonction de s
	 */
	public Evenement(HashMap<String, Double> tarif, Date date, String nomEv, String description) {
		ConstructionStade cs = new ConstructionStade();

		stade = cs.getStade();
		this.tarif = tarif;
		this.date = date;
		this.nomEv = nomEv;
		this.description = description;
	}

	/**
	 * @return the tarif
	 */
	public HashMap<String, Double> getTarif() {
		return tarif;
	}

	/**
	 * @param tarif
	 *            the tarif to set
	 */
	public void setTarif(HashMap<String, Double> tarif) {
		this.tarif = tarif;
	}

	/**
	 * @return the catAccessibles
	 */
	public String[] getCatAccessibles() {
		return catAccessibles;
	}

	/**
	 * @param catAccessibles
	 *            the catAccessibles to set
	 */
	public void setCatAccessibles(String[] catAccessibles) {
		this.catAccessibles = catAccessibles;
	}

	/**
	 * @return the orientationAccessibles
	 */
	public String[] getOrientationAccessibles() {
		return orientationAccessibles;
	}

	/**
	 * @param orientationAccessibles
	 *            the orientationAccessibles to set
	 */
	public void setOrientationAccessibles(String[] orientationAccessibles) {
		this.orientationAccessibles = orientationAccessibles;
	}

	/**
	 * @return the typeEv
	 */
	@XmlAttribute
	public int getTypeEv() {
		return typeEv;
	}

	/**
	 * @param typeEv
	 *            the typeEv to set
	 */
	public void setTypeEv(int typeEv) {
		this.typeEv = typeEv;
	}

	/**
	 * Getter prix de la categorie
	 * 
	 * @param idCat
	 *            identifiant de la categorie
	 * @return
	 */
	public double getPrixCat(String idCat) {
		return tarif.get(idCat);
	}

	/**
	 * Getter ndu nom de l'evenement
	 * 
	 * @return
	 */
	@XmlElement
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
	 * Getter du prix de la categorie dans la liste des prix
	 * 
	 * @return
	 */
	@XmlElement
	public HashMap<String, Double> getPrixCat() {
		return tarif;
	}

	/**
	 * Setter du prix de la categorie dans la liste des prix
	 * 
	 * @param tarif
	 */
	public void setPrixCat(HashMap<String, Double> tarif) {
		this.tarif = tarif;
	}

	/**
	 * Getter de la date
	 * 
	 * @return
	 */
	@XmlElement
	public Date getDate() {
		return date;
	}

	/**
	 * Setter de la date
	 * 
	 * @param nouvDate
	 */
	public void setDate(Date nouvDate) {
		date = nouvDate;
	}

	/**
	 * Getter du stade
	 * 
	 * @return
	 */
	public Stade_Impl getStade() {
		return stade;
	}

	/**
	 * Setter du stade
	 * 
	 * @param stade
	 */
	public void setStade(Stade_Impl stade) {
		this.stade = stade;
	}

	/**
	 * Getter de la description
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter de la description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter du nombre de places libres
	 * 
	 * @return
	 */
	@XmlElement
	public long getNbPlaceLibre() {
		return getPlacesLibre().size();
	}

	/**
	 * Getter de la liste des places libres réservées
	 * 
	 * @return
	 */
	public ArrayList<Place> getPlacesLibre() {
		ArrayList<Place> res = new ArrayList<Place>();

		for (int index = 0; index < stade.getOrientations().size(); index++) {
			res.addAll(getPlacesLibre(index));
		}
		return res;
	}

	/**
	 * Getter des places libres dans une orientation
	 * 
	 * @param indexOrientation
	 *            Orientations
	 * @return
	 */
	public ArrayList<Place> getPlacesLibre(int indexOrientation) {
		ArrayList<Place> res = new ArrayList<Place>();

		int tailleListEscaliers = stade.getOrientations().get(indexOrientation).getEscalier().size();
		for (int i = 0; i < tailleListEscaliers; i++) {
			if (myContains(this.getOrientationAccessibles(), indexOrientation)) {
				res.addAll(getPlacesLibre(indexOrientation, i));
			}
		}
		return res;
	}

	/**
	 * Getter des places libres dans les escaliers
	 * 
	 * @param indexOrientation
	 *            Orientations
	 * @param idEscalier
	 *            Escaliers de l'orientation
	 * @return
	 */
	public ArrayList<Place> getPlacesLibre(int indexOrientation, int idEscalier) {
		ArrayList<Place> res = new ArrayList<Place>();
		for (Rang r : stade.getOrientations().get(indexOrientation).getEscalier().get(idEscalier).getRang()) {
			if (myContains(this.getOrientationAccessibles(), indexOrientation)) {
				res.addAll(getPlacesLibre(indexOrientation, idEscalier, r.getNumeroRang()));
			}
		}
		return res;
	}

	/**
	 * Getter des places libres dans les rangs
	 * 
	 * @param indexOrientation
	 *            Orientation
	 * @param idEscalier
	 *            Escaliers de l'orientation
	 * @param idRang
	 *            Rangs des escaliers
	 * @return
	 */
	public ArrayList<Place> getPlacesLibre(int indexOrientation, int idEscalier, int idRang) {
		ArrayList<Place> res = new ArrayList<Place>();
		for (Place p : stade.getOrientations().get(indexOrientation).getEscalier().get(idEscalier).getRang().get(idRang)
				.getPlaces()) {
			if (myContains(this.getOrientationAccessibles(), indexOrientation) && p.isEstLibre()) {
				res.add(p);
			}
		}
		return res;
	}

	/**
	 * Methode pour parcourir toutes les orientations
	 * 
	 * @param op1
	 *            Premiere orientation a comparer
	 * @param op2
	 *            Seconde orientation a comparer
	 * @return
	 */
	private static boolean myContains(String[] op1, int op2) {
		for (int i = 0; i < op1.length; i++)
			if (op1[i].equals(stade.getOrientations().get(op2).getNom()))
				return true;

		return false;
	}
}
