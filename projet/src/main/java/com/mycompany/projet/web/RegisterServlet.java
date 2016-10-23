package com.mycompany.projet.web;

import com.mycompany.projet.models.User;
import com.mycompany.projet.services.UserManagerLocal;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet handling the register process for our application.
 * 
 * @author Ioannis Noukakis & Thibaut Loiseau
 */

public class RegisterServlet extends HttpServlet {
    
    @EJB
    UserManagerLocal manager;
   
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
                if(name.isEmpty() && !pass.isEmpty())
                    data = "You have entered an empty username. Please provide a non empty username.";
                else if(!name.isEmpty() && pass.isEmpty())
                    data = "You have entered an empty password. Please provide a non empty password.";
                else
                    data = "You have entered an empty username and password. Please provide a non empty username and password.";
            }else {
                int result = manager.create(name, pass);
                if( result == -1)
                    data = "A problem has occured, please try later";
                else if (result == 0)
                     data = "The user already exists";
                else{
                    request.getSession().setAttribute("logged", new User(name, pass, 2));
                    response.sendRedirect(request.getContextPath()+"/content");
                    return;
                }
            }
            request.setAttribute("data", data);
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        }
        catch (UnsupportedEncodingException ex) {
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
        return "This is http servlet";
    }
}
