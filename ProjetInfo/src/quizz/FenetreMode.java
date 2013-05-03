package Initiation;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class FenetreMode extends JFrame {


    private BorderLayout borderLayout1 = new BorderLayout();
    private JButton jButton1 = new JButton();
    private JSplitPane jSplitPane1 = new JSplitPane();
    private JPanel jPanel1 = new JPanel();
    private JTextArea jTextArea1 = new JTextArea();
    private JButton Celebrite = new JButton();
    private JButton Surdite = new JButton();
    private JButton HandicapetEntreprise = new JButton();

    public FenetreMode() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(642, 377));
        this.getContentPane().setLayout(borderLayout1);
        jButton1.setText("jButton1");
        Celebrite.setText("Célébrité");
        Surdite.setText("Surdité");
        HandicapetEntreprise.setText("HandicapetEntreprise");
        this.getContentPane().add(jButton1, BorderLayout.SOUTH);
        this.getContentPane().add(jSplitPane1, BorderLayout.WEST);
        jPanel1.add(Celebrite, null);
        jPanel1.add(HandicapetEntreprise, null);
        jPanel1.add(Surdite, null);
        jSplitPane1.add(jPanel1, JSplitPane.LEFT);
        jSplitPane1.add(jTextArea1, JSplitPane.RIGHT);
        jSplitPane1.setOneTouchExpandable(true);


    }
}
