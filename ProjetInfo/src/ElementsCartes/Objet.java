package ElementsCartes;

/**
 * @author bprely
 *
 */
public class Objet extends ElementCarte implements Recuperable{
	private Patient proprietaire;
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
	public Objet(int positionX, int positionY, String nomImage,Patient p) {
		super(positionX,positionY,nomImage);
		proprietaire=p;
	}

	
	
	public boolean estRamassable(int x, int y) {
		return false;
	}	
		
		
}	


