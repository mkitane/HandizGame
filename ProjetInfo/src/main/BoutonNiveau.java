package main;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoutonNiveau extends JButton {
	 private Image img;
	 private String imageName;
	     
	 //Un constructeur pour choisir plus simplement l'image
	 public BoutonNiveau(String imageName) {
		 super();
		 this.imageName=imageName;
		 readImages();
	 
	 }
	     
	 //On doit redéfinir la méthode paintComponent() pour les composant swing !!! et paint() pour awt
	 public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      if (img == null) return;
	      g.drawImage(img, 0, 0, getWidth(), getHeight(), this); 
	      
	      //ici on adapte l'image à la taille du composant(getWidth(), getHeight())...
	      //cf : la documentation java à http://javasearch.developpez.com/j2se/1.6.0/docs/api/java/awt/Graphics.html#drawImage(java.awt.Image,%20int,%20int,%20int,%20int,%20java.awt.image.ImageObserver)
	     
	}
	 
	 
	 /**
	 * Met les images en memoire
	*/
	private void readImages(){
		try {
			img = ImageIO.read(new File("./images/"+imageName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}    
	
}
