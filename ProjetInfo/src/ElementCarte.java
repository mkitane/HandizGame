
/**
 * @author bprely
 *
 */
abstract public class ElementCarte{
	/** La position horizontale d'un élément de la carte.Toujours positif
	 * 
	 */
	private int positionX;
	
	/**La position verticale d'un élément de la carte.Toujours positif.
	 * 
	 */
	private int positionY;
	/**Le nom de l'image qui correspond à l'élément de la carte
	 * 
	 */
	private String nomImage;
	/**
	 * @param x
	 * @param y
	 * @param n
	 */
	public ElementCarte(int x,int y,String n){
		x=positionX;
		y=positionY;
		n=nomImage;
	}
	/**
	 * 
	 */
	abstract public void placerElement();
	
	public String toString(){
		return nomImage;}
	
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
	public void setPositionX(int x){
		x=positionX;
	}
	/** positionY  private. On utilise un setteur pour modifier la valeur
	 * @param y
	 */
	public void setPositionY(int y){
		y=positionY;
	}
	/** nomImage private. On utilise un setteur pour modifier la valeur
	 * @param n
	 */
	public void setNom(String n){
		n=nomImage;
	}
}
	
	
	

	
	


