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
    
    public Hospitalisation find(String requete) {
        ResultSet result = null;
        Hospitalisation hospitalisation = new Hospitalisation();
        try {
            String Search = "select * from hospitalisation WHERE " + requete;
            result = this.get_connexion().result(Search);

            if (result.first()) {
                hospitalisation = new Hospitalisation(result.getInt("id_hospitalisation"), result.getInt("lit")); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hospitalisation;
    }

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

    @Override
    public Hospitalisation update(Hospitalisation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    @Override
    public void init() {

        ResultSet result = null;

        try {
            tableHospitalisation = this.get_connexion().remplirChampsRequete("select * from hospitalisation");
            result = this.get_connexion().result("select * from hospitalisation");
        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (result.next()) {
                int lit;
                int id;
                lit = result.getInt("lit");
                id = result.getInt("id_hospitalisation");
                Hospitalisation obj;
                obj = new Hospitalisation(id, lit);
                listHospitalisation.add(obj);

            }
        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
