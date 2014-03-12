package elementsCartes;

import java.awt.Graphics;
import java.awt.Image;

import main.Carte;
import main.Ressources;

/**
 * Classe qui modelise un Element de la carte.
 * Ne peux etre instanciee directement
 */
abstract public class ElementCarte {
	/** La position horizontale d'un element de la carte.Toujours positif */
	private int positionX;
	/** La position verticale d'un element de la carte.Toujours positif */
	private int positionY;
	/** l'image de l'element de la carte */
	private Image img;

	/**
	 * @param x
	 * @param y
	 * @param n
	 */
	public ElementCarte(int x, int y, String nom) {
		positionX = x;
		positionY = y;
		img = Ressources.getImage(nom);
	}


	/**
	 * Permet de recuperer l'image de lelement depuis la classe statique Ressources
	 * 
	 * @param nomImage
	 */
	public void setImage(String nom) {
		img = Ressources.getImage(nom);
	}

	/**
	 * Dessine l'Element dans le jPanel
	 * 
	 * @param g
	 *            le graphique java ou dessine l'image de la piece
	 */
	public void dessine(Graphics g) {
		if (img != null) {
			g.drawImage(this.img, this.positionX * Carte.COTE, this.positionY
					* Carte.COTE, Carte.COTE, Carte.COTE, null);
		}
	}

	/**
	 * Attribut positionX.On utilise un getteur.
	 * 
	 * @return int positionX
	 */
	public int getPositionX() {
		return positionX;
	}

	/**
	 * Attribut PositionY. On utilise un getteur
	 * 
	 * @return int positionY
	 */
	public int getPositionY() {
		return positionY;
	}

	/**
	 * attribut. On utilise un getteur
	 * 
	 * @return Image img
	 */
	public Image getImage() {
		return img;
	}

	/**
	 * postionX.On utilise un setteur pour modifier la valeur
	 * 
	 * @param x
	 */
	public void setPositionX(int x) {
		positionX = x;
	}

	/**
	 * positionY. On utilise un setteur pour modifier la valeur
	 * 
	 * @param y
	 */
	public void setPositionY(int y) {
		positionY = y;
	}

}
