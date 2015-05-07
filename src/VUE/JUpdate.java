/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author lucaromano
 */
public class JUpdate extends JFrame implements ActionListener, WindowListener{
    
    private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10, jb11;
    private JTextArea ja1, ja2;
    private JPanel p1, p2, p3, princ;
    
    public JUpdate(){
        
        princ = new JPanel (new BorderLayout());
        p1 = new JPanel (new GridLayout (2,4));
        p2 = new JPanel (new GridLayout (1,2));
        p3 = new JPanel (new GridLayout (1,3));
        
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
        princ.add("North", p1);
        
        this.ja1 = new JTextArea("Tous les attributs\n\n\n\n\n");
        p2.add(this.ja1);
        this.ja2 = new JTextArea("Attributs entité choisie ou nouvelle entité");
        p2.add(this.ja2);
        princ.add("Center", p2);
        
        this.jb9 = new JButton("Mettre à jour");
        p3.add(this.jb9);
        this.jb9.addActionListener(this);
        this.jb10 = new JButton("Insérer");
        p3.add(this.jb10);
        this.jb10.addActionListener(this);
        this.jb11 = new JButton("Supprimer");
        p3.add(this.jb11);
        this.jb11.addActionListener(this);
        princ.add("South", p3);
        
        this.setContentPane(princ);     
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

