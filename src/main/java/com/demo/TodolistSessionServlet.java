package com.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/todolistsession")
public class TodolistSessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write("<h1>Ajouter une tache</h1>");
        response.getWriter().write("<form action='todolistsession' method='POST'>");
        response.getWriter().write("<label>Nouvelle tache:</label>");
        response.getWriter().write("<input type='text' name='tache'/>");
        response.getWriter().write("<input type='submit' value='Envoyer'/>");
        response.getWriter().write("</form>");

        ArrayList<String> todolist = (ArrayList) request.getSession().getAttribute("todolist");
        if(todolist == null){
            todolist = new ArrayList<>();
            request.getSession().setAttribute("todolist", todolist);
        }

        response.getWriter().write("<ul>");
        for(String tache : todolist){
            response.getWriter().write("<li>"+tache);
        }
        response.getWriter().write("</ul>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nouvelleTache = request.getParameter("tache");


        ArrayList<String> todolist = (ArrayList) request.getSession().getAttribute("todolist");
        todolist.add(nouvelleTache);
        request.getSession().setAttribute("todolist", todolist);

        doGet(request, response);
    }
}
