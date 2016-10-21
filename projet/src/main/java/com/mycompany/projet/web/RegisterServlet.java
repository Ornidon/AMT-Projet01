package com.mycompany.projet.web;

import com.mycompagny.security.SHA256Util;
import com.mycompany.mysql.MySQLUtility;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ornidon
 */
public class RegisterServlet extends HttpServlet {
    private final String UPDATE_QUERY = "INSERT INTO user (username, password) VALUES (?,?)" ;
    
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
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
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        String data = "";

        try {
            if (name.isEmpty() || pass.isEmpty()) {
                data = "Empty username or password. Please provide valid information.";
                request.setAttribute("data", data);
                request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            } else {
                MySQLUtility.updateQuery(UPDATE_QUERY, name, SHA256Util.get_SHA_256_SecurePassword(pass, "rsdetizug"));
                request.getSession().setAttribute("logged", new Boolean(true));
                request.getRequestDispatcher("/WEB-INF/pages/content.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
