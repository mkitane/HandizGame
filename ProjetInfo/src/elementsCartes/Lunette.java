package elementsCartes;

/**
 * @author bprely
 * 
 */
public class Lunette extends ObjetRecuperable {

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
	public Lunette(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Lunette", proprietaire);
		this.setHandicapAssocie("celebrite");
	}

	public String toString() {
		return "Lunette";
	}

}
