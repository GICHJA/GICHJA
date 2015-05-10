/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import CONTROLEUR.BatimentDAO;
import CONTROLEUR.DAO;
import CONTROLEUR.DocteurDAO;
import CONTROLEUR.EmployeDAO;
import CONTROLEUR.HospitalisationDAO;
import CONTROLEUR.MaladeDAO;
import CONTROLEUR.ServiceDAO;
import MODELE.Batiment;
import MODELE.Docteur;
import MODELE.Employe;
import MODELE.Malade;
import MODELE.Service;
import MODELE.Hospitalisation;
import static VUE.JControleur.maconnexion;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author lucaromano
 */
public class JRecherche extends JFrame implements ActionListener, WindowListener{
    
    private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jbvalide1;
    private JTextField jt, jtf1, jtf2, jtf3, jtf4;
    private JLabel jl, jl1, jl2, jl3, jl4;
    private JTextArea ja;
    private JPanel p1service, p2service, p1, p2, p3, p4, princ, selection;
    private Object jconnexion;
    private JTable table;
    private Object[][] data;
    private String []columnNames;
    private JScrollPane scrollpane;
    private String Cursor;
    
    
    public JRecherche(){
        
        selection = new JPanel (new BorderLayout());
        princ = new JPanel (new BorderLayout());
        p1 = new JPanel (new GridLayout (2,4));
        p2 = new JPanel (new FlowLayout ());
        p3 = new JPanel (new FlowLayout ());
        p4 = new JPanel (new FlowLayout ());
        
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
        this.jb7 = new JButton ("Docteur");
        p1.add(this.jb7);
        this.jb7.addActionListener(this);
        this.jb8 = new JButton ("Soigné");
        p1.add(this.jb8);
        this.jb8.addActionListener(this);
        this.jb9 = new JButton ("Batiment");
        p1.add(this.jb9);
        this.jb9.addActionListener(this);
        princ.add("North", p1);
                
        selection.add("North", princ);
        this.setContentPane(selection);
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
        
        if (e.getActionCommand().equals("Service")){
            Cursor = "Service";
            
            this.p1service = new JPanel(new GridLayout(4, 2));
            this.p2service = new JPanel(new FlowLayout());

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
                
            jbvalide1 = new JButton("Rechercher");
            this.jbvalide1.addActionListener(this);
            p2service.add(this.jbvalide1);
                
            selection.add("Center", p1service);
            selection.add("South", p2service);
            selection.revalidate();
        }
        if (e.getActionCommand().equals("Hospitalisation")){
           Cursor = "Hospitalisation";
            
            this.p1service = new JPanel(new GridLayout(4, 2));
            this.p2service = new JPanel(new FlowLayout());

            this.jl1 = new JLabel("Numéro du malade : ");
            p1service.add(this.jl1);
            this.jtf1 = new JTextField(20);
            this.jtf1.addActionListener(this);
            p1service.add(this.jtf1);

            this.jl2 = new JLabel("Code du service : ");
            p1service.add(this.jl2);
            this.jtf2 = new JTextField(20);
            this.jtf2.addActionListener(this);
            p1service.add(this.jtf2);

            this.jl3 = new JLabel("Numero de chambre : ");
            p1service.add(this.jl3);
            this.jtf3 = new JTextField(20);
            this.jtf3.addActionListener(this);
            p1service.add(this.jtf3);

            this.jl4 = new JLabel("Nombre de lit : ");
            p1service.add(this.jl4);
            this.jtf4 = new JTextField(20);
            p1service.add(this.jtf4);
            this.jtf4.addActionListener(this);
                
            jbvalide1 = new JButton("Rechercher");
            this.jbvalide1.addActionListener(this);
            p2service.add(this.jbvalide1);
                
            selection.add("Center", p1service);
            selection.add("South", p2service);
            selection.revalidate();
        }
        
        
        if (e.getActionCommand().equals("Rechercher")){   
            if (Cursor == "Service"){
                String requete = " ";
                ServiceDAO servicedao= new ServiceDAO();
                servicedao.set_connexion(maconnexion);
                
                if ((jtf1.getText().length() == 0) & (jtf2.getText().length()== 0) & (jtf3.getText().length()== 0) & (jtf4.getText().length()== 0)){
                    DAO<Service> ServiceDAO = new ServiceDAO();
                    ServiceDAO.set_connexion(maconnexion);
                    int elem[] = ServiceDAO.nbrelem();
                    //String[] listemploye = new String[elem.length];
                    columnNames = new String[4];
                    columnNames[0] = "Code";
                    columnNames[1] = "Nom";
                    columnNames[2] = "id_batiment";
                    columnNames[3] = "directeur";
            
                    data = new Object[elem.length][4];
                    int j = 0;
            
                    for (int i = 0; i < elem.length; i++) {
                        Service service = ServiceDAO.find(elem[i]);
               
                        data[j][0] = service.getCode();
                        data[j][1] = service.getNom();
                        data[j][2] = service.getId_batiment();
                        data[j][3] = service.getDirecteur().getNom();
                        j++;
               
                    }
                    table = new JTable(data, columnNames);
                    JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
                }
                else{
                    if (jtf1.getText().length()!=0){
                        requete+= "code = \"" + jtf1.getText() + "\" " ;
                    }
                    if (jtf2.getText().length()!=0){
                        requete+= "AND nom = \"" + jtf2.getText() + "\" ";
                    }
                    if (jtf3.getText().length()!=0){
                        requete+= "AND id_batiment = " + jtf3.getText() + " ";
                    }
                    if (jtf4.getText().length()!=0){
                        requete+= "AND directeur = " + jtf4.getText() + " ";
                    }   
                    Service listservicerecherche = servicedao.find(requete);
                    columnNames = new String[3];
                    columnNames[0] = "Nom";
                    columnNames[1] = "Code";
                    columnNames[2] = "Directeur";
                    data = new Object[2][3];
                    if(listservicerecherche!=null)
                    {
                        data[0][0] = listservicerecherche.getNom();
                        data[0][1] = listservicerecherche.getCode();
                        data[0][2] = listservicerecherche.getDirecteur().getNom();
                    }
                
                }
                table = new JTable(data, columnNames);
                JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
            }
            if (Cursor == "Hospitalisation"){
                String requete = " ";
                HospitalisationDAO hospitalisationdao= new HospitalisationDAO();
                hospitalisationdao.set_connexion(maconnexion);
                
                if ((jtf1.getText().length() == 0) & (jtf2.getText().length()== 0) & (jtf3.getText().length()== 0) & (jtf4.getText().length()== 0)){
                    DAO<Service> ServiceDAO = new ServiceDAO();
                    ServiceDAO.set_connexion(maconnexion);
                    int elem[] = ServiceDAO.nbrelem();
                    columnNames = new String[4];
                    columnNames[0] = "Num_malade";
                    columnNames[1] = "Code_service";
                    columnNames[2] = "Num_chambre";
                    columnNames[3] = "Nb_lit";
            
                    data = new Object[elem.length][4];
                    int j = 0;
            
                    for (int i = 0; i < elem.length; i++) {
                        Hospitalisation hospitalisation = HospitalisationDAO.find(elem[i]);
               
                        data[j][0] = hospitalisation.getNo_malade();
                        data[j][1] = hospitalisation.getCode_service();
                        data[j][2] = hospitalisation.getNo_chambre();
                        data[j][3] = hospitalisation.getLit();
                        j++;
               
                    }
                    table = new JTable(data, columnNames);
                    JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
                }
                else{
                    if (jtf1.getText().length()!=0){
                        requete+= "no_malade = " + jtf1.getText() + " " ;
                    }
                    if (jtf2.getText().length()!=0){
                        requete+= "AND code_service = \"" + jtf2.getText() + "\" ";
                    }
                    if (jtf3.getText().length()!=0){
                        requete+= "AND no_chambre = " + jtf3.getText() + " ";
                    }
                    if (jtf4.getText().length()!=0){
                        requete+= "AND lit = " + jtf4.getText() + " ";
                    }   
                    Hospitalisation listhospitalisationrecherche = hospitalisationdao.find(requete);
                    columnNames = new String[4];
                    columnNames[0] = "Numero du malade";
                    columnNames[1] = "Code du service"; 
                    columnNames[2] = "Numero de la chambre";
                    columnNames[3] = "Nombre de lits";
                    data = new Object[2][4];
                    if(listhospitalisationrecherche!=null)
                    {
                        data[0][0] = listhospitalisationrecherche.getNo_malade();
                        data[0][1] = listhospitalisationrecherche.getCode_service();
                        data[0][2] = listhospitalisationrecherche.getNo_chambre();
                        data[0][3] = listhospitalisationrecherche.getLit();
                    }
                
                }
                table = new JTable(data, columnNames);
                JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
            }
                    
         }
                  
        if (e.getActionCommand().equals("Employé")){
            
            DAO<Employe> EmployeDAO = new EmployeDAO();
            EmployeDAO.set_connexion(maconnexion);
            int elem[] = EmployeDAO.nbrelem();
            //String[] listemploye = new String[elem.length];
            columnNames = new String[4];
            columnNames[0] = "Nom";
            columnNames[1] = "Prénom";
            columnNames[2] = "Adresse";
            columnNames[3] = "Téléphone";
            
            data = new Object[elem.length][4];
            int j = 0;
            
            for (int i = 0; i < elem.length; i++) {
                Employe employer = EmployeDAO.find(elem[i]);
               
               data[j][0] = employer.getNom();
               data[j][1] = employer.getPrenom();
               data[j][2] = employer.getAdresse();
               data[j][3] = employer.getTel();
               j++;
               
            }
            table = new JTable(data, columnNames);
            JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
        }
        if (e.getActionCommand().equals("Malade")){
            
            DAO<Malade> MaladeDAO = new MaladeDAO();
            MaladeDAO.set_connexion(maconnexion);
            int elem[] = MaladeDAO.nbrelem();
            String[] listmalade = new String[elem.length];
            columnNames = new String[5];
            columnNames[0] = "Numéro";
            columnNames[1] = "Nom";
            columnNames[2] = "Prénom";
            columnNames[3] = "Adresse";
            columnNames[4] = "Téléphone";
            
            data = new Object[elem.length][5];
            int j = 0;
            
            for (int i = 0; i < elem.length; i++) {
                Malade malade = MaladeDAO.find(elem[i]);
               
               data[j][0] = malade.getId_malade();
               data[j][1] = malade.getNom();
               data[j][2] = malade.getPrenom();
               data[j][3] = malade.getAdresse();
               data[j][4] = malade.getTel();
               j++;
               
            }
            table = new JTable(data, columnNames);
            JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
        }
        if (e.getActionCommand().equals("Docteur")){
            
            DAO<Docteur> DocteurDAO = new DocteurDAO();
            DocteurDAO.set_connexion(maconnexion);
            int elem[] = DocteurDAO.nbrelem();
            String[] listdocteur = new String[elem.length];
            columnNames = new String[3];
            columnNames[0] = "Nom";
            columnNames[1] = "Prénom";
            columnNames[2] = "Spécialité";
            
            data = new Object[elem.length][3];
            int j = 0;
            
            for (int i = 0; i < elem.length; i++) {
                Docteur docteur = DocteurDAO.find(elem[i]);
               
                data[j][0] = docteur.getNom();
                data[j][1] = docteur.getPrenom();
                data[j][2] = docteur.getSpecialite();
                j++;
               
            }
            table = new JTable(data, columnNames);
            JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
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

