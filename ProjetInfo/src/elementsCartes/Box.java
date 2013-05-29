package elementsCartes;


public class Box extends Obstacle {
	/**
	 * @param positionX
	 * @param positionY
	 * @param nomImage
	 */
		public Box(int positionX,int positionY){
			super(positionX,positionY,"Box");
			
		}
		
		public String toString(){
			return "B";
			
		}

}


