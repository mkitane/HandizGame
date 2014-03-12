package quizz;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import main.Carte;
import main.Ecrivain;
import main.Ressources;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import elementsCartes.ObjetRecuperable;

/**
 * Cette Classe modelise le Quizz du programme Permet de lancer un quizz
 * 
 */

public class Quizz extends JFrame implements KeyListener, ActionListener {
	/** Array List contenant tous les questions du fichier XML */
	public static ArrayList<ElementQuizz> listeElementQuizz = new ArrayList<ElementQuizz>();
	/** Element de Quizz, contient la question, les reponses et lexplication */
	private ElementQuizz eQ;
	private Carte carte;
	private ObjetRecuperable objetAssocieAuQuizz;

	/** Partie Graphique */
	private JTextArea labelQuestion = new JTextArea();
	private JPanel panelReponses = new JPanel();
	private JButton tableauDesReponses[];
	private JLabel indication = new JLabel(
			"Naviguer grace a tab ou fleches gauches et droites");

	/**
	 * Getter Quizz
	 * 
	 * @return ElementQuizz
	 */
	public ElementQuizz geteQ() {
		return eQ;
	}

	/**
	 * Charge le Quizz a partir d'un theme defini
	 * 
	 * @param theme
	 */
	public Quizz(String theme, Carte c, ObjetRecuperable o) {
		choisitQuizz(theme);
		this.carte = c;
		objetAssocieAuQuizz = o;

		jbInit();

	}

	/**
	 * Methode qui organise la partie graphique du programme
	 */

	public void jbInit() {
		/* Partie Graphique */
		setSize(carte.getRootPane().getWidth(), 200);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(true);

		labelQuestion.setText("Theme : " + eQ.getTheme()
				+ "   \n               " + eQ.getQuestion());
		setLayout(new BorderLayout());
		add(labelQuestion, BorderLayout.NORTH);
		add(panelReponses, BorderLayout.CENTER);
		add(indication, BorderLayout.SOUTH);

		panelReponses.setLayout(new FlowLayout());
		tableauDesReponses = new JButton[eQ.getListeReponse().size()];
		for (Reponse a : eQ.getListeReponse()) {
			tableauDesReponses[eQ.getListeReponse().indexOf(a)] = new JButton(
					a.getRep());
			panelReponses.add(tableauDesReponses[eQ.getListeReponse()
					.indexOf(a)]);
			tableauDesReponses[eQ.getListeReponse().indexOf(a)]
					.addKeyListener(this);
			tableauDesReponses[eQ.getListeReponse().indexOf(a)]
					.addActionListener(this);

		}

		/* Personalisation du JtextArea labelQuestion */

		labelQuestion.setLineWrap(true); // Permet de sauter revenir a la ligne
											// si la question est trop longue
		labelQuestion.setWrapStyleWord(true);
		labelQuestion.setEditable(false);
		labelQuestion.setFocusable(false); // On lui enleve le focus pour
											// pouvoir naviguer qu'entre les
											// reponses

		/*
		 * Ajout de la navigation par les fleches droites et gauches pour tous
		 * les boutons
		 */

		for (int i = 0; i < tableauDesReponses.length; i++) {

			Set keys = tableauDesReponses[i]
					.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS);
			Set newKeys = new HashSet(keys);
			newKeys.add(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0));
			tableauDesReponses[i].setFocusTraversalKeys(
					KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, newKeys);

			Set keys1 = tableauDesReponses[i]
					.getFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS);
			Set newKeys1 = new HashSet(keys1);
			newKeys1.add(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0));
			tableauDesReponses[i].setFocusTraversalKeys(
					KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, newKeys1);
		}

		/* Changement du look de la fenetre */

		Point p = carte.getLocationOnScreen();
		p.translate(0, carte.getHeight() - 150);
		setLocation(p);
		setUndecorated(true);

		/* Personnalisation Couleur */
		getContentPane().setBackground(Ressources.GRIS);
		labelQuestion.setOpaque(false);
		panelReponses.setOpaque(false);
		labelQuestion.setForeground(Color.white);
		indication.setForeground(Color.white);

		setVisible(true);

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			boutonsActionPerformed(e);
		}
	}

	public void actionPerformed(ActionEvent e) {
		boutonsActionPerformed(e);
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

	/**
	 * Action qui s'effectue quand on appuie sur un des boutons
	 */
	private void boutonsActionPerformed(AWTEvent e) {
		// Verifie si le JButtoncorrespond � la bonne reponse
		for (int i = 0; i < tableauDesReponses.length; i++) {
			// On Cree une boucle, on verifie si la source equivaut a chaque
			// entree du tableau des reponses
			// on attribue a la source une Reponse grace a la premiere condition
			// on verifie ensuite si cette reponse est la bonne grace au
			// deuxieme if
			if (e.getSource() == tableauDesReponses[i]) {

				if (verifierReponse(eQ.getListeReponse().get(i))) { // si c'est
																	// la bonne
																	// reponse

					// Fenetre.ecrire("Bonne reponse, Donnes l'objet au Patient a present");
					Ecrivain.getInstance().setImage(
							Ressources.getImage("Check"),
							objetAssocieAuQuizz.getProprietaire()
									.getPositionX(),
							objetAssocieAuQuizz.getProprietaire()
									.getPositionY());

					carte.getF().getChrono().incremente();
					carte.addObjetListeObjetRecuperes(objetAssocieAuQuizz); // on
																			// rajoute
																			// l'objet
																			// a
																			// notre
																			// "sac"
																			// pour
																			// pouvoir
																			// le
																			// donner
																			// au
																			// patient
					carte.removeObjet(objetAssocieAuQuizz); // on l'enleve de la
															// carte
					carte.addBonneReponse(eQ); // on rajoute a larrayList Bonnes
												// reponses pour le score a la
												// fin

				} else {

					carte.getF().getChrono().decremente();
					carte.removePatient(objetAssocieAuQuizz.getProprietaire()); // on
																				// enleve
																				// le
																				// patient
																				// de
																				// la
																				// carte
					carte.removeObjet(objetAssocieAuQuizz); // on enleve l'objet
															// de la carte
					if (!carte.patientPresent()) { // si il n'y a aucun patient
													// sur la carte
						carte.creerNouveauPatient(); // Cree un nouveau Patient
														// pour ne pas bloquer
														// le joueur seulement
														// si il n'y en a pas
														// deja
					}
					carte.addMauvaiseReponse(eQ); // on rajoute a larrayList
													// Mauvaises reponses pour
													// le score a la fin

					// Effet visuel pour savoir que la reponse est fausse;
					getContentPane().setBackground(Color.RED);
					// Fenetre.ecrire("Mauvaise reponse, Un autre Patient est apparu, va voir ce qu'il veut");
					Ecrivain.getInstance().setImage(
							Ressources.getImage("Cross"),
							objetAssocieAuQuizz.getProprietaire()
									.getPositionX(),
							objetAssocieAuQuizz.getProprietaire()
									.getPositionY());

				}

				dispose();
				carte.repaint();

				break; // plus besoin de chercher
			}

		}
	}

	/**
	 * Initialise le Quizz : charge en memoire toutes l'arrayList du Quizz
	 * 
	 * Methode qui charge le quizz a partir d'un fichier XML contenant toutes
	 * les questions
	 */
	public static void initialiser() {
		// Vide l'arrayList au cas ou;
		listeElementQuizz.clear();
		// Lire Fichier XML grace � un analyseur DOM (suffisant pour un petit
		// fichier XML comme le notre)
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(Ressources.getFichierXml());

			// optional, but recommended
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("element");

			/*
			 * Stoque tous les noeud dans une arrayList pour ensuite utiliser
			 * l'arraylist
			 */
			for (int n = 0; n < nList.getLength(); n++) {
				listeElementQuizz.add(construitElementQuizz((Element) nList
						.item(n)));
			}

			// System.out.println(listElementTheme.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Construit ElementQuizz a partir d'un des elements du fichier XML
	 * 
	 * @param eElement
	 * @return
	 */
	@SuppressWarnings("javadoc")
	private static ElementQuizz construitElementQuizz(Element eElement) {
		String theme = eElement.getAttribute("theme");
		String question = eElement.getElementsByTagName("question").item(0)
				.getTextContent();
		String explication = eElement.getElementsByTagName("explication")
				.item(0).getTextContent();
		ArrayList<Reponse> lR = new ArrayList<Reponse>();

		// Boucle pour les reponses
		for (int i = 0; i < eElement.getElementsByTagName("answer").getLength(); i++) {
			Element answerElement = (Element) eElement.getElementsByTagName(
					"answer").item(i);

			if (answerElement.getAttribute("j").equals("juste")) {
				lR.add(new Reponse(eElement.getElementsByTagName("answer")
						.item(i).getTextContent(), true));
			} else {
				lR.add(new Reponse(eElement.getElementsByTagName("answer")
						.item(i).getTextContent(), false));

			}
		}

		return new ElementQuizz(theme, question, lR, explication);

	}

	/**
	 * Choisit une Question au hasard, avec le theme desire
	 * 
	 * @param theme
	 */
	private void choisitQuizz(String theme) {
		ArrayList<ElementQuizz> temp = new ArrayList<ElementQuizz>();

		// Cree une liste des elements choisis
		for (ElementQuizz a : listeElementQuizz) {
			if (a.getTheme().equalsIgnoreCase(theme)) {
				temp.add(a);
			}
		}

		eQ = temp.get((int) (Math.random() * temp.size()));
		eQ.setListeReponse(melanger(eQ.getListeReponse()));
	}

	/**
	 * Affiche le quizz sur le terminal (pour l'instant)
	 */
	public void afficherQuizzTerminal() {
		System.out.println(eQ.getTheme());
		System.out.println(eQ.getQuestion());
		System.out.println();
		System.out.println(eQ.getListeReponse());
	}

	/**
	 * Melange une arraylist de reponses afin d'afficher les reponses dans un
	 * ordre aleatoire
	 * 
	 * @param listeDepart
	 * @return ArrayList<Reponse>
	 */
	private ArrayList<Reponse> melanger(ArrayList<Reponse> listeDepart) {

		List<Reponse> nouvelle = new ArrayList<Reponse>(listeDepart);
		Collections.shuffle(nouvelle);
		return (ArrayList<Reponse>) nouvelle;

	}

	/**
	 * Verifie si la reponse donnee en parametre est correcte
	 * 
	 * @param r
	 * @return boolean
	 */
	public boolean verifierReponse(Reponse r) {
		return r.isJustesse();
	}

}
