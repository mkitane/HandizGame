package elementsCartes;


/**
 * @author bprely
 *
 */
public class Chien2 extends ObjetRecuperable{
	
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire 
	 */
	public Chien2(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Chien2",proprietaire);
		//les handicaps ne sont pas encore bien mis
		this.setHandicapAssocie("Handicap et entreprise");
	}
	
	public String toString(){
		return "Chien2";
	}


}
