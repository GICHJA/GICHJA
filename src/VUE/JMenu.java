/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author lucaromano
 */
public class JMenu extends JFrame{
    
    private JTextArea ja1;
    private JPanel p;
    //private JTabbedPane tabbedpane;
    
    public JMenu(){
        
        p = new JPanel (new FlowLayout());
        /*tabbedpane = new JTabbedPane();
        this.getContentPane().add("North", tabbedpane);
        this.tabbedpane.addTab("Menu", p);*/
        this.ja1 = new JTextArea("Bienvenue. Ce système permet une aide à la décision pour tout le personnel hospitalier. \n" +
        "Vous avez 3 possibilités. Vous pouvez dans un premier temps faire une recherche en cliquant sur l’onglet Recherche.\n" +
        "Dans un second temps, vous pouvez mettre à jour la base de donnée en modifiant, ajoutant ou supprimant des données. Pour cela cliquer sur l’onglet Mise à jour.\n" +
        "Enfin l’onglet génération permet de créer les tables à partir des informations données (requête sql).");
        p.add(this.ja1);
        
        this.setContentPane(p);
    }
    
}

