package com.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/salutation")
public class PrenomServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

            String lePrenom = request.getParameter("prenom");
            response.getWriter().write("<h1>Bonjour, tu t'appelles:</h1>"+lePrenom);
    }
}
