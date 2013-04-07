/**
 * Cette Classe modélise une réponse du quizz
 * @author mkitane
 *
 */


public class Reponse {
	private String rep ; 
	private boolean justesse;
	
	/**
	 * Constructeur pour les questions qui possèdent une explication
	 * @param r  reponse
	 * @param j	 justesse de la reponse
	 */
	public Reponse(String r,boolean j){
		rep=r; 	
		justesse=j; 
	}
	
	
	public String toString(){
		return rep;
	}
	
}
