package main;

import initiation.PanelInitiation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelPrincipal extends JPanel {
	private PanelLogo panel = new PanelLogo();
	private JPanel panneauboutons = new JPanel();
	private JButton bouton1 = new JButton("Mode Initiation");
	private JButton bouton2 = new JButton("Mode Jeu");
	private JButton bouton3 = new JButton("Aide");
	private JButton bouton4 = new JButton("Credits");
	private JPanel panseparation = new JPanel();

	public PanelPrincipal() {
		jbInit();

		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new PanelNiveau());
			}
		});

		bouton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new PanelInitiation());
			}
		});

		bouton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setPane((new PanelHelp()));
			}
		});

		bouton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setPane((new PanelCredit()));
			}
		});

	}

	private void jbInit() {

		this.setLayout(new BorderLayout());
		this.add(panel);

		panel.setBackground(Ressources.GRIS);
		panneauboutons.setOpaque(false);

		
		panel.setLayout(new BorderLayout());
		panel.add(panneauboutons, BorderLayout.EAST);


		// panBienvenue.setOpaque(false);
		panseparation.setOpaque(false);
		// panneauboutons.setOpaque(false);

		panneauboutons.setLayout(new FlowLayout());
		panneauboutons.add(panseparation);
		panneauboutons.add(bouton1);
		panneauboutons.add(bouton2);
		panneauboutons.add(bouton3);
		panneauboutons.add(bouton4);

		panneauboutons.setPreferredSize(new Dimension(150, 600));
		panseparation.setPreferredSize(new Dimension(140, 200));
		bouton1.setPreferredSize(new Dimension(130, 50));
		bouton2.setPreferredSize(new Dimension(130, 50));
		bouton3.setPreferredSize(new Dimension(100, 40));
		bouton4.setPreferredSize(new Dimension(100, 40));


	}

}
