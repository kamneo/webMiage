package com.model;

import java.text.ParseException;
import java.util.HashMap;
import com.model.Evenement.Evenement;

public class main {

	public static void main(String[] args) throws ParseException {
		HashMap<String, Client> c = new HashMap<String, Client>();
		HashMap<String, Client> cl = new HashMap<String, Client>();
		Client client1 = new Client();
		Client client2 = new Client();
		Client client3 = new Client();
		Client client5 = new Client();
		Client client4 = new Client();
		Client client6 = new Client();
		client6.setMail("gogo@gadget.fr");
		Client client7 = new Client();
		
		c.put("1", client1);
		c.put("2", client2);
		c.put("3", client3);
		c.put("4", client4);
		c.put("5", client5);
		
		cl.put("4", client4);
		cl.put("5", client5);
		cl.put("7", client7);

	}

}
