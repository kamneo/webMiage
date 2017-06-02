package com.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Billeterie;
import com.model.Evenement.Evenement;
import com.model.Evenement.Musique;
import com.model.Evenement.Sport;
import com.utils.Utilitaire;

/**
 * Servlet implementation class AjouterEvenement
 */
@WebServlet("/ajouterEvenement")
public class AjouterEvenement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Billeterie billeterie = Billeterie.getInstance();
	private Map<String, String> erreurs = new HashMap<String, String>();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterEvenement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categories", Utilitaire.getAllCategories());
		request.setAttribute("orientations", Utilitaire.getAllOrientation());
		this.getServletContext().getRequestDispatcher("/AjouterEvenement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("typeEvenement");
		String nom = request.getParameter("nom");
		String prixCat2 = request.getParameter(Utilitaire.getAllCategories().get(1));
		String prixCat3 = request.getParameter(Utilitaire.getAllCategories().get(2));
		String prixCat1 = request.getParameter(Utilitaire.getAllCategories().get(0));
		String prixOR = request.getParameter(Utilitaire.getAllCategories().get(3));
		String date = request.getParameter("date");
		String heure = request.getParameter("time");
		String description = request.getParameter("description");
		String equipe2 = request.getParameter("equipe2");
		String equipe1 = request.getParameter("equipe1");
		
		// Controls sur le champ type
		if(type == null){
			erreurs.put("type", "Vous devez séléctionner le type d'événement !");
		}
		
		// Controls sur le champ nom
		if(nom == null || nom.equals("")){
			erreurs.put("nom", "Veuillez renseigner le nom de l'événement !");
		}
		
		// Controls sur le champ date
		if(!validateDate(date)){
			erreurs.put("date", "Veuillez renseigner la date de l'événement !");
		}
		
		// Controls sur le champ heure
		if(!validateHeure(heure)){
			erreurs.put("time", "Veuillez renseigner l'heure de l'événement !");
		}
		
		// Controls sur le champ description
		if(!validate(description)){
			erreurs.put("description", "Veuillez renseigner la description de l'événement !");
		}

		// Controls sur le champ des prix
		validatePrix("Cat1", prixCat1);
		validatePrix("Cat2", prixCat2);
		validatePrix("Cat3", prixCat3);
		if(type != null && type.equals("2")){
			validatePrix("OR", prixOR);
		}else{
			// Controls sur le champ équipe 1
			if(!validate(equipe1)){
				erreurs.put("equipe1", "Veuillez renseigner le nom de l'équipe 1 !");
			}
			
			// Controls sur le champ équipe 2
			if(!validate(equipe2)){
				erreurs.put("equipe2", "Veuillez renseigner le nom de l'équipe 2 !");
			}
		}
		
		for(String s : erreurs.values())
			System.out.println(s);
		
		if(erreurs.size() != 0){
			request.setAttribute("erreurs", erreurs);
			doGet(request, response);
		}
		
		Evenement e = null;
		HashMap<String, Double> tarif = new HashMap<>();
		tarif.put("cat1", Double.parseDouble(prixCat1));
		tarif.put("cat2", Double.parseDouble(prixCat2));
		tarif.put("cat3", Double.parseDouble(prixCat3));
		if(type.equals("1")){
			try {
				e = new Sport(nom, date+ " " +heure, tarif, equipe1, equipe2, description);
				billeterie.ajouterEvenement(e);
			} catch (ParseException e1) {
				erreurs.put("evenement", "Impossible de créer l'événement : " + e1.getMessage());
			}
		}else if (type.equals("2")) {
			tarif.put("OR", Double.parseDouble(prixOR));
			try {
				e = new Musique(nom, date+ " " +heure, tarif, description);
				billeterie.ajouterEvenement(e);
			} catch (ParseException e1) {
				erreurs.put("evenement", "Impossible de créer l'événement : " + e1.getMessage());
			}
		}else
			erreurs.put("path", "Un problème est survenue ! <br> veuillez recommencer");
		
		response.sendRedirect("evenements");
	}

	private boolean validateHeure(String heure) {
		return validate(heure);
	}

	private boolean validateDate(String date) {
		return validate(date);
	}

	private void validatePrix(String name, String prix) {
		if(!validate(prix)){
			erreurs.put(name, "Veuillez renseigner le prix pour cet catégorie !");
			return;
		}
		
		try {
			Double.parseDouble(prix);
        } catch (NumberFormatException e) {
			erreurs.put(name, "Le prix n'est pas au bon format ! (xx.xx)");
        }
	}

	/**
	 * retourne vrai si le parametre est correctement renseigné
	 * @param op1
	 * @return
	 */
	private boolean validate(String op1) {
		return !op1.equals("") && op1 != null && !op1.isEmpty() && op1.length() != 0;
	}

}
