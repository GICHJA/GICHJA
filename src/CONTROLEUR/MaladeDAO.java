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
public class MaladeDAO extends DAO <Malade> {

    @Override
    public Malade find(int id) {
               ResultSet result = null, result2 = null;
        Malade malade = new Malade();
        List<RendezVous> listrdv = null;
        try {
            String Search = "select * from malade, rendezvous WHERE malade.numero = "+id+" AND  malade.numero =  rendezvous.numero";
            result = this.get_connexion().result(Search);

            if (result.first() ) {
                     result.beforeFirst();
                while (result.next() && result.getInt("no_rdv")!= 0 ) {
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

    @Override
    public Malade create(Malade obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Malade update(Malade obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Malade obj) {
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
