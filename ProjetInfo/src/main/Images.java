package main;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
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
    public static void chargerFichiers(){
    	
    	correspondanceFiles.add("Structure");
    	correspondanceFiles.add("niveau4");
    	correspondanceFiles.add("niveau1");
    	correspondanceFiles.add("niveau2");
    	correspondanceFiles.add("niveau3");


    	//url = Images.class.getResource(".././ressources/structure.xml");
    	//    	listeFiles.add((new File(url.getPath())));

    	listeFiles.add((new File("./src/ressources/structure.xml")));
    	listeFiles.add((new File("./src/ressources/niveau1.txt")));    	
    	listeFiles.add((new File("./src/ressources/niveau2.txt")));
    	listeFiles.add((new File("./src/ressources/niveau3.txt")));
    	listeFiles.add((new File("./src/ressources/niveau4.txt")));
    	
    }
    public static void chargerPolice(){
    	try
    	{
    	     File fontFile = new File("./src/ressources/QuicksandLight.ttf");
    	 
    	     quickSand = Font.createFont(Font.TRUETYPE_FONT, fontFile);
    	     quickSand = quickSand.deriveFont((float)25.0);
    	     
    	     
    	  
    	}	  
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }
    /**
     * Méthode qui charge les images dans une Array List
     *
     */
	public static void chargerImages(){
		
			 try {
				 
			 correspondance.add("BarreVide");
			 correspondance.add("Canne");
			 correspondance.add("Chaise");
			 correspondance.add("Infirmier");
			 correspondance.add("listeObjets");
			 correspondance.add("Lit");
			 correspondance.add("Logo");
			 correspondance.add("Box");
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/BarreVide.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Canne.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Chaise.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Infirmier.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/listeObjets.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Lit.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Logo.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Box.png")));

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
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Lunette.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Mur.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/niveau1.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/niveau2.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/niveau3.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/niveau4.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/petitBout.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/petitProgression.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Poutre.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Prothese.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Sol.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Table.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Trou.png")));   
			 
			 
			 correspondance.add("Patients/Patient1");
			 correspondance.add("Patients/Patient2");
			 correspondance.add("Patients/Patient3");
			 correspondance.add("Patients/Patient4");
			 correspondance.add("Patients/Patient5");
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Patients/Patient1.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Patients/Patient2.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Patients/Patient3.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Patients/Patient4.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Patients/Patient5.png")));  
			 correspondance.add("Patients/Patient1D");
			 correspondance.add("Patients/Patient2D");
			 correspondance.add("Patients/Patient3D");
			 correspondance.add("Patients/Patient4D");
			 correspondance.add("Patients/Patient5D");
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Patients/Patient1D.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Patients/Patient2D.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Patients/Patient3D.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Patients/Patient4D.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Patients/Patient5D.png")));  

			 correspondance.add("Personnage/Derriere1");
			 correspondance.add("Personnage/Derriere2");
			 correspondance.add("Personnage/Derriere3");
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Personnage/Derriere1.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Personnage/Derriere2.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Personnage/Derriere3.png")));
			 

			 correspondance.add("Personnage/Droit1");
			 correspondance.add("Personnage/Droit2");
			 correspondance.add("Personnage/Droit3");
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Personnage/Droit1.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Personnage/Droit2.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Personnage/Droit3.png")));

			 correspondance.add("Personnage/Face1");
			 correspondance.add("Personnage/Face2");
			 correspondance.add("Personnage/Face3");
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Personnage/Face1.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Personnage/Face2.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Personnage/Face3.png")));
			 

				
			 correspondance.add("Personnage/Gauche1");
			 correspondance.add("Personnage/Gauche2");
			 correspondance.add("Personnage/Gauche3");
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Personnage/Gauche1.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Personnage/Gauche2.png")));
			 listeImages.add(ImageIO.read(new File("./src/ressources/images/Personnage/Gauche3.png")));
			 
			 
		





				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


	}
}
