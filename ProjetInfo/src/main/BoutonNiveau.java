package main;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;

/**
 * Cette class permet de creer un arriere plan au bouton correspondant au
 * niveau que le joueur selectionnera
 * 
 */
public class BoutonNiveau extends JButton {
	private Image img;

	// Un constructeur pour choisir plus simplement l'image
	public BoutonNiveau(String imageName) {
		super();
		img = Ressources.getImage(imageName);
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img == null)
			return;
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

		// ici on adapte l'image à la taille du composant(getWidth(),
		// getHeight())...

	}
}
