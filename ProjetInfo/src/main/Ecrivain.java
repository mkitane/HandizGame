package main;

import java.awt.Graphics;
import java.awt.Image;
/**
 * Classe qui dessinne les différentes bulles du jeu
 */
public class Ecrivain {
	/** L'instance statique */
	private static Ecrivain instance;
	// private String txt = "";
	private int positionX = 0;
	private int positionY = 0;
	private final int TAILLEBULLEX = 50;
	private final int TAILLEBULLEY = 50;
	private Image i = null;
	/** nombre de secondes pour afficher le txt */
	private int compteur = 3;
/**
 * Constructeur d'Ecrivaain
 */
	private Ecrivain() {
	}

	/**
	 * RŽcup?re l'instance unique de la class Singleton. Remarque : le
	 * constructeur est rendu inaccessible
	 */
  /**
     *
     * @return
     */
	public static Ecrivain getInstance() {
		if (null == instance) { // Premier appel
			instance = new Ecrivain();
		}
		return instance;
	}
/**
     *Installe l'image à la cote X,Y
     * @param i
     * @param X
     * @param Y
     */
	public void setImage(Image i, int X, int Y) {
		this.i = i;
		positionX = X * Carte.COTE;
		positionY = Y * Carte.COTE;
		compteur = 0; // on reinitialise le compteur
	}
/**
     *
     * @param i
     * @param X
     * @param Y
     */
	public void setImage(Image i, double X, double Y) {
		// TODO Auto-generated method stub
		this.i = i;
		positionX = (int) (X * 20);
		positionY = (int) (Y * 20);
		compteur = 0; // on reinitialise le compteur
	}
/**
     *Méthode graphique qui dessine la bulle selon le compteur
     * @param g
     */
	public void Ecrire(Graphics g) {
		compteur++;

		if (compteur < 3) {
			dessinerBulle(g);
		}

	}
/**
     *méthode qui dessine la bulle 
     * @param g
     */
	private void dessinerBulle(Graphics g) {
		int decallage = 20;
		if (positionX > (875 - TAILLEBULLEX - 10) && positionY < TAILLEBULLEY) { // HAUTDROITEFAIT

			g.drawImage(Ressources.getImage("Bulle4"), positionX - TAILLEBULLEX
					+ decallage, positionY + 35, TAILLEBULLEX, TAILLEBULLEY,
					null);

			int x = positionX - TAILLEBULLEX + 27 + 5;
			int y = positionY + TAILLEBULLEY - 58 + 60; // -32
			g.drawImage(i, x, y, 25, 25, null);

		} else if (positionY < TAILLEBULLEY) { // HAUTFAIT
			g.drawImage(Ressources.getImage("Bulle3"), positionX + 35
					- decallage, positionY + 35, TAILLEBULLEX, TAILLEBULLEY,
					null);

			int x = positionX + 47 - decallage;
			int y = positionY + TAILLEBULLEY + 2;
			g.drawImage(i, x, y, 25, 25, null);

		} else if (positionX < TAILLEBULLEX && positionY > (575 - TAILLEBULLEY)) { // BASGAUCHE
			g.drawImage(Ressources.getImage("Bulle2"), positionX + 35
					- decallage, positionY - TAILLEBULLEY, TAILLEBULLEX,
					TAILLEBULLEY, null);

			int x = positionX + 65 - decallage;
			int y = positionY - TAILLEBULLEY + 20;
			g.drawImage(i, x, y, 25, 25, null);

		} else if (positionX < TAILLEBULLEX) { // A GaucheFAIT
			g.drawImage(Ressources.getImage("Bulle2"), positionX + 35
					- decallage, positionY - TAILLEBULLEY, TAILLEBULLEX,
					TAILLEBULLEY, null);

			int x = positionX + 48 - decallage;
			int y = positionY - TAILLEBULLEY + 10;
			g.drawImage(i, x, y, 25, 25, null);

		} else {// FAIT

			g.drawImage(Ressources.getImage("Bulle1"), positionX - TAILLEBULLEX
					+ decallage, positionY - TAILLEBULLEY, TAILLEBULLEX,
					TAILLEBULLEY, null);

			int x = positionX - TAILLEBULLEX + 12 + decallage;
			int y = positionY - TAILLEBULLEY + 10; // 10
			g.drawImage(i, x, y, 25, 25, null);

		}
	}

	/*
	 * public void setTxt(String s, int X, int Y) { txt = s; positionX = X *
	 * Carte.COTE; positionY = Y * Carte.COTE; compteur = 0; // on reinitialise
	 * le compteur }
	 * 
	 * private void dessinerBulle(Graphics g) {
	 * 
	 * if (positionX > (875 - TAILLEBULLEX-10) && positionY < TAILLEBULLEY) { //
	 * HAUTDROITEFAIT
	 * 
	 * g.drawImage(Ressources.getImage("Bulle4"), positionX - TAILLEBULLEX,
	 * positionY + 35, TAILLEBULLEX, TAILLEBULLEY, null);
	 * 
	 * int x = positionX - TAILLEBULLEX + 27 ; int y = positionY + TAILLEBULLEY
	 * - 58 ; //-32 for(String s : decomposerTxt(txt)){ g.drawString(s, x , y +
	 * 20 ); y= y+15 ; }
	 * 
	 * 
	 * } else if (positionY < TAILLEBULLEY) { // HAUTFAIT
	 * g.drawImage(Ressources.getImage("Bulle3"), positionX + 35, positionY +
	 * 35, TAILLEBULLEX, TAILLEBULLEY, null);
	 * 
	 * int x = positionX + 65 ; int y = positionY + TAILLEBULLEY - 58 ;
	 * for(String s : decomposerTxt(txt)){ g.drawString(s, x , y + 20 ); y= y+15
	 * ; }
	 * 
	 * } else if (positionX < TAILLEBULLEX && positionY > (575 - TAILLEBULLEY))
	 * { // BASGAUCHE g.drawImage(Ressources.getImage("Bulle2"), positionX + 35,
	 * positionY - TAILLEBULLEY, TAILLEBULLEX, TAILLEBULLEY, null);
	 * 
	 * int x = positionX + 65 ; int y = positionY - TAILLEBULLEY + 20 ;
	 * for(String s : decomposerTxt(txt)){ g.drawString(s, x , y + 20 ); y= y+15
	 * ;
	 * 
	 * } } else if (positionX < TAILLEBULLEX) { // A GaucheFAIT
	 * g.drawImage(Ressources.getImage("Bulle2"), positionX + 35, positionY -
	 * TAILLEBULLEY, TAILLEBULLEX, TAILLEBULLEY, null);
	 * 
	 * 
	 * int x = positionX + 65 ; int y = positionY - TAILLEBULLEY + 20 ;
	 * for(String s : decomposerTxt(txt)){ g.drawString(s, x , y + 20 ); y= y+15
	 * ; }
	 * 
	 * } else {//FAIT
	 * 
	 * g.drawImage(Ressources.getImage("Bulle1"), positionX - TAILLEBULLEX,
	 * positionY - TAILLEBULLEY, TAILLEBULLEX, TAILLEBULLEY, null);
	 * 
	 * int x = positionX - TAILLEBULLEX + 25 ; int y = positionY - TAILLEBULLEY
	 * + 20 ; //10 for(String s : decomposerTxt(txt)){ g.drawString(s, x , y +
	 * 20 ); y= y+15 ; } } }
	 * 
	 * 
	 * private ArrayList<String> decomposerTxt(String s){ ArrayList<String>
	 * liste = new ArrayList<String>();
	 * 
	 * String[] splitArray = s.split(" "); //tableau de cha”nes String temp = ""
	 * ; int nombreDeLettreMaximal = 16 ; for(int i = 0 ; i<splitArray.length ;
	 * i++){
	 * 
	 * if((temp+splitArray[i]+ " ").length() < nombreDeLettreMaximal){ temp =
	 * temp + splitArray[i] + " "; }else{ liste.add(temp); temp = ""; temp =
	 * temp + splitArray[i] + " "; } } liste.add(temp);
	 * 
	 * 
	 * System.out.println(liste); return liste; }
	 */
}
