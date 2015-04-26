/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLEUR;
import MODELE.Chambre;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Davy
 */
public class ChambreDAO extends DAO <Chambre> {
    
    private ArrayList tablechambre = null;
    private Chambre listchambre = null;
    
    
     @Override
    public void init() {
        
        
    }
    
    

    @Override
    public Chambre find(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Chambre create(Chambre obj) {
        return obj;
    }

    @Override
    public Chambre update(Chambre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Chambre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
