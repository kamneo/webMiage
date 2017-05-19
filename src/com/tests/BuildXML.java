package com.tests;

import com.construction.ConstructionStade;
import com.model.Billeterie;
import com.model.Stade_Impl;

import java.io.File;

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

		try {

			 File file = new File("file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Stade_Impl.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(stade, file);
			jaxbMarshaller.marshal(stade, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static void buildEvenement(){
		Billeterie b = new Billeterie();
	}

}
