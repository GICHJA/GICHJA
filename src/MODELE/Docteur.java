/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELE;

import java.util.List;

/**
 *
 * @author Adrien
 */
public class Docteur extends Employe{
    
    private String specialite;
    private List<Soigne> listsoigne;
    
    Docteur(){
          super();
        this.specialite = "";
        this.listsoigne = null;
    }


    public Docteur(String specialite, List<Soigne> listsoigne, int id_employe, String nom, String prenom, String tel) {
        super(id_employe, nom, prenom, tel);
        this.specialite = specialite;
        this.listsoigne = listsoigne;
    }
    
    
    
    
   
    public String getSpecialite()
    {
        return specialite ;
    }
    
    public void setSpecialite (String spe)
    {
        this.specialite = spe ;
    }
    
        public List<Soigne> getListsoigne() {
        return this.listsoigne;
    }

    public void setList_soigne(List<Soigne> list) {
        this.listsoigne = list;
    }

    public void ajoutSoigne(Soigne soigne) {
        this.listsoigne.add(soigne);
    }
    
    
    
}
