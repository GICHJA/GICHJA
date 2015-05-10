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
    private int no_directeur;
    private String code;
    private int id_batiment;
    private List<Infirmier> listinfirmier;
    private List<Chambre> listchambre;

    /**
     *
     */
    public Service() {
        this.id_service = 0;
        this.nom = "";
        this.directeur = null;
        this.listinfirmier = null;
        this.listchambre = null;
    }

    /**
     *
     * @param id_service
     * @param code
     * @param nom
     * @param directeur
     * @param listinfirmier
     * @param listchambre
     */
    public Service(int id_service, String code, String nom, Docteur directeur, List<Infirmier> listinfirmier, List<Chambre> listchambre) {
        this.id_service = id_service;
        this.code = code;
        this.nom = nom;
        this.directeur = directeur;
        this.listinfirmier = listinfirmier;
        this.listchambre = listchambre;
    }
    
    /**
     *
     * @param code
     * @param nom
     * @param id_batiment
     * @param no_directeur
     */
    public Service(String code,String nom,  int id_batiment ,int no_directeur) {
     this.nom = nom;
     this.no_directeur = no_directeur;
     this.code = code;
     this.id_batiment = id_batiment;
     }
     
    /**
     *
     * @return
     */
    public int getId_service() {
        return id_service;
    }

    /**
     *
     * @param id
     */
    public void setId_service(int id) {
        this.id_service = id;
    }

    /**
     *
     * @return
     */
    public int getNo_directeur() {
        return no_directeur;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @return
     */
    public int getId_batiment() {
        return id_batiment;
    }

    /**
     *
     * @param no_directeur
     */
    public void setNo_directeur(int no_directeur) {
        this.no_directeur = no_directeur;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @param id_batiment
     */
    public void setId_batiment(int id_batiment) {
        this.id_batiment = id_batiment;
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
    public Docteur getDirecteur() {
        return directeur;
    }

    /**
     *
     * @param dir
     */
    public void setDirecteur(Docteur dir) {
        this.directeur = dir;
    }

    /**
     *
     * @return
     */
    public List<Chambre> getListchambre() {
        return listchambre;
    }

    /**
     *
     * @param list
     */
    public void setListchambre(List<Chambre> list) {
        this.listchambre = list;
    }

    /**
     *
     * @return
     */
    public List<Infirmier> getListinfirmier() {
        return listinfirmier;
    }

    /**
     *
     * @param list
     */
    public void setListinfirmier(List<Infirmier> list) {
        this.listinfirmier = list;
    }

    /**
     *
     * @param chambre
     */
    public void ajoutChambre(Chambre chambre) {
        this.listchambre.add(chambre);
    }

    /**
     *
     * @param infirmier
     */
    public void ajoutInfirmier(Infirmier infirmier) {
        this.listinfirmier.add(infirmier);
    }

    /**
     *
     */
    public void affiche() {

        System.out.println("Service  : id_service - " + id_service + " nom -  " + nom + "\n");

        /*if (listinfirmier != null) {
         listinfirmier.stream().forEach((s) -> {
         s.affiche();
         });
         }*/
        for (Infirmier s : listinfirmier) {
            s.affiche();
        }

        /*if (listchambre != null) {
         listchambre.stream().forEach((s) -> {
         s.affiche();
         });
         }*/
        for (Chambre s : listchambre) {
            s.affiche();
        }

        directeur.affiche();

    }

    /**
     *
     * @return
     */
    public String getstringService() {

        String montruc;

        montruc = "Service  : id_service - " + id_service + " nom -  " + nom + "\n";

        return montruc;

    }

}
