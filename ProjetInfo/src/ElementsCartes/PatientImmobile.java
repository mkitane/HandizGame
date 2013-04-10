package ElementsCartes;


/**
 * @author bprely
 *Cocntrairement au patient qui interagit avec le joueur.Celui ci est un decor.
 */
public class PatientImmobile extends Obstacle {

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param propriétaire 
	 */
	public PatientImmobile(int positionX, int positionY) {
		super(positionX, positionY, "PatientImmobile");
		
	}
	
	public String toString(){
		return "Q";
		
	}
}
