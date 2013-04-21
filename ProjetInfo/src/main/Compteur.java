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
	private int chronometre=20;
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

		if(chronometre<=0){
			System.exit(0);
		}
		//Une chance sur 10 de creer un patient
		int nbAleatoire = (int) (Math.random()*300);
		
		if(nbAleatoire == 0){
			int positionXObjet = (int)(Math.random()*c.getColonnes());
			int positionYObjet = (int)(Math.random()*c.getLignes());
			Patient p = new Patient(positionXObjet,positionYObjet);
			c.getListeElements().add(p);
			System.out.println("PatientCree");
			c.repaint();
		}
	}		
	
	
	public void incrementeChronometre(){
		chronometre+=10;
	}

	public void decrementeChronometre(){
		chronometre-=10;
	}
		
		
}