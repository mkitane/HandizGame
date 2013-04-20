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
		super(positionX, positionY, "Patient");

		int nbAleatoire = (int)(Math.random()*(listeHandicapPossible.length)) ;
		
		String image = listeHandicapPossible[nbAleatoire];
		super.setNomImage(image);
		handicap=listeHandicapPossible[nbAleatoire];
		
		lastID++;
		ID=lastID; 

		
	}
	
	public String getHandicap() {
		return handicap;
	}

	/**
	 * Methode qui demande au joueur de lui ramenner l'objet
	 * @param x
	 * @param y
	 */
	public void action(Carte c){
		//si on a un objet que le patient veut !
		if(c.verifierProprietaire(this)){
			//a revoir
			System.out.println("Objet Donne");
			c.removeObjet(c.getObjet(this));
			c.removePatient(this);			
		}else{
			//si on a pas d'objet on le cree en relation avec le handicap 
			//reste a gerer la gestion des erreurs de placement et ne pas creer l'objet dans un endroit deja remplis
			//idee pour verifier, arraylist listeElements ˆ verifier et comparer pour voir
			System.out.println("Va me rammener Cet objet");
			int positionXObjet = (int)(Math.random()*c.getColonnes());
			int positionYObjet = (int)(Math.random()*c.getLignes());

			ObjetRecuperable[] listeObjet = {new Canne(positionXObjet,positionYObjet,this),new Infirmier(positionXObjet,positionYObjet,this),new Lunette(positionXObjet,positionYObjet,this),new Prothese(positionXObjet,positionYObjet,this)};
			
			c.addObjet(choisirBonObjet(listeObjet));
			
		}
		
	}

	
	/**
	 * Choisit un objet au hasard parmis les objets qui correspondent au handicap du patient
	 * @param liste
	 * @return
	 */
	public ObjetRecuperable choisirBonObjet(ObjetRecuperable[] liste){
		ArrayList<ObjetRecuperable> l = new ArrayList<ObjetRecuperable>();
		for(int i=0;i<liste.length;i++){
			if(liste[i].getHandicapAssocie().equalsIgnoreCase(handicap)){
				l.add(liste[i]);
			}
		}
		
		return l.get((int) (l.size()*Math.random()));
	}
	public String toString(){
		return "P";
		
	}
	
	
	
	public int getID() {
		return ID;
	}
	
	
	
}
