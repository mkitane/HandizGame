package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import elementsCartes.*;


/**
 * Classe qui modelise le plateau du Jeu
 * @author Mehdi
 *
 */


//Sera plus tard un JPanel
public class Carte extends JPanel implements ActionListener{
	  /**
	   * Caracteristiques de la carte
	   */
	  private int lignes = 10;  // nombre de lignes
	  private int colonnes=10;  // nombre de colonnes
	  private int cote = 20; // Pour plus tard Taille des cases;  
	  
	  
	  private Timer compteur = new Timer(1000,this);
	  //Pourquoi ne marche pas sans ca? 
	  //private Compteur chrono = new Compteur("100");
	  private ArrayList<ElementCarte> listeElements;
	  private ArrayList<ObjetRecuperable> objetsRecuperes;
	  private ArrayList<Patient> listePatients; 
	  private ArrayList<Sol> lSol = new ArrayList<Sol>();
	  private Joueur joueur; 
	    
	  
	  
	  
		/**
		 * Constructeur
		 * Cree une carte avec ses objets et ses patients
		 */
	  public Carte(){
		listeElements = new ArrayList<ElementCarte>();
		objetsRecuperes = new ArrayList<ObjetRecuperable>();
		//listePatients = new ArrayList<Patient>();
		
		compteur.start();
		chargerCarte("map.txt"); 
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
					listeElements.add(new Chaise(positionLigne,j));
				}
				if(c=='L'){
					listeElements.add(new Lit(positionLigne,j));
				}
				if(c=='M'){
					listeElements.add(new Mur(positionLigne,j));
				}
				if(c=='Q'){
					listeElements.add(new PatientImmobile(positionLigne,j));
				}
				if(c=='T'){
					listeElements.add(new Table(positionLigne,j));
				}
				if(c=='J'){
					joueur=new Joueur(positionLigne,j);
					listeElements.add(joueur);
				}
				//Pour les autres elements
				if(c=='P'){
					listeElements.add(new Patient(positionLigne,j));
				}
			
			}
	}

	
	
	


	/**Affiche le jeu sur le terminal 
	 * 
	 */
	public void paintComponent(Graphics g){
		//p = p + this.lignes + "\n" + this.colonnes + "\n" ; 
		int f = 10;
		String p = ""; 

		
		g.drawString("----------", 10, f);
		
		for(int i=0;i<lignes;i++){
			for(int j=0;j<colonnes;j++){
				//les Elements � afficher sont dans listeElement
				if(getElement(i,j) != null){
					p=p+getElement(i,j).toString();
				}else if(getElementS(i,j) != null){
					p=p+getElementS(i,j).toString();
				}
					
				//saute une ligne
				if(j==colonnes-1){
					f+=20;
					g.drawString(p,10,f);
					p = "";
				}
				
			}
			
		}
		
		g.drawString("-------------", 10, f);
	
	}
	
	public String toString(){
			String p = ""; 
			//p = p + this.lignes + "\n" + this.colonnes + "\n" ; 
			
			p=p+"-----------------------" + "\n";
			for(int i=0;i<lignes;i++){
				for(int j=0;j<colonnes;j++){
					//les Elements � afficher sont dans listeElement
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

	
	




	
	/**
	 * Methode assurant le deplacement du joueur en fonction d'une direction precisee
	 * 
	 * @param direction
	 */
	public void unDeplacementDeJoueur(int direction){
		
		/*Ne pas oublier de creer un Patient grace au ActionPerformed qui lancera cette
		 *  methode de maniere Aleatoire @MEMO : Comment faire le lien entre Chrono et jeu
		 *  cad ajouter un patient depuis lactionPerformed, alors que la classe Quizz nest pas instanciee??
		 *  Passage par une arrayList static?
		 *  ou instanciation de carte et de chrono en parallele et non imbrique(pas chrono instanciee dans carte)
		 *  Probleme resolu (?) : Passage par un timer directement implante dans la classe Carte  
		 *  
		*Au debut 1 chance sur 100 (par exemple)
		*puis une chance sur 90 etc.. (fonction de la difficulte)
		*
		* Pour les fonctionnalite apres : ne pas oublier de commenter si j'ai fait une erreur ou oublie 
		*une action que l'on doit faire ;)
		*/
			ElementCarte e = null; 
			if(direction==Joueur.UP){
			e = recupererElement(joueur.getPositionX(),joueur.getPositionY()+1);
			}else if(direction==Joueur.DOWN){
			e = recupererElement(joueur.getPositionX(),joueur.getPositionY()-1);
			}else if(direction==Joueur.LEFT){
			e = recupererElement(joueur.getPositionX()-1,joueur.getPositionY());
			}else if(direction==Joueur.RIGHT){
			e = recupererElement(joueur.getPositionX()+1,joueur.getPositionY());
			}
			
			System.out.println(e);
			if(e instanceof Obstacle){
					/*A Faire action que l'on effectue quand on touche un obstable
					 * C'est a dire : 
					 * ne pas faire avancer le joueur
					 */
					System.out.println("Obstacle");
					
				
			}else if(e instanceof ObjetRecuperable){
					/*A faire : action que l'on effectue quand on touche un Objet
					 * cest a dire : 
					 *   	Implementer Ces actions dans la classe Objet ou ici????
					 *   			si dans classe objet public void action(Joueur j) ??  
					 *
					 * -repondre a un Quizz
					 * 
					 * -Si bonne reponse, mettre lobjet dans larrayList Objetrecupere
					 *         et Gain de Temps
					 *         et lenlever de larrayList ListElement(disparait de lecran)
					 * -si mauvaise reponse, enlever le patient de l'arrayList et perte de temps
					 * 			et enlever lobjet de larrayList listeElements
					 * 			et ne rien ajouter dans larrayList ObjetRecupere
					 * 			(chrono.setTime(chrono.getTime()-5));
					 * 
					 */
							System.out.println("Objet");

							((ObjetRecuperable) e).estRamasse(this);
							
				
			}else if(e instanceof Patient){
					/*A faire : action que l'on effectue quand on touche un patient 
					 * Si on a l'objet dont le patient est proprietaire : lui rendre
					 * 	Le patient est efface de l'arrayList (il disparait)
					 * On enleve l'objet de larrayList objet recupere
					 * 
					 * Si on a pas d'objet dont il est proprietaire : il nous demande de lui ramenner
					 * un objet qu'il veut et on le voit apparaitre sur la map 
					 * 		Math.random() pour cree lobjet � une position definie, ne pas oublier de verifier
					 * 		quil ny a pas deja quelquechose labas+ (ajout dans larrayList listeElements)
					 * 
					 */
							((Patient)e).action(this);
							System.out.println("Patient l");

				
			}else if(e instanceof Sol){  //Signifie que c'est du sol
					joueur.deplacer(direction);
					System.out.println("Sol");
			}
		
			

		//raffraichir le panel ensuite
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
		listePatients.remove(a);
		listeElements.remove(a);
	}
	
	public ObjetRecuperable getObjet(Patient p){
		
		for(ObjetRecuperable a : objetsRecuperes){
			if(a.getProprietaire().equals(p)){
				return a ; 
			}
		}
		return null; 
	}
	
	//A revoir comment verifier un proprietaire
	public boolean verifierProprietaire(Patient p){
		
		for(ObjetRecuperable a : objetsRecuperes){
			if(a.getProprietaire().getID()==p.getID()){
				return true;
			}
		}
		
		return false; 
		
	}
	

	
	  public int getLignes() {
		return lignes;
	}




	public int getColonnes() {
		return colonnes;
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
	/**Recuperer un element d'une position donnee
	 * 
	 * @param x
	 * @param y
	 * @param list
	 * @return
	 */
	private ElementCarte getElement(int x, int y){

			for(ElementCarte a : listeElements){
				if(a.getPositionX()==x && a.getPositionY()==y){
					return a; 
					}
			}

			
			return null ; 
	}
	
	
	
	/**Méthode permettant de récuperer le sol sur la carte
	 * @param x
	 * @param y
	 * @return
	 */
	private Sol getElementS(int x, int y) {
		
		for(Sol a : lSol){
			if(a.getPositionX()==x && a.getPositionY()==y){
				return a; 
				}
		}

		return null ; 
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		//Une chance sur 10 de creer un patient
		int nbAleatoire = (int) (Math.random()*10);
		
		if(nbAleatoire == 0){
			int positionXObjet = (int)(Math.random()*colonnes);
			int positionYObjet = (int)(Math.random()*lignes);
			Patient p = new Patient(positionXObjet,positionYObjet);
			listeElements.add(p);
			System.out.println("PatientCree");
			repaint();
		}
	}





	
	

	
}
