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
public class Chambre {

    private int id_chambre;
    private int nb_lit;
    private List<Hospitalisation> listhospitalisation;

    public Chambre(int id_chambre, int nb_lit, List<Hospitalisation> listhospitalisation) {
        this.id_chambre = id_chambre;
        this.nb_lit = nb_lit;
        this.listhospitalisation = listhospitalisation;
    }

    public Chambre() {
        this.id_chambre = 0;
        this.nb_lit = 0;
        this.listhospitalisation = null;
    }

    public List<Hospitalisation> getListhospitalisation() {
        return listhospitalisation;
    }

    public void setListhospitalisation(List<Hospitalisation> list) {
        this.listhospitalisation = list;
    }

    public int getId_chambre() {
        return id_chambre;
    }

    public void setId_batiment(int x) {
        this.id_chambre = x;
    }

    public int getNb_lit() {
        return nb_lit;
    }

    public void setNb_lit(int x) {
        this.nb_lit = x;
    }

    public void ajoutHospitalisation(Hospitalisation hospitalisation) {
        this.listhospitalisation.add(hospitalisation);
    }

    public void affiche() {
        System.out.println("****Chambre**** \n "
                + "Numéro chambre :  " + id_chambre + "\n "
                + "Nombre de lit disponible :" + nb_lit + "\n "
                + "List Hospitalisation dans la chambre : \n");

        if (listhospitalisation != null) {
            listhospitalisation.stream().forEach((s) -> {
                s.affiche();
            });
        }

    }

}
