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
    private int id_mutuelle;
    
    private List<RendezVous> listrdv;

    /**
     *
     */
    public Malade() {
        this.id_malade = 0;
        this.nom = "";
        this.prenom = "";
        this.tel = "";
        this.adresse = "";
        this.listrdv = null;
    }

    /**
     *
     * @param id_malade
     * @param nom
     * @param prenom
     * @param tel
     * @param adresse
     * @param listrdv
     */
    public Malade(int id_malade, String nom, String prenom, String tel, String adresse, List<RendezVous> listrdv) {
        this.id_malade = id_malade;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
        this.listrdv = listrdv;
    }

    /**
     *
     * @param id_malade
     * @param nom
     * @param prenom
     * @param adresse
     * @param tel
     * @param id_mutuelle
     */
    public Malade(int id_malade, String nom, String prenom,String adresse, String tel,  int id_mutuelle) {
        this.id_malade = id_malade;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;
        this.id_mutuelle = id_mutuelle;
    }
    
    /**
     *
     * @return
     */
    public int getId_malade() {
        return id_malade;
    }

    /**
     *
     * @param id
     */
    public void setId_malade(int id) {
        this.id_malade = id;
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
     * @return
     */
    public int getId_mutuelle() {
        return id_mutuelle;
    }

    /**
     *
     * @param id_mutuelle
     */
    public void setId_mutuelle(int id_mutuelle) {
        this.id_mutuelle = id_mutuelle;
    }

    /**
     *
     * @return
     */
    public List<RendezVous> getListrdv() {
        return this.listrdv;
    }

    /**
     *
     * @param list
     */
    public void setList_rdv(List<RendezVous> list) {
        this.listrdv = list;
    }

    /**
     *
     * @param rdv
     */
    public void ajoutrdv(RendezVous rdv) {
        this.listrdv.add(rdv);
    }
    
    /**
     *
     */
    public void affiche() {
        
                
        System.out.println("Malade  : id_malade - " + id_malade + " nom -  " + nom + " prenom -  " + prenom + " tel -  " + tel + " adresse -  "
                + adresse + "\n");

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
        return "Malade  : id_malade - " + id_malade + " nom -  " + nom + " prenom -  " + prenom + " tel -  " + tel + " adresse -  "
                + adresse + "\n";
    }

}
