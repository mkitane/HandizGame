package elementsCartes;


/**
 * @author bprely
 *
 */
public class Lit extends Obstacle {

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
	public Lit(int positionX, int positionY) {
		super(positionX, positionY,"Lit");
	}

	
	public String toString(){
		return "L";
		
	}
}
