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
public class HospitalisationDAO extends DAO <Hospitalisation> {
    
    private ArrayList tableHospitalisation = new ArrayList();
    private List<Hospitalisation> listHospitalisation = new LinkedList();

    @Override
    public Hospitalisation find(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                    lit = result.getInt("lit");
                    Hospitalisation obj;
                    obj = new Hospitalisation(lit);
                    listHospitalisation.add(obj);
                    
                    
                }
        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
     }
    
}
