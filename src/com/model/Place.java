package com.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Place")
public class Place {
	private int numero;
	private boolean estLibre;

	/**
	 * constructeur par défault
	 */
	public Place(){
		
	}
	
	/**
	 *
	 * @param numero - numero de la place
	 * @param estAchetee - statue de la place
	 * Construit l'objet Place avec le numéro passe en premier paramètre et non réservé
	 */
	public Place(int numero) {
		this.setNumero(numero);
		this.setEstLibre(true);
	}

	/**
	 * @return numero - numero de la place
	 * getNumero renvoi le nuéro de la place
	 */
	@XmlAttribute
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero - numero de la place
	 * setNumero permet de changer le numéro de la place
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return estLibre - statue de la place
	 * isEstLibre retourn true si la place est libre et false dans le cas contraire
	 */
	public boolean isEstLibre() {
		return estLibre;
	}

	/**
	 * @param estLibre - statue de la place
	 * permet de changer la valeur de estLibre 
	 */
	public void setEstLibre(boolean estLibre) {
		this.estLibre = estLibre;
	}
	
	public Object clone() {
		return new Place(numero);
	}
}
