package elementsCartes;
import java.util.ArrayList;

import main.Carte;


public class Patient extends ElementCarte {
	private final String[] listeHandicapPossible = {"Handicap et entreprise","celebrite","surdite"};
	private String handicap;
	/**Permet de reconnaitre un patient cree*/
	private static int lastID = 0 ; 
	private int ID; 

	


	public Patient(int positionX, int positionY) {
		super(positionX, positionY, "PatientDebut");

		int nbAleatoire = (int)(Math.random()*(listeHandicapPossible.length)) ;
		
		/*String image = listeHandicapPossible[nbAleatoire];
		super.setNomImage(image);*/
		handicap=listeHandicapPossible[nbAleatoire];
		
		lastID++;
		ID=lastID; 

		
	}
	
	
	/**
	 * Methode qui demande au joueur de lui ramenner l'objet
	 * @param x
	 * @param y
	 */
	
	
	/**Action que l'on effectue quand on touche un patient :
	 * 	Son image change
	 * 
	 * 
	 * Si on a l'objet dont le patient est proprietaire : lui rendre
	 * On enleve l'objet de larrayList objet recupere
	 * on enleve le patient et on remet un nouveau patient pour ne jamais être a cours de patients
	 * 
	 *
	 * Si on a pas d'objet qu'il veut :il nous demande de lui ramenner
	 * On  cree cet objet en relation avec le handicap du patient
	 * On voit alors l'objet qu'il veux apparaitre sur la carte
	 *@param: c Carte du jeu
	 */
	public void action(Carte c){
		
		setImage("PatientMilieu");
		
		if(c.verifierProprietaire(this)){
			System.out.println("Objet Donne");
			c.removeObjet(c.getObjet(this));
			c.removePatient(this);	
			if(!c.patientPresent()){
				c.creerNouveauPatient();  //Cree un nouveau Patient pour ne pas bloquer le joueur seulement si il n'y en a pas deja
			}
			c.repaint();
			
		}else{
			
			System.out.println("Va me rammener cet objet");
			c.creerNouvelObjet(this);  //this: pour signifier que l'objet appartient a ce patient
			
		}
		
	}

	
	
	
	
	
	
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
