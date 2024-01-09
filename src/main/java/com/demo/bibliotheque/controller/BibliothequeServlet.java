package com.demo.bibliotheque.controller;

import com.demo.bibliotheque.metier.Bibliotheque;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/livres")
public class BibliothequeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Bibliotheque bibli = Bibliotheque.getInstance();
        request.setAttribute("livres", bibli.getLivres());
        request.getRequestDispatcher("WEB-INF/bibliotheque.jsp")
                .forward(request, response);
    }
}
