package elementsCartes;


/**
 * @author bprely
 *
 */
public class Telephone extends ObjetRecuperable{
	
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire 
	 */
	public Telephone(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Telephone",proprietaire);
		//les handicaps ne sont pas encore bien mis
		this.setHandicapAssocie("Handicap et Entreprise");
	}
	
	public String toString(){
		return "Telephone";
	}


}
