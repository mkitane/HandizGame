package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Permet de charger en mémoire les différents éléments du jeu
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

	public static Image getImage(String nom) {
		return listeImages.get(correspondance.indexOf(nom));
	}

	public static Font getQuickSand() {
		return quickSand;
	}

	public static InputStream getFichierXml() {
		return fichierXml;
	}

	public static void chargerXML() {
		fichierXml = Ressources.class.getResourceAsStream("structure.xml");
	}

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
	 * Méthode qui charge les images dans une Array List
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

			correspondance.add("Canne");
			correspondance.add("Chaise");
			correspondance.add("Infirmier");
			correspondance.add("listeObjets");
			correspondance.add("Lit");
			correspondance.add("Logo");
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

			fichier = Ressources.class.getResourceAsStream("images/Canne.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Chaise.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/Infirmier.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class
					.getResourceAsStream("images/listeObjets.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Lit.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Logo.png");
			listeImages.add(ImageIO.read(fichier));

			fichier = Ressources.class.getResourceAsStream("images/Box.png");
			listeImages.add(ImageIO.read(fichier));

			correspondance.add("Lunette");
			correspondance.add("Mur");
			correspondance.add("niveau1");
			correspondance.add("niveau2");
			correspondance.add("niveau3");
			correspondance.add("niveau4");
			correspondance.add("petitBout");
			correspondance.add("petitProgression");
			correspondance.add("Poutre");
			correspondance.add("Prothese");
			correspondance.add("Sol");
			correspondance.add("Table");
			correspondance.add("Trou");
			fichier = Ressources.class
					.getResourceAsStream("images/Lunette.png");
			listeImages.add(ImageIO.read(fichier));

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

			fichier = Ressources.class
					.getResourceAsStream("images/Prothese.png");
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

			correspondance.add("Chien1");
			correspondance.add("Chien2");

			fichier = Ressources.class.getResourceAsStream("images/Chien1.png");
			listeImages.add(ImageIO.read(fichier));
			fichier = Ressources.class.getResourceAsStream("images/Chien2.png");
			listeImages.add(ImageIO.read(fichier));

			correspondance.add("TrouPlus");
			correspondance.add("PatientPlus");

			fichier = Ressources.class
					.getResourceAsStream("images/TrouPlus.png");
			listeImages.add(ImageIO.read(fichier));
			fichier = Ressources.class
					.getResourceAsStream("images/PatientPlus.png");
			listeImages.add(ImageIO.read(fichier));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
