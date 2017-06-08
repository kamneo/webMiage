package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Escalier;
import com.utils.UtilsResa;

@WebServlet("/AjaxEscalier")
public class AjaxEscalier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilsResa UR = new UtilsResa();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String orientation = request.getParameter("orientation");
		String strid = request.getParameter( "idEvent" );
		long id = Long.valueOf(strid);
		
		ArrayList<Escalier> escaliers = UR.getEscalier(id, orientation);
	
		StringBuilder sb = new StringBuilder();
		for (Escalier e: escaliers) {
			sb.append("<option value ='");
			sb.append(e.getNomEsc());
			sb.append("'> " + e.getNomEsc() + "</option>");
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sb.toString());
	}
}