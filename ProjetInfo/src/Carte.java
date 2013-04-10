
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.Timer;

import ElementsCartes.*;

/**
 * Classe qui modelise le plateau du Jeu
 * @author Mehdi
 *
 */


//Sera plus tard un JPanel
public class Carte implements ActionListener{
	  /**
	   * Caracteristiques de la carte
	   */
	  private int lignes;  // nombre de lignes
	  private int colonnes;  // nombre de colonnes
	  private int cote = 20; // Pour plus tard Taille des cases;  
	  
	  
	  private Timer time =  new Timer(1000,this);;
	  //Pourquoi ne marche pas sans ca? 
	  //private Compteur chrono = new Compteur("100");
	  private ArrayList<ElementCarte> listeElements;
	  private ArrayList<Objet> objetsRecuperes;
	  private ArrayList<Patient> listePatients; 
	  private ArrayList<Sol> lSol = new ArrayList<Sol>();
	  private Joueur joueur; 
	    
	  
	  
	  
	public Carte(){
		listeElements = new ArrayList<ElementCarte>();
		objetsRecuperes = new ArrayList<Objet>();
		listePatients = new ArrayList<Patient>();
		
		
		
		chargerCarte("map.txt"); 
		startGame();
	}

	
	
	
	/**Charge la Carte ˆ partir d'un fichier txt
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
				//Action ˆ effectuer selon l'objet, besoin de definir les objets que l'on mettra d'abord
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
				}
			}
	}

	
	
	


	/**Affiche le jeu sur le terminal 
	 * 
	 */
	public String toString(){
			String p = ""; 
			//p = p + this.lignes + "\n" + this.colonnes + "\n" ; 
			
			p=p+"-----------------------" + "\n";
			for(int i=0;i<lignes;i++){
				for(int j=0;j<colonnes;j++){
					//les Elements ˆ afficher sont dans listeElement
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
	

	private Sol getElementS(int x, int y) {
		
		for(Sol a : lSol){
			if(a.getPositionX()==x && a.getPositionY()==y){
				return a; 
				}
		}

		return null ; 
	}
	
	

	
	
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
		if(direction==Joueur.UP){
			ElementCarte e = getElement(joueur.getPositionX(),joueur.getPositionY()+1);
			if(e instanceof Obstacle){
					/*A Faire action que l'on effectue quand on touche un obstable
					 * C'est a dire : 
					 * ne pas faire avancer le joueur
					 */
				
			}else if(e instanceof Objet){
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
				
			}else if(e instanceof Patient){
					/*A faire : action que l'on effectue quand on touche un patient 
					 * Si on a l'objet dont le patient est proprietaire : lui rendre
					 * 	Le patient est efface de l'arrayList (il disparait)
					 * 
					 * Si on a pas d'objet dont il est proprietaire : il nous demande de lui ramenner
					 * un objet qu'il veut et on le voit apparaitre sur la map 
					 * 		Math.random() pour cree lobjet ˆ une position definie, ne pas oublier de verifier
					 * 		quil ny a pas deja quelquechose labas+ (ajout dans larrayList listeElements)
					 * 
					 */
			}else if(e==null){  //Signifie que c'est du sol
				joueur.deplacer(Joueur.UP);
			}
		}

		//raffraichir le panel ensuite
		
	}



	public void startGame(){
		//chrono.start();
		time.start();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("lolŽ");
	}
	
	
	
	
}
