import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//taper 5 pour arreter le programme
		
		Quizz q = new Quizz("celebrite");
		Scanner sc = new Scanner(System.in);
		int j = sc.nextInt();
		q.afficherCorrection(q.geteQ().getListeReponse().get(j-1));
		
		
	
		

		
		
		
		
	}

}
