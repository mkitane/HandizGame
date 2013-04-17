package elementsCartes;
import java.util.ArrayList;

import main.Carte;


public class Patient extends ElementCarte {
	private final String[] listeHandicapPossible = {"Handicap et entreprise","celebrite","surdite"};
	//private final ObjetRecuperable[] listeObjet = {new Canne(),new Lunette(),new Infirmier()};
	private String handicap;
	
	
	public Patient(int positionX, int positionY) {
		super(positionX, positionY, "Patient");

		int nbAleatoire = (int)Math.random()*listeHandicapPossible.length ;
		
		String image = listeHandicapPossible[nbAleatoire];
		super.setNomImage(image);
		handicap=listeHandicapPossible[nbAleatoire];
		

		
	}
	
	public String getHandicap() {
		return handicap;
	}

	/**
	 * Methode qui demande au joueur de lui ramenner l'objet
	 * @param x
	 * @param y
	 */
	public void lanceQuestion(Carte c){
		if(c.verifierProprietaire(this)){
			System.out.println("Objet Donne");
			c.removeObjet(c.getObjet(this));
			c.removePatient(this);			
		}else{
			//si on a pas d'objet on le cree en relation avec le handicap 
			
			
		}
		
	}

	public String toString(){
		return "P";
		
	}
	
	
	
}
