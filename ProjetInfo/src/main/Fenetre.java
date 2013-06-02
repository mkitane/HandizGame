package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elementsCartes.Joueur;

/**
 * Classe contenant la page de démarrage
 * 
 */
public class Fenetre extends JPanel implements KeyListener {

	private JPanel panelJeu = new JPanel();
	private Carte jeu = new Carte(this);
	private Chrono chrono = new Chrono(this);
	private JPanel panelBas = new JPanel();
	private JButton boutonRetour = new JButton("Retour Accueil");
	private JButton boutonRejouer = new JButton("Rejouer");

	/**
	 * Concstructeur de fenetre contient les différentes évenemments des
	 * boutons qui se lancent au cours du programme
	 */
	public Fenetre() {
		jbInit();

		addKeyListener(this);
		boutonRetour.addKeyListener(this);

		chrono.start();

		boutonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chrono.stop();
				jeu.arreterGenerateur();
				Main.setPane(new PanneauPrincipal());

			}
		});

		boutonRejouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chrono.stop();
				jeu.arreterGenerateur();
				Main.setPane(new Fenetre());

			}
		});

		setVisible(true);
	}

	/**
	 * Classe contenant l'organisation des éléments graphiques
	 * 
	 */

	private void jbInit() {

		setLayout(new BorderLayout());
		add(panelJeu);

		setBackground(Ressources.GRIS);

		panelJeu.setLayout(new BorderLayout());
		panelJeu.add(chrono, BorderLayout.NORTH);
		panelJeu.add(jeu, BorderLayout.CENTER);
		panelJeu.add(panelBas, BorderLayout.SOUTH);

		panelBas.setLayout(new FlowLayout(15));
		panelBas.add(boutonRetour);
		panelBas.add(boutonRejouer);

		panelBas.setBackground(Ressources.GRIS);

	}

	/**
	 * Méthode qui permet de déplacer le joueur avec les touches du clavier
	 * 
	 */

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			jeu.unDeplacementDeJoueur(Joueur.UP);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			jeu.unDeplacementDeJoueur(Joueur.DOWN);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			jeu.unDeplacementDeJoueur(Joueur.LEFT);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			jeu.unDeplacementDeJoueur(Joueur.RIGHT);
		}
	}

	/**
	 * Méthode devant être appelée mais elle n'a pas de réelle utilité
	 * 
	 */
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Méthode devant être appelée mais elle n'a pas de réelle utilité
	 * 
	 */
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Méthode permettant de récuperer le chrono étant private
	 */

	public Chrono getChrono() {
		return chrono;
	}

	/**
	 * le jeu est une carte.On réccupère le jeu
	 */
	public Carte getJeu() {
		return jeu;
	}

}
