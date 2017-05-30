package com.serialisation;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.model.Stade_Impl;

public class XMLMarshall {
	public static void ObjectToXML(Object o, String path){
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
	
	public static void XMLTo(Object o, String path){
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
