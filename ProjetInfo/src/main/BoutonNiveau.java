package main;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;

/**
 * Cette class permet de créer un arrière plan au bouton correspondant au
 * niveau que le joueur sélectionnera
 * 
 */
public class BoutonNiveau extends JButton {
	private Image img;

	// Un constructeur pour choisir plus simplement l'image
	public BoutonNiveau(String imageName) {
		super();
		img = Ressources.getImage(imageName);
	}

	// On doit redéfinir la méthode paintComponent() pour les composant swing
	// !!! et paint() pour awt
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img == null)
			return;
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

		// ici on adapte l'image à la taille du composant(getWidth(),
		// getHeight())...

	}
}
