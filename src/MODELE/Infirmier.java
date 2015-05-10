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
public class Infirmier extends Employe {

    private int numero;
    private String code_service;
    private String rotation;
    private double salaire;
    private List<Chambre> listchambresurveillant;

    public Infirmier(int numero, String code_service, String rotation, double salaire, List<Chambre> listchambresurveillant) {
        this.numero = numero;
        this.code_service = code_service;
        this.rotation = rotation;
        this.salaire = salaire;
        this.listchambresurveillant = listchambresurveillant;
    }

    
    
    
    public Infirmier() {
        super();
        this.rotation = "";
        this.salaire = 0;
        this.listchambresurveillant = null;
    }

    public Infirmier(String rotation, double salaire, List<Chambre> listchambresurveillant, int id_employe, String nom, String prenom, String adresse, String tel) {
        super(id_employe, nom, prenom, adresse, tel);
        this.rotation = rotation;
        this.salaire = salaire;
        this.listchambresurveillant = listchambresurveillant;
    }

    public int getNumero() {
        return numero;
    }

    public String getCode_service() {
        return code_service;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCode_service(String code_service) {
        this.code_service = code_service;
    }

    
    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public List<Chambre> getListchambresurveillant() {
        return listchambresurveillant;
    }

    public void setListchambresurveillant(List<Chambre> list) {
        this.listchambresurveillant = list;
    }

    public void ajoutChambre(Chambre chambre) {
        this.listchambresurveillant.add(chambre);
    }

    public void affiche() {
        
         super.affiche();
        
               System.out.println("inf : rotation - " + rotation +  " salaire - " +salaire +  "\n");
        
        /*if (listchambresurveillant != null) {
            listchambresurveillant.stream().forEach((s) -> {
                s.affiche();
            });
        }*/
        for (Chambre s : listchambresurveillant){
            s.affiche();
        }
        
    }

    public String getstringService() {
        
        return super.getstringService();
    }
}
