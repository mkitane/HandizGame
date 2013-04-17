package ElementsCartes;

/**
 * @author bprely
 *Classe obstacle qui caractérise les objets non traversables par le joueur
 */
public class Obstacle extends ElementCarte {

	/**
	 * @param x : positionX
	 * @param y : positionY
	 * @param n :nom de l'objet obstacle
	 */
	public Obstacle(int x, int y, String n) {
		super(x, y, n);
	}
	
	/**
	 * @param x 
	 * @param y
	 * @return
	 */
	@SuppressWarnings("javadoc")
	public boolean action(int x, int y){
		return false;
	}

}
