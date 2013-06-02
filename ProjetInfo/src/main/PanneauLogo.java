package main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * Classe qui crée le panneau contenant le logo. Elle ajuste la taille du logo
 * à la taille de la fenêtre
 */
public class PanneauLogo extends JPanel {
	private Image imgPanneau = Ressources.getImage("PanneauPrincipal");


	/**
	 *
	 */
	public PanneauLogo() {
	}

	/**
	 * Méthode graphique qui dessine le logo au centre de son emplacement
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		g.drawImage(imgPanneau, -50, -50, null);
	}

}
