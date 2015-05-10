/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELE;

/**
 *
 * @author Adrien
 */
public class Hospitalisation {
    
    /**
    * Variable integer qui corresepond au lit reservé pour l'Hospitalisation
    */
    private int id_hospitalisation;
    private int no_malade ;
    private String code_service ;
    private int no_chambre;
    private int lit;
    private int id_chambre;
    
    /**
     * Constructeur
     * @param id_hospitalisation
     * @param no_malade
     * @param lit
     * @param id_chambre
     * @param no_chambre
     * @param code_service
     */
    public Hospitalisation(int id_hospitalisation, int no_malade, String code_service, int no_chambre, int lit, int id_chambre) {
        this.id_hospitalisation = id_hospitalisation;
        this.no_malade = no_malade;
        this.code_service = code_service;
        this.no_chambre = no_chambre;
        this.lit = lit;
        this.id_chambre = id_chambre;
    }

    /**
     *
     * @param id_hospitalisation
     * @param lit
     */
    public Hospitalisation(int id_hospitalisation, int lit) {
        this.id_hospitalisation = id_hospitalisation;
        this.lit = lit;
    }

    
    
           /**
         * Constructeur vide
        */
    public Hospitalisation(){
        this.lit = 0;
        this.id_hospitalisation = 0;
    }
    
    
    
    /**
    * Fonction setLit
     * Retourne l'entier correspondant au lit reservé pour l'hospitalisation
     * @return 
    */
    public int getLit()
    {
        return lit;
    }
    
    /**
    * Fonction setLit
     * @param x 
     * Entier Correspondant au lit reservé pour l'hospitalisation
    */
    public void setLit(int x)
    {
        this.lit=x;
    }

    /**
     *
     * @return
     */
    public int getId_hospitalisation() {
        return id_hospitalisation;
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
    public int getId_chambre() {
        return id_chambre;
    }

    /**
     *
     * @param id_hospitalisation
     */
    public void setId_hospitalisation(int id_hospitalisation) {
        this.id_hospitalisation = id_hospitalisation;
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
     * @param id_chambre
     */
    public void setId_chambre(int id_chambre) {
        this.id_chambre = id_chambre;
    }
    
    
    
    /**
    * Fonction D'affichage
    */
    public void affiche()
    {
        
        System.out.print("Lit d'hospitalisation : " + lit +"\n");
    }

    /**
     *
     * @return
     */
    public Object getstringService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
