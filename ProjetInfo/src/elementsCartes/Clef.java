package elementsCartes;


/**
 * @author bprely
 *
 */
public class Clef extends ObjetRecuperable{
	
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire 
	 */
	public Clef(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Clef",proprietaire);
		//les handicaps ne sont pas encore bien mis
		this.setThemeAssocie("General");
	}
	
	public String toString(){
		return "Clef";
	}


}
