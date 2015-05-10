/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import MODELE.Malade;
import MODELE.Mutuelle;
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
public class MutuelleDAO extends DAO<Mutuelle> {

    /**
     * Méthode find : Permet de retourner la classe entiérement remplie en
     * fournissant un id requete
     *
     * @param id
     * @return
     */
    @Override
    public Mutuelle find(int id) {
        ResultSet result = null;
        Mutuelle mutuelle = new Mutuelle();
        List<Malade> listmalade;
        listmalade = new LinkedList();
        try {
            String Search = "select * from mutuelle, malade WHERE mutuelle.id_mutuelle	 = " + id + " AND  malade.id_mutuelle =  mutuelle.id_mutuelle";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                result.beforeFirst();
                while (result.next() && result.getInt("numero") != 0) {
                    MaladeDAO devDAO = new MaladeDAO();
                    devDAO.set_connexion(this.get_connexion());
                    listmalade.add(devDAO.find(result.getInt("numero")));

                }
                result.first();
                mutuelle = new Mutuelle(id,
                        result.getString("nom_mutuelle"),
                        listmalade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mutuelle;
    }

    /**
     * Méthode create : Permet de creer la classe entiérement remplie en
     * fournissant un obg requete
     *
     * @param obj
     * @return
     */
    @Override
    public Mutuelle create(Mutuelle obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "INSERT INTO malade VALUES ( '" + nextid + "','" + obj.getNom() + "' ) ";
            this.get_connexion().executeUpdate(Search);

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
    public Mutuelle update(Mutuelle obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Méthode delete : Permet de supprimer un elemde la base de donnée en
     * fournissent un obj requete
     *
     * @param obj
     */
    @Override
    public void delete(Mutuelle obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from mutuelle WHERE mutuelle.id_mutuelle = " + obj.getId_mutuelle() + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM mutuelle WHERE mutuelle.id_mutuelle = " + obj.getId_mutuelle() + " ;";
                this.get_connexion().executeUpdate(Search);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            String Search = "select COUNT(*) as nbr from mutuelle";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                nbr = new int[result.getInt("nbr")];
            }

            result = this.get_connexion().result("select id_mutuelle FROM mutuelle");

            while (result.next()) {
                nbr[i] = result.getInt("id_mutuelle");
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbr;
    }

}
