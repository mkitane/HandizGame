
/**
 * @author bprely
 *Cocntrairement au patient qui interagit avec le joueur.Celui ci est un décor.
 */
public class PatientImmobile extends Objets {

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param propriétaire 
	 */
	public PatientImmobile(int positionX, int positionY, String nomImage,Patient propriétaire) {
		super(positionX, positionY, nomImage,propriétaire);
		
	}

}
