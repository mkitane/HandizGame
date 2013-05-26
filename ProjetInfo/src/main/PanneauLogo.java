package main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PanneauLogo extends JPanel {
	private Image imgLogo = Images.get("Logo");
	
	public PanneauLogo(){}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		int positionX = this.getWidth();
		int positionY = this.getHeight();
		g.drawImage(imgLogo, 80, 20, positionX-300, positionY-100, null);
	}
	

	
}
