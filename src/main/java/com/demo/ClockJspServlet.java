package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;


@WebServlet("/clockMvc")
public class ClockJspServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        LocalDateTime heure = LocalDateTime.now();

        request.setAttribute("heure", heure );

        request.getRequestDispatcher("WEB-INF/clock.jsp")
                .forward(request, response);
    }
}
