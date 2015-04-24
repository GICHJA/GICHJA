/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;

import java.sql.SQLException;

/**
 *
 * @author Adrien
 * @param <T>
 */
public class DAO <T> extends Connexion {

    public DAO(String usernameECE, String passwordECE, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        super(usernameECE, passwordECE, loginDatabase, passwordDatabase);
    }
    
}
