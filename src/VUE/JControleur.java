/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import CONTROLEUR.Connexion;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;

/**
 *
 * @author lucaromano
 */
public class JControleur extends JFrame implements ActionListener, WindowListener {
    
    private JMenu menu;
    private JRecherche recherche;
    private JUpdate update;
    private JReporting reporting;
    private JPanel  app1, app2, app3, app4;

    /**
     *
     */
    public static Connexion maconnexion;
    private JTabbedPane tabbedpane;
   
    /**
     *
     * @param maconnexion
     */
    public JControleur(Connexion maconnexion) {
        
        super("Interface");
        
        this.maconnexion = maconnexion;
        
        
        tabbedpane = new JTabbedPane();
        menu = new JMenu();
        recherche = new JRecherche();
        update = new JUpdate();
        reporting = new JReporting();
        app1 = new JPanel (new BorderLayout());
        app2 = new JPanel (new BorderLayout());
        app3 = new JPanel (new BorderLayout());
        app4 = new JPanel (new BorderLayout());
        
        
        this.getContentPane().add(tabbedpane);
        
        this.tabbedpane.addTab ("Menu", app1);
        app1.add("Center",menu.getContentPane());
        this.tabbedpane.addTab ("Recherche",app2);
        app2.add("Center",recherche.getContentPane());
        this.tabbedpane.addTab ("Mise à jour",app3);
        app3.add("Center",update.getContentPane());
        this.tabbedpane.addTab ("Reporting",app4);
        app4.add("Center",reporting.getContentPane());
        
        this.pack();
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows to close the window directly when we click on the red cross
          
        
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
