package com.mycompany.projet.web;

import com.mycompany.mysql.MySQLUtility;
import com.mycompany.projet.models.Actor;
import com.mycompany.projet.services.FilmManagerLocal;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet serving the application's content.
 *
 * @author Ioannis Noukakis & Thibaut Loiseau
 */
public class ContentServlet extends HttpServlet {

    @EJB
    FilmManagerLocal manager;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/content.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String film = request.getParameter("filmName");
        String data = "";

        List<Actor> actors = manager.getActors(film);

        if (actors.isEmpty()) {
            data = "Sorry... Nothing was found with '" + film + "' as title.";
        } else {
            for (Actor a : actors) {
                data += a.getFirst_name() + " " + a.getLast_name() + "</br>";
            }
        }

        request.setAttribute("data", data);
        request.getRequestDispatcher("/WEB-INF/pages/content.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
