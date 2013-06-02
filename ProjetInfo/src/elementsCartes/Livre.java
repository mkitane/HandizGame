package elementsCartes;


/**
 * @author bprely
 *
 */
public class Livre extends ObjetRecuperable{
	
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire 
	 */
	public Livre(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Livre",proprietaire);
		//les handicaps ne sont pas encore bien mis
		this.setThemeAssocie("Loi et Handicap");
	}
	
	public String toString(){
		return "Livre";
	}


}
