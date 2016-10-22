package com.mycompany.projet.web;

import com.mycompany.mysql.MySQLUtility;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    //MYSQL query to fetch all actor of a movie.
    private final String ACTOR_QUERY = "SELECT first_name, last_name FROM actor\n"
            + "    INNER JOIN film_actor AS fa\n"
            + "        ON actor.actor_id = fa.actor_id\n"
            + "    INNER JOIN film AS f\n"
            + "        ON f.film_id = fa.film_id\n"
            + "    WHERE f.title = ?";

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

        try {

            ResultSet rs = MySQLUtility.doQuery(ACTOR_QUERY, film);

            if (!rs.next()) {
                data = "Sorry... Nothing was found with '" + film + "' as title.";
            } else {
                rs.previous();
                while (rs.next()) {
                    data += rs.getString("first_name") + " " + rs.getString("last_name") + "</br>";
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
