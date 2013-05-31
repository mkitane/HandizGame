package main;

import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
/**
 * Permet de charger en mémoire les différents éléments du jeu
 *
 */
public class Images {
    //Corriger Bug heap space, trop de truc charges en memoire
    /**ArrayList qui contient toutes les images*/
    public final static ArrayList<Image> listeImages = new ArrayList<Image>() ; 
    /**ArrayList qui contient les noms des images pour une correspondance*/
    public final static ArrayList<String> correspondance = new ArrayList<String>();
    public final static ArrayList<File> listeFiles = new ArrayList<File>();
    public final static ArrayList<String> correspondanceFiles = new ArrayList<String>();
    public static Font quickSand;
	

    public static Image get(String nom){
    	return listeImages.get(correspondance.indexOf(nom));
    }
    /**
	 *Méthode qui charge le fichiers polices.
	 *
	 *
	 */
    public static File getFile(String nom){
    	return listeFiles.get(correspondanceFiles.indexOf(nom));
    }
    public static void chargerFichiers() throws URISyntaxException{
    	
    	correspondanceFiles.add("Structure");
    	correspondanceFiles.add("niveau1");
    	correspondanceFiles.add("niveau2");
    	correspondanceFiles.add("niveau3");
    	correspondanceFiles.add("niveau4");


    
    	
    	
    	File fichier = new File(Images.class.getResource(".././ressources/structure.xml").toURI());
		listeFiles.add(fichier);
		
		fichier = new File(Images.class.getResource(".././ressources/niveau1.txt").toURI());
		listeFiles.add(fichier);

		fichier = new File(Images.class.getResource(".././ressources/niveau2.txt").toURI());
		listeFiles.add(fichier);
		
		fichier = new File(Images.class.getResource(".././ressources/niveau3.txt").toURI());
		listeFiles.add(fichier);
		
		fichier = new File(Images.class.getResource(".././ressources/niveau4.txt").toURI());
		listeFiles.add(fichier);
	
    
    }
    public static void chargerPolice(){
    	try
    	{
    		
    		 File fontFile = new File(Images.class.getResource(".././ressources/QuicksandLight.ttf").toURI());
    	 
    	     quickSand = Font.createFont(Font.TRUETYPE_FONT, fontFile);
    	     quickSand = quickSand.deriveFont((float)25.0);
    	     
    	     
    	  
    	}	  
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }
    /**
     * Méthode qui charge les images dans une Array List
     * @throws URISyntaxException 
     *
     */
	public static void chargerImages() throws URISyntaxException{
		
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
			 
			 File fichier = new File(Images.class.getResource(".././ressources/images/BarreVide.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Bulle1.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 fichier = new File(Images.class.getResource(".././ressources/images/Bulle2.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 fichier = new File(Images.class.getResource(".././ressources/images/Bulle3.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 fichier = new File(Images.class.getResource(".././ressources/images/Bulle4.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Canne.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Chaise.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Infirmier.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/listeObjets.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Lit.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Logo.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Box.png").toURI());
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
			 fichier = new File(Images.class.getResource(".././ressources/images/Lunette.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Mur.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/niveau1.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/niveau2.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/niveau3.png").toURI());
			 listeImages.add(ImageIO.read(fichier));

			 fichier = new File(Images.class.getResource(".././ressources/images/niveau4.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/petitBout.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/petitProgression.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Poutre.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Prothese.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Sol.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Table.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Trou.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 
			 correspondance.add("Patients/Patient1");
			 correspondance.add("Patients/Patient2");
			 correspondance.add("Patients/Patient3");
			 correspondance.add("Patients/Patient4");
			 correspondance.add("Patients/Patient5");
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Patients/Patient1.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Patients/Patient2.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Patients/Patient3.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Patients/Patient4.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Patients/Patient5.png").toURI());
			 listeImages.add(ImageIO.read(fichier));

			 

			 correspondance.add("Personnage/Derriere1");
			 correspondance.add("Personnage/Derriere2");
			 correspondance.add("Personnage/Derriere3");
			 fichier = new File(Images.class.getResource(".././ressources/images/Personnage/Derriere1.png").toURI());
			 listeImages.add(ImageIO.read(fichier));

			 fichier = new File(Images.class.getResource(".././ressources/images/Personnage/Derriere2.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Personnage/Derriere3.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 

			 correspondance.add("Personnage/Droit1");
			 correspondance.add("Personnage/Droit2");
			 correspondance.add("Personnage/Droit3");
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Personnage/Droit1.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Personnage/Droit2.png").toURI());
			 listeImages.add(ImageIO.read(fichier));

			 fichier = new File(Images.class.getResource(".././ressources/images/Personnage/Droit3.png").toURI());
			 listeImages.add(ImageIO.read(fichier));

			 correspondance.add("Personnage/Face1");
			 correspondance.add("Personnage/Face2");
			 correspondance.add("Personnage/Face3");
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Personnage/Face1.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Personnage/Face2.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Personnage/Face3.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 

				
			 correspondance.add("Personnage/Gauche1");
			 correspondance.add("Personnage/Gauche2");
			 correspondance.add("Personnage/Gauche3");
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Personnage/Gauche1.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Personnage/Gauche2.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = new File(Images.class.getResource(".././ressources/images/Personnage/Gauche3.png").toURI());
			 listeImages.add(ImageIO.read(fichier));
			 
			 
		





				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


	}
}
