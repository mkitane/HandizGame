package elementsCartes;

/**
 * @author mkitane
 * 
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
		// les handicaps ne sont pas encore bien mis
		this.setThemeAssocie("General");
	}

	public String toString() {
		return "Chien1";
	}

}
