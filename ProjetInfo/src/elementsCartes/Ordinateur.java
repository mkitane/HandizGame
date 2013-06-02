package elementsCartes;


/**
 * @author bprely
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
		//les handicaps ne sont pas encore bien mis
		this.setThemeAssocie("Handicap et Entreprise");
	}
	
	public String toString(){
		return "Ordinateur";
	}


}
