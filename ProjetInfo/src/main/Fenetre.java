package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import elementsCartes.Joueur;

public class Fenetre extends JFrame implements KeyListener{
	
	private Carte jeu = new Carte();


	
	public Fenetre(){
		setSize(610,625);
		setTitle("HandizGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jbInit();
        this.addKeyListener(this);
		jeu.addKeyListener(this);
        setVisible(true);
	}

	private void jbInit() {
		this.setLayout(new BorderLayout());
		this.add(jeu,BorderLayout.CENTER);
		
		
	}

	

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP){
			jeu.unDeplacementDeJoueur(Joueur.UP);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			jeu.unDeplacementDeJoueur(Joueur.DOWN);
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			jeu.unDeplacementDeJoueur(Joueur.LEFT);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			jeu.unDeplacementDeJoueur(Joueur.RIGHT);
		}

	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
