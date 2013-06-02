package main;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import elementsCartes.Joueur;

/**
 * Classe contenant le panel du jeu
 * 
 */
public class PanelJeu extends JPanel implements KeyListener {

	private JPanel panelMilieu = new JPanel();
	private Carte jeu = new Carte(this);
	private Chrono chrono = new Chrono(this);
	private JPanel panelBas = new JPanel();
	private JButton boutonRetour = new JButton("Retour Accueil");
	private JButton boutonRejouer = new JButton("Rejouer");

	public PanelJeu() {
		jbInit();

		addKeyListener(this);
		boutonRetour.addKeyListener(this);

		chrono.start();

		boutonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chrono.stop();
				jeu.arreterGenerateur();
				Main.setPane(new PanelPrincipal());

			}
		});

		boutonRejouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chrono.stop();
				jeu.arreterGenerateur();
				Main.setPane(new PanelJeu());

			}
		});

		setVisible(true);
	}

	/**
	 * Classe contenant l'organisation des elements graphiques
	 * 
	 */

	private void jbInit() {

		setLayout(new BorderLayout());
		add(panelMilieu);

		setBackground(Ressources.GRIS);

		panelMilieu.setLayout(new BorderLayout());
		panelMilieu.add(chrono, BorderLayout.NORTH);
		panelMilieu.add(jeu, BorderLayout.CENTER);
		panelMilieu.add(panelBas, BorderLayout.SOUTH);

		panelBas.setLayout(new FlowLayout(15));
		panelBas.add(boutonRetour);
		panelBas.add(boutonRejouer);

		panelBas.setBackground(Ressources.GRIS);

	}

	/**
	 * Methode qui permet de deplacer le joueur avec les touches du clavier
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

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public Chrono getChrono() {
		return chrono;
	}

	/**
	 * le jeu est une carte.On reccupere le jeu
	 */
	public Carte getJeu() {
		return jeu;
	}

}
