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
	private int deplacement =0;

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
			setImageJoueur(UP);
			this.setPositionY(getPositionY()-1);
		}
		if(x==DOWN){
			setImageJoueur(DOWN);
			this.setPositionY(getPositionY()+1);
		}
		if (x==LEFT){
			setImageJoueur(LEFT);
			this.setPositionX(getPositionX()-1);
		}
		if(x==RIGHT){
			setImageJoueur(RIGHT);
			this.setPositionX(getPositionX()+1);
		}

	}
	
	
	private void setImageJoueur(int direction){
		deplacement++;

		if(direction==DOWN){
			if(deplacement%3==0){
				this.setImage("./personnage/dwarf_walk_s1");
			}else if(deplacement%3==1){
				this.setImage("./personnage/dwarf_walk_s2");
			}else{
				this.setImage("./personnage/dwarf_walk_s3");
			}
		}
		
		if(direction==UP){
			if(deplacement%3==0){
				this.setImage("./personnage/dwarf_walk_n1");
			}else if(deplacement%3==1){
				this.setImage("./personnage/dwarf_walk_n2");
			}else{
				this.setImage("./personnage/dwarf_walk_n3");
			}
		}
		
		
		
		if(direction==LEFT){
			if(deplacement%3==0){
				this.setImage("./personnage/dwarf_walk_nw1");
			}else if(deplacement%3==1){
				this.setImage("./personnage/dwarf_walk_nw2");
			}else{
				this.setImage("./personnage/dwarf_walk_nw3");
			}
		}
		
		
		
		if(direction==RIGHT){
			if(deplacement%3==0){
				this.setImage("./personnage/dwarf_walk_ne1");
			}else if(deplacement%3==1){
				this.setImage("./personnage/dwarf_walk_ne2");
			}else{
				this.setImage("./personnage/dwarf_walk_ne3");
			}
		}
	}
  
}
