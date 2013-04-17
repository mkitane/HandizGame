package ElementsCartes;


/**
 * @author bprely
 *Une objet pouvant être demandé par le patient
 */
public class Lunette extends Objet{

	/**
	 * @param positionX
	 * @param positionY
	 * @param proprietaire 
	 * nomImage:Lunette
	 */
	public Lunette(int positionX, int positionY,Patient proprietaire) {
		super(positionX, positionY, "Lunette",proprietaire);
	}

	public String toString(){
		return "M";
		
	}
}
