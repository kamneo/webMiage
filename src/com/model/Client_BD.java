package com.model;

import java.util.HashMap;

public class Client_BD {
	private HashMap<String, Client> clients;
	
	public Client_BD(){
		
	}
	
	/**
	 * 
	 * @param mail est l'adresse mail du client qui lui sert d'identifiant unique
	 * @param client est un objet de la classe client qui contient toutes les informations relatives au client
	 */
	public Client_BD(String mail, Client client){
		this.clients = new HashMap<String, Client>();
		this.clients.put(mail, client);
		
	}
	
	public void AjouterClient(Client nouvClient) throws Exception{
		if(clients.containsKey(nouvClient.getMail())) // test d'unicité du client par rapport à son adresse mail
			throw new Exception("Adresse mail déjà utilisée !");
		else
			this.clients.put(nouvClient.getMail(), nouvClient); // creation d'un nouveau client
	}

}
