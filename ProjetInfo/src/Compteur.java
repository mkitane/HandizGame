import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

import ElementsCartes.Patient;

/**
 * @author Mehdi
 *
 */

/**Compteur pour une barre en haut qui nous donne le temps restant*/
public class Compteur extends JLabel implements ActionListener{
	private Timer timer = new Timer(1000, this);
	private int compteur; 
	
	

		public Compteur(String nom){
			super(nom);	
			compteur=Integer.parseInt(nom);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			compteur--;
			this.setText(String.valueOf(compteur));	
			
			/*Test mode aleatoire comme ca
			int t = (int) (Math.random()*4);
			if(t==0){
				System.out.println("Lol");
				System.out.println("Creation dun patient");
				Patient f = new Patient(4,4,"Aveugle");
			}*/
			System.out.println("lola");
			if(compteur==0){
				timer.stop();
			}
		}
		public void start(){
			timer.start();
		}
		
		public int getCompteur() {
		return compteur;
		}
	
		
		/**Permet d'augmenter ou retirer du temps si le personnage ramenne ou pas le bon objet
		 * 
		 * @param compteur
		 */
		public void setCompteur(int compteur) {
			this.compteur = compteur;
		}
		
}