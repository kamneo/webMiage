package com.metiers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import com.model.Billeterie;
import com.model.Evenement.Evenement;
import com.model.Evenement.Musique;
import com.model.Evenement.Sport;

import sun.nio.cs.ext.MacArabic;

public class EvenementMetier {
	public EvenementMetier(){
		
	}
	
	/**
	 * methode qui retourne tous les évenements créés dans la billeterie
	 * @return ArrayList<Evenement> - Liste des evenements disponible
	 */
    public ArrayList<Evenement> getAllEvenement() {
        System.out.println("getEvenement");
        return Billeterie.getAllEvenements();
    }
	
    /**
     * Methode qui retourne l'évenement en fonction de son nom dans la billeterie. 
     * S'il l'evenement n'existe pas, un exception est générée.
     * @param nomEv - nom de l'evenement à rechercher
     * @return Evenement - l'evenement recherché
     */
    public Evenement getEvenement(String nomEv) {
        System.out.println("getEvent");
       
        try {
            if (Billeterie.getInstance().getEvenements().containsKey(nomEv))
                return Billeterie.getInstance().getEvenements().get(nomEv);
            else
            	throw new Exception("Evenement introuvable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    
    public void creerEvenement(int typeEv, String nomEv,  String date, HashMap<String, Double> tarif) throws ParseException{
    	Evenement e;
    	if(typeEv == 0)
    		BilleterieMetier.creerSport(nomEv, date, tarif);
    	else
    		BilleterieMetier.creerMusique(nomEv, date, tarif);
    }

}
