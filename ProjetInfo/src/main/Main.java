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
//==>ne pas creer un objet dans un endroit deja rempli
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Quizz.initialiser();
		
		new PanneauPrincipal();
		
		new FrameLevel();
		
		//new Fenetre();
	}

}
