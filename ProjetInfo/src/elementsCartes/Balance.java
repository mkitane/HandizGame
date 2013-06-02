package elementsCartes;


/**
 * @author bprely
 *
 */
public class Balance extends ObjetRecuperable{
	
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire 
	 */
	public Balance(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Balance",proprietaire);
		//les handicaps ne sont pas encore bien mis
		this.setThemeAssocie("Loi et Handicap");
	}
	
	public String toString(){
		return "Balance";
	}


}
