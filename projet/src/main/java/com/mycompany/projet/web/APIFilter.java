package com.mycompany.projet.web;

import com.mycompany.projet.models.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class implementing a filter for the API.
 * 
 * @author Ioannis Noukakis & Thibaut Loiseau
 */
@WebFilter(filterName = "APIFilter", urlPatterns = {"/api"})
public class APIFilter implements Filter {
    
    private final int ADMIN_ID = 1;
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse rep = (HttpServletResponse)response;
        
        User logged = (User)req.getSession().getAttribute("logged");
        if(logged == null || logged.getId() != ADMIN_ID){
            rep.sendRedirect(req.getContextPath()+"/hello");
        }
        else
            chain.doFilter(request, response); 
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {
        
    }
}
