package elementsCartes;

/**
 * Classe qui modelise un Chien Jaune
 * C'est un objet.
 */
public class ChienJaune extends ObjetRecuperable {

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire
	 */
	public ChienJaune(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Chien1", proprietaire);
		this.setThemeAssocie("General");
	}

	public String toString() {
		return "Chien1";
	}

}
