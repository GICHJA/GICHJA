/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import MODELE.Employe;
import MODELE.Hospitalisation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrien
 */
public class EmployeDAO extends DAO<Employe> {

    int newattr;
    
      /**
     * Méthode find : Permet de retourner la classe entiérement remplie en
     * fournissant un id requete
     *
     * @param id
     * @return
     */
    @Override
    public Employe find(int id) {
        ResultSet result = null;
        Employe employe = new Employe();
        try {
            String Search = "select * from employe WHERE numero = " + id;
            result = this.get_connexion().result(Search);

            if (result.first()) {
                employe = new Employe(id,
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("adresse"),
                        result.getString("tel"));
                employe.setId_employe(id);

            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employe;
    }
    /**
     * Méthode create : Permet de creer la classe entiérement remplie en
     * fournissant un obg requete
     *
     * @param obj
     * @return
     */
    @Override
    public Employe create(Employe obj) {
        ResultSet result = null;
        try {
            String Search = "INSERT INTO employe VALUES ( '" + obj.getId_employe() + "','" + obj.getNom() + "','" + obj.getPrenom() + "','" + obj.getAdresse() + "','" + obj.getTel() + "' )  ";
            this.get_connexion().executeUpdate(Search);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return this.find(obj.getId_employe());
    }
    /**
     * Méthode update : Permet de mettre a jour la base de donnée en fournissent
     * un obj requete
     *
     * @param obj
     * @return
     */
    @Override
    public Employe update(Employe obj) {
        ResultSet result = null;

        try {
            String Search = "UPDATE employe SET "
                    + "numero = '" + obj.getId_employe() + "' ,"
                    + "nom = '" + obj.getNom() + "' ,"
                    + "prenom = '" + obj.getPrenom() + "' ,"
                    + "adresse = '" + obj.getAdresse() + "' , "
                    + "tel = '" + obj.getTel() + "' "
                    + "WHERE numero =  '" + obj.getId_employe() + "' ";

            System.out.println(Search);
            this.get_connexion().executeUpdate(Search);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    /**
     * Méthode delete : Permet de supprimer un elemde la base de donnée en
     * fournissent un obj requete
     *
     * @param obj
     */
    @Override
    public void delete(Employe obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from employe WHERE employe.numero = " + obj.getId_employe() + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM employe WHERE employe.numero = " + obj.getId_employe() + " ;";
                this.get_connexion().executeUpdate(Search);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Méthode delete : Permet de supprimer un elemde la base de donnée en
     * fournissent un obj requete
     *
     * @param id
     */
    public void delete(int id) {
        ResultSet result = null;
        try {
            String Search = "select * from employe WHERE employe.numero = " + id + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM employe WHERE employe.numero = " + id + " ;";
                this.get_connexion().executeUpdate(Search);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
  /**
     * Méthode nbrelem : Retrourne une liste des id de l'objet voulue requete
     *
     * @param obj
     * @return
     */
  
    /**
     * Méthode nbrelem : Retrourne une liste des id de l'objet voulue requete
     * @return
     */
    @Override
    public int[] nbrelem() {
        int nbr[] = null;
        ResultSet result = null;
        int i = 0;

        try {
            String Search = "select COUNT(*) as nbr from employe";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                nbr = new int[result.getInt("nbr")];
            }

            result = this.get_connexion().result("select numero FROM employe");

            while (result.next()) {
                nbr[i] = result.getInt("numero");
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbr;
    }
}
