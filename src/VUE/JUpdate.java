/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import CONTROLEUR.BatimentDAO;
import CONTROLEUR.ChambreDAO;
import CONTROLEUR.DAO;
import CONTROLEUR.DocteurDAO;
import CONTROLEUR.HospitalisationDAO;
import CONTROLEUR.InfirmierDAO;
import CONTROLEUR.MaladeDAO;
import CONTROLEUR.RendezVousDAO;
import CONTROLEUR.ServiceDAO;
import MODELE.Chambre;
import MODELE.Docteur;
import MODELE.Hospitalisation;
import MODELE.Infirmier;
import MODELE.Malade;
import MODELE.RendezVous;
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
    private JPanel p1, p2, p3, princ, selection, affichagecentrale;
    //// SERVICE
    private JPanel p1service, p2service, p3service, princservice, insererservice;
    private JComboBox jcservice;
    private int selection_de_la_jcombox;
    private int[] selection_de_la_jcombox_mais_ceci_est_lid;
    private Object tabobjet[];
    private String Cursor;
    ////    CE QU il faut pour creer
    private JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7, jtf8, jtf9, jtf10, jtf11, jtf12, jtf13, jtf14, jtf15;
    private JLabel jl1, jl2, jl3, jl4, jl5,jl6,jl7,jl8;
    private JButton jbvalide1;

    public JUpdate() {

        princ = new JPanel(new BorderLayout());
        selection = new JPanel(new BorderLayout());
        affichagecentrale = new JPanel(new BorderLayout());
        p1 = new JPanel(new GridLayout(2, 3));
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
        this.jb7 = new JButton("Docteur");
        p1.add(this.jb7);
        this.jb7.addActionListener(this);
        this.jb8 = new JButton("Rendez-Vous");
        p1.add(this.jb8);
        this.jb8.addActionListener(this);
        selection.add("North", p1);
        princ.add("North", selection);

        princ.add("Center", affichagecentrale);

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
        princ.add("South", p3);

        jcservice = new JComboBox();
        princservice = new JPanel(new BorderLayout());
        this.p1service = new JPanel(new GridLayout(4, 2));
        this.p2service = new JPanel(new BorderLayout());

        this.setContentPane(princ);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Service")) {
            if (Cursor != "Service") {
                ///SERVICE
                princservice.setVisible(false);
                p2service.setVisible(false);
                jcservice.setVisible(false);
                jcservice.removeAllItems();
                princ.revalidate();
                Cursor = "Service";
                DAO<Service> ServiceDAO = new ServiceDAO();
                ServiceDAO.set_connexion(maconnexion);
                int elem[] = ServiceDAO.nbrelem();
                selection_de_la_jcombox_mais_ceci_est_lid = new int[elem.length];
                //jcservice.removeAllItems();
                jcservice = new JComboBox();
                this.tabobjet = new Service[elem.length];
                for (int i = 0; i < elem.length; i++) {
                    Service service = ServiceDAO.find(elem[i]);
                    jcservice.addItem(service.getstringService());
                    selection_de_la_jcombox_mais_ceci_est_lid[i] = service.getId_service();
                    this.tabobjet[i] = service;
                }
                jcservice.setActionCommand("jcservice");
                jcservice.addActionListener(this);
                princservice.add("North", jcservice);
                affichagecentrale.setVisible(true);
                princservice.setVisible(true);
                affichagecentrale.add("North", princservice);
                jcservice.revalidate();
                princ.revalidate();

            }
        }

        if (e.getActionCommand().equals("Infirmier")) {
            if (Cursor != "Infirmier") {
                ///Infirmier
                princservice.setVisible(false);
                p2service.setVisible(false);
                jcservice.setVisible(false);
                jcservice.removeAllItems();
                princ.revalidate();
                Cursor = "Infirmier";
                InfirmierDAO infirmierDAO = new InfirmierDAO();
                infirmierDAO.set_connexion(maconnexion);
                int elem[] = infirmierDAO.nbrelem();
                selection_de_la_jcombox_mais_ceci_est_lid = new int[elem.length];
                //jcservice.removeAllItems();
                jcservice = new JComboBox();
                this.tabobjet = new Infirmier[elem.length];
                for (int i = 0; i < elem.length; i++) {
                    Infirmier infirmier = infirmierDAO.find(elem[i]);
                    jcservice.addItem(infirmier.getstringService());
                    selection_de_la_jcombox_mais_ceci_est_lid[i] = infirmier.getId_employe();
                    this.tabobjet[i] = infirmier;
                }
                jcservice.setActionCommand("jcservice");
                jcservice.addActionListener(this);
                princservice.add("North", jcservice);
                affichagecentrale.setVisible(true);
                princservice.setVisible(true);
                affichagecentrale.add("North", princservice);
                jcservice.revalidate();
                princ.revalidate();

            }

        }

        if (e.getActionCommand().equals("Chambre")) {
            if (Cursor != "Chambre") {
                ///Infirmier
                princservice.setVisible(false);
                p2service.setVisible(false);
                jcservice.setVisible(false);
                jcservice.removeAllItems();
                princ.revalidate();
                Cursor = "Chambre";
                ChambreDAO elemDAO = new ChambreDAO();
                elemDAO.set_connexion(maconnexion);
                int elem[] = elemDAO.nbrelem();
                selection_de_la_jcombox_mais_ceci_est_lid = new int[elem.length];
                //jcservice.removeAllItems();
                jcservice = new JComboBox();
                this.tabobjet = new Chambre[elem.length];
                for (int i = 0; i < elem.length; i++) {
                    Chambre elemobj = elemDAO.find(elem[i]);
                    jcservice.addItem(elemobj.getstringService());
                    selection_de_la_jcombox_mais_ceci_est_lid[i] = elemobj.getId_chambre();
                    this.tabobjet[i] = elemobj;
                }
                jcservice.setActionCommand("jcservice");
                jcservice.addActionListener(this);
                princservice.add("North", jcservice);
                affichagecentrale.setVisible(true);
                princservice.setVisible(true);
                affichagecentrale.add("North", princservice);
                jcservice.revalidate();
                princ.revalidate();

            }

        }

        if (e.getActionCommand().equals("Malade")) {
            if (Cursor != "Malade") {
                ///Infirmier
                princservice.setVisible(false);
                p2service.setVisible(false);
                jcservice.setVisible(false);
                jcservice.removeAllItems();
                princ.revalidate();
                Cursor = "Malade";
                MaladeDAO elemDAO = new MaladeDAO();
                elemDAO.set_connexion(maconnexion);
                int elem[] = elemDAO.nbrelem();
                selection_de_la_jcombox_mais_ceci_est_lid = new int[elem.length];
                //jcservice.removeAllItems();
                jcservice = new JComboBox();
                this.tabobjet = new Malade[elem.length];
                for (int i = 0; i < elem.length; i++) {
                    Malade elemobj = elemDAO.find(elem[i]);
                    jcservice.addItem(elemobj.getstringService());
                    selection_de_la_jcombox_mais_ceci_est_lid[i] = elemobj.getId_malade();
                    this.tabobjet[i] = elemobj;
                }
                jcservice.setActionCommand("jcservice");
                jcservice.addActionListener(this);
                princservice.add("North", jcservice);
                affichagecentrale.setVisible(true);
                princservice.setVisible(true);
                affichagecentrale.add("North", princservice);
                jcservice.revalidate();
                princ.revalidate();

            }

        }

        if (e.getActionCommand().equals("Docteur")) {
            if (Cursor != "Docteur") {
                ///Infirmier
                princservice.setVisible(false);
                p2service.setVisible(false);
                jcservice.setVisible(false);
                jcservice.removeAllItems();
                princ.revalidate();
                Cursor = "Docteur";
                DocteurDAO elemDAO = new DocteurDAO();
                elemDAO.set_connexion(maconnexion);
                int elem[] = elemDAO.nbrelem();
                selection_de_la_jcombox_mais_ceci_est_lid = new int[elem.length];
                //jcservice.removeAllItems();
                jcservice = new JComboBox();
                this.tabobjet = new Docteur[elem.length];
                for (int i = 0; i < elem.length; i++) {
                    Docteur elemobj = elemDAO.find(elem[i]);
                    jcservice.addItem(elemobj.getstringService());
                    selection_de_la_jcombox_mais_ceci_est_lid[i] = elemobj.getId_employe();
                    this.tabobjet[i] = elemobj;
                }
                jcservice.setActionCommand("jcservice");
                jcservice.addActionListener(this);
                princservice.add("North", jcservice);
                affichagecentrale.setVisible(true);
                princservice.setVisible(true);
                affichagecentrale.add("North", princservice);
                jcservice.revalidate();
                princ.revalidate();

            }

        }

        if (e.getActionCommand().equals("Rendez-Vous")) {
            if (Cursor != "Rendez-Vous") {
                ///Infirmier
                princservice.setVisible(false);
                p2service.setVisible(false);
                jcservice.setVisible(false);
                jcservice.removeAllItems();
                princ.revalidate();
                Cursor = "Rendez-Vous";
                RendezVousDAO elemDAO = new RendezVousDAO();
                elemDAO.set_connexion(maconnexion);
                int elem[] = elemDAO.nbrelem();
                selection_de_la_jcombox_mais_ceci_est_lid = new int[elem.length];
                //jcservice.removeAllItems();
                jcservice = new JComboBox();
                this.tabobjet = new RendezVous[elem.length];
                for (int i = 0; i < elem.length; i++) {
                    RendezVous elemobj = elemDAO.find(elem[i]);
                    jcservice.addItem(elemobj.getstringService());
                    selection_de_la_jcombox_mais_ceci_est_lid[i] = elemobj.getNo_rdv();
                    this.tabobjet[i] = elemobj;
                }
                jcservice.setActionCommand("jcservice");
                jcservice.addActionListener(this);
                princservice.add("North", jcservice);
                affichagecentrale.setVisible(true);
                princservice.setVisible(true);
                affichagecentrale.add("North", princservice);
                jcservice.revalidate();
                princ.revalidate();

            }

        }

///////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (e.getActionCommand()
                .equals("jcservice")) {
            selection_de_la_jcombox = jcservice.getSelectedIndex();
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (e.getActionCommand().equals("Supprimer")) {

            if (Cursor == "Service") {
                ServiceDAO servicedao = new ServiceDAO();
                servicedao.set_connexion(maconnexion);
                if (selection_de_la_jcombox != 0) {
                    servicedao.deleteint(selection_de_la_jcombox_mais_ceci_est_lid[selection_de_la_jcombox]);
                }
                selection_de_la_jcombox = 0;
                princservice.setVisible(false);
                p2service.setVisible(false);
                princ.revalidate();
                Cursor = "";

            }

            if (Cursor == "Infirmier") {
                InfirmierDAO infirmierDAO = new InfirmierDAO();
                infirmierDAO.set_connexion(maconnexion);
                if (selection_de_la_jcombox != 0) {
                    infirmierDAO.deleteint(selection_de_la_jcombox_mais_ceci_est_lid[selection_de_la_jcombox]);
                }
                selection_de_la_jcombox = 0;
                princservice.setVisible(false);
                p2service.setVisible(false);
                princ.revalidate();
                Cursor = "";

            }

            if (Cursor == "Chambre") {
                ChambreDAO infirmierDAO = new ChambreDAO();
                infirmierDAO.set_connexion(maconnexion);
                if (selection_de_la_jcombox != 0) {
                    infirmierDAO.deleteint(selection_de_la_jcombox_mais_ceci_est_lid[selection_de_la_jcombox]);
                }
                selection_de_la_jcombox = 0;
                princservice.setVisible(false);
                p2service.setVisible(false);
                princ.revalidate();
                Cursor = "";

            }

            if (Cursor == "Malade") {
                MaladeDAO infirmierDAO = new MaladeDAO();
                infirmierDAO.set_connexion(maconnexion);
                if (selection_de_la_jcombox != 0) {
                    infirmierDAO.deleteint(selection_de_la_jcombox_mais_ceci_est_lid[selection_de_la_jcombox]);
                }
                selection_de_la_jcombox = 0;
                princservice.setVisible(false);
                p2service.setVisible(false);
                princ.revalidate();
                Cursor = "";

            }

            if (Cursor == "Docteur") {
                DocteurDAO infirmierDAO = new DocteurDAO();
                infirmierDAO.set_connexion(maconnexion);
                if (selection_de_la_jcombox != 0) {
                    infirmierDAO.deleteint(selection_de_la_jcombox_mais_ceci_est_lid[selection_de_la_jcombox]);
                }
                selection_de_la_jcombox = 0;
                princservice.setVisible(false);
                p2service.setVisible(false);
                princ.revalidate();
                Cursor = "";

            }

            if (Cursor == "Rendez-Vous") {
                RendezVousDAO infirmierDAO = new RendezVousDAO();
                infirmierDAO.set_connexion(maconnexion);
                if (selection_de_la_jcombox != 0) {
                    infirmierDAO.deleteint(selection_de_la_jcombox_mais_ceci_est_lid[selection_de_la_jcombox]);
                }
                selection_de_la_jcombox = 0;
                princservice.setVisible(false);
                p2service.setVisible(false);
                princ.revalidate();
                Cursor = "";

            }

        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (e.getActionCommand().equals("Mettre à jour")) {
            if (Cursor == "Service") {
                Cursor = "ServiceMAJ";
                p2service.setVisible(false);
                p1service.setVisible(false);
                this.p1service = new JPanel(new GridLayout(4, 2));
                this.p2service = new JPanel(new BorderLayout());
                p2service.setVisible(true);
                p1service.setVisible(true);
                Service service = (Service) tabobjet[selection_de_la_jcombox];

                this.jl1 = new JLabel("Code : ");
                p1service.add(this.jl1);
                this.jtf1 = new JTextField(3);
                this.jtf1.setText(service.getCode());
                this.jtf1.addActionListener(this);
                p1service.add(this.jtf1);

                this.jl2 = new JLabel("Nom : ");
                p1service.add(this.jl2);
                this.jtf2 = new JTextField(20);
                this.jtf2.setText(service.getNom());
                this.jtf2.addActionListener(this);
                p1service.add(this.jtf2);

                this.jl3 = new JLabel("Id_batiment : ");
                p1service.add(this.jl3);
                this.jtf3 = new JTextField(20);
                System.out.println(service.getId_batiment());
                this.jtf3.setText(Integer.toString(service.getId_batiment()));
                this.jtf3.addActionListener(this);
                p1service.add(this.jtf3);

                this.jl4 = new JLabel("Directeur : ");
                p1service.add(this.jl4);
                this.jtf4 = new JTextField(20);
                this.jtf4.setText(Integer.toString(service.getNo_directeur()));
                p1service.add(this.jtf4);
                this.jtf4.addActionListener(this);

                jbvalide1 = new JButton("Valider Insertion");
                this.jbvalide1.addActionListener(this);

                p2service.add("Center", this.p1service);

                p2service.add("South", this.jbvalide1);

                affichagecentrale.add("Center", p2service);
                p2service.setVisible(true);
                affichagecentrale.setVisible(true);

                princ.revalidate();
            }
            
              if (Cursor == "Infirmier") {
                Cursor = "InfirmierMAJ";
                p2service.setVisible(false);
                p1service.setVisible(false);
                this.p1service = new JPanel(new GridLayout(6, 2));
                this.p2service = new JPanel(new BorderLayout());
                p2service.setVisible(true);
                p1service.setVisible(true);
                Infirmier obj = (Infirmier) tabobjet[selection_de_la_jcombox];

                   this.jl1 = new JLabel("Nom : ");
                p1service.add(this.jl1);
                this.jtf1 = new JTextField(20);
                this.jtf1.setText(obj.getNom());
                this.jtf1.addActionListener(this);
                p1service.add(this.jtf1);

                this.jl2 = new JLabel("Prenom : ");
                p1service.add(this.jl2);
                this.jtf2 = new JTextField(20);
                this.jtf2.setText(obj.getPrenom());
                this.jtf2.addActionListener(this);
                p1service.add(this.jtf2);

                this.jl3 = new JLabel("Adresse : ");
                p1service.add(this.jl3);
                this.jtf3 = new JTextField(20);
                this.jtf3.setText(obj.getAdresse());
                this.jtf3.addActionListener(this);
                p1service.add(this.jtf3);

                this.jl4 = new JLabel("Tel : ");
                p1service.add(this.jl4);
                this.jtf4 = new JTextField(20);
                this.jtf4.setText(obj.getTel());
                p1service.add(this.jtf4);
                this.jtf4.addActionListener(this);

                this.jl5 = new JLabel("Rotation : ");
                p1service.add(this.jl5);
                this.jtf5 = new JTextField(20);
                this.jtf5.setText(obj.getRotation());
                p1service.add(this.jtf5);
                this.jtf5.addActionListener(this);
                
                this.jl6 = new JLabel("Salaire : ");
                p1service.add(this.jl6);
                this.jtf6 = new JTextField(20);
                this.jtf6.setText( Double.toString(obj.getSalaire()) );
                p1service.add(this.jtf6);
                this.jtf6.addActionListener(this);

                jbvalide1 = new JButton("Valider Insertion");
                this.jbvalide1.addActionListener(this);

                p2service.add("Center", this.p1service);

                p2service.add("South", this.jbvalide1);

                affichagecentrale.add("Center", p2service);
                p2service.setVisible(true);
                affichagecentrale.setVisible(true);

                princ.revalidate();
            }

        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (e.getActionCommand().equals("Insérer")) {
            if (Cursor == "Service") {
                p2service.setVisible(false);
                p1service.setVisible(false);
                this.p1service = new JPanel(new GridLayout(4, 2));
                this.p2service = new JPanel(new BorderLayout());
                p2service.setVisible(true);
                p1service.setVisible(true);

                this.jl1 = new JLabel("Code : ");
                p1service.add(this.jl1);
                this.jtf1 = new JTextField(3);
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
                affichagecentrale.setVisible(true);

                princ.revalidate();
            }

            if (Cursor == "Infirmier") {
                p2service.setVisible(false);
                p1service.setVisible(false);
                this.p1service = new JPanel(new GridLayout(6, 2));
                this.p2service = new JPanel(new BorderLayout());
                p2service.setVisible(true);
                p1service.setVisible(true);

                this.jl1 = new JLabel("Nom : ");
                p1service.add(this.jl1);
                this.jtf1 = new JTextField(3);
                this.jtf1.addActionListener(this);
                p1service.add(this.jtf1);

                this.jl2 = new JLabel("Prenom : ");
                p1service.add(this.jl2);
                this.jtf2 = new JTextField(20);
                this.jtf2.addActionListener(this);
                p1service.add(this.jtf2);

                this.jl3 = new JLabel("Adresse : ");
                p1service.add(this.jl3);
                this.jtf3 = new JTextField(20);
                this.jtf3.addActionListener(this);
                p1service.add(this.jtf3);

                this.jl4 = new JLabel("Tel : ");
                p1service.add(this.jl4);
                this.jtf4 = new JTextField(20);
                p1service.add(this.jtf4);
                this.jtf4.addActionListener(this);

                this.jl5 = new JLabel("Rotation : ");
                p1service.add(this.jl5);
                this.jtf5 = new JTextField(20);
                p1service.add(this.jtf5);
                this.jtf5.addActionListener(this);
                
                this.jl6 = new JLabel("Salaire : ");
                p1service.add(this.jl6);
                this.jtf6 = new JTextField(20);
                p1service.add(this.jtf6);
                this.jtf6.addActionListener(this);

                jbvalide1 = new JButton("Valider Insertion");
                this.jbvalide1.addActionListener(this);

                p2service.add("Center", this.p1service);

                p2service.add("South", this.jbvalide1);

                affichagecentrale.add("Center", p2service);
                p2service.setVisible(true);
                affichagecentrale.setVisible(true);

                princ.revalidate();
            }

        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (e.getActionCommand()
                .equals("Valider Insertion")) {

            if (Cursor == "Service") {
                DAO<Service> ServiceDAO = new ServiceDAO();
                ServiceDAO.set_connexion(maconnexion);
                ServiceDAO.create(new Service(
                        jtf1.getText(), jtf2.getText(), Integer.parseInt(jtf3.getText()), Integer.parseInt(jtf4.getText()))
                );
                Cursor = "";
                princservice.setVisible(false);
                p2service.setVisible(false);
                princ.revalidate();

            }
            if (Cursor == "ServiceMAJ") {
                Service service = (Service) tabobjet[selection_de_la_jcombox];

                service.setCode(jtf1.getText());
                service.setNom((jtf2.getText()));
                service.setId_batiment(Integer.parseInt(jtf3.getText()));
                service.setNo_directeur(Integer.parseInt(jtf4.getText()));

                DAO<Service> ServiceDAO = new ServiceDAO();
                ServiceDAO.set_connexion(maconnexion);
                ServiceDAO.update(service);
                Cursor = "";
                princservice.setVisible(false);
                p2service.setVisible(false);
                princ.revalidate();

            }

        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
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
