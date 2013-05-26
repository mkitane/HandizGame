package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;

import quizz.Quizz;

public class Application {

	 public static Main frame = new Main();
	 
	 
	 public Application(){
			
	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     Dimension frameSize =  frame.getSize();
     if (frameSize.height > screenSize.height) {
         frameSize.height = screenSize.height;
     }
     if (frameSize.width > screenSize.width) {
         frameSize.width = screenSize.width;
     }
     frame.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
	
	}
     
	 
	 /**Creation de l'objet
		 * 
		 * @param args
		 */
	 public static void main(String[] args) {
	        try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	            UIManager.put("swing.boldMetal", Boolean.FALSE);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        //Instanciation de l'application
	       Quizz.initialiser();
	       new Application();
	       System.gc();


	}
	 
}
