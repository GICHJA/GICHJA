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
    
    private int lit;
    
    public Hospitalisation(int lit){
        this.lit = lit;
    }
    
    public int getLit()
    {
        return lit;
    }
    
    public void setLit(int x)
    {
        this.lit=x;
    }
    
    public void affiche()
    {
        
        System.out.print("Lit d'hospitalisation : " + lit);
    }
    
}
