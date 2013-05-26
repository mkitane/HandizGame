package main;

import java.awt.Graphics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JPanel;

import quizz.ElementQuizz;

import elementsCartes.Canne;
import elementsCartes.Chaise;
import elementsCartes.ElementCarte;
import elementsCartes.Infirmier;
import elementsCartes.Joueur;
import elementsCartes.Lit;
import elementsCartes.Lunette;
import elementsCartes.Mur;
import elementsCartes.ObjetRecuperable;
import elementsCartes.Patient;
import elementsCartes.Prothese;
import elementsCartes.Sol;
import elementsCartes.Table;
import elementsCartes.Obstacle;
import elementsCartes.Poutre;
import elementsCartes.Trou;

/**
 * Classe qui modelise le plateau du Jeu
 */


public class Carte extends JPanel{
	  /**
	   * Caracteristiques de la carte
	   */
	  private int lignes = 15;  // nombre de lignes
	  private int colonnes=25;  // nombre de colonnes
	  public static final int COTE = 35; // Pour plus tard Taille des cases;  
	  public static String niveau = "niveau1.txt";
	  
	  private Generateur generateurPatient = new Generateur();
	  //Score de la partie
	  	//Augmente quand on rend un objet � un patient
	  	//Le temps quand � lui augmente quand on repond juste � une question et diminue quand on repond faux
	  private int score = 0 ; 

	  /**Liste des elements presents sur la carte*/
	  private ArrayList<ElementCarte> listeElements;
	  /**Liste des objets recuperes par le joueur*/
	  private ArrayList<ObjetRecuperable> objetsRecuperes;
	  /**Liste contenant le sol*/
	  private ArrayList<Sol> lSol = new ArrayList<Sol>();
	  /**Le Joueur*/
	  private Joueur joueur; 
	  
	  /**Permet de calculer les scores ensuite*/
	  private ArrayList<ElementQuizz> listeBonnesReponses = new ArrayList<ElementQuizz>(); 
	  private ArrayList<ElementQuizz> listeMauvaisesReponses= new ArrayList<ElementQuizz>();	  
	  
	  private Fenetre f; 
	  
	/**
	* Constructeur
	* Cree une carte avec ses objets et ses patients
	*/
	public Carte(Fenetre f){
		listeElements = new ArrayList<ElementCarte>();
		objetsRecuperes = new ArrayList<ObjetRecuperable>();
		chargerCarte(niveau); 
		generateurPatient.start();
		
		setBackground(Fenetre.GRIS);
		this.f=f;
	}

	
	
	
	/**Charge la Carte a partir d'un fichier txt
	 * 
	 * @param nomFichier
	 */
	private void chargerCarte(String nomFichier){
			
			//charger fichier
			try{
			  	BufferedReader br = new BufferedReader(new FileReader(new File(nomFichier))); 
		        String l ; 
		        int ligneFichier = 0 ;
		      
		        while ((l= br.readLine()) != null ) {
		        	if(ligneFichier==0){
		        		this.colonnes=Integer.parseInt(l);
		        	}else if(ligneFichier==1){
		        		this.lignes=Integer.parseInt(l);
		        		
		        		
		        		//Ajouter du sol partout
		        		  for(int k=0;k<lignes;k++){
		      	        	for(int j=0;j<colonnes;j++){
		      					lSol.add(new Sol(j,k));
		      	        	}
		      	        }
		        		
		        	}else {
		        		lireLigne(l,ligneFichier);
		        	}
		        	ligneFichier++;
		        }    
		        br.close() ;  
		    
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			System.out.println("--------------------------");
			System.out.println("ChargementFini");
			System.out.println("--------------------------");

			repaint();
		}

	
	
	/**Lis une ligne du fichier Txt
	 * 	
	 * @param l
	 * @param positionLigne
	 */
	private void lireLigne(String l,int positionLigne) {
			char c ; 
			positionLigne=positionLigne-2;
			for(int j=0;j<l.length();j++){
				c=l.charAt(j);
				//Action � effectuer selon l'objet, besoin de definir les objets que l'on mettra d'abord
				if(c=='D'){
					listeElements.add(new Chaise(j,positionLigne));
				}
				if(c=='L'){
					listeElements.add(new Lit(j,positionLigne));
				}
				if(c=='M'){
					listeElements.add(new Mur(j,positionLigne));
				}
				if(c=='Q'){
					listeElements.add(new Poutre(j,positionLigne));
				}
				if(c=='T'){
					listeElements.add(new Table(j,positionLigne));
				}
				if(c=='J'){
					joueur=new Joueur(j,positionLigne);
					listeElements.add(joueur);
				}
				//Pour les autres elements
				if(c=='P'){
					listeElements.add(new Patient(j,positionLigne));
				}
			
			}
	}

	
	
	


	/**Dessine la carte
	 * 
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		for(ElementCarte a : lSol){
			a.dessine(g);
		}
		for(ElementCarte a : listeElements){
			a.dessine(g);
		}
	}
	
	
	


	
	/**
	 * Methode assurant le deplacement du joueur en fonction d'une direction precisee
	 * 
	 * @param direction
	 */
	public void unDeplacementDeJoueur(int direction){
		

			ElementCarte e = null; 
			if(direction==Joueur.UP){
			e = recupererElement(joueur.getPositionX(),joueur.getPositionY()-1);
			}else if(direction==Joueur.DOWN){
			e = recupererElement(joueur.getPositionX(),joueur.getPositionY()+1);
			}else if(direction==Joueur.LEFT){
			e = recupererElement(joueur.getPositionX()-1,joueur.getPositionY());
			}else if(direction==Joueur.RIGHT){
			e = recupererElement(joueur.getPositionX()+1,joueur.getPositionY());
			}
			
			
			if(e instanceof Obstacle){

			}else if(e instanceof ObjetRecuperable){
							((ObjetRecuperable) e).estRamasse(this);				
			}else if(e instanceof Patient){
							((Patient)e).action(this);
			}else if(e instanceof Sol){ 
							joueur.deplacer(direction);
			}else if(e instanceof Trou){
							joueur.deplacer(direction);
							f.getChrono().mettreAZero();
			}
		
			repaint();
	}


	
	/**
	 * Augmente le score de 1 
	 */
	 public void augmenteScore(){
		 score++;
	 }
	  
	
	/**
	 * Rajoute un objet a l'arrayList objetsRecuperes
	 * @param a:l'objet a rajouter
	 */
	public void addObjetRecuperable(ObjetRecuperable a){
		objetsRecuperes.add(a);
	}
	/**
	 * Supprime un objet de l'arrayList objetsRecuperes
	 * @param a : l'objet a supprimer
	 */
	public void removeObjetListeObjetRecuperes(ObjetRecuperable a){
		objetsRecuperes.remove(a);
	}
	/**
	 * Supprime un objet de la carte et donc de l'arrayList listeElements
	 * @param a
	 */
	public void removeObjet(ObjetRecuperable a){
		listeElements.remove(a);
	}
	/**
	 * Ajoute un objet a la liste des elements
	 * @param a
	 */
	public void addObjet(ObjetRecuperable a){
		listeElements.add(a);
	}
	
	/**
	 * Supprime un patient de la liste des elements
	 * @param a
	 */
	public void removePatient(Patient a){
		listeElements.remove(a);
	}
	
	/**ajoute une bonne reponse a larraylist bonne reponse*/
	public void addBonneReponse(ElementQuizz e){
		listeBonnesReponses.add(e);
	}
	
	/**ajoute une mauvaise reponse a larraylist bonne reponse*/
	public void addMauvaiseReponse(ElementQuizz e){
		listeMauvaisesReponses.add(e);
	}
	
	
	
	/**Recupere lobjet qui appartient au bon patient grace a son ID
	 * 
	 * @param p le patient dont on veut recuperer l'objet
	 * @return l'objet associe au bon patient
	 */
	public ObjetRecuperable getObjet(Patient p){
		
		for(ObjetRecuperable a : objetsRecuperes){
			if(a.getProprietaire().getID()==p.getID()){
				return a ; 
			}
		}
		return null; 
	}
	
	/**
	 * Verifie si un objet qui appartient au patient entre en parametre est present dans la carte
	 * @param p :  patient 
	 * @return vrai si un objet appartenant a ce patient est present
	 * 			faux si il n'y a pas d'objet appartenant a ce patient
	 */
	public boolean verifierProprietaire(Patient p){
		
		for(ObjetRecuperable a : objetsRecuperes){
			if(a.getProprietaire().getID()==p.getID()){
				return true;
			}
		}
		
		return false; 
		
	}
	

	
	/**
	 * Recupere un element sur la carte en fonction de ses coordonnees
	 * Si l'element n'apparait pas dans listeElements
	 * On verifie dans la liste des Sol
	 * @param x ligne
	 * @param y colonne
	 * @return ElementCarte
	 */
	public ElementCarte recupererElement(int x,int y){

		for(ElementCarte a : listeElements){
			if(a.getPositionX()==x && a.getPositionY()==y){
				return a; 
				}
		}
		
		for(Sol a : lSol){
			if(a.getPositionX()==x && a.getPositionY()==y){
				return a; 
				}
		}

		
		return null ; 
	}


	/**
	 * Recupere un element present dans la liste Elements en fonction de ses coordonnees
	 * @param x ligne
	 * @param y colonne
	 * @return ElementCarte
	 */
	private ElementCarte getElement(int x, int y){

		for(ElementCarte a : listeElements){
			if(a.getPositionX()==x && a.getPositionY()==y){
				return a; 
				}
		}

		
		return null ; 
	}




	/*Getters et Setters
	 * 
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
	
	public int getScore(){
		  return score;
	}
	
	  public ArrayList<ElementQuizz> getListeBonnesReponses() {
		return listeBonnesReponses;
	}

	public Fenetre getF(){
		return f;
	}


	public ArrayList<ElementQuizz> getListeMauvaisesReponses() {
		return listeMauvaisesReponses;
	}


	
	 
	/**
	 * Arrete le generateur de patients
	 */
	public void arreterGenerateur() {
		generateurPatient.arret();
	}
	
	/**Instancie un nouveau Trou
	 * @memo:Bug possible pour l'instant : boucle infinie si toutes les cases sont deja remplies
	 */
	public void creerNouveauTrou(){
		boolean b=true;
		int positionXObjet= (int)(Math.random()*colonnes);
		int positionYObjet= (int)(Math.random()*lignes);
		while(b){
			positionXObjet = (int)(Math.random()*colonnes);
			positionYObjet = (int)(Math.random()*lignes);
			//On verifie si il n'y a pas deja un objet dans cette case ==> listeElements
			//si il n'y a rien (null) on sort de la boucle
			if(getElement(positionXObjet,positionYObjet)== null){
				b=false;
			}
		}
		
		
		Trou p = new Trou(positionXObjet,positionYObjet);
		Fenetre.ecrire("Attention!! Un Trou est apparu!");
		listeElements.add(p);
	}
	/**Instancie un nouveau patient
	 * @memo:Bug possible pour l'instant : boucle infinie si toutes les cases sont deja remplies
	 */
	public void creerNouveauPatient(){
		boolean b=true;
		int positionXObjet= (int)(Math.random()*colonnes);
		int positionYObjet= (int)(Math.random()*lignes);
		while(b){
			positionXObjet = (int)(Math.random()*colonnes);
			positionYObjet = (int)(Math.random()*lignes);
			//On verifie si il n'y a pas deja un objet dans cette case ==> listeElements
			//si il n'y a rien (null) on sort de la boucle
			if(getElement(positionXObjet,positionYObjet)== null){
				b=false;
			}
		}
		
		
		Patient p = new Patient(positionXObjet,positionYObjet);
		Fenetre.ecrire("Un Patient est apparu!");
		listeElements.add(p);
	}

	
	/**Instancie un nouvel objet en relation avec le patient qui le cree
	 * @memo:Bug possible pour l'instant : boucle infinie si toutes les cases sont deja remplies
	 * @param p patient qui cree l'objet
	 */
	public void creerNouvelObjet(Patient p){
		boolean b=true;
		int positionXObjet= (int)(Math.random()*colonnes);
		int positionYObjet= (int)(Math.random()*lignes);
		
		while(b){
			positionXObjet = (int)(Math.random()*colonnes);
			positionYObjet = (int)(Math.random()*lignes);
			//On verifie si il n'y a pas deja un objet dans cette case ==> listeElements
			//si il n'y a rien (null) on sort de la boucle
			if(getElement(positionXObjet,positionYObjet)== null){
				b=false;
			}
		}
		
		
		ObjetRecuperable[] listeObjet = {new Canne(positionXObjet,positionYObjet,p),new Infirmier(positionXObjet,positionYObjet,p),new Lunette(positionXObjet,positionYObjet,p),new Prothese(positionXObjet,positionYObjet,p)};
		
		addObjet(choisirBonObjet(listeObjet,p));
	}
	
	
	/**
	 * Choisit un objet au hasard parmis les objets qui correspondent au handicap du patient
	 * @param liste
	 * @return
	 */
	public ObjetRecuperable choisirBonObjet(ObjetRecuperable[] liste,Patient p){
		//On cree une liste qui contient les objets recuperable ayant le meme handicap que le patient
		ArrayList<ObjetRecuperable> temp = new ArrayList<ObjetRecuperable>();
		for(int i=0;i<liste.length;i++){
			if(liste[i].getHandicapAssocie().equalsIgnoreCase(p.getHandicap())){
				temp.add(liste[i]);
			}
		}
		
		return temp.get((int) (temp.size()*Math.random()));
	}
	
	
	/**
	 * Verifier s'il y a deja un patient dans la carte
	 * @return
	 */
	public boolean patientPresent(){
		for(ElementCarte a:listeElements){
			if(a instanceof Patient){
				return true;
			}
		}
		return false; 
	}
	
	
	

	
	/*Ne sert plus a rien puisque l'on n'utilise plus le terminal comme moyen d'affichage
	public String toString(){
			String p = ""; 
			//p = p + this.lignes + "\n" + this.colonnes + "\n" ; 
			
			p=p+"-----------------------" + "\n";
			for(int i=0;i<lignes;i++){
				for(int j=0;j<colonnes;j++){
					//les Elements a afficher sont dans listeElement
					if(getElement(i,j) != null){
						p=p+getElement(i,j).toString();
					}else if(getElementS(i,j) != null){
						p=p+getElementS(i,j).toString();
					}
						
					//saute une ligne
					if(j==colonnes-1){
						p=p + "\n";
					}
					
				}
				
			}
			
			p=p+"-----------------------" + "\n";
			System.out.println(p);
			return p;
			
	}


	private ElementCarte getElement(int x, int y){

			for(ElementCarte a : listeElements){
				if(a.getPositionX()==x && a.getPositionY()==y){
					return a; 
					}
			}

			
			return null ; 
	}
	
	


	private Sol getElementS(int x, int y) {
		
		for(Sol a : lSol){
			if(a.getPositionX()==x && a.getPositionY()==y){
				return a; 
				}
		}

		return null ; 
	}

	*/
	  
	
	 
	
	  /**Compteur interne � la classe Carte.
	  * Il Permet de generer des patients aleatoirements
	  */
	  private class Generateur extends Thread{

			/**Variable qui indique la chance de creer un patient*/
			private int chance = 30 ; 
			private int chanceTrou=20;
			private boolean running = true;

			
			public Generateur(){}

			/**Arrete le timer*/
			public void arret(){
				running = false;
			}
			
			
			public void run() {

				while(running){
					genererPatient();
					genererTrou();
					supprimerTrou();
					changerScore();
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}	
			
			
			public void genererPatient(){
				//Une chance sur 30 de creer un patient
				int nbAleatoire = (int) (Math.random()*chance);

				if(nbAleatoire == 0){
					creerNouveauPatient();
					repaint();
				}
			}
			
			
			public void genererTrou(){
				//Une chance sur 30 de creer un patient
				int nbAleatoire = (int) (Math.random()*chanceTrou);

				if(nbAleatoire == 1){
					creerNouveauTrou();
					repaint();
				}				
			}
			
			
			/**On supprimer le premier Trou */
			public void supprimerTrou(){		
						for(ElementCarte e : listeElements){
							if(e instanceof Trou){
								((Trou) e).incremente();
								if(((Trou) e).getCompteur()==10){
									listeElements.remove(e);
									repaint();
									break;
								}
							}
						}
			}
			
			
			public void changerScore(){
				//Si le score augmente, on augmente la difficulte
				switch(score){
					case 5 :chance=25;
							Fenetre.ecrire("Attention plus de patients vont apparaitre!");
							break;
					case 10 :chance=20;
							Fenetre.ecrire("Attention plus de patients vont apparaitre!");
							break;
					case 15 :chance=15;
							Fenetre.ecrire("Attention plus de patients vont apparaitre!");
							break;
					case 20 :chance=10;
							Fenetre.ecrire("Attention plus de patients vont apparaitre!");
							break;					
				}
			}
			
		
		
			

		}

	
}
