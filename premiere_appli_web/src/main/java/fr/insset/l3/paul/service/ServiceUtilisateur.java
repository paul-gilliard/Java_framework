/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insset.l3.paul.service;

import fr.insset.l3.paul.modele.Utilisateur;

/**
 *
 * @author paul
 */
public class ServiceUtilisateur {
    
    public Utilisateur getUtilisateur (String login, String password){
        
        if("Paul".equals(login) && "Gilliard".equals(password)){
            
            Utilisateur resultat = new Utilisateur();
            resultat.setNom("Gilliard");
            resultat.setEmail("paul.gilliard.8@gmail.com ");
            resultat.setLogin("Paul");
            resultat.setPassword(password);
            return resultat;
        }
        
        else if("Polo".equals(login) && "Polo".equals(password)){
            
            Utilisateur resultat = new Utilisateur();
            resultat.setNom("Gilliard");
            resultat.setEmail("Polo.gilliard.8@gmail.com ");
            resultat.setLogin("Polo");
            resultat.setPassword(password);
            resultat.setRole("admin");
            return resultat;
        }
        
        return null;
    }
    
}
