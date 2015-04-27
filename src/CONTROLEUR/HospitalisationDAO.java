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
            result = this.get_connexion().result("select * from hospitalisation WHERE id_hospitalisation = " + id);

            if (result.first()) {
                hospitalisation = new Hospitalisation(id,
                        result.getInt("lit"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hospitalisation;
    }

    @Override
    public Hospitalisation create(Hospitalisation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hospitalisation update(Hospitalisation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Hospitalisation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public int nbrelem() {
        int nbr = 1;
        ResultSet result = null;

        try {
            String Search = "select COUNT(*) as nbr from hospitalisation";
            result = this.get_connexion().result("select COUNT(*) AS nbr FROM hospitalisation");

            if (result.first()) {
                nbr = result.getInt("nbr");
            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbr;
    }
}
