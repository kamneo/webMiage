package com.model;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Place")
public class Place {
	private int numero;
	private boolean estLibre;

	/**
<<<<<<< HEAD
	 * Constructeur
=======
	 * constructeur par défault
	 */
	public Place(){
		
	}
	
	/**
	 * 
>>>>>>> 1288926f4df07119eedf2c0721b9ea551ec3d5fd
	 * @param numero
	 * @param estAchetee
	 * Construit l'objet Place avec le numéro passe en premier paramètre et non réservé
	 */
	public Place(int numero) {
		this.setNumero(numero);
<<<<<<< HEAD
		this.setEstLibre(true);
=======
		this.setestLibre(true);
>>>>>>> 1288926f4df07119eedf2c0721b9ea551ec3d5fd
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
