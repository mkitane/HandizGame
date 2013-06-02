package elementsCartes;

/**
 * @author bprely
 * 
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
		// les handicaps ne sont pas encore bien mis
		this.setThemeAssocie("General");
	}

	public String toString() {
		return "Chien2";
	}

}
