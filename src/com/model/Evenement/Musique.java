package com.model.Evenement;
import java.util.HashMap;

public class Musique extends Evenement{
	
	public Musique(){
		String[] catAccessibles = new String [4];
		String[] orientationAccessibles = new String [3];
		super("test", new HashMap<String, Double>(), 1);
	}
	
	public Musique(String nomEv, HashMap<String, Double> tarif){

		super(nomEv, tarif, 1, catAccessibles, orientationAccessibles);
	}
}


