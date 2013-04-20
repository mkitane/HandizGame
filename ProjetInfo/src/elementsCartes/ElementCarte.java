package elementsCartes;

/**
 * @author bprely
 *
 */
abstract public class ElementCarte{
	/** La position horizontale d'un element de la carte.Toujours positif*/
	private int positionX;
	/**La position verticale d'un element de la carte.Toujours positif*/
	private int positionY;
	/**Le nom de l'image qui correspond a l'element de la carte*/
	private String nomImage;
	
	/**
	 * @param x
	 * @param y
	 * @param n
	 */
	public ElementCarte(int x,int y,String n){
		positionX=x;
		positionY=y;
		nomImage=n;
	}
	/**
	 * 
	 */
	
	
	
	
	
	
	/**Attribut positionX private.On utilise un getteur.
	 * @return  int positionX
	 */
	public int getPositionX(){
		return positionX;
	}
	/**Attribut PositionY private. On utilise un getteur
	 * @return  int positionY
	 */
	public int getPositionY(){
		return positionY;
	}
	/**attribut private. On utilise un getteur 
	 * @return string nomImage
	 */
	public String getImage(){
		return nomImage;
	}
	/**postionX private .On utilise un setteur pour modifier la valeur
	 * @param x
	 */
	//Prely : les setteurs et pour en general mettre une valeur dans une variable on fait
	//x=10;  toi tu fais 10=x; 
	//donc ici c positionX=x;
	//pas x=positionX;
	
	public void setPositionX(int x){
		positionX=x;
	}
	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}






	/** positionY  private. On utilise un setteur pour modifier la valeur
	 * @param y
	 */
	public void setPositionY(int y){
		positionY=y;
	}
	/** nomImage private. On utilise un setteur pour modifier la valeur
	 * @param n
	 */
	public void setNom(String n){
		n=nomImage;
	}
}
	
	
	

	
	


