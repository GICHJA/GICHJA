/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import MODELE.Chambre;
import MODELE.Infirmier;
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
public class InfirmierDAO extends DAO<Infirmier>{

    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] nbrelem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Infirmier find(int id) {
        ResultSet result = null;
        Infirmier obj = new Infirmier();
        List<Chambre> listobj = new LinkedList();;
        try {
            String Search = "SELECT * FROM employe , infirmier , chambre WHERE infirmier.numero = "+id+" AND  employe.numero = infirmier.numero AND chambre.surveillant =  infirmier.numero ";
            result = this.get_connexion().result(Search);

            if (result.first()  ) {
                     result.beforeFirst();
                while (result.next() && result.getInt("id_chambre")!= 0) {
                    ChambreDAO objDAO = new ChambreDAO();
                    objDAO.set_connexion(this.get_connexion());
                    listobj.add(objDAO.find(result.getInt("id_chambre")));

                }
                result.first();
                obj = new Infirmier(result.getString("Infirmier"), result.getDouble("salaire"),
                                       listobj, id, result.getString("nom")  
                        ,result.getString("prenom"),result.getString("adresse")
                        ,result.getString("tel"));
                
                //String specialite, List<RendezVous> listrdv, int id_employe, String nom, String prenom, String adresse, String tel
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public Infirmier create(Infirmier obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Infirmier update(Infirmier obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Infirmier obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}