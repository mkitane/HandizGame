package elementsCartes;

import main.Carte;
import main.Fenetre;

public interface Recuperable {

	/**Permet de savoir si l'objet peut �tre ramasse
	 * 
	 * @param x Position X du joueur
	 * @param y Position Y du joueur
	 * @return
	 */
	public void estRamasse(Carte c);
	
	
}
