package com.model.Evenement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.construction.ConstructionStade;
import com.model.Escalier;
import com.model.Orientation;
import com.model.Place;
import com.model.Rang;
import com.model.Stade_Impl;

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
	 * @param tarif the tarif to set
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
	 * @param catAccessibles the catAccessibles to set
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
	 * @param orientationAccessibles the orientationAccessibles to set
	 */
	public void setOrientationAccessibles(String[] orientationAccessibles) {
		this.orientationAccessibles = orientationAccessibles;
	}

	/**
	 * @return the typeEv
	 */
	public int getTypeEv() {
		return typeEv;
	}

	/**
	 * @param typeEv the typeEv to set
	 */
	public void setTypeEv(int typeEv) {
		this.typeEv = typeEv;
	}

	public double getPrixCat(String idCat) {
		return tarif.get(idCat);
	}

	public String getNomEv() {
		return nomEv;
	}

	public void setNomEv(String nomEv) {
		this.nomEv = nomEv;
	}

	public HashMap<String, Double> getPrixCat() {
		return tarif;
	}

	public void setPrixCat(HashMap<String, Double> tarif) {
		this.tarif = tarif;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date nouvDate) {
		date = nouvDate;
	}
	
	public Stade_Impl getStade() {
		return stade;
	}

	public void setStade(Stade_Impl stade) {
		this.stade = stade;
	}
	
	public ArrayList<Place> getPlacesLibre() {
		ArrayList<Place> res = new ArrayList<Place>();

		for (Orientation o : stade.getOrientations()) {
			res.addAll(getPlacesLibre(o.getNom()));
		}
		return res;
	}

	public ArrayList<Place> getPlacesLibre(String nomOrientation) {
		ArrayList<Place> res = new ArrayList<Place>();
		int index = -1;
		for(int i=0; i<stade.getOrientations().size();i++)
			if(stade.getOrientations().get(i).getNom().equals(nomOrientation))
				index = i;
		
		if(index == -1)
			return res;

		for (Escalier e : stade.getOrientations().get(index).getEscalier().values()) {
			if (myContains(this.getOrientationAccessibles(), nomOrientation)) {
				res.addAll(getPlacesLibre(nomOrientation, e.getNomEsc()));
			}
		}
		return res;
	}

	public ArrayList<Place> getPlacesLibre(String nomOrientation, String idEscalier) {
		ArrayList<Place> res = new ArrayList<Place>();
		int index = -1;
		for(int i=0; i<stade.getOrientations().size();i++)
			if(stade.getOrientations().get(i).getNom().equals(nomOrientation))
				index = i;
		
		if(index == -1)
			return res;

		for (Rang r : stade.getOrientations().get(index).getEscalier().get(idEscalier).getRang().values()) {
			if (myContains(this.getOrientationAccessibles(), nomOrientation)) {
				res.addAll(getPlacesLibre(nomOrientation, idEscalier, r.getNumeroRang()));
			}
		}
		return res;
	}

	public ArrayList<Place> getPlacesLibre(String nomOrientation, String idEscalier, int idRang) {
		ArrayList<Place> res = new ArrayList<Place>();
		int index = -1;
		for(int i=0; i<stade.getOrientations().size();i++)
			if(stade.getOrientations().get(i).getNom().equals(nomOrientation))
				index = i;
		
		if(index == -1)
			return res;

		for (Place p : stade.getOrientations().get(index).getEscalier().get(idEscalier).getRang().get(idRang)
				.getPlaces().values()) {
			if (myContains(this.getOrientationAccessibles(), nomOrientation) && p.isEstLibre()) {
				res.add(p);
			}
		}
		return res;
	}

	private static boolean myContains(String[] op1, String op2) {
		for (int i = 0; i < op1.length; i++)
			if (op1[i].equals(op2))
				return true;

		return false;
	}
}
