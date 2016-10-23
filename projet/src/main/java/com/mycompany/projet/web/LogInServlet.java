package com.mycompany.projet.web;

import com.mycompany.projet.models.User;
import com.mycompany.projet.services.UserManagerLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet handling the login process for our application.
 * 
 * @author Ioannis Noukakis & Thibaut Loiseau
 */
public class LogInServlet extends HttpServlet {
    
    
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
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
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

        User user = manager.get(name, pass);
        if(user == null){
            data = "Invalid username or password.";
            request.setAttribute("data", data);
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }else{
            request.getSession().setAttribute("logged", user);
            response.sendRedirect(request.getContextPath() + "/content");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "This is login servlet";
    }
}
