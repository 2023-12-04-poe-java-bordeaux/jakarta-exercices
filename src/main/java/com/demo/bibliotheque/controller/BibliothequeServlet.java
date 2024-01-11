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
import java.util.List;

@WebServlet("/livres")
public class BibliothequeServlet extends HttpServlet {

    final int TAILLE_PAGE = 5;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Bibliotheque bibli = Bibliotheque.getInstance();

        int page = 1;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e){

        }

        int fromIndex = (page-1) * TAILLE_PAGE;
        int toIndex = Math.min(fromIndex + TAILLE_PAGE, bibli.getLivres().size()); // Ne pas dépasser la taille de la liste
        List<Livre> livresDeLaPage = bibli.getLivres().subList(fromIndex, toIndex);
        request.setAttribute("livres", livresDeLaPage);

        request.setAttribute("page", page);
        request.setAttribute("showprevious", page > 1);
        request.setAttribute("shownext", page*TAILLE_PAGE < bibli.getLivres().size());

        request.getRequestDispatcher("WEB-INF/bibliotheque.jsp")
                .forward(request, response);
    }
}
