/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_java_2015;

import CONTROLEUR.Connexion;
import java.sql.SQLException;
import java.util.ArrayList;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        Scanner clavier;
        clavier = new Scanner(System.in);
        
        nameECE = clavier.nextLine();
        passwECE = clavier.nextLine();
        loginBDD = clavier.nextLine();
        passwdBDD = clavier.nextLine();
        
        try{
        maconnexion = new Connexion(nameECE, passwECE,loginBDD, passwdBDD);
        }
        catch(SQLException | ClassNotFoundException ex) {
            
        }
        
        
        ArrayList remplirChampsRequete = maconnexion.remplirChampsRequete("select * from chambre");
        
        for(Object s : remplirChampsRequete)
        {
            System.out.print(s);
            
        }
    }
    
}
