/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insset.l3.paul.controller;

import fr.insset.l3.paul.modele.Utilisateur;
import fr.insset.l3.paul.service.ServiceUtilisateur;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paul
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // 1 récupérer les paramètres
        String login = request.getParameter("login");
        String password = request.getParameter("password");
      
        // 2 Vérifications de surfaces
        
        if(login==null || password ==null)
        {
        }
        
        
        // 3 éxcécuter méthodes métiers
        
        
        ServiceUtilisateur service = new ServiceUtilisateur();
        Utilisateur utilisateur = service.getUtilisateur(login,password);
        
        // 4 branchement vers la vue
        if(utilisateur ==null){
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jspx"); // va chercher la source
        requestDispatcher.forward(request,response); // forward 
        }
        
        
        else
        { 
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/accueil.jspx");
        HttpSession session = request.getSession();
        session.setAttribute("user", utilisateur);
        requestDispatcher.forward(request,response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
