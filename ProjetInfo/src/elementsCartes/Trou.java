package elementsCartes;

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
/**
     *
     * @return
     */
	public String toString() {
		return "U";
	}

	/**
	 * @return the compteur
	 */
	public int getCompteur() {
		return compteur;
	}
/**
 *Le trou a une durée de vie limitée sur la carte
 * On utilisera cette méthode pour la suite
 */
	public void incremente() {
		compteur++;
	}
}
