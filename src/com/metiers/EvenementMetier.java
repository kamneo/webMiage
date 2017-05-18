package com.metiers;

import java.util.ArrayList;

import com.model.Billeterie;
import com.model.Evenement.Evenement;
import com.model.Evenement.Musique;
import com.model.Evenement.Sport;

import sun.nio.cs.ext.MacArabic;

public class EvenementMetier {
	public EvenementMetier(){
		
	}
	
    public ArrayList<Evenement> getAllEvenement() {
        System.out.println("getEvenement");
        return Billeterie.getAllEvenements();
    }
	
    public Evenement getEvenement(String nomEv) {
        System.out.println("getEvent");

        if (Billeterie.getEvenements().containsKey(nomEv)) {
            return Billeterie.getEvenements().get(nomEv);
        }
        
        try {
			throw new Exception("Evenement introuvable");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    
    public void creerEvenement(int typeEv){
    	Evenement e;
    	if(typeEv == 0)
    		Billeterie.creerSport();
    	else
    		Billeterie.creerMusique();
    }

}
