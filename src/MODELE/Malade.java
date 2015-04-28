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
    private List <RendezVous> listrdv;

    public Malade(){
              this.id_malade = 0;
        this.nom = "";
        this.prenom = "";
        this.tel = "";
        this.adresse = "";
        this.listrdv = null;
    }

    public Malade(int id_malade, String nom, String prenom, String tel, String adresse, List<RendezVous> listrdv) {
        this.id_malade = id_malade;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
        this.listrdv = listrdv;
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
    
     public List<RendezVous> getListrdv()
    {
        return this.listrdv ;
    }
    
    public void setList_rdv (List<RendezVous> list)
    {
        this.listrdv = list ;
    }
    
    
    public void ajoutrdv(RendezVous rdv)
    {
        this.listrdv.add(rdv);
    }
    
}
