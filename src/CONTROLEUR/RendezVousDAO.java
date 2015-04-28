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

    @Override
    public RendezVous find(int id) {
        ResultSet result = null;
        RendezVous obj = new RendezVous();
        try {
            String Search = "SELECT * FROM rendezvous WHERE no_rdv = " + id + "";
            result = this.get_connexion().result(Search);

                if (result.first()) {
                obj = new RendezVous(id,result.getDate("datearr"),result.getDate("atedep"),result.getString("motif"));
            }
                //int id_service, String nom, Docteur directeur, List<Infirmier> listinfirmier, List<Chambre> listchambre*/
            
        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public RendezVous create(RendezVous obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RendezVous update(RendezVous obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(RendezVous obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] nbrelem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
