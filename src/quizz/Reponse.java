package quizz;

/**
 * Cette Classe modelise une reponse du quizz
 * 
 * @author mkitane
 * 
 */

public class Reponse {
	/** Une des reponses du quizz */
	private String rep;
	/** Justesse de la reponse */
	private boolean justesse;

	/**
	 * Constructeur pour les reponses
	 * 
	 * @param r
	 *            reponse
	 * @param j
	 *            justesse de la reponse
	 */
	public Reponse(String r, boolean j) {
		rep = r;
		justesse = j;
	}

	public String toString() {
		return rep;
	}

	/**
	 * Getter Justesse de la reponse
	 * 
	 * @return justesse
	 */
	public boolean isJustesse() {
		return justesse;
	}

	/**
	 * Getter Reponse
	 * 
	 * @return reponse
	 */
	public String getRep() {
		return rep;
	}

}
