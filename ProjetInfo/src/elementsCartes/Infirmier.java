package elementsCartes;

/**
 * @author bprely
 * 
 */
public class Infirmier extends ObjetRecuperable {

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
	public Infirmier(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Infirmier", proprietaire);
		this.setThemeAssocie("Surdite");
	}

	public String toString() {
		return "Infirmier";
	}

}
