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
public class Employe {

    private int id_employe;
    private String nom;
    private String prenom;
    private String tel;
    private String adresse;
    

    public Employe() {
        this.id_employe = 0;
        this.nom = "";
        this.prenom = "";
        this.tel = "";
    }

    public Employe(int id_employe, String nom, String prenom, String tel) {
        this.id_employe = id_employe;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int x) {
        this.id_employe = x;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String x) {
        this.nom = x;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String x) {
        this.prenom = x;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String x) {
        this.tel = x;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String x) {
        this.adresse = x;
    }


}
