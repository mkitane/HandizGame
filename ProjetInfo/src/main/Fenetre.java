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

public class Fenetre extends JFrame implements ActionListener,KeyListener{
	
	private Carte jeu = new Carte();
	private JPanel panelHaut = new JPanel();
	private JButton boutonHaut = new JButton(">");
	private JButton boutonBas = new JButton("<");
	private JButton boutonGauche = new JButton("^");
	private JButton boutonDroit = new JButton("v");

	
	public Fenetre(){
		setSize(500,500);
		setTitle("HandizGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jbInit();
		
        
		boutonHaut.addActionListener(this);
		boutonBas.addActionListener(this);
		boutonGauche.addActionListener(this);
		boutonDroit.addActionListener(this);
		boutonHaut.addKeyListener(this);
        setVisible(true);
	}

	private void jbInit() {
		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());
		this.add(panelHaut,BorderLayout.NORTH);
		this.add(jeu,BorderLayout.CENTER);
		
		panelHaut.setLayout(new FlowLayout());
		panelHaut.add(boutonHaut);
		panelHaut.add(boutonBas);
		panelHaut.add(boutonDroit);
		panelHaut.add(boutonGauche);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==boutonHaut){
			jeu.unDeplacementDeJoueur(Joueur.UP);
			setSize(500,510);
			setSize(500,500);
		}
		if(e.getSource()==boutonBas){
			jeu.unDeplacementDeJoueur(Joueur.DOWN);
			setSize(500,510);
			setSize(500,500);
		}
		if(e.getSource()==boutonDroit){
			jeu.unDeplacementDeJoueur(Joueur.RIGHT);
			setSize(500,510);
			setSize(500,500);
		}
		if(e.getSource()==boutonGauche){
			jeu.unDeplacementDeJoueur(Joueur.LEFT);
			setSize(500,510);
			setSize(500,500);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP){
			jeu.unDeplacementDeJoueur(Joueur.LEFT);
			setSize(500,510);
			setSize(500,500);
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			jeu.unDeplacementDeJoueur(Joueur.RIGHT);
			setSize(500,510);
			setSize(500,500);
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			jeu.unDeplacementDeJoueur(Joueur.DOWN);
			setSize(500,510);
			setSize(500,500);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			jeu.unDeplacementDeJoueur(Joueur.UP);
			setSize(500,510);
			setSize(500,500);
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
