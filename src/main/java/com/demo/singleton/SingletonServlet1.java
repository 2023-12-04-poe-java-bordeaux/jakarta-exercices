package com.demo.singleton;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/singleton1")
public class SingletonServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {


        Annuaire annuaire = Annuaire.getAnnuaire();
        response.getWriter().write("<h1>Nombre de personnes dans l'annuaire:</h1>"+annuaire.getPersonnes().size());
    }
}
