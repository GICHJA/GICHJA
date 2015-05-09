/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_java_2015;

import CONTROLEUR.BatimentDAO;
import CONTROLEUR.ChambreDAO;
import CONTROLEUR.Connexion;
import CONTROLEUR.DAO;
import CONTROLEUR.DocteurDAO;
import CONTROLEUR.HospitalisationDAO;
import CONTROLEUR.InfirmierDAO;
import CONTROLEUR.MaladeDAO;
import CONTROLEUR.ServiceDAO;
import MODELE.Batiment;
import MODELE.Chambre;
import MODELE.Docteur;
import MODELE.Hospitalisation;
import MODELE.Infirmier;
import MODELE.Malade;
import MODELE.Service;
import VUE.JConnexion;
import VUE.JControleur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Adrien
 */
public class PROJET_JAVA_2015 {

    private static String nameECE;
    private static String passwECE;
    private static String loginBDD;
    private static String passwdBDD;
    private static Connexion maconnexion;
    private static JControleur jControleur;
    private static JConnexion jconnexion;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner clavier;
        clavier = new Scanner(System.in);

        //nameECE = "romano";
        // passwECE = clavier.nextLine();
        //loginBDD = "romano-rw";
        //passwdBDD = clavier.nextLine(); //UZzWhDla //hEpFkmQh

      
            //maconnexion = new Connexion(nameECE, passwECE, loginBDD, passwdBDD);
            /*    DAO<Chambre> ChambreDAO = new ChambreDAO();
             ChambreDAO.set_connexion(maconnexion);
             int elem[] = ChambreDAO.nbrelem();
             for(int i=0 ; i < elem.length ; i++)
             ChambreDAO.find(elem[i]).affiche();*/
            /*    DAO<Batiment> BatimentDAO = new BatimentDAO();
            BatimentDAO.set_connexion(maconnexion);
            for (int i = 1; i <= 2; i++) {
            BatimentDAO.find(i).affiche();
            System.out.println("\n *************************************************** \n ");
            }*/

            /*        DAO<Malade> MaladeDAO = new MaladeDAO();
            MaladeDAO.set_connexion(maconnexion);
            int elem[] = MaladeDAO.nbrelem();
            for (int i = 0; i < elem.length; i++) {
            System.out.println("\n ---- > " + elem[i] + " <----  \n");
            MaladeDAO.find(elem[i]).affiche();
            System.out.println("\n *************************************************** \n ");
            }
            } catch (SQLException | ClassNotFoundException ex) {
            } }*/
           
            jconnexion = new JConnexion();
            
    
      
     /*
            DAO<Batiment> BatimentDAO = new BatimentDAO();
            BatimentDAO.set_connexion(jconnexion.getConnexion());
            Batiment test = new Batiment();
            test.setNom_batiment("Bonjour");
            Batiment testend = BatimentDAO.create(test);
            testend.affiche();
            BatimentDAO.delete(testend);
            
*/

        return;
    

}
}
