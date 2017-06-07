package com.tests;

import java.util.HashMap;

import com.construction.ConstructionStade;
import com.model.Billet;
import com.model.Billeterie;
import com.model.Client;
import com.model.Client_BD;
import com.model.Escalier;
import com.model.Orientation;
import com.model.Place;
import com.model.Rang;
import com.model.Reservation;
import com.model.Evenement.Evenement;
import com.model.Evenement.Musique;
import com.model.Evenement.Sport;

public class testResa {
	public static void main(String[] args) throws Exception {		
		Billeterie b = Billeterie.getInstance();
		
		Evenement e1 = new Sport("e1", "01/01/2005", new HashMap<String, Double>(), "eux", "nous", "description");
		Evenement e2 = new Musique("e2", "01/01/2005", new HashMap<String, Double>(), "description");
		
		b.ajouterEvenement(e1);
		b.ajouterEvenement(e2);
		
		System.out.println(e1.getNomEv());
		System.out.println(b.getEvenements().get(1).getPlacesLibre().size());
		
		Orientation ob1 = e1.getStade().getOrientations().get(2);
		Escalier esc = ob1.getEscalier().get("esc1");
		Rang r = esc.getRang().get(1);
		Place p = r.getPlaces().get(3);
		
		b.acheterPlace(new Reservation("e1", new Billet(ob1, esc, r, p, 23.8) , "aaa@aaa.com"));
		
		System.out.println(b.getEvenements().get(1).getPlacesLibre().size());
	
	}
}
