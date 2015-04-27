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

    @Override
    public void init() {

    }

    @Override
    public Chambre find(int id_chambre) {
        ResultSet result = null, result2 = null;
        Chambre chambre = new Chambre();
        List<Hospitalisation> listhospitalisation;
        listhospitalisation = new LinkedList();
        try {
            String Search = "select * from chambre WHERE no_chambre = " + id_chambre;
            result = this.get_connexion().result(Search);
            result2 = this.get_connexion().result("select id_hospitalisation from hospitalisation WHERE no_chambre = " + id_chambre);

            while (result2.next()) {
                HospitalisationDAO devDAO = new HospitalisationDAO();

                listhospitalisation.add(devDAO.find(result.getInt("id_hospitalisation")));

            }
            
            result.first();
            chambre = new Chambre(id_chambre,
                    result.getInt("nb_lits"), listhospitalisation);

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chambre;
    }

    @Override
    public Chambre create(Chambre obj) {
        return obj;
    }

    @Override
    public Chambre update(Chambre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Chambre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbrelem() {
                int nbr = 1;
        ResultSet result = null;

        try {
            String Search = "select COUNT(*) as nbr from chambre";
            result = this.get_connexion().result("select COUNT(*) AS nbr FROM chambre");

            if (result.first()) {
                nbr = result.getInt("nbr");
            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbr;
    }
    
    

}
