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
    
    private int id_service;
    private String nom;
    private Docteur directeur;
    private List<Infirmier> listinfirmier;
    private List<Hospitalisation> listhospitalisation;
    private List<Chambre> listchambre;
    
    Service(){
        
    }
    
    public int getId_service()
    {
        return id_service;
    }
    
    public void setId_service(int id)
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
    
    public List<Hospitalisation> getListhospitalisation()
    {
        return listhospitalisation ;
    }
    
    public void setListhospitalisation (List<Hospitalisation> list)
    {
        this.listhospitalisation = list ;
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
    
    public void ajoutHospitalisation(Hospitalisation hospitalisation)
    {
        this.listhospitalisation.add(hospitalisation);
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
