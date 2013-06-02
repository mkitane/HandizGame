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
 * Classe créant le timer qui s'incrémente où s'implémente selon le résultat du joueur
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
	
	public Chrono(PanelJeu f){
		this.f=f;
		c=f.getJeu();
		
		this.setPreferredSize(new Dimension(625,50));
		setBackground(Ressources.GRIS);
	}

	
	
		public void actionPerformed(ActionEvent e) {
		compteur--;
		repaint();
		
		
		if(compteur<=0){
			c.arreterJeu();
		}
		
		
	}
	
	
	
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(imglisteObjets, 0, 3, 254, 45, null);
		g.setColor(Color.WHITE);
		dessinerBarre(g);
		g.drawString(String.valueOf(c.getScore()), f.getWidth()/2, 28);

		
		dessinerObjets(g);
		
		
	}
	
	
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
	
		
	public void start(){
		t.start();
	}
	public void stop(){
		t.stop();
	}
	public void incremente(){
		compteur+=10;
	}
	
	public void decremente(){
		compteur-=10;
	}
	
}
