package main;

import initiation.PanelInitiation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panneau pricipal permet de selectionner les differents lodes du jeu
 */
public class PanelPrincipal extends JPanel {
	private PanelLogo panel = new PanelLogo();
	private JPanel panneauboutons = new JPanel();
	private JButton btnInitiation = new JButton("Mode Initiation");
	private JButton btnJeu = new JButton("Mode Jeu");
	private JButton btnAide = new JButton("Aide");
	private JButton bntCredits = new JButton("Credits");
	private JPanel panseparation = new JPanel();

	/**
	 * Constructeur du Panneau principal. Contient les declencheur des
	 * evenements permettant de lancer les modes initiation ,jeu, aide et credit
	 */
	public PanelPrincipal() {
		jbInit();

		btnJeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new PanelNiveau());
			}
		});

		btnInitiation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new PanelInitiation());
			}
		});

		btnAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setPane((new PanelHelp()));
			}
		});

		bntCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setPane((new PanelCredit()));
			}
		});

	}

	/**
	 * Partie graphique organisant les elements du Panneau
	 */
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
		panneauboutons.add(btnInitiation);
		panneauboutons.add(btnJeu);
		panneauboutons.add(btnAide);
		panneauboutons.add(bntCredits);

		panneauboutons.setPreferredSize(new Dimension(150, 600));
		panseparation.setPreferredSize(new Dimension(140, 200));
		btnInitiation.setPreferredSize(new Dimension(130, 50));
		btnJeu.setPreferredSize(new Dimension(130, 50));
		btnAide.setPreferredSize(new Dimension(100, 40));
		bntCredits.setPreferredSize(new Dimension(100, 40));

	}

}
