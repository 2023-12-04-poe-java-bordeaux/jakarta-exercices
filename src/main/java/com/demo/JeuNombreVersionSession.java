package com.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Random;

@WebServlet("/jeunombresession")
public class JeuNombreVersionSession extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // utilisation encodage qui supporte les lettres accentuées...
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // recupération dans l'URL de la proposition du joueur
        String nombreString = request.getParameter("nombre");

        // initialisation nouvelle partie
        if(request.getSession().getAttribute("nombreADeviner") == null
            || (int)request.getSession().getAttribute("tentativesRestantes") == 0){
            initialisationPartie(request, response);
        }

        try {
            int proposition = Integer.parseInt(nombreString);

            int nombreADeviner = (int)request.getSession().getAttribute("nombreADeviner");
            int tentativesRestantes = (int)request.getSession().getAttribute("tentativesRestantes");

            // Triche
            response.getWriter().write("<h1>Nombre à deviner: </h1>"+nombreADeviner);
            response.getWriter().write("<h1>Tentatives restantes: </h1>"+tentativesRestantes);


            // Algo du jeu:
            if(nombreADeviner == proposition){
                response.getWriter().write("<h1>Bravo, vous avez gagné !</h1>");

                initialisationPartie(request, response);
            }else {
                tentativesRestantes--;
                if (proposition < nombreADeviner) {
                    response.getWriter().write("<h1>trop petit !</h1>");

                } else {
                    response.getWriter().write("<h1>trop grand !</h1>");
                }
            }

            if(tentativesRestantes == 0){
                response.getWriter().write("<h1>Perdu, nombre de tentatives restantes egal à zero !</h1>");
            }

            // Sauvegarde des de données de la partie dans la Session
            request.getSession().setAttribute("tentativesRestantes", tentativesRestantes);
        }
        catch(NumberFormatException numberFormatException){
            response.getWriter().write("<h1>Erreur : ce n'est pas un nombre</h1>");
        }
    }

    private void initialisationPartie(HttpServletRequest request, HttpServletResponse response){
        int tentativesRestantes = 3;
        int nombreADeviner = new Random().nextInt(1, 10);

        request.getSession().setAttribute("tentativesRestantes", tentativesRestantes);
        request.getSession().setAttribute("nombreADeviner", nombreADeviner);
    }
}
