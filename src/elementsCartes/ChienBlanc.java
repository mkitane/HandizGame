package elementsCartes;

/**
 * Classe qui modelise un Chien Blanc
 * C'est un objet.
 */
public class ChienBlanc extends ObjetRecuperable {

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire
	 */
	public ChienBlanc(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Chien2", proprietaire);
		this.setThemeAssocie("General");
	}

	public String toString() {
		return "Chien2";
	}

}
