package Initiation;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import Initiation.Mode;
import Initiation.ElementMode;

import oracle.jdeveloper.layout.VerticalFlowLayout;


public class FenetreMode1 extends JFrame {


    private BorderLayout borderLayout1 = new BorderLayout();
    private JButton jButton1 = new JButton();
    private JSplitPane jSplitPane1 = new JSplitPane();
    private JPanel jPanel1 = new JPanel();
    private JTextArea jTextArea1 = new JTextArea();
    private JButton Celebrite = new JButton();
    private JButton Surdite = new JButton();
    private JButton HandicapetEntreprise = new JButton();
    private VerticalFlowLayout verticalFlowLayout1 = new oracle.jdeveloper.layout.VerticalFlowLayout();

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
        Celebrite.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Celebrite_actionPerformed(e);
                }
            });
        Surdite.setText("Surdité");
        Surdite.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Surdite_actionPerformed(e);
                }
            });
        HandicapetEntreprise.setText("HandicapetEntreprise");
        HandicapetEntreprise.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    HandicapetEntreprise_actionPerformed(e);
                }
            });
        this.getContentPane().add(jButton1, BorderLayout.SOUTH);
        this.getContentPane().add(jSplitPane1, BorderLayout.WEST);
        jPanel1.add(Celebrite, null);
        jPanel1.add(HandicapetEntreprise, null);
        jPanel1.add(Surdite, null);
        jSplitPane1.add(jPanel1, JSplitPane.LEFT);
        jSplitPane1.add(jTextArea1, JSplitPane.RIGHT);
        jSplitPane1.setOneTouchExpandable(true);
        jPanel1.setLayout(verticalFlowLayout1);

    }

    private void Celebrite_actionPerformed(ActionEvent e) {
             jTextArea1.setText(Mode.choisit("celebrite"));
        
        
    }

    private void HandicapetEntreprise_actionPerformed(ActionEvent e) {
             jTextArea1.setText(Mode.choisit("Handicap et Entrprise"));
    }

    private void Surdite_actionPerformed(ActionEvent e) {
             jTextArea1.setText(Mode.choisit("Sudité"));
    }
}
