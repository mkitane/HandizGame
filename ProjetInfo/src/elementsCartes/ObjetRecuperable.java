package elementsCartes;

import main.Carte;
import quizz.Quizz;

/**
 * @author bprely
 *
 */
public class ObjetRecuperable extends ElementCarte{
	private Patient proprietaire;
	private String handicapAssocie; 
	/**Permet de ne pas lancer plusieurs Quizz*/
	private boolean verificateur=true;

	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
	public ObjetRecuperable(int positionX, int positionY, String nomImage,Patient p) {
		super(positionX,positionY,nomImage);
		proprietaire=p;
	}

	
	/*A faire : action que l'on effectue quand on touche un Objet
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
	public void estRamasse(Carte c) {
		if(verificateur){
		String theme = proprietaire.getHandicap();
		new Quizz(theme,c,this);
		verificateur=false;
		}else{
			System.out.println("Veuillez repondre au quizz que vous avez deja lance");
		}
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


