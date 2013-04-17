package ElementsCartes;


/**
 * @author bprely
 *Une table est un obstacle
 */
public class Table extends Obstacle {

	/**
	 * @param positionX
	 * @param positionY
	 * nomImage="Table"
	 */
	public Table(int positionX, int positionY) {
		super(positionX, positionY, "Table");
		
	}
	
	public String toString(){
		return "T";
	}

}
