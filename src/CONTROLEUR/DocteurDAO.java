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
        int nbr[] = null;
        ResultSet result = null;
        int i = 0;

        try {
            String Search = "select COUNT(*) as nbr from docteur";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                nbr = new int[result.getInt("nbr")];
            }

            result = this.get_connexion().result("select numero FROM docteur");

            while (result.next()) {
                nbr[i] = result.getInt("numero");
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbr;
    }

    @Override
    public Docteur find(int id) {
        ResultSet result = null, result2 = null;
        Docteur obj = new Docteur();
        List<RendezVous> listobj = new LinkedList();;
        try {
            String Search = "SELECT * FROM employe , docteur , rendezvous WHERE docteur.numero = " + id + " AND  employe.numero = docteur.numero AND rendezvous.no_docteur =  docteur.numero ";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                result.beforeFirst();
                while (result.next() && result.getInt("no_rdv") != 0) {
                    RendezVousDAO objDAO = new RendezVousDAO();
                    objDAO.set_connexion(this.get_connexion());
                    listobj.add(objDAO.find(result.getInt("no_rdv")));

                }
                result.first();
                obj = new Docteur(result.getString("specialite"),
                        listobj, id, result.getString("nom"), result.getString("prenom"), result.getString("adresse"), result.getString("tel"));

                //String specialite, List<RendezVous> listrdv, int id_employe, String nom, String prenom, String adresse, String tel
            } else {
                Search = "SELECT * FROM employe , docteur  WHERE docteur.numero = " + id + " AND  employe.numero = docteur.numero ";
                result = this.get_connexion().result(Search);
                if (result.first()) {
                    result.first();
                    obj = new Docteur(result.getString("specialite"),
                            null, id, result.getString("nom"), result.getString("prenom"), result.getString("adresse"), result.getString("tel"));
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public Docteur create(Docteur obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "INSERT INTO docteur VALUES ( '" + nextid + "','" + obj.getSpecialite() + "','";
            this.get_connexion().executeUpdate(Search);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return this.find(nextid);
    }

    @Override
    public Docteur update(Docteur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Docteur obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from docteur WHERE docteur.numero = " + obj.getNumero() + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM batiment WHERE docteur.numero = " + obj.getNumero() + " ;";
                this.get_connexion().executeUpdate(Search);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteint(int selection_de_la_jcombox_mais_ceci_est_lid) {
                        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from docteur WHERE docteur.numero = " + selection_de_la_jcombox_mais_ceci_est_lid + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                 Search = "DELETE FROM batiment WHERE docteur.numero = " +selection_de_la_jcombox_mais_ceci_est_lid + " ;";
                this.get_connexion().executeUpdate(Search);
                
                EmployeDAO employeDAO = new EmployeDAO();
                employeDAO.delete(selection_de_la_jcombox_mais_ceci_est_lid);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
