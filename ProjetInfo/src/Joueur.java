
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


	
	
	
	/**
	 * @param x
	 * Cette méthode permet de modifier la position du joueur en fonction d'un entier allant de 0 à 3 
	 * associé à un déplacement
	 */
	public void deplacer(int x){
		if (x==0)/*x=0 signifie déplacement en haut*/{
			this.setPositionY(getPositionY()+1);
		}
		if(x==1)/*x=1 signifie déplacement en bas*/{
			this.setPositionY(getPositionY()-1);
		}
		if (x==2)/*déplacement à gauche*/{
			this.setPositionX(getPositionX()-1);
		}
		if(x==3)/*déplacement à droite*/{
			this.setPositionX(getPositionX()+1);
		}

	}
	
  
}
