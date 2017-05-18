package com.model;

import java.text.ParseException;
import java.util.HashMap;

import com.model.Evenement.Evenement;

public class main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		HashMap<String, Double> hashtest = new HashMap<String, Double>();
		hashtest.put("0", 0.10);
		hashtest.put("1", 0.25);
		hashtest.put("2", 0.5);
		Evenement evt = Billeterie.creerMusique(hashtest, "10/10/1020", "Super Papi");
		
		System.out.println(evt.getOrientationAccessibles()[2]);
	}

}
