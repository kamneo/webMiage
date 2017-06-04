package com.tests;

import com.construction.ConstructionStade;
import com.model.Billeterie;
import com.model.Client_BD;
import com.model.Reservation_BD;
import com.model.Stade_Impl;
import com.model.Evenement.Evenement;
import com.model.Evenement.Sport;
import com.model.Client;

import java.io.File;
import java.text.ParseException;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class BuildXML {
	public static void main(String[] args) throws Exception {
		//buildStade();
		buildEvenement();
		
		/*Client_BD cbd = Client_BD.getinstance();
		Client c1 = new Client();
		Client c2 = new Client("joffrey@gmail.com","azerty", "Ronald", "jeff");
		cbd.ajouterClients(c1);
		cbd.ajouterClients(c2);

		buildClient_BD(cbd);
		
		serialize(c1, "toto.xml");
		
		
		Reservation_BD rbd = Reservation_BD.getInstance();
		
		buildReservation_BD(rbd);*/
	}
	
	public static void buildStade(){
		ConstructionStade cs = new ConstructionStade();
		Stade_Impl stade = cs.getStade();

		serialize(stade, "stade.xml");
	}
	
	public static void buildEvenement(){
		Billeterie b = Billeterie.getInstance();
		serialize(b, "billeterie.xml");
		
		Evenement ev;
		try {
			ev = new Sport("test", "03/03/2017 00:00", new HashMap<String, Double>(), "eux", "nous", "description");
			b.ajouterEvenement(ev);
			serialize(b, "test_billetterie.xml");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void buildClient_BD(Client_BD cbd){
		serialize(cbd, "client_BD.xml");
	}
	
	public static void buildReservation_BD(Reservation_BD rbd){
		serialize(rbd, "reservation_BD.xml");
	}
	
	public static void serialize(Object o, String path){
		try {

			 File file = new File(path);
			JAXBContext jaxbContext = JAXBContext.newInstance(Stade_Impl.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(o, file);
			jaxbMarshaller.marshal(o, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
