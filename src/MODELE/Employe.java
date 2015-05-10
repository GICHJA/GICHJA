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

    /**
     *
     */
    public Employe() {
        this.id_employe = 0;
        this.nom = "";
        this.prenom = "";
        this.tel = "";
    }

    /**
     *
     * @param id_employe
     * @param nom
     * @param prenom
     * @param adresse
     * @param tel
     */
    public Employe(int id_employe, String nom, String prenom, String adresse, String tel) {
        this.id_employe = id_employe;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
    }

    /**
     *
     * @return
     */
    public int getId_employe() {
        return id_employe;
    }

    /**
     *
     * @param x
     */
    public void setId_employe(int x) {
        this.id_employe = x;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param x
     */
    public void setNom(String x) {
        this.nom = x;
    }

    /**
     *
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @param x
     */
    public void setPrenom(String x) {
        this.prenom = x;
    }

    /**
     *
     * @return
     */
    public String getTel() {
        return tel;
    }

    /**
     *
     * @param x
     */
    public void setTel(String x) {
        this.tel = x;
    }

    /**
     *
     * @return
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     *
     * @param x
     */
    public void setAdresse(String x) {
        this.adresse = x;
    }

    /**
     *
     */
    public void affiche() {

        System.out.println("Emp : id_employe - " + id_employe + " nom - " + nom + " prenom- " + prenom +" tel- " + tel +" adresse -" + adresse + "\n");

    }

    String getstringService() {
        return "Id_employe = " + id_employe + " Nom = " + nom + " prenom = " + prenom +" tel = " + tel +" adresse = " + adresse + "\n";
    }

}
