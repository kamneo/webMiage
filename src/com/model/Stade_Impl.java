package com.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Stade")
public class Stade_Impl {
	private String nom;
	//private HashMap<String, Object> orientation;
	private ArrayList<Orientation> orientation;
	private static Stade_Impl instance = null;

	public Stade_Impl() {
		this.nom = "defaut";
		orientation = new ArrayList<Orientation>();
	}
	
	public Stade_Impl(String nom, Orientation[] or) {
		this.nom = nom;
		orientation = new ArrayList<Orientation>();
		for (int i = 0; i < or.length; i++) {
			orientation.add(or[i]);
		}
	}

	@XmlElement(name="nbPlace")
	public long getNbPlace() {
		long count = 0;
		for (Object o : orientation) {
			for (Escalier e : ((Orientation) o).getEscalier()) {
				for(Rang r : e.getRang()){
					count += r.getPlaces().size();
				}
			}
		}
		
		return count;
	}
	
	@XmlAttribute
	public String getNom() {
		return nom;
	}
	
	@XmlElement(name="orientation")
	public ArrayList<Orientation> getOrientations() {
		return orientation; 
	}
	
	/**
	 * 
	 * Point d'accès pour l'instance unique du singleton
	 */
	public static synchronized Stade_Impl getInstance() {
		if (instance == null) {
			instance = new Stade_Impl();
		}
		return instance;
	}
}
