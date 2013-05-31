package elementsCartes;


/**
 * @author bprely
 *
 */
public class Canne extends ObjetRecuperable{
	
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire 
	 */
	public Canne(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Canne",proprietaire);
		//les handicaps ne sont pas encore bien mis
		this.setHandicapAssocie("Handicap et entreprise");
	}
	
	public String toString(){
		return "ma canne";
	}


}
