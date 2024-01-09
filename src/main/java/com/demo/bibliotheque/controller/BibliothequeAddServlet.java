package com.demo.bibliotheque.controller;

import com.demo.bibliotheque.metier.Bibliotheque;
import com.demo.bibliotheque.metier.Livre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/add")
public class BibliothequeAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/bibliothequeajout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titre = req.getParameter("titre");
        String auteur = req.getParameter("auteur");
        String isbn = req.getParameter("isbn");

        String errorMessage = "";

        if(titre.isBlank())
            errorMessage += "Le titre ne peut etre vide</br>";

        if(auteur.isBlank())
            errorMessage += "L'auteur ne peut etre vide</br>";

        if(isbn.isBlank())
            errorMessage += "L'ISBN ne peut etre vide</br>";


        Bibliotheque bibli = Bibliotheque.getInstance();

        if(errorMessage.isEmpty()){
           Livre livre = new Livre(titre,auteur, isbn );
           bibli.addLivre(livre);
            req.setAttribute("livres", bibli.getLivres());
            req.getRequestDispatcher("WEB-INF/bibliotheque.jsp")
                    .forward(req, resp);
        }else {
            req.setAttribute("errorMessage", errorMessage);
            req.setAttribute("titre", titre);
            req.setAttribute("auteur", auteur);
            req.setAttribute("isbn", isbn);
            req.getRequestDispatcher("WEB-INF/bibliothequeajout.jsp")
                    .forward(req, resp);
        }




    }
}
