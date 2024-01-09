package com.demo.vip.controller;

import com.demo.plantes.metier.Plante;
import com.demo.plantes.metier.Serre;
import com.demo.vip.metier.ApplicationData;
import com.demo.vip.metier.Personne;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/annuairepersonnes")
public class AnnuairePersonneServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("personnes", ApplicationData.annuaire.getPersonnesNonVip());
        request.getRequestDispatcher("WEB-INF/personnesNonVip.jsp")
                .forward(request, response);
    }
}
