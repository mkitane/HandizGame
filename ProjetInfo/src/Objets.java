
/**
 * @author bprely
 *
 */
public class Objets extends ElementCarte {
	private Patient propriétaire;
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
	public Objets(int positionX, int positionY, String nomImage,Patient n) {
		super(positionX,positionY,nomImage);
		n=propriétaire;
	}	
		
		
}	


