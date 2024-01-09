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

@WebServlet("/search")
public class BibliothequeSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/bibliothequesearch.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchKeyword = req.getParameter("recherche");

        // gestion de l'historique de recherche dans la Session
        ArrayList<String> historiqueDeRecherche = (ArrayList<String>)req.getSession().getAttribute("historiqueDeRecherche");
        if(historiqueDeRecherche == null)
            historiqueDeRecherche = new ArrayList<>();
        historiqueDeRecherche.add(searchKeyword);
        req.getSession().setAttribute("historiqueDeRecherche", historiqueDeRecherche);


        Bibliotheque bibli = Bibliotheque.getInstance();
        ArrayList<Livre> livres = bibli.search(searchKeyword);
        req.setAttribute("livres", livres);
        // pas necessaire car la JSP accede directement aux attributs de la Session:
        //req.setAttribute("historiqueDeRecherche", historiqueDeRecherche);
        req.getRequestDispatcher("WEB-INF/bibliothequesearch.jsp")
                .forward(req, resp);
    }
}
