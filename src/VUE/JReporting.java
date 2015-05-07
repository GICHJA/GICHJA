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
public class JReporting extends JFrame implements ActionListener, WindowListener {

    private JButton jb1, jb2;
    private JTextArea ja;
    private JPanel p1, p2, princ;
    
    public JReporting(){
        
        princ = new JPanel (new BorderLayout ());
        p1 = new JPanel (new GridLayout(1,2));
        p2 = new JPanel (new FlowLayout());
        
        this.jb1 = new JButton ("Moyenne Salaire");
        p1.add(this.jb1);
        this.jb1.addActionListener(this);
        this.jb2 = new JButton ("Nombre d'hospitalisés par type de service");
        p1.add(this.jb2);
        this.jb2.addActionListener(this);
        princ.add("North", this.p1);
        
        this.ja = new JTextArea ("Quand on clique sur une des statistiques au dessus, le graphique \ns’affichera directement dans cette fenêtre. Il y aura beaucoup plus\nde statistiques. "
                + "Nous en avons mis que deux pour expliquer comment\ncela fonctionnera. ");
        p2.add(this.ja);
        princ.add("South", this.p2);
        
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
