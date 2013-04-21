package elementsCartes;

import java.util.Scanner;

import main.Carte;

import quizz.Quizz;

/**
 * @author bprely
 *
 */
public class ObjetRecuperable extends ElementCarte{
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


