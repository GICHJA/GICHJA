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
public class Malade {
    
    private int id_malade;
    private String nom;
    private String prenom;
    private String tel;
    private String adresse;
    
    private List <Soigne> listsoigne;
    private List <Hospitalisation> listhospitalisation;
    
    Malade(){
        
    }
    
    public int getId_malade()
    {
        return id_malade ;
    }
    
    public void setId_malade(int id)
    {
        this.id_malade=id ;
    }
    
    public String getNom()
    {
        return nom ;
    }
    
    public void setNom (String x)
    {
        this.nom = x ;
    }
    
    public String getPrenom()
    {
        return prenom ;
    }
    
    public void setPrenom (String x)
    {
        this.prenom = x ;
    }
    
    public String getTel()
    {
        return tel ;
    }
    
    public void setTel (String x)
    {
        this.tel = x ;
    }
    
    public String getAdresse()
    {
        return adresse ;
    }
    
    public void setAdresse (String x)
    {
        this.adresse = x ;
    }
    
     public List<Soigne> getListsoigne()
    {
        return this.listsoigne ;
    }
    
    public void setList_soigne (List<Soigne> list)
    {
        this.listsoigne = list ;
    }
    
    public List<Hospitalisation> getListhospitalisation()
    {
        return listhospitalisation ;
    }
    
    public void setListhospitalisation (List<Hospitalisation> list)
    {
        this.listhospitalisation = list ;
    }
    
    public void ajoutHospitalisation(Hospitalisation hospitalisation)
    {
        this.listhospitalisation.add(hospitalisation);
    }
    
    public void ajoutSoigne(Soigne soigne)
    {
        this.listsoigne.add(soigne);
    }
    
}
