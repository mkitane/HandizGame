package main;

import initiation.PanelInitiation;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;


import quizz.Quizz;

/**
 * Lancement du jeu
 */

// Il reste Chrono � implementer
// Gestion des Objets
// ==>ne pas creer un objet dans un endroit deja rempli

// Singleton
public class Main extends JFrame {
	private static Main frame;

	/**
	 * Main de la classe Main. Lance le panneau principal
	 * 
	 */
	private Main() {
		setTitle("HandizGame");
		setSize(Carte.COTE * 25, Carte.COTE * 15 + 73 + 40);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(new PanelPrincipal());

		setResizable(false);
		setVisible(true);
	}

	/**
	 * Installe les panel dans la frame
	 */
	public static void setPane(Component c) {
		frame.getContentPane().removeAll();
		frame.add(c);
		frame.validate();
		c.requestFocus();
	}

	private void reglerTaille() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);

	}

	/**
	 * Creation de l'objet
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("swing.boldMetal", Boolean.FALSE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Instanciation de l'application
		Ressources.chargerImages();
		Ressources.chargerPolice();
		Ressources.chargerXML();
		Quizz.initialiser();

		// seul moyen d'instancier le Main
		Main.frame = new Main();
		frame.reglerTaille();

	}

}
