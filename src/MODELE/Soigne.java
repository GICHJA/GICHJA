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

    /**
     *
     * @param id_soigne
     * @param no_docteur
     * @param no_malade
     */
    public Soigne(int id_soigne, int no_docteur, int no_malade) {
        this.id_soigne = id_soigne;
        this.no_docteur = no_docteur;
        this.no_malade = no_malade;
    }
    
    /**
     *
     */
    public Soigne(){
        this.id_soigne = 0;
    }

    /**
     *
     * @param id_soigne
     */
    public Soigne(int id_soigne) {
        this.id_soigne = id_soigne;
    }
    
    /**
     *
     * @return
     */
    public int getId_soigne()
    {
        return id_soigne;
    }
    
    /**
     *
     * @param id
     */
    public void setId_soigne (int id)
    {
        this.id_soigne=id ;
    }

    /**
     *
     * @return
     */
    public int getNo_docteur() {
        return no_docteur;
    }

    /**
     *
     * @return
     */
    public int getNo_malade() {
        return no_malade;
    }

    /**
     *
     * @param no_docteur
     */
    public void setNo_docteur(int no_docteur) {
        this.no_docteur = no_docteur;
    }

    /**
     *
     * @param no_malade
     */
    public void setNo_malade(int no_malade) {
        this.no_malade = no_malade;
    }
    
    /**
     *
     */
    public void affiche() {
        
        
    }
    
}
