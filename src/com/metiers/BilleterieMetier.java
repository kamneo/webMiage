package com.metiers;

import java.text.ParseException;
import java.util.HashMap;

import com.model.Billet;
import com.model.Billeterie;
import com.model.Escalier;
import com.model.Orientation;
import com.model.Place;
import com.model.Rang;
import com.model.Reservation;
import com.model.Evenement.Evenement;

public class BilleterieMetier {
	private static Billeterie billeterie;
	
	public BilleterieMetier(){
		billeterie = Billeterie.getInstance();
	}


	public static void creerSport(String nomEv, String date, HashMap<String, Double> tarif) throws ParseException {
		billeterie.creerSport(nomEv, date, tarif);
	}

	public static void creerMusique(String nomEv,  String date, HashMap<String, Double> tarif) throws ParseException {
		billeterie.creerMusique(nomEv,  date, tarif);
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