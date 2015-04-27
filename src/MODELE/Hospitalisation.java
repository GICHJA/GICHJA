/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELE;

/**
 *
 * @author Adrien
 */
public class Hospitalisation {
    
    /**
    * Variable integer qui corresepond au lit reservé pour l'Hospitalisation
    */
    private int id_hospitalisation;
    private int lit;
    
        /**
         * Constructeur
        */
    public Hospitalisation(int id_hospitalisation,int lit){
        this.lit = lit;
        this.id_hospitalisation = id_hospitalisation;
    }
    
           /**
         * Constructeur vide
        */
    public Hospitalisation(){
        this.lit = 0;
        this.id_hospitalisation = 0;
    }
    
    /**
    * Fonction setLit
     * Retourne l'entier correspondant au lit reservé pour l'hospitalisation
    */
    public int getLit()
    {
        return lit;
    }
    
    /**
    * Fonction setLit
     * @param x 
     * Entier Correspondant au lit reservé pour l'hospitalisation
    */
    public void setLit(int x)
    {
        this.lit=x;
    }
    
    /**
    * Fonction D'affichage
    */
    public void affiche()
    {
        
        System.out.print("Lit d'hospitalisation : " + lit +"\n");
    }
    
}
