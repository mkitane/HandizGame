package elementsCartes;


/**
 * Classe qui modelise un Livre
 * C'est un objet.
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
		this.setThemeAssocie("Loi et Handicap");
	}
	
	public String toString(){
		return "Livre";
	}


}
