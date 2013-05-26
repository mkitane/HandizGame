package quizz;

import java.util.ArrayList;

/**
 * Classe qui modelise un element de quizz
 * @author Mehdi
 *
 */
public class ElementQuizz {
	
	/**theme de la question*/
	private String theme; 
	/**Question*/
	private String question; 
	/**Liste de r�ponses*/
	private ArrayList<Reponse> listeReponse ; 
	/**Explication de la reponse
	 * Optionnel:Pourquoi la reponse est fausse ou juste
	 */
	private String explication; 
	/**Question raccourcie pour le mode initiation*/
	private String questionRaccourci; 
	
	
	
	/**
	 * Constructeur avec explication
	 * @param t : le theme
	 * @param q : la question
	 * @param lR : la liste de reponses
	 * @param e : l'explication
	 */
	public ElementQuizz(String t,String q, ArrayList<Reponse> lR, String e){
		theme=t; 
		question=q; 
		listeReponse=lR;
		explication=e; 
		questionRaccourci=raccourcir(q);
	}

	
	
	
	public String toString(){
		return questionRaccourci;
	}
	/**
	 * Getter Theme
	 * @return Theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * Setter Theme
	 * @param theme du quizz
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	
	
	
	
	/**
	 * Getter Question
	 * @return Question du quizz
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Setter Question
	 * @param question 
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	
	
	/**
	 * Getter Liste reponse
	 * @return liste des reponses du quizz
	 */
	public ArrayList<Reponse> getListeReponse() {
		return listeReponse;
	}

	/**
	 * Setter listeReponse
	 */
	
	public void setListeReponse(ArrayList<Reponse> listeReponse) {
		this.listeReponse = listeReponse;
	}

	
	
	
	/**
	 * Getter Explication
	 * @return explication
	 */
	public String getExplication() {
		return explication;
	}
	/**
	 * Setter Explication
	 * @param explication du quizz
	 */
	public void setExplication(String explication) {
		this.explication = explication;
	}



	/**
	 * Getter Question Raccourci
	 * @return Question Raccourci
	 */
	public String getQuestionRaccourci() {
		return questionRaccourci;
	}
	
	
	
	/**Raccourcit une chaine de caractere*/
	private String raccourcir(String s){
		String nouvelle = "";
		
		for(int i=0;i<35;i++){
			nouvelle = nouvelle + s.charAt(i);
		}
		nouvelle=nouvelle+"...";
		
		
		return nouvelle;
	}
	
	
	
	
}
