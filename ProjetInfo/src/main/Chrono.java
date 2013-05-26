package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import elementsCartes.ObjetRecuperable;

public class Chrono extends JPanel implements ActionListener  {
	private Fenetre f;
	private Carte c;
	private Timer t = new Timer(1000,this);
	private int compteur=4000;

	private Image imglisteObjets;
	private Image imgBarreVide;
	private Image imgdelta;
	private Image imgdeltaFin;
	
	public Chrono(Fenetre f){
		this.f=f;
		c=f.getJeu();
		
		readImages();
		this.setPreferredSize(new Dimension(625,50));
		setBackground(Fenetre.GRIS);
	}

	
	
		public void actionPerformed(ActionEvent e) {
		compteur--;
		repaint();
		
		
		if(compteur<=0){
			c.arreterGenerateur();
			stop();
			
			//on recuperer la fenetre active
			Window x = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
			if(x.getClass().getName().equals("quizz.Quizz")){
				x.dispose();
			}
			
			f.setPane((new PanelScore(c.getListeBonnesReponses(),c.getListeMauvaisesReponses())));
			f.validate();
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
		int y= 9;
		
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
	
	
	private void readImages(){
		try {
			imglisteObjets = ImageIO.read(new File("./images/listeObjets.png"));
			imgBarreVide = ImageIO.read(new File("./images/BarreVide.png"));
			imgdelta = ImageIO.read(new File("./images/petitProgression.png"));
			imgdeltaFin = ImageIO.read(new File("./images/petitBout.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void mettreAZero(){
		compteur=0;
	}
}
