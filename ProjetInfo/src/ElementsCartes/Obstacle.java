package ElementsCartes;

public class Obstacle extends ElementCarte {

	public Obstacle(int x, int y, String n) {
		super(x, y, n);
	}
	
	public boolean action(int x, int y){
		return false;
	}

}
