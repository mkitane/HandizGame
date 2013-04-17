package ElementsCartes;


/**
 * @author bprely
 *Cocntrairement au patient qui interagit avec le joueur. 
 *Celui-ci est un decor.
 */
public class PatientImmobile extends Obstacle {

	/**Constructeur de PatientImmobile
	 * @param positionX
	 * @param positionY
	 *nomImage="PatientImmobile"
	 */
	public PatientImmobile(int positionX, int positionY) {
		super(positionX, positionY, "PatientImmobile");
		
	}
	
	public String toString(){
		return "Q";
		
	}
}
