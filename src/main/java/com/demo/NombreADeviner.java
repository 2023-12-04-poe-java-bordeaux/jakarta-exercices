package com.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Random;

@WebServlet("/jeu")
public class NombreADeviner extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String nombreString = request.getParameter("nombre");

        try { // permet de gérer le cas où nombre n'est pas un nombre ou il est null
            int nombre = Integer.parseInt(nombreString);

            // Algo du jeu:
            int nombreADeviner = new Random().nextInt(1, 10);
            if (nombre == nombreADeviner) {
                response.getWriter().write("<h1>Bravo, vous avez gagné !</h1>");
            } else {
                if (nombre < nombreADeviner) {
                    response.getWriter().write("<h1>Perdu ! trop petit !</h1>");
                } else {
                    response.getWriter().write("<h1>Perdu ! trop grand !</h1>");
                }
            }
        }
        catch(NumberFormatException numberFormatException){
            response.getWriter().write("<h1>Erreur : ce n'est pas un nombre</h1>");
        }


    }
}
