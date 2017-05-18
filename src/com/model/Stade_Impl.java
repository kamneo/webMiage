package com.model;

import java.util.HashMap;
import com.model.Categorie;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Stade")
public class Stade_Impl {
	private String nom;
	private HashMap<String, Object> orientation;

	public Stade_Impl() {
		this.nom = "defaut";
		orientation = new HashMap<String, Object>();
	}
	
	public Stade_Impl(String nom, Orientation[] or) {
		this.nom = nom;
		orientation = new HashMap<String, Object>();
		for (int i = 0; i < or.length; i++) {
			orientation.put(or[i].getNom(), or[i]);
		}
	}

	@XmlElement(name="nbPlace")
	public long getNbPlace() {
		long count = 0;
		for (Object o : orientation.values()) {
			for (Escalier e : ((Orientation) o).getEscalier().values()) {
				for(Rang r : e.getRang().values()){
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
	public HashMap<String, Object> getOrientations() {
		return orientation;
	}
}
