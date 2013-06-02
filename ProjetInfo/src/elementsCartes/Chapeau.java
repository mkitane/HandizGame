package elementsCartes;


/**
 * @author bprely
 *
 */
public class Chapeau extends ObjetRecuperable{
	
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire 
	 */
	public Chapeau(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Chapeau",proprietaire);
		//les handicaps ne sont pas encore bien mis
		this.setHandicapAssocie("Celebrite");
	}
	
	public String toString(){
		return "Chapeau";
	}


}
