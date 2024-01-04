package com.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Random;

@WebServlet("/jeunombre")
public class JeuNombre extends HttpServlet {

    int nombreADeviner;
    int tentativesRestantes = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String nombreString = request.getParameter("nombre");

        // initialisation nouvelle partie
        if(tentativesRestantes == 0){
            initialisationPartie();
        }


        try { // permet de gérer le cas où nombre n'est pas un nombre ou il est null
            int proposition = Integer.parseInt(nombreString);

            // Triche
            response.getWriter().write("<h1>Nombre à deviner: </h1>"+nombreADeviner);
            response.getWriter().write("<h1>Tetaives restantes: </h1>"+tentativesRestantes);



            // Algo du jeu:
            if(nombreADeviner == proposition){
                response.getWriter().write("<h1>Bravo, vous avez gagné !</h1>");

                initialisationPartie();
            }else {

                if (proposition < nombreADeviner) {
                    response.getWriter().write("<h1>trop petit !</h1>");
                    tentativesRestantes--;
                } else {
                    response.getWriter().write("<h1>trop grand !</h1>");
                    tentativesRestantes--;
                }
            }

            if(tentativesRestantes == 0){
                response.getWriter().write("<h1>Perdu, nombre de tentatives restantes egal à zero !</h1>");
            }
        }
        catch(NumberFormatException numberFormatException){
            response.getWriter().write("<h1>Erreur : ce n'est pas un nombre</h1>");
        }


    }

    private void initialisationPartie(){
        tentativesRestantes = 3;
        nombreADeviner = new Random().nextInt(1, 10);
    }
}
