/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fr.insset.l3.paul.modele.Utilisateur;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paul
 */
public class authentification implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public authentification() {
    }    
    
    

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
        
         HttpSession session = ((HttpServletRequest) request).getSession();
         Object user = session.getAttribute("user");
         
         if (user == null)
         {
             System.out.println("pas d'user dans la session");
             RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jspx");
             requestDispatcher.forward(request,response);
         }
         else
         {
             // L'utilisateur est identifié, on laisse passé
            String role =  filterConfig.getInitParameter("role");
            if(role != null){
                if(role.equals(((Utilisateur)user).getRole()))
                {
                    chain.doFilter(request, response);
                }
                else{
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jspx");
                requestDispatcher.forward(request,response);
                }
            }
            else{
             System.out.println("y'a un user");
             chain.doFilter(request, response);
             }
         }
     
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
       
        filterConfig = this.filterConfig = filterConfig;
    }

    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
