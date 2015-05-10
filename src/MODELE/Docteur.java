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

    /**
     *
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     * @param specialite
     */
    public Docteur(int numero, String specialite) {
        this.numero = numero;
        this.specialite = specialite;
    }

    /**
     *
     */
    public Docteur() {
        super();
        this.specialite = "";
        this.listrdv = null;
    }

    /**
     *
     * @param specialite
     * @param listrdv
     * @param id_employe
     * @param nom
     * @param prenom
     * @param adresse
     * @param tel
     */
    public Docteur(String specialite, List<RendezVous> listrdv, int id_employe, String nom, String prenom, String adresse, String tel) {
        super(id_employe, nom, prenom, adresse, tel);
        this.specialite = specialite;
        this.listrdv = listrdv;
    }

    /**
     *
     * @return
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     *
     * @param spe
     */
    public void setSpecialite(String spe) {
        this.specialite = spe;
    }

    /**
     *
     * @return
     */
    public List<RendezVous> getListsoigne() {
        return this.listrdv;
    }

    /**
     *
     * @param list
     */
    public void setList_soigne(List<RendezVous> list) {
        this.listrdv = list;
    }

    /**
     *
     * @param rdv
     */
    public void ajoutSoigne(RendezVous rdv) {
        this.listrdv.add(rdv);
    }

    /**
     *
     */
    public void affiche() {

        super.affiche();

        System.out.println("Doc : specialite - " + specialite + "\n");

        /*if (listrdv != null) {
            listrdv.stream().forEach((s) -> {
                s.affiche();
            });
        }*/
        for (RendezVous s : listrdv){
            s.affiche();
        }
    }
    
    /**
     *
     * @return
     */
    public String getstringService() {
        
        return super.getstringService() + "Doc : specialite - " + specialite + "\n";
    }

}
