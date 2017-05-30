package com.tests;

import com.construction.ConstructionStade;
import com.model.Billeterie;
import com.model.Stade_Impl;

import java.io.File;

import javax.sql.rowset.serial.SerialArray;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class BuildXML {
	public static void main(String[] args) {
		buildStade();

	}
	
	public static void buildStade(){
		ConstructionStade cs = new ConstructionStade();
		Stade_Impl stade = cs.getStade();

		serialize(stade, "stade.xml");
	}
	
	public static void buildEvenement(){
		Billeterie b = Billeterie.getInstance();
		serialize(b, "billeterie.xml");
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
