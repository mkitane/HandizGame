package main;
import java.util.Scanner;

import elementsCartes.Joueur;

import quizz.ElementQuizz;
import quizz.Quizz;

/**
 *Lancement du jeu
 */


//Il reste Chrono � implementer
//Gestion des Objets
//ne pas creer un objet dans un endroit deja rempli
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quizz.initialiser();
		//jeu.toString();
		
		Fenetre f = new Fenetre();

		
	
		
		
		/*
		Quizz q = new Quizz("Handicap et entreprise");
		Scanner sc = new Scanner(System.in);
		int j = sc.nextInt();
		q.afficherCorrection(q.geteQ().getListeReponse().get(j-1));
		*/
		


		
	}

}
