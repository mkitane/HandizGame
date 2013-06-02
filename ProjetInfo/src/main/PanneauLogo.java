package main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * Classe qui crée le panneau contenant le logo. Elle ajuste la taille du logo
 * à la taille de la fenêtre
 */
public class PanneauLogo extends JPanel {
	private Image imgLogo = Ressources.getImage("Logo");

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

		int positionX = this.getWidth();
		int positionY = this.getHeight();
		g.drawImage(imgLogo, 80, 20, positionX - 300, positionY - 100, null);
	}

}
