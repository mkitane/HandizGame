package elementsCartes;

/**
 * Classe qui modelise des Lunettes
 * C'est un objet.
 */
public class Lunette extends ObjetRecuperable {

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
	public Lunette(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Lunette", proprietaire);
		this.setThemeAssocie("Celebrite");
	}

	public String toString() {
		return "Lunette";
	}

}
