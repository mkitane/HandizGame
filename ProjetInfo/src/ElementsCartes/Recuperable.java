package ElementsCartes;

public interface Recuperable {

	/**Permet de savoir si l'objet peut tre ramasse
	 * 
	 * @param x Position X du joueur
	 * @param y Position Y du joueur
	 * @return
	 */
	public boolean estRamassable(int x, int y);
	
	
}
