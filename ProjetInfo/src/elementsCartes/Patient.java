package elementsCartes;
import main.Carte;
import main.Fenetre;


public class Patient extends ElementCarte {
	private final String[] listeHandicapPossible = {"Handicap et entreprise","celebrite","surdite"};
	private String handicap;
	/**Permet de reconnaitre un patient cree*/
	private static int lastID = 0 ; 
	private int ID; 
	/**Permet de savoir si on a deja demande au patient de rammener un objet ou pas pour qu'un patient ne puisse instancier plusieurs objets*/
	private boolean verificateur = true ; 
	private int typePatient;
	


	public Patient(int positionX, int positionY) {
		super(positionX, positionY, "Patients/Patient1");
		
		typePatient = (int)(Math.random()*5+1);
		setImage("Patients/Patient" + typePatient);

		int nbAleatoire = (int)(Math.random()*(listeHandicapPossible.length)) ;
		
		/*String image = listeHandicapPossible[nbAleatoire];
		super.setNomImage(image);*/
		handicap=listeHandicapPossible[nbAleatoire];
		
		lastID++;
		ID=lastID; 

		
	}
	
	

	
	/**Action que l'on effectue quand on touche un patient :
	 * 	Son image change
	 * 
	 * 
	 * Si on a l'objet dont le patient est proprietaire : lui rendre
	 * On enleve l'objet de larrayList objet recupere
	 * on enleve le patient et on remet un nouveau patient pour ne jamais �tre a cours de patients
	 * 
	 *
	 * Si on a pas d'objet qu'il veut :il nous demande de lui ramenner
	 * On  cree cet objet en relation avec le handicap du patient
	 * On voit alors l'objet qu'il veux apparaitre sur la carte
	 *@param: c Carte du jeu
	 */
	public void action(Carte c){
		
		
		if(c.verifierProprietaire(this)){ //si on possede un objet dont ce patient est le proprietaire, on le lui rend
			Fenetre.ecrire("Merci!");

			c.removeObjet(c.getObjet(this));
			c.removeObjetListeObjetRecuperes(c.getObjet(this));
			c.removePatient(this);	
			if(!c.patientPresent()){
				c.creerNouveauPatient();  //Cree un nouveau Patient pour ne pas bloquer le joueur seulement si il n'y en a pas deja
			}
			c.repaint();
			c.augmenteScore();
			
		}else if(!verificateur){ 
			Fenetre.ecrire("Ramenne moi deja l'objet au lieu d'en redemander s'il te plait.");
		}else{	 
			Fenetre.ecrire("Peut-tu me rammener cet objet s'il te plait?");
			c.creerNouvelObjet(this);  //this: pour signifier que l'objet appartient a ce patient
			verificateur=false;
		}
		
	}

	
	
	
	
	
	/*Getters et Setters*/
	public String toString(){
		return "P";
		
	}
	
	public String getHandicap() {
		return handicap;
	}

	public int getID() {
		return ID;
	}
	
	
	
}
