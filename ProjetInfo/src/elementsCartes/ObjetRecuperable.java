package elementsCartes;

import main.Carte;
import quizz.Quizz;

/**
 * Classe qui modelise un ObjetRecuperable. Ne peux etre instanciee directement.
 * 
 */
public abstract class ObjetRecuperable extends ElementCarte {
	/**
	 * Chaque objet possede un patient qui l'instancie, d'ou la variable
	 * proprietaire. Elle permet de reconnaitre le proprietaire de chaque Objet.
	 */
	private Patient proprietaire;
	/**
	 * Chaque objet est associe a un handicap, ce qui permet a chaque patient
	 * d'instancier un objet qui possede le meme handicap que lui.
	 */
	private String handicapAssocie;
	/** Boolean qui Permet de ne pas lancer plusieurs Quizz */
	private boolean verificateur = true;

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
	public ObjetRecuperable(int positionX, int positionY, String nomImage,
			Patient p) {
		super(positionX, positionY, nomImage);
		proprietaire = p;
	}

	/*
	 * A faire : action que l'on effectue quand on touche un Objet
	 * 
	 * -repondre a un Quizz
	 * 
	 * -Si bonne reponse, mettre lobjet dans larrayList Objetrecupere et Gain de
	 * Temps et lenlever de larrayList ListElement(disparait de lecran) -si
	 * mauvaise reponse, enlever le patient de l'arrayList et perte de temps et
	 * enlever lobjet de larrayList listeElements et ne rien ajouter dans
	 * larrayList ObjetRecupere (chrono.setTime(chrono.getTime()-5));
	 */
	/**
	 * Action effectuee quand un objet est ramasse
	 * 
	 * @param c
	 *            : Carte que l'on modifie
	 */
	public void estRamasse(Carte c) {
		if (verificateur) {
			String theme = proprietaire.getHandicap();
			new Quizz(theme, c, this);
			verificateur = false;
		} else {
			// Fenetre.ecrire("Veuillez repondre au quizz que vous avez deja lance");
		}
	}

	/* Getters et setters */
	/**Recupere le Proprietaire*/
	public Patient getProprietaire() {
		return proprietaire;
	}

	/**Recupere le handicap associe*/
	public String getHandicapAssocie() {
		return handicapAssocie;
	}

	/**Associe a l'objet un theme*/
	protected void setThemeAssocie(String handicapAssocie) {
		this.handicapAssocie = handicapAssocie;
	}

}
