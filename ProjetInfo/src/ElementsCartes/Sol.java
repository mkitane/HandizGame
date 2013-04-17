package ElementsCartes;

/**
 * @author bprely
 *Le sol n'est ni un obstacle ni un objet
 */
public class Sol extends ElementCarte {

	/**
	 * Constructeur de Sol
	 * @param x PositionX
	 * @param y PositionY
	 * nomImage="Sol"
	 */
	public Sol(int x, int y) {
		super(x, y, "Sol");
	}

	public String toString(){
		return " "; 
	}
}
