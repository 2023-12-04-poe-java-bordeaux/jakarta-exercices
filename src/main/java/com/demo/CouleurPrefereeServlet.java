package com.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/couleur")
public class CouleurPrefereeServlet extends HttpServlet  {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String couleur = request.getParameter("macouleurpreferee");

        HttpSession session = request.getSession();

        if(couleur != null) {
            session.setAttribute("couleur", couleur);
        }

        if(session.getAttribute("couleur") == null){
            response.getWriter()
                    .write("<h1>Vous n'avez pas encore enregistré de couleur:</h1>");
        } else {
            response.getWriter()
                    .write("<h1>Ta couleur préférée est:</h1>"+session.getAttribute("couleur"));
        }
    }
}
