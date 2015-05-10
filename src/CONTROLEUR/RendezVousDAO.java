/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import MODELE.Chambre;
import MODELE.Docteur;
import MODELE.Hospitalisation;
import MODELE.Infirmier;
import MODELE.RendezVous;
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
public class RendezVousDAO extends DAO<RendezVous> {

    /**
     * Méthode find : Permet de retourner la classe entiérement remplie en
     * fournissant un id requete
     *
     * @param id
     * @return
     */
    @Override
    public RendezVous find(int id) {
        ResultSet result = null;
        RendezVous obj = new RendezVous();
        try {
            String Search = "SELECT * FROM rendezvous WHERE no_rdv = " + id + "";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                obj = new RendezVous(id, result.getString("datearr"), result.getString("datedep"), result.getString("motif"));

            }
            //int id_service, String nom, Docteur directeur, List<Infirmier> listinfirmier, List<Chambre> listchambre*/

        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    /**
     * Méthode create : Permet de creer la classe entiérement remplie en
     * fournissant un obg requete
     *
     * @param obj
     * @return
     */
    @Override
    public RendezVous create(RendezVous obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "INSERT INTO rendezvous VALUES ( '" + nextid + "','" + obj.getNo_malade() + "','" + obj.getNo_docteur() + "','" + obj.getDate_arr() + "','" + obj.getDate_dep() + "','" + obj.getMotif() + "' ) ";
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
    public RendezVous update(RendezVous obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Méthode delete : Permet de supprimer un elemde la base de donnée en
     * fournissent un obj requete
     *
     * @param obj
     */
    @Override
    public void delete(RendezVous obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from rendezvous WHERE rendezvous.no_rdv = " + obj.getNo_rdv() + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM batiment WHERE rendezvous.no_rdv = " + obj.getNo_rdv() + " ;";
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
            String Search = "select COUNT(*) as nbr from rendezvous";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                nbr = new int[result.getInt("nbr")];
            }

            result = this.get_connexion().result("select no_rdv FROM rendezvous");

            while (result.next()) {
                nbr[i] = result.getInt("no_rdv");
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbr;
    }

    /**
     *
     * @param selection_de_la_jcombox_mais_ceci_est_lid
     */
    public void deleteint(int selection_de_la_jcombox_mais_ceci_est_lid) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from rendezvous WHERE rendezvous.no_rdv = " + selection_de_la_jcombox_mais_ceci_est_lid + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM batiment WHERE rendezvous.no_rdv = " + selection_de_la_jcombox_mais_ceci_est_lid + " ;";
                this.get_connexion().executeUpdate(Search);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
