package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elementsCartes.Joueur;

public class Fenetre extends JFrame implements KeyListener{
	
	private JPanel panelJeu = new JPanel();
	private Carte jeu = new Carte();
	private Chrono chrono= new Chrono(this);
	private JPanel panelBas = new JPanel();
	private JButton boutonRetour = new JButton("Retour Acceuil");
	private static JLabel labelInfo = new JLabel();
	
	public Fenetre(){
		setSize(Carte.COTE*15,Carte.COTE*15+73+35);
		setTitle("HandizGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,0);
        jbInit();
        
        boutonRetour.addKeyListener(this);
		chrono.start();
		
		
        setVisible(true);
	}

	private void jbInit() {
		
		setContentPane(panelJeu);
		setBackground(Color.getHSBColor(Float.parseFloat("27"), Float.parseFloat("0.08"), Float.parseFloat("0.42")));
		
		panelJeu.setLayout(new BorderLayout());
		panelJeu.add(chrono,BorderLayout.NORTH);
		panelJeu.add(jeu,BorderLayout.CENTER);
		panelJeu.add(panelBas,BorderLayout.SOUTH);
		
		panelBas.setLayout(new FlowLayout(15));
		panelBas.add(boutonRetour);
		panelBas.add(labelInfo);
		
		labelInfo.setForeground(Color.WHITE);
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
	
	
	public Chrono getChrono(){
		return chrono;
	}
	
	public Carte getJeu() {
		return jeu;
	}

	public static void ecrire(String s){
		labelInfo.setText(s);
	}
	
}
