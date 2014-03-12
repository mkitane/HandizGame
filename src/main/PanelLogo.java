package main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * Classe qui cree le panneau contenant le logo. Elle ajuste la taille du logo
 * a la taille de la fenetre
 */
public class PanelLogo extends JPanel {
	private Image imgPanneau = Ressources.getImage("PanneauPrincipal");


	public PanelLogo() {
	}

	/**
	 * Methode graphique qui dessine le logo au centre de son emplacement
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		g.drawImage(imgPanneau, -50, -50, null);
	}

}
