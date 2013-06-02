package elementsCartes;


/**
 * Classe qui modelise un Telephone
 * C'est un objet.
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
		this.setThemeAssocie("Handicap et Entreprise");
	}
	
	public String toString(){
		return "Telephone";
	}


}
