package main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

import Initiation.modeInitiation1;

import quizz.Quizz;

/**
 *Lancement du jeu
 */


//Il reste Chrono � implementer
//Gestion des Objets
//==>ne pas creer un objet dans un endroit deja rempli
public class Main extends JFrame{

	/**
	 *Main de la classe Main.  
	 *Lance le panneau principal
	 *
	 */
	   public Main(){
			setTitle("HandizGame");
			setSize(Carte.COTE*25,Carte.COTE*15+73+40);
		    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		    
		    setContentPane(new PanneauPrincipal());
			   	
		    setResizable(false);
	        setVisible(true);
	   }
	   /**
		 *Installe les panel dans la frame
		 */
	   public static void setPane(Component c){
		   Application.frame.getContentPane().removeAll();
		   Application.frame.add(c);
		   Application.frame.validate();
		   c.requestFocus();
	   }
	   
	   
}
