/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

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
public class HospitalisationDAO extends DAO<Hospitalisation> {

    private ArrayList tableHospitalisation = new ArrayList();
    private List<Hospitalisation> listHospitalisation = new LinkedList();

    /**
     * Méthode find : Permet de retourner la classe entiérement remplie en
     * fournissant un id requete
     *
     * @param id
     * @return
     */
    @Override
    public Hospitalisation find(int id) {
        ResultSet result = null;
        Hospitalisation hospitalisation = new Hospitalisation();
        try {
            String Search = "select * from hospitalisation WHERE id_hospitalisation = " + id;
            result = this.get_connexion().result(Search);

            if (result.first()) {
                hospitalisation = new Hospitalisation(id,
                        result.getInt("lit"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hospitalisation;
    }

    /**
     * Méthode create : Permet de creer la classe entiérement remplie en
     * fournissant un obg requete
     *
     * @param obj
     * @return
     */
    @Override
    public Hospitalisation create(Hospitalisation obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "INSERT INTO hospitalisation VALUES ( '" + nextid + "','" + obj.getNo_malade() + "','" + obj.getCode_service() + "','" + obj.getNo_chambre() + "','" + obj.getLit() + "','" + obj.getId_chambre() + "' ) ";
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
    public Hospitalisation update(Hospitalisation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Méthode delete : Permet de supprimer un elemde la base de donnée en
     * fournissent un obj requete
     *
     * @param obj
     */
    @Override
    public void delete(Hospitalisation obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from hospitalisation WHERE hospitalisation.id_hospitalisation = " + obj.getId_hospitalisation() + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM hospitalisation WHERE hospitalisation.id_hospitalisation = " + obj.getId_hospitalisation() + " ;";
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
            String Search = "select COUNT(*) as nbr from hospitalisation";
            result = this.get_connexion().result("select COUNT(*) AS nbr FROM hospitalisation");

            if (result.first()) {
                nbr = new int[result.getInt("nbr")];
            }

            result = this.get_connexion().result("select id_hospitalisation FROM hospitalisation");

            while (result.next()) {
                nbr[i] = result.getInt("id_hospitalisation");
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbr;
    }
}
