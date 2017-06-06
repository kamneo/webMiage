package com.tests;

import com.construction.ConstructionStade;
import com.model.Billeterie;
import com.model.Client_BD;
import com.model.Reservation_BD;
import com.model.Stade_Impl;
import com.model.Evenement.Evenement;
import com.model.Evenement.Sport;
import com.serialisation.XMLMarshall;
import com.model.Client;

import java.io.File;
import java.text.ParseException;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class BuildXML {
	private final static String relativePath = "DataBase/";
	public static void main(String[] args) throws Exception {
		buildBilleterie();
	}
	
	public static void buildStade(){
		ConstructionStade cs = new ConstructionStade();
		Stade_Impl stade = cs.getStade();

		XMLMarshall.ObjectToXML(stade, relativePath+"stade.xml");
	}
	
	public static void buildBilleterie(){
		Billeterie b = Billeterie.getInstance();
		
		XMLMarshall.ObjectToXML(b, relativePath+"billetterie.xml");
	}
	
	public static void buildClient_BD(Client_BD cbd){
		XMLMarshall.ObjectToXML(cbd, relativePath+"client_BD.xml");
	}
	
	public static void buildReservation_BD(Reservation_BD rbd){
		XMLMarshall.ObjectToXML(rbd, relativePath+"reservation_BD.xml");
	}

}
