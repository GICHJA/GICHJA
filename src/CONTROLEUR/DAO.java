/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import java.sql.SQLException;

/**
 *
 * @author Adrien
 * @param <T>
 */
public abstract class DAO<T> {

    private Connexion maconnexion;

    /**
     *
     * @return
     */
    public Connexion get_connexion() {
        return maconnexion;
    }

    /**
     *
     * @param maconnexion
     */
    public void set_connexion(Connexion maconnexion) {
        this.maconnexion = maconnexion;
    }

      /**
     * Méthode nbrelem : Retrourne une liste des id de l'objet voulue requete
     *
     * @return
     */
    public abstract int[] nbrelem();

     /**
     * Méthode find : Permet de retourner la classe entiérement remplie en
     * fournissant un id requete
     *
     * @param id
     * @return
     */
    public abstract T find(int id);

       /**
     * Méthode create : Permet de creer la classe entiérement remplie en
     * fournissant un obg requete
     *
     * @param obj
     * @return
     */
    public abstract T create(T obj);

      /**
     * Méthode update : Permet de mettre a jour la base de donnée en fournissent
     * un obj requete
     *
     * @param obj
     * @return
     */
    public abstract T update(T obj);

      /**
     * Méthode delete : Permet de supprimer un elemde la base de donnée en
     * fournissent un obj requete
     *
     * @param obj
     */
    public abstract void delete(T obj);

}
