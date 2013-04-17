package ElementsCartes;

/**
 * @author bprely
 *Les objets sont récupérables par le joueur et demandé par le patient
 */
public class Objet extends ElementCarte implements Recuperable{
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private Patient proprietaire;
	/**Constructeur d'un objet
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 * @param p Patient
	 */
	public Objet(int positionX, int positionY, String nomImage,Patient p) {
		super(positionX,positionY,nomImage);
		proprietaire=p;
	}

	
	
	public boolean estRamassable(int x, int y) {
		return false;
	}	
		
		
}	


