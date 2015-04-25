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
public class Docteur extends Employe{
    
    private String specialite;
    
    Docteur(){
        
    }
   
    public String getSpecialite()
    {
        return specialite ;
    }
    
    public void setSpecialite (String spe)
    {
        this.specialite = spe ;
    }
    
    
}
