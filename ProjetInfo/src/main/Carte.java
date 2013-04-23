package main;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JPanel;

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
import elementsCartes.PatientImmobile;
import elementsCartes.Prothese;
import elementsCartes.Sol;
import elementsCartes.Table;
import elementsCartes.Obstacle;

/**
 * Classe qui modelise le plateau du Jeu
 * @author Mehdi
 *
 */


//Sera plus tard un JPanel
public class Carte extends JPanel{
	  /**
	   * Caracteristiques de la carte
	   */
	  private int lignes = 10;  // nombre de lignes
	  private int colonnes=10;  // nombre de colonnes
	  public static final int COTE = 40; // Pour plus tard Taille des cases;  
	  
	  private Generateur generateurPatient = new Generateur(this);



	  private ArrayList<ElementCarte> listeElements;
	  private ArrayList<ObjetRecuperable> objetsRecuperes;
	  private ArrayList<Sol> lSol = new ArrayList<Sol>();
	  private Joueur joueur; 
	    
	  
	  
	  
		/**
		 * Constructeur
		 * Cree une carte avec ses objets et ses patients
		 */
	  public Carte(){
		listeElements = new ArrayList<ElementCarte>();
		objetsRecuperes = new ArrayList<ObjetRecuperable>();
		chargerCarte("map.txt"); 
		generateurPatient.start();
		
		
		this.setLayout(new FlowLayout());
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
		        		this.lignes=Integer.parseInt(l);
		        	}else if(ligneFichier==1){
		        		this.colonnes=Integer.parseInt(l);
		        		
		        		
		        		//Ajouter du sol partout
		        		  for(int k=0;k<lignes;k++){
		      	        	for(int j=0;j<colonnes;j++){
		      					lSol.add(new Sol(k,j));
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

			//repaint();
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
					listeElements.add(new PatientImmobile(j,positionLigne));
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
			}
		
			repaint();
	}


	
	
	
	
	
	public void addObjetRecuperable(ObjetRecuperable a){
		objetsRecuperes.add(a);
	}
	
	public void removeObjet(ObjetRecuperable a){
		listeElements.remove(a);
	}
	public void addObjet(ObjetRecuperable a){
		listeElements.add(a);
	}
	
	public void removePatient(Patient a){
		listeElements.remove(a);
	}
	
	/**Recupere lobjet qui appartient au bon patient
	 * 
	 * @param p
	 * @return
	 */
	public ObjetRecuperable getObjet(Patient p){
		
		for(ObjetRecuperable a : objetsRecuperes){
			if(a.getProprietaire().getID()==p.getID()){
				return a ; 
			}
		}
		return null; 
	}
	
	public boolean verifierProprietaire(Patient p){
		
		for(ObjetRecuperable a : objetsRecuperes){
			if(a.getProprietaire().getID()==p.getID()){
				return true;
			}
		}
		
		return false; 
		
	}
	

	
	
	private ElementCarte recupererElement(int x,int y){

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
		listeElements.add(p);
		System.out.println("PatientCree");
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
		ArrayList<ObjetRecuperable> l = new ArrayList<ObjetRecuperable>();
		for(int i=0;i<liste.length;i++){
			if(liste[i].getHandicapAssocie().equalsIgnoreCase(p.getHandicap())){
				l.add(liste[i]);
			}
		}
		
		return l.get((int) (l.size()*Math.random()));
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
	



	
}
