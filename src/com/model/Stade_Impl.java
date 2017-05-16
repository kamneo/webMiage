package com.model;

import java.util.HashMap;
import com.model.Categorie;;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Stade")
public class Stade_Impl {
	private String nom;
	private HashMap<String, Categorie> categorie;
	private HashMap<String, Object> orientation;
	
	public Stade_Impl(String nom) {
		this.nom=nom;
		
	}
}
