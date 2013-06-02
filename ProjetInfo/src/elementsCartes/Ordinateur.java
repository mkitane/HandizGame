package elementsCartes;


/**
 * Classe qui modelise un Ordinateur.
 * C'est un objet.
 *
 */
public class Ordinateur extends ObjetRecuperable{
	
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param proprietaire 
	 */
	public Ordinateur(int positionX, int positionY, Patient proprietaire) {
		super(positionX, positionY, "Ordinateur",proprietaire);
		this.setThemeAssocie("Handicap et Entreprise");
	}
	
	public String toString(){
		return "Ordinateur";
	}


}
