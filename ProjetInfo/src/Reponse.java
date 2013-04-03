/**
 * Cette Classe modélise une réponse du quizz
 * @author mkitane
 *
 */


public class Reponse {
	private String rep ; 
	private boolean justesse;
	//Optionnel Pourquoi la reponse est fausse ou juste
	private String explication; 
	
	
	public Reponse(String r,boolean j){
		rep=r; 	
		justesse=j; 
	}
	
	/**
	 * Constructeur pour les questions qui possèdent une explication
	 * @param r  reponse
	 * @param j	 justesse de la reponse
	 * @param e	
	 */
	public Reponse(String r, boolean j, String e){
		rep=r;
		justesse=j; 
		explication=e;
		
	}
	
	public String toString(){
		return rep;
	}
	
}
