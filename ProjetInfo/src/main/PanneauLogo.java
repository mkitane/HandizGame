package main;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanneauLogo extends JPanel {
	private Image imgLogo; 
	
	public PanneauLogo(){
		readImages();
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		int positionX = this.getWidth();
		int positionY = this.getHeight();
		g.drawImage(imgLogo, 80, 20, positionX-300, positionY-100, null);
	}
	
	
	/**
	 * Met les images en memoire
	 */
	private void readImages(){
		try {
			imgLogo = ImageIO.read(new File("./images/Logo.png"));

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
