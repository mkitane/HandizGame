package elementsCartes;


/**
 * Classe qui modelise un Chapeau
 * C'est un objet.
 */
public class Chapeau extends ObjetRecuperable{
	
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire 
	 */
	public Chapeau(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Chapeau",proprietaire);
		this.setThemeAssocie("Celebrite");
	}
	
	public String toString(){
		return "Chapeau";
	}


}
