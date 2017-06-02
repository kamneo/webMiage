package com.metiers;

import java.text.ParseException;
import java.util.HashMap;

import com.model.Billeterie;
import com.model.Reservation;

public class BilleterieMetier {
	private static Billeterie billeterie;
	
	public BilleterieMetier(){
		billeterie = Billeterie.getInstance();
	}


	public static void creerSport(String nomEv, String date, HashMap<String, Double> tarif, String equipe1, String equipe2, String description) throws ParseException {
		billeterie.creerSport(nomEv, date, tarif, equipe1, equipe2, description);
	}

	public static void creerMusique(String nomEv,  String date, HashMap<String, Double> tarif, String description) throws ParseException {
		billeterie.creerMusique(nomEv,  date, tarif, description);
	}
	
	public static void supprimerEvenement(String nomEv) {
		billeterie.supprimerEvenement(nomEv);
	}
	
	public static void validerReservation(Reservation[] res) throws Exception{
		for(int i=0;i<res.length;i++){ 
			billeterie.acheterPlace(res[i]);
		}
	}
}
