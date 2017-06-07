package com.serialisation;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.model.Stade_Impl;

public class XMLMarshall {
	public static void ObjectToXML(Object o, String path){
		try {

			 File file = new File(path);
			JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(o, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static Object XMLTo(Class<?> o, String path) throws JAXBException{
		File file = new File(path);
	    JAXBContext jaxbContext = JAXBContext.newInstance(o);

	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    return jaxbUnmarshaller.unmarshal(file);
	}
	
	public static String ObjectToString(Object o) throws JAXBException {
		java.io.StringWriter sw = new StringWriter();

	    JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(o, sw);
		
		return sw.toString();

	}
}
