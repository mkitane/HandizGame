
/**
 * @author bprely
 *
 */
public class Joueur extends ElementCarte {
	private int tempsdeVie;

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param tps
	 */
	public Joueur(int positionX, int positionY, String nomImage,int tps) {
		super(positionX, positionY,nomImage);
		
		tps=tempsdeVie;
	}

	@Override
	public void placerElement() {
	
	}
	/**on veut modifier la positionY du joueur pour le déplacer d'une case vers le haut.
	 * On vérifie que la positionY soit toujours positive.
	 * 
	 */
	/**A modifier ke n'ai pas fini public void deplacerJoueurHaut(){
		int x=Joueur.getPositionX();
		int y=Joueur.getPositionY()++;
		Joueur.setPositionX(x);
		Joueur.setPositionY(y);
	
	}
	*/
	/**On modifie la positionY du joueur pour le déplacer d'une case vers le bas.
	 * On vérifie que la positionY soit toujours positive.
	 * 
	 */
	/**public void deplacerJoueurBas(){
		
	}
	
	
	**/
}
