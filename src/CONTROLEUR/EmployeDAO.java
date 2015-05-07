/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import MODELE.Employe;
import MODELE.Hospitalisation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrien
 */
public class EmployeDAO extends DAO<Employe> {

    int newattr;

    @Override
    public Employe find(int id) {
        ResultSet result = null;
        Employe employe = new Employe();
        try {
            String Search = "select * from employe WHERE numero = " + id;
            result = this.get_connexion().result(Search);

            if (result.first()) {
                employe = new Employe(id,
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("adresse"),
                        result.getString("tel"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employe;
    }

    @Override
    public Employe create(Employe obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "INSERT INTO employe VALUES ( '" + nextid + "','" + obj.getNom() + "','" + obj.getPrenom() + "','" + obj.getAdresse() + "','" + obj.getTel() + "' )  ";
            this.get_connexion().executeUpdate(Search);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return this.find(nextid);
    }

    @Override
    public Employe update(Employe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Employe obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from employe WHERE employe.numero = " + obj.getId_employe() + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM employe WHERE employe.numero = " + obj.getId_employe() + " ;";
                this.get_connexion().executeUpdate(Search);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] nbrelem() {
        int nbr[] = null;
        ResultSet result = null;
        int i = 0;

        try {
            String Search = "select COUNT(*) as nbr from employe";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                nbr = new int[result.getInt("nbr")];
            }

            result = this.get_connexion().result("select numero FROM employe");

            while (result.next()) {
                nbr[i] = result.getInt("numero");
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbr;
    }
}
