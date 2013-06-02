package elementsCartes;

/**
 * @author bprely
 * 
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
		// les handicaps ne sont pas encore bien mis
		this.setHandicapAssocie("surdite");
	}

	public String toString() {
		return "Prothese";
	}

}
