package com.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/salutation")
public class PrenomServlet extends HttpServlet {

    String prenom;
    String nom;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {


            String prenomQuery = request.getParameter("prenom");
            if(prenomQuery != null)
                prenom = prenomQuery;


            String nomQuery = request.getParameter("nom");
            if(nomQuery != null)
                nom = nomQuery;

            response.getWriter().write("<h1>Bonjour, tu t'appelles:</h1>"+prenom+"  "+nom);
    }
}
