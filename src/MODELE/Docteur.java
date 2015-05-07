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
public class Docteur extends Employe {

    private int numero;
    private String specialite;
    private List<RendezVous> listrdv;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public Docteur(int numero, String specialite) {
        this.numero = numero;
        this.specialite = specialite;
    }

    public Docteur() {
        super();
        this.specialite = "";
        this.listrdv = null;
    }

    public Docteur(String specialite, List<RendezVous> listrdv, int id_employe, String nom, String prenom, String adresse, String tel) {
        super(id_employe, nom, prenom, adresse, tel);
        this.specialite = specialite;
        this.listrdv = listrdv;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String spe) {
        this.specialite = spe;
    }

    public List<RendezVous> getListsoigne() {
        return this.listrdv;
    }

    public void setList_soigne(List<RendezVous> list) {
        this.listrdv = list;
    }

    public void ajoutSoigne(RendezVous rdv) {
        this.listrdv.add(rdv);
    }

    public void affiche() {

        super.affiche();

        System.out.println("Doc : specialite - " + specialite + "\n");

       if(listrdv != null)
        for (RendezVous s : listrdv){
            s.affiche();
        }
    }

}
