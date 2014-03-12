package elementsCartes;


/**
 * Classe qui modelise une Clef
 * C'est un objet.
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
		this.setThemeAssocie("General");
	}
	
	public String toString(){
		return "Clef";
	}


}
