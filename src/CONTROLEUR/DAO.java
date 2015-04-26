/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import java.sql.SQLException;

/**
 *
 * @author Adrien
 * @param <T>
 */
public abstract class DAO <T> {
    
    private Connexion maconnexion;
    
    
        public Connexion get_connexion()
        {
            return maconnexion;
        }
    
        public void set_connexion(Connexion maconnexion)
        {
            this.maconnexion = maconnexion;
        }
        
                        
    	/**
	 * Permet de Crée la list d'objet
	 * @return
	 */
	public abstract void init();
	
        
                
    	/**
	 * Permet de récupérer un objet via son ID
	 * @param id
	 * @return
	 */
	public abstract T find(long id);
	
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 */
	public abstract T create(T obj);
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 */
	public abstract T update(T obj);
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	public abstract void delete(T obj);
            
           
    
 
    
}

