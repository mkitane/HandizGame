package ElementsCartes;


/**
 * @author bprely
 *
 */
public class Canne extends Objet{

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire 
	 */
	public Canne(int positionX, int positionY, String nomImage,Patient proprietaire) {
		super(positionX, positionY, "Canne",proprietaire);
	}
	
	public String toString(){
		return "C";
		
	}

}
