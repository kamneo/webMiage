package com.model.Evenement;

import java.util.HashMap;

public class Sport extends Evenement {
	
	public Sport(){
		String[] catAccessibles = new String [3];
		String[] orientationAccessibles = new String [4];
		super("test", new HashMap<String, Double>(), 0);
	}
	
	public Sport(String nomEv, HashMap<String, Double> tarif){
		String[] catAccessibles = new String[3];
		String[] orientationAccessibles = new String [4];
		catAccessibles= ["Or", "Argent", "Bronze"];
		orientationAccessibles =new String["Nord", "Sud", "Est", "Ouest"];
		super(nomEv, tarif, 0, catAccessibles, orientationAccessibles);
	}

}
