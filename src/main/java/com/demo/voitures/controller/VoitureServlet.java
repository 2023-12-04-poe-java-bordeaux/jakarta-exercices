package com.demo.voitures.controller;

import com.demo.voitures.metier.Garage;
import com.demo.voitures.metier.Voiture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/voitures")
public class VoitureServlet extends HttpServlet {

    private Garage garage = new Garage();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("voitures", garage.getVoitures());
        request.getRequestDispatcher("WEB-INF/voitures.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // récpérer les données dans la requete qui ont été envoyées par
        // l'utilisateur à travers le Form HTML
        String nom = request.getParameter("nom");
        String marque = request.getParameter("marque");
        String immatriculation = request.getParameter("immatriculation");
        String anneeString = request.getParameter("annee");
        // parser le nombre dans le String
        int annee = 0;
        try {
             annee = Integer.parseInt(anneeString);
        }
        catch (NumberFormatException e){
            // à compléter
        }

        // code métier : enregistrer la Plante dans la Serre
        Voiture voiture = new Voiture(nom, marque, immatriculation, annee);
        garage.addVoiture(voiture);

        doGet(request, response);
    }
}
