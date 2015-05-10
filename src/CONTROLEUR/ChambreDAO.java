/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import MODELE.Chambre;
import MODELE.Hospitalisation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Davy
 */
public class ChambreDAO extends DAO<Chambre> {

    private ArrayList tablechambre = null;
    private Chambre listchambre = null;


        /**
     * Méthode find : Permet de retourner la classe entiérement remplie en
     * fournissant un id requete
     *
     * @param id_chambre
     * @return
     */
    public Chambre find(int id_chambre) {
        ResultSet result = null, result2 = null;
        Chambre chambre = new Chambre();
        List<Hospitalisation> listhospitalisation;
        listhospitalisation = new LinkedList();
        try {
            String Search = "select * from chambre, hospitalisation WHERE chambre.id_chambre = " + id_chambre + " AND  chambre.id_chambre =  hospitalisation.id_chambre";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                result.beforeFirst();
                while (result.next() && result.getInt("id_hospitalisation") != 0) {
                    HospitalisationDAO devDAO = new HospitalisationDAO();
                    devDAO.set_connexion(this.get_connexion());
                    listhospitalisation.add(devDAO.find(result.getInt("id_hospitalisation")));

                }
                result.first();
                chambre = new Chambre(result.getInt("no_chambre"),
                        result.getInt("nb_lits"), listhospitalisation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chambre;
    }
    
        /**
     * Méthode create : Permet de creer la classe entiérement remplie en
     * fournissant un obg requete
     *
     * @param obj
     * @return
     */
    @Override
    public Chambre create(Chambre obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "INSERT INTO chambre VALUES ( "
                    + "'" 
                    + nextid 
                    + "','"
                    + obj.getCode_service()
                    + "','"
                    + obj.getNo_chambre()
                    + "','"
                    + obj.getSurveillant()
                    + "','"
                    + obj.getNb_lit()
                    + "' ) ";
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
    public Chambre update(Chambre obj) {
        ResultSet result = null;
/*
        try {
            String Search = "UPDATE chambre SET "
                    + "code_service = '" 
                    + obj.getCode_service() 
                    + "', '" 
                    + obj.getSurveillant() 
                    + "','" 
                    + obj.getNo_chambre() 
                    + "' ) ";"' WHERE id_batiment =  '"
                    + obj.getId_batiment() + "'  ";
            this.get_connexion().executeUpdate(Search);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
*/
        return obj;
    }
    /**
     * Méthode delete : Permet de supprimer un elemde la base de donnée en
     * fournissent un obj requete
     *
     * @param obj
     */
    @Override
    public void delete(Chambre obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from chambre WHERE chambre.id_chambre = " + obj.getId_chambre() + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM chambre WHERE chambre.id_chambre = " + obj.getId_chambre() + " ;";
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
            String Search = "select COUNT(*) as nbr from chambre";
            result = this.get_connexion().result("select COUNT(*) AS nbr FROM chambre");

            if (result.first()) {
                nbr = new int[result.getInt("nbr")];
            }

            result = this.get_connexion().result("select id_chambre FROM chambre");

            while (result.next()) {
                nbr[i] = result.getInt("id_chambre");
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
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
             String Search = "select * from chambre WHERE chambre.id_chambre = " + selection_de_la_jcombox_mais_ceci_est_lid + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                 Search = "DELETE FROM chambre WHERE chambre.id_chambre = " + selection_de_la_jcombox_mais_ceci_est_lid + " ;";
                this.get_connexion().executeUpdate(Search);
                
                
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
