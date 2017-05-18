package com.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Place")
public class Place {
	private int numero;
	private boolean estLibre;

	/**
	 * Constructeur
	 * @param numero
	 * @param estAchetee
	 * Construit l'objet Place avec le numéro passe en premier paramètre et non réservé
	 */
	public Place(int numero) {
		this.setNumero(numero);
		this.setEstLibre(true);
	}

	/**
	 * @return numero
	 * getNumero renvoi le nuéro de la place
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 * setNumero permet de changer le numéro de la place
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the estLibre
	 * isEstLibre retourn true si la place est libre et false dans le cas contraire
	 */
	public boolean isEstLibre() {
		return estLibre;
	}

	/**
	 * @param estLibre the estLibre to set
	 * permet de changer la valeur de estLibre 
	 */
	public void setEstLibre(boolean estLibre) {
		this.estLibre = estLibre;
	}
}
