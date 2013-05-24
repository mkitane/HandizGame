package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Initiation.modeInitiation1;


public class PanneauPrincipal extends JPanel {
	private PanneauLogo panel = new PanneauLogo();
	private JPanel panBienvenue = new JPanel();
	private JPanel panneauboutons = new JPanel();
	private JButton bouton1 =new JButton("Mode Initiation");
	private JButton bouton2 =new JButton("Mode Jeu");
	private JButton bouton3 =new JButton("Aide");
	private JButton bouton4 =new JButton("Credit");
	private JLabel bienvenue=new JLabel("Bienvenue au jeu ! Amusez vous bien =]", JLabel.CENTER);
	private JPanel panseparation=new JPanel ();
	
	
	public PanneauPrincipal(){
        jbInit();  
        
        

		bouton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new FrameLevel());
			}
		});
		
		bouton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new modeInitiation1());
			}
		});
		
	}

	private void jbInit() {
		
		this.setLayout(new BorderLayout());
		this.add(panel);
		
		
		panel.setBackground(Fenetre.GRIS);
		panBienvenue.setBackground(Color.gray);
		panel.setBackground(Fenetre.GRIS);
		
		
		panel.setLayout(new BorderLayout());
		panel.add(panneauboutons, BorderLayout.EAST);
		panel.add(panBienvenue, BorderLayout.NORTH);
		
		
		panBienvenue.setPreferredSize(new Dimension(50,60));
		panBienvenue.setLayout(new BorderLayout());
		panBienvenue.add(bienvenue, BorderLayout.CENTER);
		
		//panBienvenue.setOpaque(false);
		panseparation.setOpaque(false);
		//panneauboutons.setOpaque(false);
		
		panneauboutons.setLayout(new FlowLayout());
		panneauboutons.add(panseparation);
		panneauboutons.add(bouton1);
		panneauboutons.add(bouton2);
		panneauboutons.add(bouton3);	
		panneauboutons.add(bouton4);
		
		panneauboutons.setPreferredSize(new Dimension(150,600));
		panseparation.setPreferredSize(new Dimension(140,150));
		bouton1.setPreferredSize(new Dimension(130,50));
		bouton2.setPreferredSize(new Dimension(130,50));
		bouton3.setPreferredSize(new Dimension(100,40));
		bouton4.setPreferredSize(new Dimension(100,40));

		
		bienvenue.setForeground(Color.white);
		
	}

}
