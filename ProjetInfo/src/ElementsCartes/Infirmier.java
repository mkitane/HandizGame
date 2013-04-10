package ElementsCartes;


/**
 * @author bprely
 *
 */
public class Infirmier extends Objet {

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
	public Infirmier(int positionX, int positionY,Patient proprietaire) {
		super(positionX, positionY, "Infirmier", proprietaire);

	}

	
	public String toString(){
		return "I";
		
	}
	
}
