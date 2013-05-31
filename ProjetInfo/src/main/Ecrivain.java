package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Ecrivain {
	/** L'instance statique */
	private static Ecrivain instance;
	private String txt = "";
	private int positionX = 0;
	private int positionY = 0;
	private final int TAILLEBULLEX = 140;
	private final int TAILLEBULLEY = 80;

	/** nombre de secondes pour afficher le txt */
	private int compteur = 3;

	private Ecrivain() {

	}

	/**
	 * Récupère l'instance unique de la class Singleton. Remarque : le
	 * constructeur est rendu inaccessible
	 */
	public static Ecrivain getInstance() {
		if (null == instance) { // Premier appel
			instance = new Ecrivain();
		}
		return instance;
	}

	public void setTxt(String s, int X, int Y) {
		txt = s;
		positionX = X * Carte.COTE;
		positionY = Y * Carte.COTE;
		compteur = 0; // on reinitialise le compteur
	}

	public void Ecrire(Graphics g) {
		compteur++;

		if (compteur < 3) {
			dessinerBulle(g);
		}

	}

	private void dessinerBulle(Graphics g) {
		
		if (positionX > (875 - TAILLEBULLEX) && positionY < TAILLEBULLEY) { // HAUTDROITEFAIT

			g.drawImage(Images.get("Bulle4"), positionX - TAILLEBULLEX,
					positionY + 35, TAILLEBULLEX, TAILLEBULLEY, null);

			int x = positionX - TAILLEBULLEX + 27 ; 
			int y = positionY + TAILLEBULLEY - 32 ; 
			for(String s : decomposerTxt(txt)){
				g.drawString(s, x , y + 20 );
				y= y+10 ; 
			}
			
			
		} else if (positionY < TAILLEBULLEY) { // HAUTFAIT
			g.drawImage(Images.get("Bulle3"), positionX + 35, positionY + 35,
					TAILLEBULLEX, TAILLEBULLEY, null);

			int x = positionX + 65 ; 
			int y = positionY + TAILLEBULLEY - 32 ; 
			for(String s : decomposerTxt(txt)){
				g.drawString(s, x , y + 20 );
				y= y+10 ; 
			}
			
		} else if (positionX < TAILLEBULLEX && positionY > (575 - TAILLEBULLEY)) { // BASGAUCHE
			g.drawImage(Images.get("Bulle4"), positionX - TAILLEBULLEX,
					positionY - TAILLEBULLEY, TAILLEBULLEX, TAILLEBULLEY, null);

			int x = positionX + 65 ; 
			int y = positionY - TAILLEBULLEY + 10 ; 
			for(String s : decomposerTxt(txt)){
				g.drawString(s, x , y + 20 );
				y= y+10 ; 
			
			}
		} else if (positionX < TAILLEBULLEX) { // A GaucheFAIT
			g.drawImage(Images.get("Bulle2"), positionX + 35, positionY
					- TAILLEBULLEY, TAILLEBULLEX, TAILLEBULLEY, null);


			int x = positionX + 65 ; 
			int y = positionY - TAILLEBULLEY + 10 ; 
			for(String s : decomposerTxt(txt)){
				g.drawString(s, x , y + 20 );
				y= y+10 ; 
			}
			
		} else {//FAIT

			g.drawImage(Images.get("Bulle1"), positionX - TAILLEBULLEX,
					positionY - TAILLEBULLEY, TAILLEBULLEX, TAILLEBULLEY, null);
			
			int x = positionX - TAILLEBULLEX + 25 ; 
			int y = positionY - TAILLEBULLEY + 10 ; 
			for(String s : decomposerTxt(txt)){
				g.drawString(s, x , y + 20 );
				y= y+10 ; 
			}
		}
	}
	
	
	private ArrayList<String> decomposerTxt(String s){
		ArrayList<String> liste = new ArrayList<String>();

		String[] splitArray = s.split(" "); //tableau de chaînes
		String temp = "" ; 
		int nombreDeLettreMaximal = 16 ; 
		for(int i = 0 ; i<splitArray.length ; i++){

			if((temp+splitArray[i]+ " ").length() < nombreDeLettreMaximal){
				temp = temp + splitArray[i] + " ";
			}else{
				liste.add(temp);
				temp = ""; 
				temp = temp + splitArray[i] + " ";
			}	
		}
		liste.add(temp);
		
		
		System.out.println(liste);
		return liste; 
	}
}
