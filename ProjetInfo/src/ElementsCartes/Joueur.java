package ElementsCartes;


/**
 * @author bprely
 *
 */
public class Joueur extends ElementCarte {

	/**
	 * référence au déplacement en haut avec 0
	 */
	public static final int UP = 0 ;
	/**
	 * Référence au déplacement bas avec 1
	 */
	public static final int DOWN = 1 ;
	/**
	 * On associe 2 au déplacement à gauche
	 */
	public static final int LEFT = 2 ;
	/**
	 * on associe 3 au déplacement à droite
	 */
	public static final int RIGHT = 3 ;

	/**
	 * Constructeur de la classe Joueur
	 * @param positionX
	 * @param positionY
	 */
	public Joueur(int positionX, int positionY) {
		super(positionX, positionY,"Joueur");
	}


	public String toString(){
		return "J";
	}
	
	
	/**
	 * @param x
	 * Cette méthode permet de modifier la position du joueur en fonction d'un entier allant de 0 à 3 
	 * associé à un déplacement
	 */
	public void deplacer(int x){
		if (x==UP){
			this.setPositionY(getPositionY()+1);
		}
		if(x==DOWN){
			this.setPositionY(getPositionY()-1);
		}
		if (x==LEFT){
			this.setPositionX(getPositionX()-1);
		}
		if(x==RIGHT){
			this.setPositionX(getPositionX()+1);
		}

	}
	
  
}
