/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VUE;

import java.awt.*;
import static java.awt.BorderLayout.CENTER;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 *
 * @author lucaromano
 */
public class JMenu extends JFrame {

    private JTextArea ja1;
    private JPanel p;
    //private JTabbedPane tabbedpane;

    /**
     *
     */
    public JMenu()  {

        p = new JPanel(new BorderLayout());
        /*tabbedpane = new JTabbFlowLayoutedPane();
         this.getContentPane().add("North", tabbedpane);
         this.tabbedpane.addTab("Menu", p);*/
        String s1 = "Bienvenue.\nCe système permet une aide \n"
                + "à la décision pour tout le personnel hospitalier. \n\n"
                + "Vous avez 3 possibilités. \n\n"
                + "Vous pouvez dans un premier temps \n"
                + "faire une recherche en cliquant sur l’onglet Recherche.\n\n"
                + "Dans un second temps, "
                + "\nvous pouvez mettre à jour la base de donnée en modifiant,"
                + "\n ajoutant ou supprimant des données. "
                + "\nPour cela cliquer sur l’onglet Mise à jour.\n\n"
                + "Enfin l’onglet génération permet de créer "
                + "\nles tables à partir des informations données (requête sql).";
        this.ja1 = new JTextArea(s1);
       // Style defaut = ja1.getStyle("default");
        //StyledDocument sDoc = (StyledDocument) ja1.getDocument();
        // sDoc.insertString(0, s1, defaut);;
        JLabel image = new JLabel(new ImageIcon("image/fondhmin.jpg"));
        ja1.setOpaque(false);
        ja1.setBackground(new Color(0, 0, 0, 0));
        ja1.setOpaque(false);
       // ja1.setContentAreaFilled(false);
        // ja1.setBorderPainted(false);
        //   ja1.getViewport().setOpaque(false);

        p.add(image, BorderLayout.CENTER);

       // p.add("South", this.ja1);
        p.setOpaque(false);
        this.setContentPane(p);
    }

}
