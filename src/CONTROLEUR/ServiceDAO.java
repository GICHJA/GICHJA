/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import MODELE.Chambre;
import MODELE.Docteur;
import MODELE.Infirmier;
import MODELE.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class ServiceDAO extends DAO<Service> {

    @Override
    public Service find(int id) {
        ResultSet result = null;
        Service obj = new Service();
        List<Infirmier> listobj = new LinkedList();
        List<Chambre> listobj2 = new LinkedList();
        Docteur directeur = new Docteur();
        try {
            String Search = "SELECT * FROM service, infirmier WHERE id_service = " + id + " AND infirmier.code_service = service.code";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                result.beforeFirst();
                while (result.next() && result.getInt("numero") != 0) {
                    InfirmierDAO objDAO = new InfirmierDAO();
                    objDAO.set_connexion(this.get_connexion());
                    listobj.add(objDAO.find(result.getInt("numero")));

                }
            }

            Search = "SELECT * FROM service, chambre WHERE id_service = " + id + " AND chambre.code_service = service.code";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                result.beforeFirst();
                while (result.next() && result.getInt("no_chambre") != 0) {
                    ChambreDAO objDAO2 = new ChambreDAO();
                    objDAO2.set_connexion(this.get_connexion());
                    listobj2.add(objDAO2.find(result.getInt("no_chambre")));

                }

                result.first();
                DocteurDAO objDAO3 = new DocteurDAO();
                objDAO3.set_connexion(this.get_connexion());
                directeur = objDAO3.find(result.getInt("directeur"));
                obj = new Service(id, result.getString("code"), result.getString("nom"), directeur, listobj, listobj2);

                //int id_service, String nom, Docteur directeur, List<Infirmier> listinfirmier, List<Chambre> listchambre
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public Service create(Service obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "INSERT INTO service VALUES ( '" + nextid + "','" + obj.getCode() + "','" + obj.getNom() + "','" + obj.getId_batiment() + "','" + obj.getNo_directeur() + "' ) ";
            this.get_connexion().executeUpdate(Search);

        } catch (SQLException ex) {
            Logger.getLogger(ServiceDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return this.find(nextid);
    }

    @Override
    public Service update(Service obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Service obj) {
        ResultSet result = null;
        int[] listelem = this.nbrelem();
        int nextid = listelem[listelem.length - 1] + 1;
        try {
            String Search = "select * from service WHERE service.id_service = " + obj.getId_service() + " ;";
            result = this.get_connexion().result(Search);
            if (result.first()) {

                Search = "DELETE FROM service WHERE service.id_service = " + obj.getId_service() + " ;";
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
            String Search = "select COUNT(*) as nbr from service";
            result = this.get_connexion().result(Search);

            if (result.first()) {
                nbr = new int[result.getInt("nbr")];
            }

            result = this.get_connexion().result("select id_service FROM service");

            while (result.next()) {
                nbr[i] = result.getInt("id_service");
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nbr;
    }

}
