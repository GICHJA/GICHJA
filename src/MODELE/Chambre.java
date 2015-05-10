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
    String code_service ;
    int no_chambre;
    int  surveillant;

    /**
     *
     * @param id_chambre
     * @param code_service
     * @param no_chambre
     * @param surveillant
     * @param nb_lit
     */
    public Chambre(int id_chambre,String code_service,  int no_chambre, int surveillant,int nb_lit) {
        this.id_chambre = id_chambre;
        this.nb_lit = nb_lit;
        this.code_service = code_service;
        this.no_chambre = no_chambre;
        this.surveillant = surveillant;
   
    }

    /**
     *
     * @param id_chambre
     */
    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }

    /**
     *
     * @param code_service
     */
    public void setCode_service(String code_service) {
        this.code_service = code_service;
    }

    /**
     *
     * @param no_chambre
     */
    public void setNo_chambre(int no_chambre) {
        this.no_chambre = no_chambre;
    }

    /**
     *
     * @param surveillant
     */
    public void setSurveillant(int surveillant) {
        this.surveillant = surveillant;
    }

    /**
     *
     * @return
     */
    public String getCode_service() {
        return code_service;
    }

    /**
     *
     * @return
     */
    public int getNo_chambre() {
        return no_chambre;
    }

    /**
     *
     * @return
     */
    public int getSurveillant() {
        return surveillant;
    }
    private List<Hospitalisation> listhospitalisation;

    /**
     *
     * @param id_chambre
     * @param nb_lit
     * @param listhospitalisation
     */
    public Chambre(int id_chambre, int nb_lit, List<Hospitalisation> listhospitalisation) {
        this.id_chambre = id_chambre;
        this.nb_lit = nb_lit;
        this.listhospitalisation = listhospitalisation;
    }

    /**
     *
     */
    public Chambre() {
        this.id_chambre = 0;
        this.nb_lit = 0;
        this.listhospitalisation = null;
    }

    /**
     *
     * @return
     */
    public List<Hospitalisation> getListhospitalisation() {
        return listhospitalisation;
    }

    /**
     *
     * @param list
     */
    public void setListhospitalisation(List<Hospitalisation> list) {
        this.listhospitalisation = list;
    }

    /**
     *
     * @return
     */
    public int getId_chambre() {
        return id_chambre;
    }

    /**
     *
     * @param x
     */
    public void setId_batiment(int x) {
        this.id_chambre = x;
    }

    /**
     *
     * @return
     */
    public int getNb_lit() {
        return nb_lit;
    }

    /**
     *
     * @param x
     */
    public void setNb_lit(int x) {
        this.nb_lit = x;
    }

    /**
     *
     * @param hospitalisation
     */
    public void ajoutHospitalisation(Hospitalisation hospitalisation) {
        this.listhospitalisation.add(hospitalisation);
    }

    /**
     *
     */
    public void affiche() {
       
        
        System.out.println("Bat : id_chambre - " + id_chambre + " +  nb_lit - " + nb_lit + "\n");
                

        /*if (listhospitalisation != null) {
            listhospitalisation.stream().forEach((s) -> {
                s.affiche();
            });
        }*/
        for (Hospitalisation s : listhospitalisation){
            s.affiche();
        }

    }

    /**
     *
     * @return
     */
    public String getstringService() {
        return "Id_chambre - " + id_chambre + " +  nb_lit - " + nb_lit + "\n";
    }

}
