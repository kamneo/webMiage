package com.model.Evenement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class Sport extends Evenement {
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public Sport(){
		super();
		this.catAccessibles = new String[3];
		this.catAccessibles[0] = "Or";
		this.catAccessibles[1] = "Argent";
		this.catAccessibles[2] = "Bronze";
		this.orientationAccessibles =new String[4];
		this.orientationAccessibles[0] = "Nord";
		this.orientationAccessibles[1] = "Sud";
		this.orientationAccessibles[2] = "Est";
		this.orientationAccessibles[3] = "Ouest";
		this.typeEv=0;
	}
	
	public Sport(String nomEv, String date, HashMap<String, Double> tarif) throws ParseException{
		
		super(tarif, formatter.parse(date), nomEv);
		this.catAccessibles = new String[3];
		this.catAccessibles[0] = "Or";
		this.catAccessibles[1] = "Argent";
		this.catAccessibles[2] = "Bronze";
		this.orientationAccessibles =new String[4];
		this.orientationAccessibles[0] = "Nord";
		this.orientationAccessibles[1] = "Sud";
		this.orientationAccessibles[2] = "Est";
		this.orientationAccessibles[3] = "Ouest";
		this.typeEv=0;
		
	}

}
