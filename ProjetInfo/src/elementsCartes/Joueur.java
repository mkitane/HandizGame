package elementsCartes;

/**
 * Classe qui modelise le Joueur
 * 
 */
public class Joueur extends ElementCarte {
	/** Deplacement Haut */
	public static final int UP = 0;
	/** Deplacement Bas */
	public static final int DOWN = 1;
	/** Deplacement Gauche */
	public static final int LEFT = 2;
	/** Deplacement Droit */
	public static final int RIGHT = 3;
	/** Variable qui permet de savoir quelle image du personnage on doit charger */
	private int deplacement = 0;

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param tps
	 */
	public Joueur(int positionX, int positionY) {
		super(positionX, positionY, "Personnage/Derriere1");
	}

	public String toString() {
		return "J";
	}

	/**
	 * @param x
	 *            Cette methode permet de modifier la position du joueur en
	 *            fonction d'un entier allant de 0 a 3 associe a un deplacement
	 */
	public void deplacer(int x) {
		if (x == UP) {
			setImageJoueur(UP);
			this.setPositionY(getPositionY() - 1);
		}
		if (x == DOWN) {
			setImageJoueur(DOWN);
			this.setPositionY(getPositionY() + 1);
		}
		if (x == LEFT) {
			setImageJoueur(LEFT);
			this.setPositionX(getPositionX() - 1);
		}
		if (x == RIGHT) {
			setImageJoueur(RIGHT);
			this.setPositionX(getPositionX() + 1);
		}

	}

	/**
	 * Selon la direction du joueur on charge l'image correspondante
	 * 
	 * @param direction
	 */
	private void setImageJoueur(int direction) {
		deplacement++;

		if (direction == DOWN) {
			if (deplacement % 3 == 0) {
				this.setImage("Personnage/Face1");
			} else if (deplacement % 3 == 1) {
				this.setImage("Personnage/Face2");
			} else {
				this.setImage("Personnage/Face3");
			}
		}

		if (direction == UP) {
			if (deplacement % 3 == 0) {
				this.setImage("Personnage/Derriere1");
			} else if (deplacement % 3 == 1) {
				this.setImage("Personnage/Derriere2");
			} else {
				this.setImage("Personnage/Derriere3");
			}
		}

		if (direction == LEFT) {
			if (deplacement % 3 == 0) {
				this.setImage("Personnage/Gauche1");
			} else if (deplacement % 3 == 1) {
				this.setImage("Personnage/Gauche2");
			} else {
				this.setImage("Personnage/Gauche3");
			}
		}

		if (direction == RIGHT) {
			if (deplacement % 3 == 0) {
				this.setImage("Personnage/Droit1");
			} else if (deplacement % 3 == 1) {
				this.setImage("Personnage/Droit2");
			} else {
				this.setImage("Personnage/Droit3");
			}
		}
	}

}
