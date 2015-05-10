/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import MODELE.Malade;
import MODELE.RendezVous;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davy
 */
public class MaladeDAO extends DAO<Malade> {

    /**
     * Méthode find : Permet de retourner la classe entiérement remplie en
     * fournissant un id requete
     *
     * @param id
     * @return
     */
    @Override
    public Malade find(int id) {
        ResultSet result = null, result2 = null;
        Malade malade = new Malade();
        List<RendezVous> listrdv = new LinkedList();
        try {
            String Search = "select * from malade, rendezvous WHERE malade.numero = " + id + " AND  malade.numero =  rendezvous.no_malade";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                result.beforeFirst();
                while (result.next() && result.getInt("no_rdv") != 0) {
                    RendezVousDAO rdvDAO = new RendezVousDAO();
                    rdvDAO.set_connexion(this.get_connexion());
                    listrdv.add(rdvDAO.find(result.getInt("no_rdv")));

                }
                result.first();
                malade = new Malade(result.getInt("numero"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("adresse"),
                        result.getString("tel"),
                        listrdv
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return malade;
    }

    /**
     * Méthode find : Permet de retourner la classe entiérement remplie en
     * fournissant un id requete
     *
     * @param requete
     * @return
     */
    public Malade find(String requete) {
        ResultSet result = null, result2 = null;
        Malade malade = new Malade();
        List<RendezVous> listrdv = new LinkedList();
        try {
            String Search = "select * from malade, rendezvous WHERE" + requete + " AND  malade.numero =  rendezvous.no_malade";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                result.beforeFirst();
                while (result.next() && result.getInt("no_rdv") != 0) {
                    RendezVousDAO rdvDAO = new RendezVousDAO();
                    rdvDAO.set_connexion(this.get_connexion());
                    listrdv.add(rdvDAO.find(result.getInt("no_rdv")));

                }
                result.first();
                malade = new Malade(result.getInt("numero"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("adresse"),
                        result.getString("tel"),
                        listrdv
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return malade;
    }

    /**
     * Méthode create : Permet de creer la classe entiérement remplie en
     * fournissant un obg requete
     *
     * @param obj
     * @return
     */
    @Override
    public Malade create(Malade obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "INSERT INTO malade VALUES ( '" + nextid + "','" + obj.getNom() + "','" + obj.getPrenom() + "','" + obj.getAdresse() + "','" + obj.getTel() + "','" + obj.getId_mutuelle() + "' ) ";
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
    public Malade update(Malade obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Méthode delete : Permet de supprimer un elemde la base de donnée en
     * fournissent un obj requete
     *
     * @param obj
     */
    @Override
    public void delete(Malade obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from malade WHERE malade.numero = " + obj.getId_malade() + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM malade WHERE malade.numero = " + obj.getId_malade() + " ;";
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
            String Search = "select COUNT(*) as nbr from malade";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                nbr = new int[result.getInt("nbr")];
            }

            result = this.get_connexion().result("select numero FROM malade");

            while (result.next()) {
                nbr[i] = result.getInt("numero");
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            String Search = "select * from malade WHERE malade.numero = " + selection_de_la_jcombox_mais_ceci_est_lid + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM malade WHERE malade.numero = " + selection_de_la_jcombox_mais_ceci_est_lid + " ;";
                this.get_connexion().executeUpdate(Search);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
