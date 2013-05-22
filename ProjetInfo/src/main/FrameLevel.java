package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

import java.awt.GridLayout;





public class FrameLevel extends JFrame {
	private BorderLayout bl = new BorderLayout();
	private JPanel panneauNiveau = new JPanel();    
	private JLabel labelNiveau = new JLabel();
	private GridLayout gl = new GridLayout();
    private BoutonNiveau niveau1 = new BoutonNiveau("Mur.png");
    private BoutonNiveau niveau2 = new BoutonNiveau("Mur.png");
    private BoutonNiveau niveau3 = new BoutonNiveau("Mur.png");
    private BoutonNiveau niveau4 = new BoutonNiveau("Mur.png");

    public FrameLevel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        
    	this.getContentPane().setLayout(bl);
        this.setTitle("Choix du Niveau");
        this.setSize(new Dimension(761, 397));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(labelNiveau, BorderLayout.NORTH);
        this.getContentPane().add(panneauNiveau, BorderLayout.CENTER); 
        panneauNiveau.setBackground(Color.CYAN);
        getContentPane().setBackground(Color.CYAN);		
        
        //modification label
        labelNiveau.setText("Bienvenue dans l'univers HandizGame : Veuillez choisir l'environnement dans lequel vous souhaitez évoluer.");
        
     
        
        //modification layout panneau
        panneauNiveau.setLayout(gl); //
        gl.setColumns(2);
        gl.setRows(2);
        gl.setHgap(35);
        gl.setVgap(35);
        
        //ajout des boutons 
        panneauNiveau.add(niveau1);
        panneauNiveau.add(niveau2);
        panneauNiveau.add(niveau3);
        panneauNiveau.add(niveau4);

        //modifications boutons
        niveau1.setText("1");
        niveau2.setText("Niveau 2");
        niveau3.setText("Niveau 3");
        niveau4.setText("Niveau 4");
     
     
     
        //ajout d'une image de fond pour les boutons

     
        
        setVisible(true);
    }

    private void niv1_actionPerformed(ActionEvent e) {
        //Carte.niveau="niveau1.txt";
    }

    private void niv2_actionPerformed(ActionEvent e) {
        //Carte.niveau="niveau2.txt";
    }

    private void niv3_actionPerformed(ActionEvent e) {
        //Carte.niveau="niveau3.txt";
    }
}
