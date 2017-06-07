package com.metiers;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import com.model.Billeterie;
import com.model.Evenement.Evenement;
import com.serialisation.XMLMarshall;

@Path("/evenements")
public class EvenementMetier {
	
	/**
	 * methode qui retourne tous les évenements créés dans la billeterie
	 * @return ArrayList<Evenement> - Liste des evenements disponible
	 * @throws JAXBException 
	 */
	@GET
	@Produces({"text/plain","application/xml","application/json"})
    public String getAllEvenement() throws JAXBException {
		String s = "";
		for(Evenement ev : Billeterie.getInstance().getAllEvenements()){
			s += XMLMarshall.ObjectToString(ev);
		}
		return s;

    }
	
	 /**
     * Methode qui retourne l'évenement en fonction de son nom dans la billeterie. 
     * S'il l'evenement n'existe pas, un exception est g�n�r�e.
     * @param nomEv - nom de l'evenement à rechercher
     * @return Evenement - l'evenement recherché
     * @throws JAXBException 
     */
	@GET
	@Path("/{id}")
	@Produces({"text/plain","application/xml","application/json"})
    public String getEvenement(@PathParam("id")String IdEv) throws JAXBException {
		int idEvenement = Integer.parseInt(IdEv);
		String s = "";
		Evenement e = Billeterie.getInstance().getEvenements().get(idEvenement);
        if (e != null){
        	s = XMLMarshall.ObjectToString(e);
        }
        return s;
    }
}
