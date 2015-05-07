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
public class Mutuelle {

    private int id_mutuelle;
    private String nom;
    private List<Malade> listmalade;

    public Mutuelle() {
        this.id_mutuelle = 0;
        this.nom = "";
        this.listmalade = null;
    }

    public Mutuelle(int id_mutuelle, String nom, List<Malade> listmalade) {
        this.id_mutuelle = id_mutuelle;
        this.nom = nom;
        this.listmalade = listmalade;
    }

    public int getId_mutuelle() {
        return id_mutuelle;
    }

    public void setId_mutuelle(int id) {
        this.id_mutuelle = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String x) {
        this.nom = x;
    }

    public List<Malade> getListmalade() {
        return listmalade;
    }

    public void setListmalade(List<Malade> list) {
        this.listmalade = list;
    }

    public void ajoutMalade(Malade malade) {
        this.listmalade.add(malade);
    }

    public void affiche() {

        System.out.println("Mutuelle  : id_mutuelle - " + id_mutuelle + " nom -  " + nom + "\n");

       if(listmalade != null)
        for (Malade s : listmalade){
            s.affiche();
        }

    }

}
