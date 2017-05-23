package com.model;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Billet{
	private Orientation or;
	private Escalier esc;
	private Rang rang;
	private Place pl;
	private double prix;
	
	public Billet(){
		
	}
	
/** 
 * 
 * @param or orientation ou se situe la place
 * @param esc escalier ou se situe la place
 * @param rang rang ou se situe la place
 * @param pl place ou se situe la place
 * @param prix prix ou se situe la place
 */
	public Billet(Orientation or, Escalier esc, Rang rang, Place pl, double prix){
		this.setOr(or);
		this.setEsc(esc);
		this.setRang(rang);
		this.setPl(pl);
		this.setPrix(prix);	
	}

	public Orientation getOr() {
		return or;
	}

	public void setOr(Orientation or) {
		this.or = or;
	}

	public Escalier getEsc() {
		return esc;
	}

	public void setEsc(Escalier esc) {
		this.esc = esc;
	}

	public Rang getRang() {
		return rang;
	}

	public void setRang(Rang rang) {
		this.rang = rang;
	}

	public Place getPl() {
		return pl;
	}

	public void setPl(Place pl) {
		this.pl = pl;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}