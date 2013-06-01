package elementsCartes;


/**
 * @author mkitane
 *
 */
public class Chien1 extends ObjetRecuperable{
	
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire 
	 */
	public Chien1(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Chien1",proprietaire);
		//les handicaps ne sont pas encore bien mis
		this.setHandicapAssocie("celebrite");
	}
	
	public String toString(){
		return "Chien1";
	}


}
