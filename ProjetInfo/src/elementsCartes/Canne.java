package elementsCartes;


/**
 * Classe qui modelise une Canne
 * C'est un objet.
 */
public class Canne extends ObjetRecuperable{
	
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire 
	 */
	public Canne(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Canne",proprietaire);
		this.setThemeAssocie("Celebrite");
	}
	
	public String toString(){
		return "Canne";
	}


}
