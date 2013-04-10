package ElementsCartes;
import java.util.ArrayList;


public class Patient extends ElementCarte {
	private String handicap;
	
	public Patient(int positionX, int positionY, String h) {
		super(positionX, positionY, "Patient");
		handicap=h;
	}
	
	/**
	 * Methode qui demande au joueur de lui ramenner l'objet
	 * @param x
	 * @param y
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
