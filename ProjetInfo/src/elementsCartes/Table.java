package elementsCartes;


/**
 * @author bprely
 *
 */
public class Table extends Obstacle {

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param propriétaire 
	 */
	public Table(int positionX, int positionY) {
		super(positionX, positionY, "Table");
		
	}
	
	public String toString(){
		return "T";
	}

}
