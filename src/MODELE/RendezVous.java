/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELE;

import java.util.Date; //https://docs.oracle.com/javase/7/docs/api/java/util/Date.html

/**
 *
 * @author Davy
 */
public class RendezVous {

    private int no_rdv;
    private int no_malade;
    private int no_docteur;
    
    private String date_arr;
    private String date_dep;
    private String motif;
    //private Hospitalisation hospitalisation;
    //private Docteur soigne; 

    /**
     *
     */
    public RendezVous() {
        this.no_rdv = 0;
        this.date_arr = "";
        this.date_dep = "";
        this.motif = "";

    }

    /**
     *
     * @param no_rdv
     * @param date_arr
     * @param date_dep
     * @param motif
     */
    public RendezVous(int no_rdv, String date_arr, String date_dep, String motif) {
        this.no_rdv = no_rdv;
        this.date_arr = date_arr;
        this.date_dep = date_dep;
        this.motif = motif;
    }

    /**
     *
     * @param no_rdv
     * @param no_malade
     * @param no_docteur
     * @param date_arr
     * @param date_dep
     * @param motif
     */
    public RendezVous(int no_rdv, int no_malade, int no_docteur, String date_arr, String date_dep, String motif) {
        this.no_rdv = no_rdv;
        this.no_malade = no_malade;
        this.no_docteur = no_docteur;
        this.date_arr = date_arr;
        this.date_dep = date_dep;
        this.motif = motif;
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
     * @return
     */
    public int getNo_docteur() {
        return no_docteur;
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
     * @param no_docteur
     */
    public void setNo_docteur(int no_docteur) {
        this.no_docteur = no_docteur;
    }
    
    /**
     *
     * @return
     */
    public int getNo_rdv() {
        return no_rdv;
    }

    /**
     *
     * @param no
     */
    public void setNo_rdv(int no) {
        this.no_rdv = no;
    }

    /**
     *
     * @return
     */
    public String getDate_arr() {
        return date_arr;
    }

    /**
     *
     * @param d
     */
    public void setDate_arr(String d) {
        this.date_arr = d;
    }

    /**
     *
     * @return
     */
    public String getDate_dep() {
        return date_dep;
    }

    /**
     *
     * @param d
     */
    public void setDate_dep(String d) {
        this.date_dep = d;
    }

    /**
     *
     * @return
     */
    public String getMotif() {
        return motif;
    }

    /**
     *
     * @param motif
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     *
     */
    public void affiche() {

        System.out.println("RendezVous  : no_rdv - " + no_rdv + " date_arr -  " + date_arr + " date_dep -  " + date_dep + " motif -  " + motif + "\n");

    }

    /**
     *
     * @return
     */
    public String getstringService() {
        return "RendezVous  : no_rdv - " + no_rdv + " date_arr -  " + date_arr + " date_dep -  " + date_dep + " motif -  " + motif + "\n";
    }

}
