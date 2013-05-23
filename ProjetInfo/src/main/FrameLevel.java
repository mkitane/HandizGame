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
	private JLabel labelNiveau = new JLabel("Bienvenue dans l'univers HandizGame : Veuillez choisir l'environnement dans lequel vous souhaitez evoluer.",JLabel.CENTER);
	private JPanel panneauGauche = new JPanel();
	private JPanel panneauDroit = new JPanel();
	private JPanel panneauBas = new JPanel();
	private JButton boutonRetour = new JButton("Retour Accueil");

	
	private GridLayout gl = new GridLayout();
    private BoutonNiveau niveau1 = new BoutonNiveau("niveau1.png");
    private BoutonNiveau niveau2 = new BoutonNiveau("niveau2.png");
    private BoutonNiveau niveau3 = new BoutonNiveau("niveau3.png");
    private BoutonNiveau niveau4 = new BoutonNiveau("niveau4.png");

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
		setSize(Carte.COTE*25,Carte.COTE*15+73+40);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        this.getContentPane().add(labelNiveau, BorderLayout.NORTH);
        this.getContentPane().add(panneauNiveau, BorderLayout.CENTER); 
        
        //Personnalisqtion Panneaux pour le vide
        this.getContentPane().add(panneauBas, BorderLayout.SOUTH); 
        this.getContentPane().add(panneauDroit, BorderLayout.EAST); 
        this.getContentPane().add(panneauGauche, BorderLayout.WEST); 
        
        panneauBas.setPreferredSize(new Dimension(20,33));
        panneauDroit.setPreferredSize(new Dimension(20,20));
        panneauGauche.setPreferredSize(new Dimension(20,20));

        panneauBas.setOpaque(false);
        panneauDroit.setOpaque(false);
        panneauGauche.setOpaque(false);

        panneauBas.add(boutonRetour);
        
        panneauNiveau.setBackground(Fenetre.GRIS);
        getContentPane().setBackground(Fenetre.GRIS);		
        
        //modification label
        labelNiveau.setPreferredSize(new Dimension(800,30));
        labelNiveau.setForeground(Color.white);
        
     
        
        //modification layout panneau
        panneauNiveau.setLayout(gl); //
        gl.setColumns(2);
        gl.setRows(2);
        gl.setHgap(30);
        gl.setVgap(30);
        
        //ajout des boutons 
        panneauNiveau.add(niveau1);
        panneauNiveau.add(niveau2);
        panneauNiveau.add(niveau3);
        panneauNiveau.add(niveau4);

        //modifications boutons
        /*niveau1.setText("1");
        niveau2.setText("Niveau 2");
        niveau3.setText("Niveau 3");
        niveau4.setText("Niveau 4");*/
     
     
        niveau1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Carte.niveau="niveau1.txt";	
				dispose();
				new Fenetre();
			}
        });

        niveau2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Carte.niveau="niveau2.txt";		
				new Fenetre();
				dispose();
			}
        });

        niveau3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Carte.niveau="niveau3.txt";
				new Fenetre();
				dispose();
			}
        });

        niveau4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Carte.niveau="niveau4.txt";
				new Fenetre();
				dispose();
			}
        });

     
        
        setVisible(true);
    }


    
}
