package main;

import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import elementsCartes.Box;
import elementsCartes.Chaise;
import elementsCartes.ElementCarte;
import elementsCartes.Joueur;
import elementsCartes.Lit;
import elementsCartes.Mur;
import elementsCartes.Patient;
import elementsCartes.Poutre;
import elementsCartes.Sol;
import elementsCartes.Table;
/**
 * Permet de charger en mémoire les différents éléments du jeu
 *
 */
public class Ressources {
    //Corriger Bug heap space, trop de truc charges en memoire
    /**ArrayList qui contient toutes les images*/
    private static ArrayList<Image> listeImages = new ArrayList<Image>() ; 
    /**ArrayList qui contient les noms des images pour une correspondance*/
    private static ArrayList<String> correspondance = new ArrayList<String>();
    private static ArrayList<ArrayList<ElementCarte>> listeNiveaux = new ArrayList<ArrayList<ElementCarte>>();
    private static ArrayList<String> correspondanceNiveaux = new ArrayList<String>();
    private static  InputStream fichierXml ; 
    private static Font quickSand;
	

    public static Image getImage(String nom){
    	return listeImages.get(correspondance.indexOf(nom));
    }
    /**
	 *Méthode qui charge le fichiers polices.
	 *
	 *
	 */
    public static ArrayList<ElementCarte> getNiveau(String nom){
    	return listeNiveaux.get(correspondanceNiveaux.indexOf(nom));
    }
    
    
    public static Font getQuickSand(){
    	return quickSand;
    }
    
    public static InputStream getFichierXml(){
    	return fichierXml;
    }
    
    
    
    
    
    
    
    
    public static void chargerXML(){
		 fichierXml = Ressources.class.getResourceAsStream("structure.xml");
    }
    
    
    
    /**On met tous les niveaux en m�moire sous forme d'arrayList*/
    public static void chargerNiveaux() {
    	//correspondanceNiveaux.add("Structure");
    	correspondanceNiveaux.add("niveau1");
    	correspondanceNiveaux.add("niveau2");
    	correspondanceNiveaux.add("niveau3");
    	correspondanceNiveaux.add("niveau4");


    
    
		listeNiveaux.add(chargerNiveau("niveau1.txt"));
		listeNiveaux.add(chargerNiveau("niveau2.txt"));
		listeNiveaux.add(chargerNiveau("niveau3.txt"));
		listeNiveaux.add(chargerNiveau("niveau4.txt"));
    }
    
    
    
    /**On charge un niveau et on le met en m�moire*/
    
    private static ArrayList<ElementCarte> chargerNiveau(String nomFichier){
    	ArrayList<ElementCarte> lElements = new ArrayList<ElementCarte>();
    	//charger fichier
		try{
	    	InputStream fichierLvl = Ressources.class.getResourceAsStream(nomFichier);
			InputStreamReader isr = new InputStreamReader(fichierLvl);
		  	BufferedReader br = new BufferedReader(isr); 
	        String l ; 
	        int ligneFichier = 0 ;
	      
	      
  		  
	        while ((l= br.readLine()) != null ) {
	        		lireLigne(l,ligneFichier,lElements);
		        	ligneFichier++;
	        }
	        
	        isr.close();
	        br.close() ;  
	    
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return lElements ; 
    }
    
    /**Lis une ligne du fichier Txt et met les elements dans arrayList d'elements
	 * 	
	 * @param l
	 * @param positionLigne
	 */
	private static void lireLigne(String l,int positionLigne,ArrayList<ElementCarte> lElements) {
			char c ; 
			for(int j=0;j<l.length();j++){
				c=l.charAt(j);
				//Action a effectuer selon l'objet, besoin de definir les objets que l'on mettra d'abord
				if(c=='C'){
					lElements.add(new Chaise(j,positionLigne));
				}
				if(c=='B'){
					lElements.add(new Box(j,positionLigne));
				}
				if(c=='L'){
					lElements.add(new Lit(j,positionLigne));
				}
				if(c=='M'){
					lElements.add(new Mur(j,positionLigne));
				}
				if(c=='Q'){
					lElements.add(new Poutre(j,positionLigne));
				}
				if(c=='T'){
					lElements.add(new Table(j,positionLigne));
				}
				if(c=='J'){
					lElements.add(new Joueur(j,positionLigne));
				}
				//Pour les autres elements
				if(c=='P'){
					lElements.add(new Patient(j,positionLigne));
				}
			
			}
	}

	
    
    
    
    
    
    
    
    
    
    
    
    
    public static void chargerPolice(){
    	try
    	{
    		
    		 InputStream fontFile = Ressources.class.getResourceAsStream("QuicksandLight.ttf");
    	 
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
	public static void chargerImages(){
		
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
			 
			 InputStream fichier = Ressources.class.getResourceAsStream("images/BarreVide.png");
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
			 
			 fichier = Ressources.class.getResourceAsStream("images/Infirmier.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/listeObjets.png");
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
			 fichier = Ressources.class.getResourceAsStream("images/Lunette.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Mur.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/niveau1.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/niveau2.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/niveau3.png");
			 listeImages.add(ImageIO.read(fichier));

			 fichier = Ressources.class.getResourceAsStream("images/niveau4.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/petitBout.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/petitProgression.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Poutre.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Prothese.png");
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
			 
			 fichier = Ressources.class.getResourceAsStream("images/Patients/Patient1.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Patients/Patient2.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Patients/Patient3.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Patients/Patient4.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Patients/Patient5.png");
			 listeImages.add(ImageIO.read(fichier));

			 

			 correspondance.add("Personnage/Derriere1");
			 correspondance.add("Personnage/Derriere2");
			 correspondance.add("Personnage/Derriere3");
			 fichier = Ressources.class.getResourceAsStream("images/Personnage/Derriere1.png");
			 listeImages.add(ImageIO.read(fichier));

			 fichier = Ressources.class.getResourceAsStream("images/Personnage/Derriere2.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Personnage/Derriere3.png");
			 listeImages.add(ImageIO.read(fichier));
			 

			 correspondance.add("Personnage/Droit1");
			 correspondance.add("Personnage/Droit2");
			 correspondance.add("Personnage/Droit3");
			 
			 fichier = Ressources.class.getResourceAsStream("images/Personnage/Droit1.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Personnage/Droit2.png");
			 listeImages.add(ImageIO.read(fichier));

			 fichier = Ressources.class.getResourceAsStream("images/Personnage/Droit3.png");
			 listeImages.add(ImageIO.read(fichier));

			 correspondance.add("Personnage/Face1");
			 correspondance.add("Personnage/Face2");
			 correspondance.add("Personnage/Face3");
			 
			 fichier = Ressources.class.getResourceAsStream("images/Personnage/Face1.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Personnage/Face2.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Personnage/Face3.png");
			 listeImages.add(ImageIO.read(fichier));
			 

				
			 correspondance.add("Personnage/Gauche1");
			 correspondance.add("Personnage/Gauche2");
			 correspondance.add("Personnage/Gauche3");
			 
			 fichier = Ressources.class.getResourceAsStream("images/Personnage/Gauche1.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Personnage/Gauche2.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 fichier = Ressources.class.getResourceAsStream("images/Personnage/Gauche3.png");
			 listeImages.add(ImageIO.read(fichier));
			 
			 
		





				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


	}
}
