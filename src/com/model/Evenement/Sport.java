package com.model.Evenement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class Sport extends Evenement {
	private String equipe1 = "";
	private String equipe2 = "";
	
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
	
	public Sport(String nomEv, String date, HashMap<String, Double> tarif, String equipe1, String equipe2, String description) throws ParseException{
		super(tarif, formatter.parse(date), nomEv, description);
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
		this.setEquipe1(equipe1);
		this.equipe2=equipe2;
	}

	public String getEquipe1() {
		return equipe1;
	}

	public void setEquipe1(String equipe1) {
		this.equipe1 = equipe1;
	}

	public String getEquipe2() {
		return equipe2;
	}

	public void setEquipe2(String equipe2) {
		this.equipe2 = equipe2;
	}

}
