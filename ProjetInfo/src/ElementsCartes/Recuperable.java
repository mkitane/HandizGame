package ElementsCartes;

/**
 * @author bprely
 *Interface 
 */
public interface Recuperable {

	/**Permet de savoir si l'objet peut �tre ramasse
	 * 
	 * @param x Position X du joueur
	 * @param y Position Y du joueur
	 * @return
	 */
	
	@SuppressWarnings("javadoc")
	public boolean estRamassable(int x, int y);
	
	
}
