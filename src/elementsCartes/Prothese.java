package elementsCartes;

/**
 * Classe qui modelise une Prothese
 * C'est un objet.
 */
public class Prothese extends ObjetRecuperable {

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire
	 */
	public Prothese(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Prothese", proprietaire);
		this.setThemeAssocie("Surdite");
	}

	public String toString() {
		return "Prothese";
	}

}
