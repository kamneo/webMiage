package com.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metiers.BilleterieMetier;
import com.model.Billeterie;
import com.model.Escalier;
import com.model.Orientation;
import com.model.Place;
import com.model.Rang;
import com.utils.UtilsResa;

@WebServlet("/reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilsResa UR = new UtilsResa();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String strid = request.getParameter( "idEvent" );
		long id = Long.valueOf(strid);
		request.setAttribute("orientations", UR.getOrientation(id));
		
		request.setAttribute("idEvent", strid);
		this.getServletContext().getRequestDispatcher("/nouvelleReservation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String idEv = request.getParameter("idEvent");
		String orientation = request.getParameter("orientation");
		String escalier = request.getParameter("escalier");
		String rang = request.getParameter("rang");
		String place = request.getParameter("place");
		String mail = request.getParameter("mail");
		String idReduc = request.getParameter("idReduc");
		
		HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:8080/Billeterie/API/billetterie/reserver/"+idEv+"/"+orientation+"/"+escalier+"/"+rang+"/"+place+"/"+idReduc+"/" +mail).openConnection();
	    connection.setRequestMethod("GET");
		
		/*try {
			Place p = BilleterieMetier.reserver(idEv, orientation, escalier, rang, place, idReduc, mail);
			if(p.isEstLibre()){
				throw new Exception("Une erreur s'est produite lors de la reservation");
			}
		} catch (Exception e) {
			request.setAttribute("erreur", "Une erreur s'est produite lors de la reservation");
			this.getServletContext().getRequestDispatcher("/erreurDeSuppression.jsp").forward(request, response);
			return;
		}*/
		
		request.setAttribute("messageJocker", "La place "+ place + " au rang " + rang + " a bien été réservé pour l'evenement "+ idEv);
		this.getServletContext().getRequestDispatcher("/evenements").forward(request, response);
	}
}
