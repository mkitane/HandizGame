package main;

import java.awt.Graphics;
import java.awt.KeyboardFocusManager;
import java.awt.Window;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JPanel;

import quizz.ElementQuizz;

import elementsCartes.Balance;
import elementsCartes.Canne;
import elementsCartes.Chapeau;
import elementsCartes.ChienJaune;
import elementsCartes.ChienBlanc;
import elementsCartes.Clef;
import elementsCartes.ElementCarte;
import elementsCartes.Infirmier;
import elementsCartes.Joueur;
import elementsCartes.Livre;
import elementsCartes.Lunette;
import elementsCartes.ObjetRecuperable;
import elementsCartes.Ordinateur;
import elementsCartes.Patient;
import elementsCartes.Prothese;
import elementsCartes.Sol;
import elementsCartes.Obstacle;
import elementsCartes.Telephone;
import elementsCartes.Trou;

/**
 * Classe qui modelise le plateau du Jeu
 */

public class Carte extends JPanel {
	/**
	 * Caracteristiques de la carte
	 */
	private int lignes = 15; // nombre de lignes
	private int colonnes = 25; // nombre de colonnes
	public static final int COTE = 35; // Pour plus tard Taille des cases;
	public static String niveau = "niveau1";

	private Generateur generateurPatient = new Generateur();
	// Score de la partie
	// Augmente quand on rend un objet � un patient
	// Le temps quand � lui augmente quand on repond juste � une question et
	// diminue quand on repond faux
	private int score = 0;

	/** Liste des elements presents sur la carte */
	private ArrayList<ElementCarte> listeElements;
	/** Liste des objets recuperes par le joueur */
	private ArrayList<ObjetRecuperable> objetsRecuperes;
	/** Liste contenant le sol */
	private ArrayList<Sol> lSol = new ArrayList<Sol>();
	/** Le Joueur */
	private Joueur joueur;

	/** Permet de calculer les scores ensuite */
	private ArrayList<ElementQuizz> listeBonnesReponses = new ArrayList<ElementQuizz>();
	private ArrayList<ElementQuizz> listeMauvaisesReponses = new ArrayList<ElementQuizz>();

	private PanelJeu f;

	/**
	 * Constructeur Cree une carte avec ses objets et ses patients
	 */
	public Carte(PanelJeu f) {
		listeElements = new ArrayList<ElementCarte>();
		objetsRecuperes = new ArrayList<ObjetRecuperable>();
		chargerCarte(niveau);
		generateurPatient.start();

		setBackground(Ressources.GRIS);
		this.f = f;
	}

	/**
	 * Charge la Carte a partir d'un fichier txt
	 * 
	 * @param nomFichier
	 */
	private void chargerCarte(String nomFichier) {

		// charger fichier
		try {
			InputStream fichierLvl = Ressources.class
					.getResourceAsStream(nomFichier + ".txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fichierLvl));

			String l;
			int ligneFichier = 0;

			while ((l = br.readLine()) != null) {
				if (ligneFichier == 0) {
					this.colonnes = Integer.parseInt(l);
				} else if (ligneFichier == 1) {
					this.lignes = Integer.parseInt(l);

					// Ajouter du sol partout
					for (int k = 0; k < lignes; k++) {
						for (int j = 0; j < colonnes; j++) {
							lSol.add(new Sol(j, k));
						}
					}

				} else {
					lireLigne(l, ligneFichier);
				}
				ligneFichier++;
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--------------------------");
		System.out.println("ChargementFini");
		System.out.println("--------------------------");

		repaint();
	}

	/**
	 * Lis une ligne du fichier Txt
	 * 
	 * @param l
	 * @param positionLigne
	 */
	private void lireLigne(String l, int positionLigne) {
		char c;
		positionLigne = positionLigne - 2;
		for (int j = 0; j < l.length(); j++) {
			c = l.charAt(j);
			// Action � effectuer selon l'objet, besoin de definir les objets
			// que l'on mettra d'abord
			if (c == 'C') {
				listeElements.add(new Obstacle(j, positionLigne, "Chaise"));
			}
			if (c == 'B') {
				listeElements.add(new Obstacle(j, positionLigne, "Box"));
			}
			if (c == 'L') {
				listeElements.add(new Obstacle(j, positionLigne, "Lit"));
			}
			if (c == 'M') {
				listeElements.add(new Obstacle(j, positionLigne, "Mur"));
			}
			if (c == 'Q') {
				listeElements.add(new Obstacle(j, positionLigne, "Poutre"));
			}
			if (c == 'T') {
				listeElements.add(new Obstacle(j, positionLigne, "Table"));
			}
			if (c == 'J') {
				joueur = new Joueur(j, positionLigne);
				listeElements.add(joueur);
			}
			// Pour les autres elements
			if (c == 'P') {
				listeElements.add(new Patient(j, positionLigne));
			}

		}
	}

	/**
	 * Dessine la carte
	 * 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (ElementCarte a : lSol) {
			a.dessine(g);
		}
		for (ElementCarte a : listeElements) {
			a.dessine(g);
		}

		Ecrivain.getInstance().Ecrire(g);
	}

	/**
	 * Methode assurant le deplacement du joueur en fonction d'une direction
	 * precisee
	 * 
	 * @param direction
	 */
	public void unDeplacementDeJoueur(int direction) {

		ElementCarte e = null;
		if (direction == Joueur.UP) {
			e = recupererElement(joueur.getPositionX(),
					joueur.getPositionY() - 1);
		} else if (direction == Joueur.DOWN) {
			e = recupererElement(joueur.getPositionX(),
					joueur.getPositionY() + 1);
		} else if (direction == Joueur.LEFT) {
			e = recupererElement(joueur.getPositionX() - 1,
					joueur.getPositionY());
		} else if (direction == Joueur.RIGHT) {
			e = recupererElement(joueur.getPositionX() + 1,
					joueur.getPositionY());
		}

		if (e instanceof Obstacle) {
		} else if (e instanceof ObjetRecuperable) {
			((ObjetRecuperable) e).estRamasse(this);
		} else if (e instanceof Patient) {
			((Patient) e).action(this);
		} else if (e instanceof Sol) {
			joueur.deplacer(direction);
		} else if (e instanceof Trou) {
			joueur.deplacer(direction);
			arreterJeu();
		}

		repaint();
	}

	/**
	 * Augmente le score de 1
	 */
	public void augmenteScore() {
		score++;
		// Si le score augmente, on augmente la difficulte
		switch (score) {
		case 3:
			generateurPatient.chance = 25;
			Ecrivain.getInstance().setImage(Ressources.getImage("PatientPlus"),
					-0.7, -1.8);

			// Fenetre.ecrire("Attention plus de patients vont apparaitre!");
			break;
		case 5:
			generateurPatient.chance = 20;
			generateurPatient.chanceTrou=15;
			Ecrivain.getInstance().setImage(Ressources.getImage("PatientPlus"),
					-0.7, -1.8);
			// Fenetre.ecrire("Attention plus de patients vont apparaitre!");
			break;
		case 10:
			generateurPatient.chance = 19;
			generateurPatient.chanceTrou=10;

			Ecrivain.getInstance().setImage(Ressources.getImage("PatientPlus"),
					-0.7, -1.8);
			// Fenetre.ecrire("Attention plus de patients vont apparaitre!");
			break;
		case 15:
			generateurPatient.chance = 17;
			generateurPatient.chanceTrou=9;
			Ecrivain.getInstance().setImage(Ressources.getImage("PatientPlus"),
					-0.7, -1.8);
		
		}
		
	}

	/**
	 * Rajoute un objet a l'arrayList objetsRecuperes
	 * 
	 * @param a
	 *            :l'objet a rajouter
	 */
	public void addObjetListeObjetRecuperes(ObjetRecuperable a) {
		objetsRecuperes.add(a);
	}

	/**
	 * Supprime un objet de l'arrayList objetsRecuperes
	 * 
	 * @param a
	 *            : l'objet a supprimer
	 */
	public void removeObjetListeObjetRecuperes(ObjetRecuperable a) {
		objetsRecuperes.remove(a);
	}

	/**
	 * Supprime un objet de la carte et donc de l'arrayList listeElements
	 * 
	 * @param a
	 */
	public void removeObjet(ObjetRecuperable a) {
		listeElements.remove(a);
	}

	/**
	 * Ajoute un objet a la liste des elements
	 * 
	 * @param a
	 */
	public void addObjet(ObjetRecuperable a) {
		listeElements.add(a);
	}

	/**
	 * Supprime un patient de la liste des elements
	 * 
	 * @param a
	 */
	public void removePatient(Patient a) {
		listeElements.remove(a);
	}

	/** ajoute une bonne reponse a larraylist bonne reponse */
	public void addBonneReponse(ElementQuizz e) {
		listeBonnesReponses.add(e);
	}

	/** ajoute une mauvaise reponse a larraylist bonne reponse */
	public void addMauvaiseReponse(ElementQuizz e) {
		listeMauvaisesReponses.add(e);
	}

	/**
	 * Recupere lobjet qui appartient au bon patient grace a son ID depuis la
	 * liste des objets Recuperes
	 * 
	 * @param p
	 *            le patient dont on veut recuperer l'objet
	 * @return l'objet associe au bon patient
	 */
	public ObjetRecuperable recupererObjetDejaPris(Patient p) {

		for (ObjetRecuperable a : objetsRecuperes) {
			if (a.getProprietaire().getID() == p.getID()) {
				return a;
			}
		}
		return null;
	}

	/**
	 * Recupere l'Objet qui appartient au bon patient grace a son ID depuis la
	 * listeElements
	 */

	public ObjetRecuperable recupererObjetListeElements(Patient p) {
		for (ElementCarte a : listeElements) {
			if (a instanceof ObjetRecuperable) {
				if (((ObjetRecuperable) a).getProprietaire().getID() == p
						.getID()) {
					return (ObjetRecuperable) a;
				}
			}
		}
		return null;
	}

	/**
	 * Verifie si un objet qui appartient au patient entre en parametre est
	 * present dans la carte
	 * 
	 * @param p
	 *            : patient
	 * @return vrai si un objet appartenant a ce patient est present faux si il
	 *         n'y a pas d'objet appartenant a ce patient
	 */
	public boolean verifierProprietaire(Patient p) {

		for (ObjetRecuperable a : objetsRecuperes) {
			if (a.getProprietaire().getID() == p.getID()) {
				return true;
			}
		}

		return false;

	}

	/**
	 * Recupere un element sur la carte en fonction de ses coordonnees Si
	 * l'element n'apparait pas dans listeElements On verifie dans la liste des
	 * Sol
	 * 
	 * @param x
	 *            ligne
	 * @param y
	 *            colonne
	 * @return ElementCarte
	 */
	public ElementCarte recupererElement(int x, int y) {

		for (ElementCarte a : listeElements) {
			if (a.getPositionX() == x && a.getPositionY() == y) {
				return a;
			}
		}

		for (Sol a : lSol) {
			if (a.getPositionX() == x && a.getPositionY() == y) {
				return a;
			}
		}

		return null;
	}

	/**
	 * Recupere un element present dans la liste Elements en fonction de ses
	 * coordonnees
	 * 
	 * @param x
	 *            ligne
	 * @param y
	 *            colonne
	 * @return ElementCarte
	 */

	private ElementCarte getElement(int x, int y) {

		for (ElementCarte a : listeElements) {
			if (a.getPositionX() == x && a.getPositionY() == y) {
				return a;
			}
		}

		return null;
	}

	/**
	 * Arrete le generateur de patients
	 */
	public void arreterGenerateur() {
		generateurPatient.arret();
	}

	/**
	 * Instancie un nouveau Trou
	 * 
	 * @memo:Bug possible pour l'instant : boucle infinie si toutes les cases
	 *           sont deja remplies
	 */
	public void creerNouveauTrou() {
		if (!isFilled()) {
			boolean b = true;
			int positionXObjet = (int) (Math.random() * colonnes);
			int positionYObjet = (int) (Math.random() * lignes);
			while (b) {
				positionXObjet = (int) (Math.random() * colonnes);
				positionYObjet = (int) (Math.random() * lignes);
				// On verifie si il n'y a pas deja un objet dans cette case ==>
				// listeElements
				// si il n'y a rien (null) on sort de la boucle
				if (getElement(positionXObjet, positionYObjet) == null) {
					b = false;
				}
			}

			Trou p = new Trou(positionXObjet, positionYObjet);
			// Fenetre.ecrire("Attention!! Un Trou est apparu!");
			// Ecrivain.getInstance().setTxt("Attention!! Un Trou est apparu!",
			// positionXObjet, positionYObjet);

			listeElements.add(p);
		}else{
			arreterJeu();
		}
	}

	/**
	 * Instancie un nouveau patient
	 * 
	 * @memo:Bug possible pour l'instant : boucle infinie si toutes les cases
	 *           sont deja remplies
	 */
	public void creerNouveauPatient() {
		if (!isFilled()) {
			boolean b = true;
			int positionXObjet = (int) (Math.random() * colonnes);
			int positionYObjet = (int) (Math.random() * lignes);
			while (b) {
				positionXObjet = (int) (Math.random() * colonnes);
				positionYObjet = (int) (Math.random() * lignes);
				// On verifie si il n'y a pas deja un objet dans cette case ==>
				// listeElements
				// si il n'y a rien (null) on sort de la boucle
				if (getElement(positionXObjet, positionYObjet) == null) {
					b = false;
				}
			}

			Patient p = new Patient(positionXObjet, positionYObjet);
			// Fenetre.ecrire("Un Patient est apparu!");
			// Ecrivain.getInstance().setTxt("Un Patient est apparu!",
			// positionXObjet, positionYObjet);

			listeElements.add(p);
		}else{
			arreterJeu();
		}
	}

	/**
	 * Instancie un nouvel objet en relation avec le patient qui le cree
	 * 
	 * @memo:Bug possible pour l'instant : boucle infinie si toutes les cases
	 *           sont deja remplies
	 * @param p
	 *            patient qui cree l'objet
	 */
	public void creerNouvelObjet(Patient p) {
		if (!isFilled()) {
			boolean b = true;
			int positionXObjet = (int) (Math.random() * colonnes);
			int positionYObjet = (int) (Math.random() * lignes);

			while (b) {
				positionXObjet = (int) (Math.random() * colonnes);
				positionYObjet = (int) (Math.random() * lignes);
				// On verifie si il n'y a pas deja un objet dans cette case ==>
				// listeElements
				// si il n'y a rien (null) on sort de la boucle
				if (getElement(positionXObjet, positionYObjet) == null) {
					b = false;
				}
			}

			ObjetRecuperable[] listeObjet = {
					new Canne(positionXObjet, positionYObjet, p),
					new Infirmier(positionXObjet, positionYObjet, p),
					new Lunette(positionXObjet, positionYObjet, p),
					new Prothese(positionXObjet, positionYObjet, p),
					new ChienJaune(positionXObjet, positionYObjet, p),
					new ChienBlanc(positionXObjet, positionYObjet, p),
					new Balance(positionXObjet, positionYObjet, p),
					new Chapeau(positionXObjet, positionYObjet, p),
					new Clef(positionXObjet, positionYObjet, p),
					new Livre(positionXObjet, positionYObjet, p),
					new Ordinateur(positionXObjet, positionYObjet, p),
					new Telephone(positionXObjet, positionYObjet, p) };

			ObjetRecuperable a = choisirBonObjet(listeObjet, p);
			addObjet(a);
		}else{
			arreterJeu();
		}
	}

	/**
	 * Choisit un objet au hasard parmis les objets qui correspondent au
	 * handicap du patient
	 * 
	 * @param liste
	 * @return
	 */
	public ObjetRecuperable choisirBonObjet(ObjetRecuperable[] liste, Patient p) {
		// On cree une liste qui contient les objets recuperable ayant le meme
		// handicap que le patient
		ArrayList<ObjetRecuperable> temp = new ArrayList<ObjetRecuperable>();
		for (int i = 0; i < liste.length; i++) {
			if (liste[i].getHandicapAssocie().equalsIgnoreCase(p.getHandicap())) {
				temp.add(liste[i]);
			}
		}

		return temp.get((int) (temp.size() * Math.random()));
	}

	/**
	 * Verifier s'il y a deja un patient dans la carte
	 * 
	 * @return
	 */
	public boolean patientPresent() {
		for (ElementCarte a : listeElements) {
			if (a instanceof Patient) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifier si la carte n'est pas complete
	 * 
	 **/
	private boolean isFilled() {
		if (listeElements.size() < (colonnes * lignes))
			return false;

		return true;
	}

	/*
	 * Ne sert plus a rien puisque l'on n'utilise plus le terminal comme moyen
	 * d'affichage public String toString(){ String p = ""; //p = p +
	 * this.lignes + "\n" + this.colonnes + "\n" ;
	 * 
	 * p=p+"-----------------------" + "\n"; for(int i=0;i<lignes;i++){ for(int
	 * j=0;j<colonnes;j++){ //les Elements a afficher sont dans listeElement
	 * if(getElement(i,j) != null){ p=p+getElement(i,j).toString(); }else
	 * if(getElementS(i,j) != null){ p=p+getElementS(i,j).toString(); }
	 * 
	 * //saute une ligne if(j==colonnes-1){ p=p + "\n"; }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * p=p+"-----------------------" + "\n"; System.out.println(p); return p;
	 * 
	 * }
	 * 
	 * 
	 * private ElementCarte getElement(int x, int y){
	 * 
	 * for(ElementCarte a : listeElements){ if(a.getPositionX()==x &&
	 * a.getPositionY()==y){ return a; } }
	 * 
	 * 
	 * return null ; }
	 * 
	 * 
	 * 
	 * 
	 * private Sol getElementS(int x, int y) {
	 * 
	 * for(Sol a : lSol){ if(a.getPositionX()==x && a.getPositionY()==y){ return
	 * a; } }
	 * 
	 * return null ; }
	 */

	/**
	 * Compteur interne � la classe Carte. Il Permet de generer des patients
	 * aleatoirements
	 */
	private class Generateur extends Thread {

		/** Variable qui indique la chance de creer un patient */
		private int chance = 30;
		private int chanceTrou = 20;
		private boolean running = true;

		/**
		 * Permet de savoir si on a change le score pour ne pas le changer a
		 * chaque fois
		 */
		public Generateur() {
		}

		/** Arrete le timer */
		public void arret() {
			running = false;
		}

		public void run() {

			while (running) {
				genererPatient();
				genererTrou();
				supprimerTrou();
				repaint();
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void genererPatient() {
			// Une chance sur 30 de creer un patient
			int nbAleatoire = (int) (Math.random() * chance);

			if (nbAleatoire == 0) {
				creerNouveauPatient();
			}
		}

		public void genererTrou() {
			// Une chance sur 30 de creer un patient
			int nbAleatoire = (int) (Math.random() * chanceTrou);

			if (nbAleatoire == 1) { // on prend un autre nombreAleatoire, car le
									// temps n'est pas si aleatoire que ca..
									// vu que les 2 fontions se lancent en meme
									// temps
									// on creera souvent un Trou et un patient
									// en meme temps
				creerNouveauTrou();
			}
		}

		/** On supprimer le premier Trou */
		public void supprimerTrou() {
			for (ElementCarte e : listeElements) {
				if (e instanceof Trou) {
					((Trou) e).incremente();
					if (((Trou) e).getCompteur() == 10) {
						listeElements.remove(e);
						break;
					}
				}
			}
		}
	}

	public void arreterJeu() {
		arreterGenerateur();
		f.getChrono().stop();

		Main.setPane((new PanelScore(listeBonnesReponses,
				listeMauvaisesReponses)));

		// on recuperer la fenetre active
		Window x = KeyboardFocusManager.getCurrentKeyboardFocusManager()
				.getActiveWindow();
		try {
			if (x.getClass().getName().equals("quizz.Quizz")) {
				x.dispose();
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/*
	 * Getters et Setters
	 */

	public int getLignes() {
		return lignes;
	}

	public int getColonnes() {
		return colonnes;
	}

	public ArrayList<ElementCarte> getListeElements() {
		return listeElements;
	}

	public ArrayList<ObjetRecuperable> getObjetsRecuperes() {
		return objetsRecuperes;
	}

	public int getScore() {
		return score;
	}

	public PanelJeu getF() {
		return f;
	}

}
