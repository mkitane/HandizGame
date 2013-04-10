package quizz;
/**
 * Cette Classe modélise une réponse du quizz
 * @author mkitane
 *
 */


public class Reponse {
	/**Une des reponses du quizz*/
	private String rep ; 
	/**Justesse de la reponse*/
	private boolean justesse;
	
	/**
	 * Constructeur pour les reponses
	 * @param r  reponse
	 * @param j	 justesse de la reponse
	 */
	public Reponse(String r,boolean j){
		rep=r; 	
		setJustesse(j); 
	}
	
	
	
	public String toString(){
		return rep;
	}


	/**
	 * Getter Justesse de la reponse
	 * @return justesse
	 */
	public boolean isJustesse() {
		return justesse;
	}


	/**
	 * Setter Justesse de la reponse
	 * @param justesse
	 */
	public void setJustesse(boolean justesse) {
		this.justesse = justesse;
	}
	
}
