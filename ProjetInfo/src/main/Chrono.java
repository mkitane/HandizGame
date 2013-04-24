package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
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
	private Timer t = new Timer(1000,this);
	private int compteur=200;

	private Image imglisteObjets;
	private Image imgBarreVide;
	private Image imgdelta;
	private Image imgdeltaFin;
	
	public Chrono(Fenetre f){
		this.f=f;
		readImages();
		this.setPreferredSize(new Dimension(625,50));
		setBackground(Color.getHSBColor(Float.parseFloat("27"), Float.parseFloat("0.08"), Float.parseFloat("0.42")));
	}

	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		compteur--;
		repaint();
		
		
		if(compteur<=0){
			System.exit(0);
			;
		}
		
		
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(imglisteObjets, 0, 3, 254, 45, null);
		dessinerBarre(g);
		
		
		g.setColor(Color.WHITE);
		g.drawString(String.valueOf(compteur), f.getWidth()-260, 28);
		
		int i=3;
		for(ObjetRecuperable a:f.getJeu().getObjetsRecuperes()){
			if(f.getJeu().getObjetsRecuperes().indexOf(a)<6){
			g.drawImage(a.getImage(), i, 9, 39,34,null);
			i+=42;
			}else{
			g.drawString("..", 260, 28);
				break;
			}
		}
		
	}
	
	
	public void dessinerBarre(Graphics g){
		g.drawImage(imgBarreVide, f.getWidth()-230, 15, 209, 20, null);
		
		
		if(compteur>197){
			g.drawImage(imgdeltaFin,f.getWidth()-28,18,5,11,null);

			for(int i=0;i<197;i++){
					g.drawImage(imgdelta, f.getWidth()-224+i, 19, 1, 11,null);
			}
			
		}else{
			
			for(int i=0;i<compteur;i++){
				g.drawImage(imgdelta, f.getWidth()-224+i, 19, 1, 11,null);
			}
			
		}
	}
	
	
	
	
	public void readImages(){
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
	
	public void incremente(){
		compteur+=10;
	}
	
	public void decremente(){
		compteur-=10;
	}
}
