package com.demo.vip.controller;

import com.demo.vip.metier.ApplicationData;
import com.demo.vip.metier.Personne;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/annuaireform")
public class AnnuairePersonneFormServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/personnesFormulaire.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // récpérer les données dans la requete qui ont été envoyées par
        // l'utilisateur à travers le Form HTML
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String vipString = request.getParameter("vip");
        // parser le nombre dans le String
        boolean vip = false;
        try {
             vip = Boolean.parseBoolean(vipString);
        }
        catch (Exception e){
            // à compléter
        }

        // code métier : enregistrer la Plante dans la Serre
        Personne p = new Personne(prenom, nom, vip);
        ApplicationData.annuaire.addPersonne(p);

        doGet(request, response);
    }
}
