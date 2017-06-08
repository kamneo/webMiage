package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Place;
import com.utils.UtilsResa;

@WebServlet("/AjaxPlace")
public class AjaxPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilsResa UR = new UtilsResa();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orientation = request.getParameter("orientation");
		String strid = request.getParameter( "idEvent" );
		long id = Long.valueOf(strid);
		String escalier = request.getParameter("escalier");
		String stgrang = request.getParameter("rang");
		int rang= Integer.valueOf(stgrang);
		
		ArrayList<Place> places = UR.getPlace(id, orientation, escalier, rang);
		ArrayList<Place> placesLibres=UR.getPlaceLibre(places);
		
		StringBuilder sb = new StringBuilder();
		for (Place p: placesLibres) {
			sb.append("<option value ='");
			sb.append(p.getNumero());
			sb.append("'> " + p.getNumero() + "</option>");
		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sb.toString());
	}
}