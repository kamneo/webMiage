package com.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Billet {
	private Orientation or;
	private Escalier esc;
	private Rang rang;
	private Place pl;
	private double prix;

	/**
	 * Constructeur par d�fault
	 */
	public Billet() {

	}

	/**
	 * Constructeur de billet
	 * 
	 * @param or
	 *            orientation ou se situe la place
	 * @param esc
	 *            escalier ou se situe la place
	 * @param rang
	 *            rang ou se situe la place
	 * @param pl
	 *            place ou se situe la place
	 * @param prix
	 *            prix ou se situe la place
	 */
	public Billet(Orientation or, Escalier esc, Rang rang, Place pl, double prix) {
		this.setOrientation(or);
		this.setEsc(esc);
		this.setRang(rang);
		this.setPl(pl);
		this.setPrix(prix);
	}

	/**
	 * Retourne l'orientation � laquelle se trouve la place
	 * 
	 * @return Orientation
	 */
	public Orientation getOrientation() {
		return or;
	}

	/**
	 * Permet la modification de l'orientation � laquelle se trouve la place
	 * 
	 * @param or
	 *            - Orientation
	 */
	public void setOrientation(Orientation or) {
		this.or = or;
	}

	/**
	 * Retourne l'escalier ou est la place
	 * 
	 * @return
	 */
	public Escalier getEsc() {
		return esc;
	}

	/**
	 * Permet la modification de l'ecalier d'ou se trouve la place
	 * 
	 * @param esc
	 */
	public void setEsc(Escalier esc) {
		this.esc = esc;
	}

	/**
	 * Getter de l'objet rang
	 * 
	 * @return
	 */
	public Rang getRang() {
		return rang;
	}

	/**
	 * Setter de l'objet rang
	 * 
	 * @param rang
	 */
	public void setRang(Rang rang) {
		this.rang = rang;
	}

	/**
	 * Getter de l'objet place
	 * 
	 * @return
	 */
	@XmlElement(name = "place")
	public Place getPl() {
		return pl;
	}

	/**
	 * Setter de l'objet place
	 * 
	 * @param pl
	 */
	public void setPl(Place pl) {
		this.pl = pl;
	}

	/**
	 * Getter de l'objet prix
	 * 
	 * @return
	 */
	@XmlElement(name = "prix")
	public double getPrix() {
		return prix;
	}

	/**
	 * Setter de l'objet prix
	 * 
	 * @param prix
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}
}