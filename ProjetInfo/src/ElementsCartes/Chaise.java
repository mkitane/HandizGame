package ElementsCartes;


/**
 * @author bprely
 *
 */
public class Chaise extends Obstacle {
	/**
	 * @param positionX
	 * @param positionY
	 * Le nom de l'image est "chaise"
	 */
	public Chaise(int positionX,int positionY){
		super(positionX,positionY,"Chaise");
		
	}
	
	public String toString(){
		return "D";
		
	}

}
