package elementsCartes;

public class Trou extends ElementCarte {
	/** Le compteur permet de supprimer le Trou apres 5 secondes */
	private int compteur = 0;

	public Trou(int x, int y) {
		super(x, y, "Trou");
	}

	public String toString() {
		return "U";
	}

	/**
	 * @return the compteur
	 */
	public int getCompteur() {
		return compteur;
	}

	public void incremente() {
		compteur++;
	}
}
