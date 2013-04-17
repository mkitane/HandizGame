package ElementsCartes;


/**
 * @author bprely
 * un lit est un obstacle Immobile
 */
public class Lit extends Obstacle {

	/**
	 * Constructeur de Lit
	 * @param positionX
	 * @param positionY
	 * nomImage:lit
	 */
	public Lit(int positionX, int positionY) {
		super(positionX, positionY,"Lit");
	}

	
	public String toString(){
		return "L";
		
	}
}
