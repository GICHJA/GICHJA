/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import MODELE.Chambre;
import MODELE.Employe;
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
public class InfirmierDAO extends DAO<Infirmier> {

    /**
     * Méthode nbrelem : Retrourne une liste des id de l'objet voulue requete
     *
     * @return
     */
    @Override
    public int[] nbrelem() {
        int nbr[] = null;
        ResultSet result = null;
        int i = 0;

        try {
            String Search = "select COUNT(*) as nbr from infirmier";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                nbr = new int[result.getInt("nbr")];
            }

            result = this.get_connexion().result("select numero FROM infirmier");

            while (result.next()) {
                nbr[i] = result.getInt("numero");
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbr;
    }

    /**
     * Méthode find : Permet de retourner la classe entiérement remplie en
     * fournissant un id requete
     *
     * @param id
     * @return
     */
    @Override
    @SuppressWarnings("empty-statement")
    public Infirmier find(int id) {
        ResultSet result = null;
        Infirmier obj = new Infirmier();
        List<Chambre> listobj = new LinkedList();;
        try {
            String Search = "SELECT * FROM employe , infirmier , chambre WHERE infirmier.numero = " + id + " AND  employe.numero = infirmier.numero AND chambre.surveillant =  infirmier.numero ";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                result.beforeFirst();
                while (result.next() && result.getInt("id_chambre") != 0) {
                    ChambreDAO objDAO = new ChambreDAO();
                    objDAO.set_connexion(this.get_connexion());
                    listobj.add(objDAO.find(result.getInt("id_chambre")));

                }
                result.first();
                obj = new Infirmier(result.getString("rotation"), result.getDouble("salaire"),
                        listobj, id, result.getString("nom"), result.getString("prenom"), result.getString("adresse"), result.getString("tel"));
                obj.setCode_service(result.getString("code_service"));
                obj.setNumero(result.getInt("numero"));

                //String specialite, List<RendezVous> listrdv, int id_employe, String nom, String prenom, String adresse, String tel
            } else {
                Search = "SELECT * FROM employe , infirmier  WHERE infirmier.numero = " + id + " AND  employe.numero = infirmier.numero ";
                result = this.get_connexion().result(Search);
                if (result.first()) {
                    obj = new Infirmier(result.getString("rotation"), result.getDouble("salaire"),
                            null, id, result.getString("nom"), result.getString("prenom"), result.getString("adresse"), result.getString("tel"));
                    obj.setCode_service(result.getString("code_service"));
                    obj.setNumero(result.getInt("numero"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    /**
     * Méthode create : Permet de creer la classe entiérement remplie en
     * fournissant un obg requete
     *
     * @param obj
     * @return
     */
    @Override
    public Infirmier create(Infirmier obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 40;
        try {
            String Search = "INSERT INTO infirmier VALUES ( '" + nextid + "','" + obj.getCode_service() + "','" + obj.getRotation() + "','" + obj.getSalaire() + "' ) ";
            this.get_connexion().executeUpdate(Search);
            obj.setId_employe(nextid);
            EmployeDAO employeDAO = new EmployeDAO();
            employeDAO.set_connexion(this.get_connexion());
            employeDAO.create(obj);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return this.find(nextid);
    }

    /**
     * Méthode update : Permet de mettre a jour la base de donnée en fournissent
     * un obj requete
     *
     * @param obj
     * @return
     */
    @Override
    public Infirmier update(Infirmier obj) {
        ResultSet result = null;

        try {
            String Search = "UPDATE infirmier SET "
                    + "numero = '" + obj.getNumero() + "' ,"
                    + "code_service = '" + obj.getCode_service() + "' ,"
                    + "rotation = '" + obj.getRotation() + "' ,"
                    + "salaire = '" + obj.getSalaire() + "' "
                    + "WHERE numero =  '" + obj.getNumero() + "' ";

            EmployeDAO employeDAO = new EmployeDAO();
            employeDAO.set_connexion(this.get_connexion());
            employeDAO.update(obj);

            System.out.println(Search);
            this.get_connexion().executeUpdate(Search);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    /**
     * Méthode delete : Permet de supprimer un elemde la base de donnée en
     * fournissent un obj requete
     *
     * @param obj
     */
    @Override
    public void delete(Infirmier obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from infirmier WHERE infirmier.numero = " + obj.getNumero() + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM infirmier WHERE infirmier.numero = " + obj.getNumero() + " ;";
                this.get_connexion().executeUpdate(Search);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Méthode delete : Permet de supprimer un elemde la base de donnée en
     * fournissent un obj requete
     *
     * @param id
     */
    public void deleteint(int id) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from infirmier WHERE infirmier.numero = " + id + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM infirmier WHERE infirmier.numero = " + id + " ;";
                this.get_connexion().executeUpdate(Search);

                EmployeDAO employeDAO = new EmployeDAO();
                employeDAO.set_connexion(this.get_connexion());
                employeDAO.delete(id);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param requete
     * @return
     */
    public Infirmier find(String requete) {
        ResultSet result = null;
        Infirmier obj = new Infirmier();
        List<Chambre> listobj = new LinkedList();;
        try {
            String Search = "SELECT * FROM employe , infirmier , chambre WHERE" + requete + " AND  employe.numero = infirmier.numero AND chambre.surveillant =  infirmier.numero ";
            result = this.get_connexion().result(Search);
            if (result.first()) {
                result.beforeFirst();
                while (result.next() && result.getInt("id_chambre") != 0) {
                    ChambreDAO objDAO = new ChambreDAO();
                    objDAO.set_connexion(this.get_connexion());
                    listobj.add(objDAO.find(result.getInt("id_chambre")));

                }
                result.first();
                obj = new Infirmier(result.getString("rotation"), result.getDouble("salaire"),
                        listobj, result.getInt("numero"), result.getString("nom"), result.getString("prenom"), result.getString("adresse"), result.getString("tel"));

                //String specialite, List<RendezVous> listrdv, int id_employe, String nom, String prenom, String adresse, String tel
            } else {
                Search = "SELECT * FROM employe , infirmier  WHERE" + requete + " AND  employe.numero = infirmier.numero ";
                result = this.get_connexion().result(Search);
                result.first();
                obj = new Infirmier(result.getString("rotation"), result.getDouble("salaire"),
                        null, result.getInt("numero"), result.getString("nom"), result.getString("prenom"), result.getString("adresse"), result.getString("tel"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

}
