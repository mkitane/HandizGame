package ElementsCartes;


/**
 * @author bprely
 *
 */
public class Mur extends Obstacle{

	/**
	 * @param positionX
	 * @param positionY
	 * nomImage=Mur
	 */

	public Mur(int positionX, int positionY) {
		super(positionX, positionY, "Mur");
	}
	
	public String toString(){
		return "M";
		
	}

}
