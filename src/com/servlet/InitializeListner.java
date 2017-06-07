package com.servlet;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.bind.JAXBException;

import com.model.Billeterie;
import com.serialisation.XMLMarshall;


@WebListener
public class InitializeListner implements ServletContextListener {
	
	@Override
	public final void contextInitialized(final ServletContextEvent sce) {
		try {
			System.out.println(sce.getServletContext().getRealPath("/DataBase/billetterie.xml"));
			Billeterie b = Billeterie.getInstance(); 
			b.load((Billeterie)XMLMarshall.XMLTo(Billeterie.class, sce.getServletContext().getRealPath("/DataBase/billetterie.xml")));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public final void contextDestroyed(final ServletContextEvent sce) {
		Billeterie b = Billeterie.getInstance(); 
		XMLMarshall.ObjectToXML(b, sce.getServletContext().getRealPath("/DataBase/billetterie.xml"));
	}
}