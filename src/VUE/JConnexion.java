/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import CONTROLEUR.Connexion;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author lucaromano
 */
public class JConnexion extends JFrame implements ActionListener, WindowListener {

    private JLabel jl1, jl2, jl3, jl4, jl5;
    private JButton jb;
    private JTextField jt1, jt2;
    private JPasswordField jp1, jp2;
    private JPanel princ, p1, p2, p3;
    private Connexion maconnexion;
    private static JControleur jControleur;

    public JConnexion() {
        super("Interface ");
        maconnexion = new Connexion();
        princ = new JPanel(new BorderLayout());
        p1 = new JPanel(new FlowLayout());
        p2 = new JPanel(new GridLayout(4, 4));
        p3 = new JPanel(new FlowLayout());

        this.jl1 = new JLabel("Bonjour, veuillez saisir votre nom et mot de passe ECE ainsi que votre nom"
                + " et mot de passe BDD :");
        p1.add(this.jl1);
        princ.add("North", p1);

        this.jl2 = new JLabel("Nom ECE :");
        p2.add(this.jl2);
        this.jt1 = new JTextField();
        p2.add(this.jt1);
        this.jl3 = new JLabel("Mot de passe ECE :");
        p2.add(this.jl3);
        this.jp1 = new JPasswordField();
        p2.add(this.jp1);
        this.jl4 = new JLabel("Nom BDD :");
        p2.add(this.jl4);
        this.jt2 = new JTextField();
        p2.add(this.jt2);
        this.jl5 = new JLabel("Mot de passe BDD :");
        p2.add(this.jl5);
        this.jp2 = new JPasswordField();
        p2.add(this.jp2);
        princ.add("Center", p2);

        this.jb = new JButton("Connexion");
        p3.add(this.jb);
        this.jb.addActionListener(this);
        princ.add("South", p3);

        this.setContentPane(princ);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows to close the window directly when we click on the red cross
    }

    public int getConnexionValide() {

        return maconnexion.getconnexionok();

    }

    public Connexion getConnexion() {

        return maconnexion;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Connexion")) {

        /*    if (maconnexion.getconnexionok() == 0) {
                jControleur = new JControleur(maconnexion);
                jControleur.setSize(800, 800);
                jControleur.setVisible(true);
                this.setVisible(false);
            }*/
             try {

             maconnexion = new Connexion(jt1.getText(), jp1.getText(), jt2.getText(), jp2.getText());

             if (maconnexion.getconnexionok() == 1) {
             jControleur = new JControleur(maconnexion);
             jControleur.setSize(800, 800);
             jControleur.setVisible(true);
             this.setVisible(false);

             }

             } catch (SQLException ex) {
             Logger.getLogger(JConnexion.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
             Logger.getLogger(JConnexion.class.getName()).log(Level.SEVERE, null, ex);
             }
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
