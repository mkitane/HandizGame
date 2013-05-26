package elementsCartes;


/**
 * @author bprely
 *
 */
public class Poutre extends Obstacle {

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
	public Poutre(int positionX, int positionY) {
		super(positionX, positionY,"Poutre");
	}

	
	public String toString(){
		return "Q";
		
	}
}
