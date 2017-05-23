package com.metiers;

import java.util.HashMap;

import com.model.Billeterie;

public class BilleterieMetier {
	private static Billeterie billeterie;
	
	public BilleterieMetier(Billeterie b){
		billeterie = b;
	}
	


	public static void creerSport(String nomEv, String date, HashMap<String, Double> tarif) {
		billeterie.creerSport(nomEv, date, tarif);
	}

	public static void creerMusique(String nomEv,  String date, HashMap<String, Double> tarif) {
		billeterie.creerMusique(nomEv,  date, tarif);
	}
	
	public static void supprimerEvenement(String nomEv) {
		billeterie.supprimerEvenement(nomEv);
	}

}
