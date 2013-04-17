package elementsCartes;


/**
 * @author bprely
 *
 */
public class Joueur extends ElementCarte {

	public static final int UP = 0 ;
	public static final int DOWN = 1 ;
	public static final int LEFT = 2 ;
	public static final int RIGHT = 3 ;

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param tps
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
