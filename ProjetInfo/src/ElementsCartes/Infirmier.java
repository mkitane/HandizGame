package ElementsCartes;


/**
 * @author bprely
 *Le pateitn pourra demander l'aide d'un infirmier
 */
public class Infirmier extends Objet {

	/**
	 * @param positionX
	 * @param positionY
	 * nomImage:infirmier
	 * @param proprietaire 
	 */
	public Infirmier(int positionX, int positionY,Patient proprietaire) {
		super(positionX, positionY, "Infirmier", proprietaire);

	}

	
	public String toString(){
		return "I";
		
	}
	
}
