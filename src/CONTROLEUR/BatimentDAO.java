/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import MODELE.Batiment;
import MODELE.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrien
 */
public class BatimentDAO extends DAO<Batiment> {

    /**
     * Méthode find : Permet de retourner la classe entiérement remplie en
     * fournissant un id requete
     *
     * @param id_batiment
     * @return
     */
    @Override
    public Batiment find(int id_batiment) {
        ResultSet result = null, result2 = null;
        Batiment batiment = new Batiment();
        List<Service> listService;
        listService = new LinkedList();
        try {
            String Search = "select * from batiment, service WHERE batiment.id_batiment = " + id_batiment + " AND  batiment.id_batiment =  service.id_batiment";
            result = this.get_connexion().result(Search);
            if (result.first()) {
                result.beforeFirst();
                while (result.next() && result.getInt("id_service") != 0) {
                    ServiceDAO devDAO = new ServiceDAO();
                    devDAO.set_connexion(this.get_connexion());
                    listService.add(devDAO.find(result.getInt("id_service")));

                }
                result.first();
                batiment = new Batiment(result.getInt("id_batiment"), result.getString("nom_batiment"),
                        listService);
            } else {
                Search = "select * from batiment WHERE batiment.id_batiment = " + id_batiment + " ;";
                result = this.get_connexion().result(Search);
                if (result.first()) {
                    batiment = new Batiment(result.getInt("id_batiment"), result.getString("nom_batiment"),
                            null);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return batiment;
    }

    /**
     * Méthode create : Permet de creer la classe entiérement remplie en
     * fournissant un obg requete
     *
     * @param obj
     * @return
     */
    @Override
    public Batiment create(Batiment obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "INSERT INTO batiment VALUES ( '" + nextid + "','" + obj.getNom_batiment() + "' ) ";
            this.get_connexion().executeUpdate(Search);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return this.find(nextid);
    }

    /**
     * Méthode update : Permet de mettre a jour la base de donnée en fournissent
     * un obj requete
     *
     * @param obj
     * @return
     */
    @Override
    public Batiment update(Batiment obj) {
        ResultSet result = null;

        try {
            String Search = "UPDATE batiment SET nom_batiment = '" + obj.getNom_batiment() + "' WHERE id_batiment =  '"
                    + obj.getId_batiment() + "'  ";
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
    public void delete(Batiment obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from batiment WHERE batiment.id_batiment = " + obj.getId_batiment() + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM batiment WHERE batiment.id_batiment = " + obj.getId_batiment() + " ;";
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
     * @return
     */
    @Override
    public int[] nbrelem() {
        int nbr[] = null;
        ResultSet result = null;
        int i = 0;

        try {
            String Search = "select COUNT(*) as nbr from batiment";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                nbr = new int[result.getInt("nbr")];
            }

            result = this.get_connexion().result("select id_batiment FROM batiment ORDER BY id_batiment ASC");

            while (result.next()) {
                nbr[i] = result.getInt("id_batiment");
                i++;

            }

        } catch (SQLException ex) {
            Logger.getLogger(BatimentDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return nbr;
    }

}
