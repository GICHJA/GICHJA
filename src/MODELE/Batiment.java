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
public class Batiment {

    private int id_batiment;
    private String nom_batiment;
    private List<Service> listservice;

    public Batiment() {
         this.id_batiment = 0;
        this.nom_batiment = "";
        this.listservice = null;

    }

    public Batiment(int id_batiment, String nom_batiment, List<Service> listservice) {
        this.id_batiment = id_batiment;
        this.nom_batiment = nom_batiment;
        this.listservice = listservice;
    }

    public String getNom_batiment() {
        return nom_batiment;
    }

    public void setNom_batiment(String nom_batiment) {
        this.nom_batiment = nom_batiment;
    }

    public void setListservice(List<Service> listservice) {
        this.listservice = listservice;
    }
    
    
    public List<Service> getListservice() {
        return listservice;
    }

    public void setId_batiment(List<Service> list) {
        this.listservice = list;
    }

    public int getId_batiment() {
        return id_batiment;
    }

    public void setId_batiment(int x) {
        this.id_batiment = x;
    }

    public void ajoutService(Service service) {
        this.listservice.add(service);
    }

    public void affiche() {
       
        System.out.println("Bat : id_batiment - " + id_batiment + " +  nom_batiment - " + nom_batiment + "\n");
        
        if (listservice != null) {
            listservice.stream().forEach((s) -> {
                s.affiche();
            });
        }
        
     //test 
        

    }
}
