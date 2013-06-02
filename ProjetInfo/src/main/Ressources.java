package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Permet de charger en memoire les differents elements du jeu
 * 
 */
public class Ressources {
	// Corriger Bug heap space, trop de truc charges en memoire
	/** ArrayList qui contient toutes les images */
	private static ArrayList<Image> listeImages = new ArrayList<Image>();
	/** ArrayList qui contient les noms des images pour une correspondance */
	private static ArrayList<String> correspondance = new ArrayList<String>();
	private static InputStream fichierXml;
	private static Font quickSand;
	public static final Color GRIS = Color.getHSBColor(Float.parseFloat("27"),
			Float.parseFloat("0.08"), Float.parseFloat("0.42"));

	/**
	 * Recupere L'image voulue
	 * @param nom
	 * @return
	 */
	public static Image getImage(String nom) {
		return listeImages.get(correspondance.indexOf(nom));
	}

	/**
	 * Recupere la police QuickSand
	 * @return
	 */
	public static Font getQuickSand() {
		return quickSand;
	}

	/**
	 * Recupere le Fichier Xml strucure
	 * @return
	 */
	public static InputStream getFichierXml() {
		return fichierXml;
	}

	/**
	 * Methode qui charge le fichier xml
	 */
	public static void chargerXML() {
		fichierXml = Ressources.class.getResourceAsStream("structure.xml");
	}

	/**
	 * Charge les polices d'ecriture
	 */
	public static void chargerPolice() {
		try {

			InputStream fontFile = Ressources.class
					.getResourceAsStream("QuicksandLight.ttf");

			quickSand = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			quickSand = quickSand.deriveFont((float) 25.0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methode qui charge les images dans une Array List
	 * 
	 * @throws URISyntaxException
	 * 
	 */
	public static void chargerImages() {

		try {

			correspondance.add("BarreVide");
			correspondance.add("Bulle1");
			correspondance.add("Bulle2");
			correspondance.add("Bulle3");
			correspondance.add("Bulle4");

			correspondance.add("Chaise");
			correspondance.add("listeObjets");
			correspondance.add("Lit");
			correspondance.add("Box");

			InputStream fichier = Ressources.class
					.getResourceAsStream("images/BarreVide.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Bulle1.png");
			listeImages.add(ImageIO.read(fichier));
			fichier = Ressources.class.getResourceAsStream("images/Bulle2.png");
			listeImages.add(ImageIO.read(fichier));
			fichier = Ressources.class.getResourceAsStream("images/Bulle3.png");
			listeImages.add(ImageIO.read(fichier));
			fichier = Ressources.class.getResourceAsStream("images/Bulle4.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Chaise.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/listeObjets.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Lit.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Box.png");
			listeImages.add(ImageIO.read(fichier));

			correspondance.add("Mur");
			correspondance.add("niveau1");
			correspondance.add("niveau2");
			correspondance.add("niveau3");
			correspondance.add("niveau4");
			correspondance.add("petitBout");
			correspondance.add("petitProgression");
			correspondance.add("Poutre");
			correspondance.add("Sol");
			correspondance.add("Table");
			correspondance.add("Trou");

			fichier = Ressources.class.getResourceAsStream("images/Mur.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/niveau1.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/niveau2.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/niveau3.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/niveau4.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/petitBout.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/petitProgression.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Poutre.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Sol.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Table.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Trou.png");
			listeImages.add(ImageIO.read(fichier));

			correspondance.add("Patients/Patient1");
			correspondance.add("Patients/Patient2");
			correspondance.add("Patients/Patient3");
			correspondance.add("Patients/Patient4");
			correspondance.add("Patients/Patient5");

			fichier = Ressources.class
					.getResourceAsStream("images/Patients/Patient1.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Patients/Patient2.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Patients/Patient3.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Patients/Patient4.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Patients/Patient5.png");
			listeImages.add(ImageIO.read(fichier));

			correspondance.add("Personnage/Derriere1");
			correspondance.add("Personnage/Derriere2");
			correspondance.add("Personnage/Derriere3");
			fichier = Ressources.class
					.getResourceAsStream("images/Personnage/Derriere1.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Personnage/Derriere2.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Personnage/Derriere3.png");
			listeImages.add(ImageIO.read(fichier));

			correspondance.add("Personnage/Droit1");
			correspondance.add("Personnage/Droit2");
			correspondance.add("Personnage/Droit3");

			fichier = Ressources.class
					.getResourceAsStream("images/Personnage/Droit1.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Personnage/Droit2.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Personnage/Droit3.png");
			listeImages.add(ImageIO.read(fichier));

			correspondance.add("Personnage/Face1");
			correspondance.add("Personnage/Face2");
			correspondance.add("Personnage/Face3");

			fichier = Ressources.class
					.getResourceAsStream("images/Personnage/Face1.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Personnage/Face2.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Personnage/Face3.png");
			listeImages.add(ImageIO.read(fichier));

			correspondance.add("Personnage/Gauche1");
			correspondance.add("Personnage/Gauche2");
			correspondance.add("Personnage/Gauche3");

			fichier = Ressources.class
					.getResourceAsStream("images/Personnage/Gauche1.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Personnage/Gauche2.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Personnage/Gauche3.png");
			listeImages.add(ImageIO.read(fichier));

			correspondance.add("Check");
			correspondance.add("Cross");
			correspondance.add("Amis");

			fichier = Ressources.class.getResourceAsStream("images/Check.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Cross.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Amis.png");
			listeImages.add(ImageIO.read(fichier));

			correspondance.add("PatientPlus");

			fichier = Ressources.class
					.getResourceAsStream("images/PatientPlus.png");
			listeImages.add(ImageIO.read(fichier));

			correspondance.add("PanneauPrincipal");
			fichier = Ressources.class
					.getResourceAsStream("images/PanneauPrincipal.png");
			listeImages.add(ImageIO.read(fichier));

			correspondance.add("Canne");
			correspondance.add("Infirmier");
			correspondance.add("Lunette");
			correspondance.add("Prothese");
			correspondance.add("Chien1");
			correspondance.add("Chien2");
			correspondance.add("Balance");
			correspondance.add("Chapeau");
			correspondance.add("Clef");
			correspondance.add("Livre");
			correspondance.add("Ordinateur");
			correspondance.add("Telephone");

			fichier = Ressources.class
					.getResourceAsStream("images/Objets/Canne.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Objets/Infirmier.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Objets/Lunette.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Objets/Prothese.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Objets/Chien1.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Objets/Chien2.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Objets/Balance.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Objets/Chapeau.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Objets/Clef.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Objets/Livre.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Objets/Ordinateur.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Objets/Telephone.png");
			listeImages.add(ImageIO.read(fichier));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
