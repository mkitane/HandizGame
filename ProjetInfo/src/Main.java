import java.util.Scanner;

import quizz.ElementQuizz;
import quizz.Quizz;


/**
 * @author bprely
 *Lancement du jeu
 */
@SuppressWarnings("unused")
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Carte jeu = new Carte(); 
		jeu.toString();
		
		
		
		Quizz.initialiser();
	
		
		/*
		Quizz q = new Quizz("Handicap et entreprise");
		Scanner sc = new Scanner(System.in);
		int j = sc.nextInt();
		q.afficherCorrection(q.geteQ().getListeReponse().get(j-1));
		*/
		


		
	}

}
