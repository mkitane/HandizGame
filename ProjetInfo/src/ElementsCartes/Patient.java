package ElementsCartes;
import java.util.ArrayList;


/**
 * @author bprely
 * Le patient lance la question qui déroule le quizz. 
 * C'est un élément de carte.
 *
 */
@SuppressWarnings("unused")
public class Patient extends ElementCarte {
	/**
	 * liste des handicaps du patient
	 */
	private String handicap;
	
	/**Constructeur de Patient
	 * @param positionX
	 * @param positionY
	 * @param h les handicaps du patient
	 */
	public Patient(int positionX, int positionY, String h) {
		super(positionX, positionY, "Patient");
		handicap=h;
	}
	
	/**
	 * Methode qui demande au joueur de lui ramenner l'objet
	 * @param x
	 * @param y
	 * @param objet 
	 */
	public void lanceQuestion(int x, int y,String objet){
		if(x==this.getPositionX() && y==this.getPositionY()){
			System.out.println("Peut-tu me ramenner l'objet"+ objet + "?");
		}
		
	}

	public String toString(){
		return "P";
		
	}
	
	
	
}
