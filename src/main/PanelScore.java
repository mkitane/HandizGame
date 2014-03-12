package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import quizz.ElementQuizz;

//Gerer le fait qu'il n'y ai aucune reponse
/**
 * Classe Jpanel permettant de creer un panneau ou les scores de la partie sont
 * affichees.
 * 
 * 
 */
public class PanelScore extends JPanel {
	private ArrayList<ElementQuizz> listeBonnesReponses;
	private ArrayList<ElementQuizz> listeMauvaisesReponses;
	private ArrayList<String> listeThemes = new ArrayList<String>();
	private String themeLacune;

	private Image imgBarreVide = Ressources.getImage("BarreVide");
	private Image imgdelta = Ressources.getImage("petitProgression");
	private Image imgdeltaFin = Ressources.getImage("petitBout");
	private Image imgAmis = Ressources.getImage("Amis");

	private JPanel panelBtn = new JPanel();
	private JButton btnRetour = new JButton("Retour Accueil");
	private JButton btnRejouer = new JButton("Rejouer");

	/**
	 * Constructeur du panneau score
	 */
	public PanelScore(ArrayList<ElementQuizz> lB, ArrayList<ElementQuizz> lM) {
		setBackground(Ressources.GRIS);

		listeBonnesReponses = lB;
		listeMauvaisesReponses = lM;

		trouverThemes();

		themeLacune = trouverLacune();

		this.setLayout(new BorderLayout());
		this.add(panelBtn, BorderLayout.SOUTH);

		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(btnRetour);
		panelBtn.add(btnRejouer);
		panelBtn.setBackground(Ressources.GRIS);

		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new PanelPrincipal());
			}
		});
		btnRejouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new PanelJeu());
			}
		});
	}

	/**
	 * Méthode graphique elle dessine les differents elements du panneau
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(Ressources.getQuickSand());

		g.drawImage(imgAmis, 80, 60, null);

		dessinerScore(g);
		dessinerBarreJustesse(g);

		int y = 300; // Permet de positionner toute la partie Detail en fonction
						// de cette position en y
		int x = 100;

		g.setFont(Ressources.getQuickSand().deriveFont((float) 30));
		g.drawString("Details :", getWidth() / 2 - 65, y);
		// pour chaque theme, on regarde le pourcentage de bonnes reponses

		for (String theme : listeThemes) {
			if (listeThemes.indexOf(theme) % 2 == 0) { // Une fois sur deux,
														// soit on decale en y ,
														// soit on decale en x;
				x = 100;
				y = y + 60;
				dessinerBarreTheme(g, y, x, theme, rapportBonnesReponses(theme));
			} else {
				x = this.getWidth() - 212 - 100; // taille totale - taille barre
													// - 100 pour symetrie par
													// rapport au int x = 100 ;
				dessinerBarreTheme(g, y, x, theme, rapportBonnesReponses(theme));

			}
		}

		y = y + 60;

		g.setFont(Ressources.getQuickSand().deriveFont((float) 20));
		if (themeLacune == null) {
			g.drawString("Vous n'avez rien a ameliorer ;)", 40,
					getHeight() - 45);
		} else {
			g.drawString(
					"Il faut que vous approfondissiez vos connaissances sur le theme : ",
					40, getHeight() - 65);
			g.drawString(themeLacune + ".", 580, getHeight() - 45);
		}
	}

	/**
	 * Dessine le score
	 * 
	 * @param g
	 */
	private void dessinerScore(Graphics g) {
		int positionX = 690;
		int positionY = 120;

		String s = String.valueOf(listeBonnesReponses.size());
		g.drawString(s, positionX, positionY);

		// chaque fois que le nombre de chiffre du score augmente, on augmente
		// de 30 la position du score total;
		int xPositionString = positionX + 20 * s.length();
		s = "/" + (listeBonnesReponses.size() + listeMauvaisesReponses.size());

		g.drawString(s, xPositionString, positionY - 20);
	}

	/**
	 * Dessine la barre du nombre de bonnes reponses total
	 * 
	 * @param g
	 */
	private void dessinerBarreJustesse(Graphics g) {
		int positionX = 600;
		int positionY = 160;
		g.drawString("Justesse", positionX + 40, positionY - 10);
		g.drawImage(imgBarreVide, positionX, positionY, 212, 20, null);

		float p = (float) (listeBonnesReponses.size())
				/ (float) (listeBonnesReponses.size() + listeMauvaisesReponses
						.size());

		for (int i = 0; i < pourcentage(p) * 2; i++) {
			g.drawImage(imgdelta, positionX + 6 + i, positionY + 4, 1, 11, null);

		}
		// on dessine le petit bout � droite
		if (pourcentage(p) * 2 == 200) {
			g.drawImage(imgdeltaFin, positionX + 205, positionY + 3, 5, 11,
					null);
		}

		g.setFont(Ressources.getQuickSand().deriveFont((float) 13));
		g.drawString(pourcentage(p) + "%", positionX + 225, positionY + 13);

		g.setFont(Ressources.getQuickSand().deriveFont((float) 40));
		if (pourcentage(p) > 50) {
			g.drawString("Bravo!", getWidth() / 2 - 70, 50);
		} else if (pourcentage(p) == 0) {
			g.drawString("0, vous pouvez faire mieux..", 170, 50);
		} else {
			g.drawString("Vous pouvez encore vous ameliorer ! ;)", 60, 50);
		}

	}

	/**
	 * Dessine la barre du nombre de bonnes reponses par theme
	 * 
	 * @param g
	 * @param y
	 * @param theme
	 * @param pourcentageBonnesReponses
	 */
	private void dessinerBarreTheme(Graphics g, int y, int x, String theme,
			float pourcentageBonnesReponses) {
		// int positionX=80;

		g.drawImage(imgBarreVide, x, y, 212, 20, null);

		for (int i = 0; i < pourcentage(pourcentageBonnesReponses) * 2; i++) {
			g.drawImage(imgdelta, x + 6 + i, y + 4, 1, 11, null);

		}
		// on dessine le petit bout � droite
		if (pourcentage(pourcentageBonnesReponses) * 2 == 200) {
			g.drawImage(imgdeltaFin, x + 205, y + 3, 5, 11, null);
		}

		g.setFont(Ressources.getQuickSand().deriveFont((float) 15));
		// g.drawString("------------------------------", positionX,
		// positionY-30);
		g.drawString(theme, x + 40, y - 10);
		g.drawString(pourcentage(pourcentageBonnesReponses) + "%", x + 225,
				y + 13); // +175
	}

	/**
	 * Convertit un nombre a virgule en pourcentage
	 * 
	 * @param f
	 * @return
	 */
	private int pourcentage(float f) {
		int i = (int) (f * 100);
		return i;
	}

	/**
	 * Remplit l'arrayList des themes pour savoir les themes qui ont etes lance
	 * pendant cette partie
	 */
	private void trouverThemes() {
		for (ElementQuizz a : listeBonnesReponses) {
			if (!verifierTheme(a.getTheme())) { // Si le theme n'est pas deja
												// present, dans la liste des
												// themes, on l'ajoute
				listeThemes.add(a.getTheme());
			}
		}
		for (ElementQuizz a : listeMauvaisesReponses) {
			if (!verifierTheme(a.getTheme())) { // Si le theme n'est pas deja
												// present, dans la liste des
												// themes, on l'ajoute
				listeThemes.add(a.getTheme());
			}
		}
	}

	/**
	 * Verifie si le theme n'est pas deja present dans l'arraylist des themes
	 * 
	 * @param theme
	 * @return
	 */
	private boolean verifierTheme(String theme) {
		for (String t : listeThemes) {
			if (theme.equals(t)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Nous donne le rapport de bonnes reponses sur le nombre totale de reponses
	 * pour un theme donne
	 */
	private float rapportBonnesReponses(String theme) {
		ArrayList<ElementQuizz> listeBonnesReponsesTheme = new ArrayList<ElementQuizz>();
		ArrayList<ElementQuizz> listeMauvaisesReponsesTheme = new ArrayList<ElementQuizz>();

		for (ElementQuizz a : listeBonnesReponses) {
			if (a.getTheme().equals(theme)) {
				listeBonnesReponsesTheme.add(a);
			}
		}

		for (ElementQuizz a : listeMauvaisesReponses) {
			if (a.getTheme().equals(theme)) {
				listeMauvaisesReponsesTheme.add(a);
			}
		}

		float p = (float) listeBonnesReponsesTheme.size()
				/ (float) (listeBonnesReponsesTheme.size() + listeMauvaisesReponsesTheme
						.size());

		return p;
	}

	/**
	 * Nous donne le theme ou le joueur a eu le plus de difficulte
	 * 
	 * @return
	 */
	private String trouverLacune() {
		String themeLacune = null;
		int rBLacune = 100;

		for (String theme : listeThemes) {
			int rBActuel = pourcentage(rapportBonnesReponses(theme));
			if (rBActuel < rBLacune) { // si le rapport du theme actuel est plus
										// petit, on met son theme dans la
										// lacune
				themeLacune = theme;
				rBLacune = rBActuel;
			}
		}

		System.out.println("Le theme le plus faible est " + themeLacune);
		return themeLacune;

	}

}
