package elementsCartes;

/**
 * Classe qui modelise un Trou. Particularite : Peut faire perdre la partie en
 * marchant dessus
 * 
 */
public class Trou extends ElementCarte {
	/** Le compteur permet de supprimer le Trou apres 5 secondes */
	private int compteur = 0;

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Trou(int x, int y) {
		super(x, y, "Trou");
	}

	
	public String toString() {
		return "U";
	}

	/** Recupere le compteur du Trou
	 * @return the compteur
	 */
	public int getCompteur() {
		return compteur;
	}

	/**
	 * Le trou a une duree de vie limitee sur la carte. On utilisera cette
	 * methode pour augmenter le compteur interne du Trou
	 */
	public void incremente() {
		compteur++;
	}
}
