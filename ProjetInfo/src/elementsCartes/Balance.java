package elementsCartes;


/**
 * Classe qui modelise une Balance
 * C'est un objet.
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
		this.setThemeAssocie("Loi et Handicap");
	}
	
	public String toString(){
		return "Balance";
	}


}
