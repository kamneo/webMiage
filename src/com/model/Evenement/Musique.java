package com.model.Evenement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class Musique extends Evenement{
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public Musique(){
		super();
		this.catAccessibles = new String[4];
		this.catAccessibles[0] = "Or";
		this.catAccessibles[1] = "Argent";
		this.catAccessibles[2] = "Bronze";
		this.catAccessibles[3] = "Terrain";
		this.orientationAccessibles =new String[3];
		this.orientationAccessibles[0] = "Nord";
		this.orientationAccessibles[1] = "Sud";
		this.orientationAccessibles[2] = "Est";
		this.typeEv=1;
	}
	
	public Musique(String nomEv,  String date, HashMap<String, Double> tarif) throws ParseException{

		super(tarif, formatter.parse(date), nomEv);
		this.catAccessibles = new String[4];
		this.catAccessibles[0] = "Or";
		this.catAccessibles[1] = "Argent";
		this.catAccessibles[2] = "Bronze";
		this.catAccessibles[3] = "Terrain";
		this.orientationAccessibles =new String[3];
		this.orientationAccessibles[0] = "Nord";
		this.orientationAccessibles[1] = "Sud";
		this.orientationAccessibles[2] = "Est";
		this.typeEv=1;
	}
	
}


