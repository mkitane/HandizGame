package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

import elementsCartes.ObjetRecuperable;
/**
 * Classe cr√©ant le timer qui s'incr√©mente o√π s'impl√©mente selon le r√©sultat du joueur
 * 
 *
 */
public class Chrono extends JPanel implements ActionListener  {
	private PanelJeu f;
	private Carte c;
	private Timer t = new Timer(1000,this);
	private int compteur=200;

	private Image imglisteObjets =  Ressources.getImage("listeObjets");
	private Image imgBarreVide = Ressources.getImage("BarreVide");
	private Image imgdelta = Ressources.getImage("petitProgression");
	private Image imgdeltaFin  = Ressources.getImage("petitBout");
	/**
     *Le constructeur du chrono
     * @param f
     */
	public Chrono(PanelJeu f){
		this.f=f;
		c=f.getJeu();
		
		this.setPreferredSize(new Dimension(625,50));
		setBackground(Ressources.GRIS);
	}

	
	/**
     *DÈcrÈmente le compteur et arrÍte le jeu si il arrive ‡ 0
     * @param e
     */
		public void actionPerformed(ActionEvent e) {
		compteur--;
		repaint();
		
		
		if(compteur<=0){
			c.arreterJeu();
		}
		
		
	}
	
	
	
	
	/**
     *La partie graphique du chrono.Dessine la barre du chrono.
     * @param g
     */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(imglisteObjets, 0, 3, 254, 45, null);
		g.setColor(Color.WHITE);
		dessinerBarre(g);
		g.drawString(String.valueOf(c.getScore()), f.getWidth()/2, 28);

		
		dessinerObjets(g);
		
		
	}
	
	/**
     *M"thode qui dessine la barre et attribue une image ‡ la quantit de temps
     * @param g
     */
	private void dessinerBarre(Graphics g){

		int x=f.getWidth()-250; 
		int y=15; 
		
		g.drawImage(imgBarreVide, x, y, 212, 20, null);
		
		
		if(compteur>200){

			for(int i=0;i<200;i++){
			g.drawImage(imgdelta, x+6+i, y+4, 1, 11,null);
			}
			
			g.drawImage(imgdeltaFin,x+205,y+3,5,11,null);

		}else{
			
			for(int i=0;i<compteur;i++){
				g.drawImage(imgdelta, x+6+i, y+4, 1, 11,null);
			}
			
		}
		
		g.drawString(String.valueOf(compteur), x+212, y+13);
		
	}
	
	/**
     *Dessine un objet 
     * @param g
     */
	private void dessinerObjets(Graphics g){

		int x=3;
		int y=9;
		
		for(ObjetRecuperable a:c.getObjetsRecuperes()){
			if(c.getObjetsRecuperes().indexOf(a)<6){
			g.drawImage(a.getImage(), x, y, 39,34,null);
			x+=42;
			}else{
			g.drawString("...", y+253, y+19);
				break;
			}
		}
	}
	
		/**
     * dÈmarre le timer
     */
	public void start(){
		t.start();
	}
    /**
     * Stoppe le timer
     */
	public void stop(){
		t.stop();
	}
    
    /**
     * IncrÈmente le compteur
     */
	public void incremente(){
		compteur+=10;
	}
	/**
   * DÈcrÈmente le compteur
   */
	public void decremente(){
		compteur-=10;
	}
	
}
