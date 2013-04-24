package main; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


/**
 *
 */
/**Compteur interne ˆ la classe Carte
 * Permet de generer des patients aleatoirements
 * */
public class Generateur implements ActionListener{

	private Timer t = new Timer(1000,this);
	private Carte c; 
	
	public Generateur(Carte c){
		this.c=c;
	}


	public void start(){
		t.start();
	}

	public void actionPerformed(ActionEvent e) {

		
		//Une chance sur 30 de creer un patient
		int nbAleatoire = (int) (Math.random()*30);
		
		if(nbAleatoire == 0){
			c.creerNouveauPatient();
			Fenetre.ecrire("Un Patient est apparu!");
			c.repaint();
		}
	}		
	

}