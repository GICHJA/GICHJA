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
import CONTROLEUR.InfirmierDAO;
import CONTROLEUR.MaladeDAO;
import CONTROLEUR.ServiceDAO;
import CONTROLEUR.SoigneDAO;
import MODELE.Batiment;
import MODELE.Docteur;
import MODELE.Employe;
import MODELE.Malade;
import MODELE.Service;
import MODELE.Hospitalisation;
import MODELE.Infirmier;
import MODELE.Soigne;
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
    private JTextField jt, jtf1, jtf2, jtf3, jtf4, jtf5;
    private JLabel jl, jl1, jl2, jl3, jl4, jl5;
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
        p1 = new JPanel (new GridLayout (2,3));
        p2 = new JPanel (new FlowLayout ());
        p3 = new JPanel (new FlowLayout ());
        p4 = new JPanel (new FlowLayout ());
        
        this.jb1 = new JButton ("Service");
        p1.add(this.jb1);
        this.jb1.addActionListener(this);
        this.jb2 = new JButton ("Infirmier");
        p1.add(this.jb2);
        this.jb2.addActionListener(this);
        this.jb4 = new JButton ("Malade");
        p1.add(this.jb4);
        this.jb4.addActionListener(this);
        this.jb7 = new JButton ("Docteur");
        p1.add(this.jb7);
        this.jb7.addActionListener(this);
        princ.add("North", p1);
                
        selection.add("North", princ);
        this.setContentPane(selection);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {   
        if (e.getActionCommand().equals("Service")){
            Cursor = "Service";
                this.p1service = new JPanel(new GridLayout(5, 2));
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
        
        if (e.getActionCommand().equals("Infirmier")){
            Cursor = "Infirmier";
                this.p1service = new JPanel(new GridLayout(5, 2));
                this.p2service = new JPanel(new FlowLayout());

                this.jl1 = new JLabel("Numero : ");
                p1service.add(this.jl1);
                this.jtf1 = new JTextField(20);
                this.jtf1.addActionListener(this);
                p1service.add(this.jtf1);

                this.jl2 = new JLabel("Code du service : ");
                p1service.add(this.jl2);
                this.jtf2 = new JTextField(20);
                this.jtf2.addActionListener(this);
                p1service.add(this.jtf2);

                this.jl3 = new JLabel("Rotation : ");
                p1service.add(this.jl3);
                this.jtf3 = new JTextField(20);
                this.jtf3.addActionListener(this);
                p1service.add(this.jtf3);

                this.jl4 = new JLabel("Salaire : ");
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
        
        if (e.getActionCommand().equals("Malade")){
            Cursor = "Malade";
                this.p1service = new JPanel(new GridLayout(5, 2));
                this.p2service = new JPanel(new FlowLayout());

                this.jl1 = new JLabel("Numero : ");
                p1service.add(this.jl1);
                this.jtf1 = new JTextField(20);
                this.jtf1.addActionListener(this);
                p1service.add(this.jtf1);

                this.jl2 = new JLabel("Nom : ");
                p1service.add(this.jl2);
                this.jtf2 = new JTextField(20);
                this.jtf2.addActionListener(this);
                p1service.add(this.jtf2);

                this.jl3 = new JLabel("Prénom : ");
                p1service.add(this.jl3);
                this.jtf3 = new JTextField(20);
                this.jtf3.addActionListener(this);
                p1service.add(this.jtf3);

                this.jl4 = new JLabel("Adresse : ");
                p1service.add(this.jl4);
                this.jtf4 = new JTextField(20);
                p1service.add(this.jtf4);
                this.jtf4.addActionListener(this);
            
                this.jl5 = new JLabel("Téléphone : ");
                p1service.add(this.jl5);
                this.jtf5 = new JTextField(20);
                p1service.add(this.jtf5);
                this.jtf5.addActionListener(this);
                
                jbvalide1 = new JButton("Rechercher");
                this.jbvalide1.addActionListener(this);
                p2service.add(this.jbvalide1);
                
                selection.add("Center", p1service);
                selection.add("South", p2service);
                selection.revalidate();
        }
                
        if (e.getActionCommand().equals("Docteur")){
            Cursor = "Docteur";
            
                this.p1service = new JPanel(new GridLayout(5, 2));
                this.p2service = new JPanel(new FlowLayout());

                this.jl1 = new JLabel("Numero : ");
                p1service.add(this.jl1);
                this.jtf1 = new JTextField(20);
                this.jtf1.addActionListener(this);
                p1service.add(this.jtf1);

                this.jl2 = new JLabel("Spécialité : ");
                p1service.add(this.jl2);
                this.jtf2 = new JTextField(20);
                this.jtf2.addActionListener(this);
                p1service.add(this.jtf2);
                
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
                    if(listservicerecherche!=null){
                        data[0][0] = listservicerecherche.getNom();
                        data[0][1] = listservicerecherche.getCode();
                        data[0][2] = listservicerecherche.getDirecteur().getNom();
                    }
                
                }
                table = new JTable(data, columnNames);
                JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
            }
            
            if (Cursor == "Docteur"){
                String requete = " ";
                DocteurDAO docteurdao= new DocteurDAO();
                docteurdao.set_connexion(maconnexion);
                
                if ((jtf1.getText().length() == 0) & (jtf2.getText().length()== 0)){
                    DAO<Docteur> DocteurDAO = new DocteurDAO();
                    DocteurDAO.set_connexion(maconnexion);
                    int elem[] = DocteurDAO.nbrelem();
                    //String[] listemploye = new String[elem.length];
                    columnNames = new String[4];
                    columnNames[0] = "Numéro";
                    columnNames[1] = "Nom";
                    columnNames[2] = "Prénom";
                    columnNames[3] = "Spécialité";
            
                    data = new Object[elem.length][4];
                    int j = 0;
            
                    for (int i = 0; i < elem.length; i++) {
                        Docteur docteur = DocteurDAO.find(elem[i]);
               
                        data[j][0] = docteur.getNumero();
                        data[j][1] = docteur.getNom();
                        data[j][2] = docteur.getPrenom();
                        data[j][3] = docteur.getSpecialite();
                        j++;
               
                    }
                    table = new JTable(data, columnNames);
                    JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
                }
                else{
                    if (jtf1.getText().length()!=0){
                        requete+= "numero = " + jtf1.getText() + " " ;
                    }
                    if (jtf2.getText().length()!=0){
                        requete+= "AND specialite = \"" + jtf2.getText() + "\" ";
                    }
                    Docteur listdocteurrecherche = docteurdao.find(requete);
                    columnNames = new String[4];
                    columnNames[0] = "Numero";
                    columnNames[1] = "Nom";
                    columnNames[2] = "Prénom";
                    columnNames[3] = "Spécialité";
                    data = new Object[2][4];
                    if(listdocteurrecherche!=null)
                    {
                        data[0][0] = listdocteurrecherche.getNumero();
                        data[0][1] = listdocteurrecherche.getNom();
                        data[0][2] = listdocteurrecherche.getPrenom();
                        data[0][3] = listdocteurrecherche.getSpecialite();
                    }
                
                }
                table = new JTable(data, columnNames);
                JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
            }
            
            if (Cursor == "Malade"){
                String requete = " ";
                MaladeDAO maladedao= new MaladeDAO();
                maladedao.set_connexion(maconnexion);
                
                if ((jtf1.getText().length() == 0) & (jtf2.getText().length()== 0) & (jtf3.getText().length()== 0) & (jtf4.getText().length()== 0) & (jtf5.getText().length()== 0)){
                    DAO<Malade> MaladeDAO = new MaladeDAO();
                    MaladeDAO.set_connexion(maconnexion);
                    int elem[] = MaladeDAO.nbrelem();
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
                else{
                    if (jtf1.getText().length()!=0){
                        requete+= "numero = " + jtf1.getText() + " " ;
                    }
                    if (jtf2.getText().length()!=0){
                        requete+= "AND nom = \"" + jtf2.getText() + "\" ";
                    }
                    if (jtf3.getText().length()!=0){
                        requete+= "AND prenom = \"" + jtf1.getText() + "\" " ;
                    }
                    if (jtf4.getText().length()!=0){
                        requete+= "ANd adresse = \"" + jtf1.getText() + "\" " ;
                    }
                    if (jtf5.getText().length()!=0){
                        requete+= "AND tel = \"" + jtf1.getText() + "\" " ;
                    }
                    Malade listmaladerecherche = maladedao.find(requete);
                    columnNames = new String[5];
                    columnNames[0] = "Numero";
                    columnNames[1] = "Nom";
                    columnNames[2] = "Prénom";
                    columnNames[3] = "Adresse";
                    columnNames[4] = "Téléphone";
                    data = new Object[2][5];
                    if(listmaladerecherche!=null)
                    {
                        data[0][0] = listmaladerecherche.getId_malade();
                        data[0][1] = listmaladerecherche.getNom();
                        data[0][2] = listmaladerecherche.getPrenom();
                        data[0][3] = listmaladerecherche.getAdresse();
                        data[0][4] = listmaladerecherche.getTel();
                    }
                
                }
                table = new JTable(data, columnNames);
                JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
            }
            
            if (Cursor == "Infirmier"){
                String requete = " ";
                InfirmierDAO infirmierdao= new InfirmierDAO();
                infirmierdao.set_connexion(maconnexion);
                
                if ((jtf1.getText().length() == 0) & (jtf2.getText().length()== 0) & (jtf3.getText().length()== 0) & (jtf4.getText().length()== 0)){
                    DAO<Infirmier> InfirmierDAO = new InfirmierDAO();
                    InfirmierDAO.set_connexion(maconnexion);
                    int elem[] = InfirmierDAO.nbrelem();
                    columnNames = new String[4];
                    columnNames[0] = "Nom";
                    columnNames[1] = "Prenom";
                    columnNames[2] = "Rotation";
                    columnNames[3] = "Salaire";
            
                    data = new Object[elem.length][4];
                    int j = 0;
            
                    for (int i = 0; i < elem.length; i++) {
                        Infirmier infirmier = InfirmierDAO.find(elem[i]);
               
                        data[j][0] = infirmier.getNom();
                        data[j][1] = infirmier.getPrenom();
                        data[j][2] = infirmier.getRotation();
                        data[j][3] = infirmier.getSalaire();
                        j++;
               
                    }
                    table = new JTable(data, columnNames);
                    JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
                }
                else{
                    if (jtf1.getText().length()!=0){
                        requete+= "numero = " + jtf1.getText() + " " ;
                    }
                    if (jtf2.getText().length()!=0){
                        requete+= "AND code_service = \"" + jtf2.getText() + "\" ";
                    }
                    if (jtf3.getText().length()!=0){
                        requete+= "AND rotation = \"" + jtf1.getText() + "\" " ;
                    }
                    if (jtf4.getText().length()!=0){
                        requete+= "ANd salaire = " + jtf1.getText() + " " ;
                    }
                    Infirmier listinfirmierrecherche = infirmierdao.find(requete);
                    columnNames = new String[4];
                    columnNames[0] = "Nom";
                    columnNames[1] = "Prénom";
                    columnNames[2] = "Rotation";
                    columnNames[3] = "Salaire";
                    data = new Object[2][4];
                    if(listinfirmierrecherche!=null)
                    {
                        data[0][0] = listinfirmierrecherche.getNom();
                        data[0][1] = listinfirmierrecherche.getPrenom();
                        data[0][2] = listinfirmierrecherche.getRotation();
                        data[0][3] = listinfirmierrecherche.getSalaire();
                    }
                
                }
                table = new JTable(data, columnNames);
                JOptionPane.showMessageDialog(null,new JScrollPane(new JTable(data, columnNames)));
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

