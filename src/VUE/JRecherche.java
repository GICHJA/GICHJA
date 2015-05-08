/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import CONTROLEUR.BatimentDAO;
import CONTROLEUR.DAO;
import MODELE.Batiment;
import static VUE.JControleur.maconnexion;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author lucaromano
 */
public class JRecherche extends JFrame implements ActionListener, WindowListener{
    
    private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9;
    private JTextField jt;
    private JLabel jl;
    private JTextArea ja;
    private JPanel p1, p2, p3, p4, princ;
    //private JTabbedPane tabbedpane;
    private Object jconnexion;
    
    public JRecherche(){
        
        princ = new JPanel (new BorderLayout());
        p1 = new JPanel (new GridLayout (2,4));
        p2 = new JPanel (new FlowLayout ());
        p3 = new JPanel (new FlowLayout ());
        p4 = new JPanel (new FlowLayout ());
        /*tabbedpane = new JTabbedPane();
        this.getContentPane().add("North", tabbedpane);
        this.tabbedpane.addTab("Recherche", p1);*/
        
        this.jb1 = new JButton ("Service");
        p1.add(this.jb1);
        this.jb1.addActionListener(this);
        this.jb2 = new JButton ("Infirmier");
        p1.add(this.jb2);
        this.jb2.addActionListener(this);
        this.jb3 = new JButton ("Chambre");
        p1.add(this.jb3);
        this.jb3.addActionListener(this);
        this.jb4 = new JButton ("Malade");
        p1.add(this.jb4);
        this.jb4.addActionListener(this);
        this.jb5 = new JButton ("Employé");
        p1.add(this.jb5);
        this.jb5.addActionListener(this);
        this.jb6 = new JButton ("Hospitalisation");
        p1.add(this.jb6);
        this.jb6.addActionListener(this);
        this.jb7 = new JButton ("Malade");
        p1.add(this.jb7);
        this.jb7.addActionListener(this);
        this.jb8 = new JButton ("Soigné");
        p1.add(this.jb8);
        this.jb8.addActionListener(this);
        this.jb9 = new JButton ("Batiment");
        p1.add(this.jb9);
        this.jb9.addActionListener(this);
        princ.add("North", p1);
        
        this.jl = new JLabel("Tapez votre recherche :");
        p2.add(this.jl);
        this.jt = new JTextField (10);
        p2.add(this.jt);
        princ.add("West", p2);
        
        this.jb9 = new JButton("Rechercher");
        p3.add(this.jb9);
        this.jb9.addActionListener(this);
        princ.add("South", p3);
        
        this.ja = new JTextArea("Affichage de notre recherche. Si par exemple, on clique sur le bouton employé,\ntous les employés seront affichés. "
                + "On peut également pour être plus précis mettre \ndans la recherche le nom de l’employé recherché, "
                + "le résultat affichera cette employé \navec tous les attributs qui lui correspond.");
        p4.add(this.ja);
        princ.add("Center", p4);
        
        this.setContentPane(princ);
        
        /*this.pack();
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Batiment")) {
            
            DAO<Batiment> BatimentDAO = new BatimentDAO();
            BatimentDAO.set_connexion(maconnexion);
            Batiment test = new Batiment();
            test.setNom_batiment("Bonjour");
            Batiment testend = BatimentDAO.create(test);
            testend.affiche();
            BatimentDAO.delete(testend);
            
        }
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

