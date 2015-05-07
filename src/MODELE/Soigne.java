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
    private int no_docteur;
    private int no_malade;

    public Soigne(int id_soigne, int no_docteur, int no_malade) {
        this.id_soigne = id_soigne;
        this.no_docteur = no_docteur;
        this.no_malade = no_malade;
    }
    
    
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

    public int getNo_docteur() {
        return no_docteur;
    }

    public int getNo_malade() {
        return no_malade;
    }

    public void setNo_docteur(int no_docteur) {
        this.no_docteur = no_docteur;
    }

    public void setNo_malade(int no_malade) {
        this.no_malade = no_malade;
    }
    
    public void affiche() {
        
        
    }
    
}
