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
	private String handicapAssocie; 


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
		Quizz q = new Quizz(theme,c,this);
		
		
		
		/*
		Scanner sc = new Scanner(System.in);
		int j1 = sc.nextInt();
		
		//si bonne reponse : 
			if(q.verifierReponse(q.geteQ().getListeReponse().get(j1-1))){
				System.out.println("Bonne reponse");
				c.addObjetRecuperable(this);
				c.removeObjet(this);
				//reste à implementer le score qui augmente
			}else{
				System.out.println("Mauvaise Reponse");

				c.removePatient(proprietaire);
				c.removeObjet(this);
				//reste à implementer le score qui diminue
			}
		 */
	
	}	
		
	
	public Patient getProprietaire() {
		return proprietaire;
	}



	public String getHandicapAssocie() {
		return handicapAssocie;
	}



	protected void setHandicapAssocie(String handicapAssocie) {
		this.handicapAssocie = handicapAssocie;
	}
	
	
		
}	


