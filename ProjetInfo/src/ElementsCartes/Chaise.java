package ElementsCartes;


/**
 * @author bprely
 *
 */
public class Chaise extends Obstacle {
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
	public Chaise(int positionX,int positionY){
		super(positionX,positionY,"Chaise");
		
	}
	
	public String toString(){
		return "D";
		
	}

}
