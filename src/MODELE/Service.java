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
public class Service {
    
    private String id_service;
    private String nom;
    private Docteur directeur;
    private List<Infirmier> listinfirmier;
    private List<Chambre> listchambre;
    
    public Service(){
             this.id_service = null;
        this.nom = "";
        this.directeur = null;
        this.listinfirmier = null;
        this.listchambre = null;   
    }

    public Service(String id_service, String nom, Docteur directeur, List<Infirmier> listinfirmier, List<Chambre> listchambre) {
        this.id_service = id_service;
        this.nom = nom;
        this.directeur = directeur;
        this.listinfirmier = listinfirmier;
        this.listchambre = listchambre;
    }
    
    
    
    
    public String getId_service()
    {
        return id_service;
    }
    
    public void setId_service(String id)
    {
        this.id_service=id;
    }
    
    public String getNom()
    {
        return nom ;
    }
    
    public void setNom (String x)
    {
        this.nom = x ;
    }
    
    public Docteur getDirecteur ()
    {
        return directeur;
    }
    
    public void setDirecteur(Docteur dir)
    {
        this.directeur=dir ;
    }
    
    
    public List<Chambre> getListchambre()
    {
        return listchambre  ;
    }
    
    public void setListchambre (List<Chambre> list)
    {
        this.listchambre = list ;
    }
    
    public List<Infirmier> getListinfirmier()
    {
        return listinfirmier;
    }
    
    public void setListinfirmier(List <Infirmier> list)
    {
        this.listinfirmier=list ;
    }
    
 
    public void ajoutChambre(Chambre chambre)
    {
        this.listchambre.add(chambre);
    }
    
    public void ajoutInfirmier(Infirmier infirmier)
    {
        this.listinfirmier.add(infirmier);
    }
    
}
