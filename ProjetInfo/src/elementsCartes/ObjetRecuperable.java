package elementsCartes;

import java.util.Scanner;

import main.Carte;

import quizz.Quizz;

/**
 * @author bprely
 *
 */
public class ObjetRecuperable extends ElementCarte implements Recuperable{
	private Patient proprietaire;



	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
	public ObjetRecuperable(int positionX, int positionY, String nomImage,Patient p) {
		super(positionX,positionY,nomImage);
		proprietaire=p;
	}

	
	
	public void estRamasse(Carte c) {

		String theme = proprietaire.getHandicap();
		Quizz q = new Quizz(theme);
		Scanner sc = new Scanner(System.in);
		int j1 = sc.nextInt();
		
		//si bonne reponse : 
			if(q.verifierReponse(q.geteQ().getListeReponse().get(j1-1))){
				c.addObjet(this);
				c.removeObjet(this);
				//reste à implementer le score qui augmente
			}else{
				c.removePatient(proprietaire);
				c.removeObjet(this);
				//reste à implementer le score qui diminue
			}
	
	
	}	
		
	
	public Patient getProprietaire() {
		return proprietaire;
	}
	
	
		
}	


