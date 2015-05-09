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

    public Service() {
        this.id_service = 0;
        this.nom = "";
        this.directeur = null;
        this.listinfirmier = null;
        this.listchambre = null;
    }

    public Service(int id_service, String code, String nom, Docteur directeur, List<Infirmier> listinfirmier, List<Chambre> listchambre) {
        this.id_service = id_service;
        this.code = code;
        this.nom = nom;
        this.directeur = directeur;
        this.listinfirmier = listinfirmier;
        this.listchambre = listchambre;
    }
    /*
     public Service(int id_service, String nom, Docteur directeur, int no_directeur, String code, int id_batiment) {
     this.id_service = id_service;
     this.nom = nom;
     this.directeur = directeur;
     this.no_directeur = no_directeur;
     this.code = code;
     this.id_batiment = id_batiment;
     }
     */

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id) {
        this.id_service = id;
    }

    public int getNo_directeur() {
        return no_directeur;
    }

    public String getCode() {
        return code;
    }

    public int getId_batiment() {
        return id_batiment;
    }

    public void setNo_directeur(int no_directeur) {
        this.no_directeur = no_directeur;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setId_batiment(int id_batiment) {
        this.id_batiment = id_batiment;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String x) {
        this.nom = x;
    }

    public Docteur getDirecteur() {
        return directeur;
    }

    public void setDirecteur(Docteur dir) {
        this.directeur = dir;
    }

    public List<Chambre> getListchambre() {
        return listchambre;
    }

    public void setListchambre(List<Chambre> list) {
        this.listchambre = list;
    }

    public List<Infirmier> getListinfirmier() {
        return listinfirmier;
    }

    public void setListinfirmier(List<Infirmier> list) {
        this.listinfirmier = list;
    }

    public void ajoutChambre(Chambre chambre) {
        this.listchambre.add(chambre);
    }

    public void ajoutInfirmier(Infirmier infirmier) {
        this.listinfirmier.add(infirmier);
    }

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

    public String getstringService() {

        String montruc;

        montruc = "Service  : id_service - " + id_service + " nom -  " + nom + "\n";

        return montruc;

    }

}
