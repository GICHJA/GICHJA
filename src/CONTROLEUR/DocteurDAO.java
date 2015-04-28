/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import MODELE.Docteur;
import MODELE.Employe;
import MODELE.RendezVous;
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
public class DocteurDAO extends DAO<Docteur> {

    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] nbrelem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Docteur find(int id) {
        ResultSet result = null, result2 = null;
        Docteur obj = new Docteur();
        List<RendezVous> listobj = new LinkedList();;
        try {
            String Search = "SELECT * FROM employe , docteur , rendezvous WHERE docteur.numero = "+id+" AND  employe.numero = docteur.numero AND rendezvous.no_docteur =  docteur.numero ";
            result = this.get_connexion().result(Search);

            if (result.first()  ) {
                     result.beforeFirst();
                while (result.next() && result.getInt("no_rdv")!= 0) {
                    RendezVousDAO objDAO = new RendezVousDAO();
                    objDAO.set_connexion(this.get_connexion());
                    listobj.add(objDAO.find(result.getInt("no_rdv")));

                }
                result.first();
                obj = new Docteur(result.getString("specialite"),
                                       listobj, id, result.getString("nom")  
                        ,result.getString("prenom"),result.getString("adresse")
                        ,result.getString("tel"));
                
                //String specialite, List<RendezVous> listrdv, int id_employe, String nom, String prenom, String adresse, String tel
            }
        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public Docteur create(Docteur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Docteur update(Docteur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Docteur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
