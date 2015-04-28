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
public class Soigne {
    
    private int id_soigne;
    
    public Soigne(){
        this.id_soigne = 0;
    }

    public Soigne(int id_soigne) {
        this.id_soigne = id_soigne;
    }
    
    
    
    public int getId_soigne()
    {
        return id_soigne;
    }
    
    public void setId_soigne (int id)
    {
        this.id_soigne=id ;
    }
    
    public void affiche() {
        
        
    }
    
}
