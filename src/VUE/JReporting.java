/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import static VUE.JControleur.maconnexion;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author lucaromano
 */
public class JReporting extends JFrame implements ActionListener, WindowListener {

    private JButton jb1, jb2, jb3, jb4, jb5;
    private JTextArea ja;
    private JPanel p1, p2, princ;
    private JTextArea jtf1, jtf2, jtf3, jtf4, jtf5;
    private JTable jt1;
    private Object[][] donnees;
    private String[] entetes;
    private JFreeChart chart;

    public JReporting() {

        princ = new JPanel(new BorderLayout());

        p1 = new JPanel(new GridLayout(5, 1));
        p2 = new JPanel(new BorderLayout());

        this.jb1 = new JButton("Moyenne des salaires des infirmiers par service");
        p1.add(this.jb1);
        this.jb1.addActionListener(this);
        this.jb2 = new JButton("Nombre de docteur par spécialité");
        p1.add(this.jb2);
        this.jb2.addActionListener(this);
        this.jb3 = new JButton("Le nombre de lits dans chaque Batiment");
        p1.add(this.jb3);
        this.jb3.addActionListener(this);

        princ.add("North", this.p1);
        jt1 = new JTable();

        /* this.ja = new JTextArea("Quand on clique sur une des statistiques au dessus, le graphique \ns’affichera directement dans cette fenêtre. Il y aura beaucoup plus\nde statistiques. "
         + "Nous en avons mis que deux pour expliquer comment\ncela fonctionnera. ");
         p2.add(this.ja);
         princ.add("South", this.p2);*/
        this.setContentPane(princ);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Moyenne des salaires des infirmiers par service")) {

            String sql = "SELECT COUNT(service.code) FROM service WHERE service.code in ( SELECT  infirmier.code_service FROM  infirmier );";
            String sql2 = "SELECT service.code ,AVG(infirmier.salaire)  FROM infirmier ,service Where service.code = infirmier.code_service GROUP BY service.code";
            try {
                ResultSet res = maconnexion.result(sql);
                p2.removeAll();
                if (res.first()) {
                    donnees = new Object[1][res.getInt(1)];
                    entetes = new String[res.getInt(1)];
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    res = maconnexion.result(sql2);
                    int i = 0;
                    if (res.first()) {
                        res.beforeFirst();
                        while (res.next()) {
                            dataset.setValue(res.getInt("AVG(infirmier.salaire)"), "", res.getString("code"));
                            entetes[i] = res.getString("code");
                            donnees[0][i] = res.getString("AVG(infirmier.salaire)");
                            //    System.out.println(donnees[0][i]);
                            i++;

                        }
                        jt1 = new JTable(donnees, entetes);
                        chart = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.VERTICAL, false, false, false);
                        ChartPanel chartpanel = new ChartPanel(chart);
                        chartpanel.setSize(500, 350);
                        //p2.add("Center", new JScrollPane(jt1));
                        p2.add("Center", new JScrollPane(chartpanel));
                        princ.add("Center", this.p2);
                        p2.setVisible(true);
                        princ.revalidate();

                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(JReporting.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getActionCommand().equals("Nombre de docteur par spécialité")) {

            String sql2 = "SELECT docteur.specialite, COUNT(docteur.specialite) FROM docteur GROUP by specialite";
            try {
                ResultSet res = maconnexion.result(sql2);
                p2.removeAll();
                if (res.first()) {
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    if (res.first()) {
                        res.beforeFirst();
                        while (res.next()) {
                            dataset.setValue(res.getInt("COUNT(docteur.specialite)"), "", res.getString("specialite"));
                        }
                        chart = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.VERTICAL, false, false, false);
                        ChartPanel chartpanel = new ChartPanel(chart);
                        chartpanel.setSize(500, 350);
                        //p2.add("Center", new JScrollPane(jt1));
                        p2.add("Center", new JScrollPane(chartpanel));
                        princ.add("Center", this.p2);
                        p2.setVisible(true);
                        princ.revalidate();

                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(JReporting.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (e.getActionCommand().equals("Le nombre de lits dans chaque Batiment")) {

            String sql2 = "SELECT batiment.nom_batiment , SUM(chambre.nb_lits) FROM batiment,service, chambre WHERE Batiment.id_batiment = Service.id_batiment and Service.code = chambre.code_service GROUP by Batiment.nom_batiment";
            try {
                ResultSet res = maconnexion.result(sql2);
                p2.removeAll();
                if (res.first()) {
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    if (res.first()) {
                        res.beforeFirst();
                        while (res.next()) {
                            dataset.setValue(res.getInt("SUM(chambre.nb_lits)"), "", res.getString("batiment.nom_batiment"));
                        }
                        chart = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.VERTICAL, false, false, false);
                        ChartPanel chartpanel = new ChartPanel(chart);
                        chartpanel.setSize(500, 350);
                        //p2.add("Center", new JScrollPane(jt1));
                        p2.add("Center", new JScrollPane(chartpanel));
                        princ.add("Center", this.p2);
                        p2.setVisible(true);
                        princ.revalidate();

                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(JReporting.class.getName()).log(Level.SEVERE, null, ex);
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
