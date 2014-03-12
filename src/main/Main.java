package main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import quizz.Quizz;

/**
 * Lancement du jeu
 */

// Il reste Chrono � implementer  //FAIT
// Gestion des Objets  //FAIT
// ==>ne pas creer un objet dans un endroit deja rempli //FAIT

// Singleton
/**
 * Classe main qui est une fenetre contenant les panneaux definissant le jeu
 * 
 */
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

	/**
	 * Regle la taille de la fenetre en fonction de la taille disponible
	 */
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
