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
import java.awt.Image;

/**
 *
 * @author lucaromano
 */
public class JConnexion extends JFrame implements ActionListener, WindowListener {

    private JLabel jl1, jl2, jl3, jl4, jl5;
    private JButton jb, jb2;
    private JTextField jt1, jt2;
    private JPasswordField jp1, jp2;
    private JPanel princ, p1, p2, p3;
    private Connexion maconnexion;
    private static JControleur jControleur;
    private Image panel;

    /**
     *
     */
    public JConnexion() {
        super("Interface ");
        maconnexion = new Connexion();
        princ = new JPanel(new BorderLayout());
        princ.setLayout(new BorderLayout());

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
        p3.add("East", this.jb);
        this.jb.addActionListener(this);
        this.jb2 = new JButton("Hors-ligne");
        p3.add(this.jb2);
        this.jb2.addActionListener(this);
        p3.add("West", this.jb2);

        princ.add("South", p3);

        this.setContentPane(princ);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows to close the window directly when we click on the red cross
    }

    /**
     *
     * @return
     */
    public int getConnexionValide() {

        return maconnexion.getconnexionok();

    }

    /**
     *
     * @return
     */
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
               // maconnexion = new Connexion("romano", jp1.getText(), "romano-rw", "UZzWhDla");

                if (maconnexion.getconnexionok() == 1) {
                    jControleur = new JControleur(maconnexion);
                    jControleur.setSize(500, 350);
                    jControleur.setLocation(1024 / 4, 1000 / 4);
                    jControleur.setVisible(true);
                    this.setVisible(false);

                }

            } catch (SQLException ex) {
                Logger.getLogger(JConnexion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getActionCommand().equals("Hors-ligne")) {
            try {

                // maconnexion = new Connexion(jt1.getText(), jp1.getText(), jt2.getText(), jp2.getText());
                maconnexion = new Connexion("prieux");

                if (maconnexion.getconnexionok() == 1) {
                    jControleur = new JControleur(maconnexion);
                    jControleur.setSize(500, 350);
                    jControleur.setLocation(1024 / 4, 1000 / 4);
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
