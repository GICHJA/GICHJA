/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import CONTROLEUR.BatimentDAO;
import CONTROLEUR.DAO;
import CONTROLEUR.ServiceDAO;
import MODELE.Docteur;
import MODELE.Service;
import static VUE.JControleur.maconnexion;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author lucaromano
 */
public class JUpdate extends JFrame implements ActionListener, WindowListener {

    private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10, jb11;
    private JTextArea ja1, ja2;
    private JPanel p1, p2, p3, princ, selection ,affichagecentrale;
    //// SERVICE
    private JPanel p1service, p2service, p3service, princservice, insererservice;
    private JComboBox jcservice;
    private int selection_de_la_jcombox;
    private int[] selection_de_la_jcombox_mais_ceci_est_lid;
    private String Cursor;
    ////    CE QU il faut pour creer
    private JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8, jtf9, jtf10, jtf11, jtf12, jtf13, jtf14, jtf15;
    private JLabel jl1, jl2, jl3, jl4, jl5;
    private JButton jbvalide1;

    public JUpdate() {

        princ = new JPanel(new BorderLayout());
        selection = new JPanel(new BorderLayout());
        affichagecentrale = new JPanel(new BorderLayout());
        p1 = new JPanel(new GridLayout(2, 4));
        p2 = new JPanel(new GridLayout(1, 2));
        p3 = new JPanel(new GridLayout(1, 3));

        this.jb1 = new JButton("Service");
        p1.add(this.jb1);
        this.jb1.addActionListener(this);
        this.jb2 = new JButton("Infirmier");
        p1.add(this.jb2);
        this.jb2.addActionListener(this);
        this.jb3 = new JButton("Chambre");
        p1.add(this.jb3);
        this.jb3.addActionListener(this);
        this.jb4 = new JButton("Malade");
        p1.add(this.jb4);
        this.jb4.addActionListener(this);
        this.jb5 = new JButton("Employé");
        p1.add(this.jb5);
        this.jb5.addActionListener(this);
        this.jb6 = new JButton("Hospitalisation");
        p1.add(this.jb6);
        this.jb6.addActionListener(this);
        this.jb7 = new JButton("Docteur");
        p1.add(this.jb7);
        this.jb7.addActionListener(this);
        this.jb8 = new JButton("Soigné");
        p1.add(this.jb8);
        this.jb8.addActionListener(this);
        selection.add("North", p1);

        affichagecentrale.setSize(10,41);
        selection.add("South",affichagecentrale);

        this.jb9 = new JButton("Mettre à jour");
        this.jb9.setBackground(Color.red);
        this.jb9.setForeground(Color.white);
        p3.add(this.jb9);
        this.jb9.addActionListener(this);
        this.jb10 = new JButton("Insérer");
        this.jb10.setBackground(Color.red);
        this.jb10.setForeground(Color.white);
        p3.add(this.jb10);
        this.jb10.addActionListener(this);
        this.jb11 = new JButton("Supprimer");
        this.jb11.setBackground(Color.red);
        this.jb11.setForeground(Color.white);
        p3.add(this.jb11);
        this.jb11.addActionListener(this);
        selection.add("Center", p3);

        princ.add("North", selection);
        this.setContentPane(princ);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Service")) {
            ///SERVICE
            Cursor = "Service";
            DAO<Service> ServiceDAO = new ServiceDAO();
            ServiceDAO.set_connexion(maconnexion);
            int elem[] = ServiceDAO.nbrelem();
            jcservice = new JComboBox();
            selection_de_la_jcombox_mais_ceci_est_lid = new int[elem.length];
            //jcservice.removeAllItems();
            for (int i = 0; i < elem.length; i++) {
                Service service = ServiceDAO.find(elem[i]);
                jcservice.addItem(service.getstringService());
                selection_de_la_jcombox_mais_ceci_est_lid[i] = service.getId_service();

            }
            jcservice.setActionCommand("jcservice");
            jcservice.addActionListener(this);
            princservice = new JPanel(new BorderLayout());
            princservice.add("North", jcservice);
            princservice.setVisible(true);
            affichagecentrale.add("South", princservice);
            princ.revalidate();

        }

        if (e.getActionCommand().equals("jcservice")) {
            selection_de_la_jcombox = jcservice.getSelectedIndex();
        }

        if (e.getActionCommand().equals("Supprimer")) {
            if (Cursor == "Service") {
                ServiceDAO servicedao = new ServiceDAO();
                servicedao.set_connexion(maconnexion);
                if (selection_de_la_jcombox != 0) {
                    servicedao.deleteint(selection_de_la_jcombox_mais_ceci_est_lid[selection_de_la_jcombox]);
                }
                selection_de_la_jcombox = 0;
                // princ.validate();
                princservice.setVisible(false);
            }
        }

        if (e.getActionCommand().equals("Insérer")) {
            if (Cursor == "Service") {
                System.out.println("1");
                this.p1service = new JPanel(new GridLayout(4, 2));
                this.p2service = new JPanel(new BorderLayout());

                this.jl1 = new JLabel("Code : ");
                p1service.add(this.jl1);
                this.jtf1 = new JTextField(20);
                this.jtf1.addActionListener(this);
                p1service.add(this.jtf1);

                this.jl2 = new JLabel("Nom : ");
                p1service.add(this.jl2);
                this.jtf2 = new JTextField(20);
                this.jtf2.addActionListener(this);
                p1service.add(this.jtf2);

                this.jl3 = new JLabel("Id_batiment : ");
                p1service.add(this.jl3);
                this.jtf3 = new JTextField(20);
                this.jtf3.addActionListener(this);
                p1service.add(this.jtf3);

                this.jl4 = new JLabel("Directeur : ");
                p1service.add(this.jl4);
                this.jtf4 = new JTextField(20);
                p1service.add(this.jtf4);
                this.jtf4.addActionListener(this);

                jbvalide1 = new JButton("Valider Insertion");
                this.jbvalide1.addActionListener(this);

                p2service.add("Center", this.p1service);

                p2service.add("South", this.jbvalide1);

                affichagecentrale.add("Center", p2service);
                p2service.setVisible(true);
                princ.revalidate();
                /// princ.validate();
            }
        }

        if (e.getActionCommand().equals("Valider Insertion")) {
            DAO<Service> ServiceDAO = new ServiceDAO();
            ServiceDAO.set_connexion(maconnexion);
            ServiceDAO.create(new Service(
                    jtf1.getText(), jtf2.getText(), Integer.parseInt(jtf3.getText()), Integer.parseInt(jtf4.getText()))
            );
            p2service.setVisible(false);
            princservice.setVisible(false);
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
