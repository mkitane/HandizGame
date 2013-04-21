package elementsCartes;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import main.Carte;

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
	/**l'image de l'element de la carte*/
    private Image img;

	/**
	 * @param x
	 * @param y
	 * @param n
	 */
	public ElementCarte(int x,int y,String n){
		positionX=x;
		positionY=y;
		nomImage=n;
		setImage(n);
	}
	/**
	 * 
	 */
	
	/**Permet de recuperer l'image de lelement dans le dossier images
	 * 
	 * @param nomImage
	 */
    private void setImage(String nomImage) {
    	        try {
    	            this.img=ImageIO.read(new File("./images/"+nomImage+".png"));
    	        } catch (Exception e) {
    	            System.out.println("image pas trouvee " + nomImage);
    	        }
     }
		
	


	/**Dessine l'Element dans le jPanel
     * @param g le graphique java ou dessine l'image de la piece
     */
    public void dessine(Graphics g) {
        if (this.nomImage != null) {
            g.drawImage(this.img, this.positionX * Carte.COTE, this.positionY * Carte.COTE, Carte.COTE,
            		Carte.COTE, null);
        }
    }

	
	
	
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
	
	
	

	
	


