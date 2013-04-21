package main; 

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

import elementsCartes.Patient;


/**
 * @author Mehdi
 *
 */

public class Compteur extends JLabel implements ActionListener{

	private Timer t = new Timer(1000,this);
	private int chronometre=100;
	private Carte c; 
	
	public Compteur(Carte c){
		this.c=c;
	}
	
	
		
			
				
	

	public void start(){
		t.start();
	}

	public void actionPerformed(ActionEvent e) {

		chronometre--;
		this.setText(String.valueOf(chronometre));

		/* a ne pas mettre pour la phase de test
		if(chronometre<=0){
			System.exit(0);
		}
		*/
		
		//Une chance sur 0 de creer un patient
		int nbAleatoire = (int) (Math.random()*30);
		
		if(nbAleatoire == 0){
			c.creerNouveauPatient();
			System.out.println("PatientCree");
			c.repaint();
		}
	}		
	
	
	public void incremente(){
		chronometre+=10;
	}

	public void decremente(){
		chronometre-=10;
	}
		
		
}