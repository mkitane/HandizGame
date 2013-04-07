
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


/**
 * Cette Classe modélise le Quizz du programme
 * Permet de lancer un quizz
 * @author mkitane
 *
 */


public class Quizz {

	
	
	private Question question; 
	private ArrayList<Reponse> listeReponse ; 
	//Optionnel Pourquoi la reponse est fausse ou juste
	private String explication; 
	
	
	/**
	 * Charge le Quizz à partir d'un theme defini
	 * @param theme
	 */
	public Quizz(String theme){
		chargerQuizz(theme);
		
	}
	
	
	
	
	
	public void chargerQuizz(String theme){
		ArrayList<Element> listElementTheme = new ArrayList<Element>();
		
		//Lire Fichier XML grace � un analyseur DOM (suffisant pour un petit fichier XML comme le notre)
	    try {
	 
		File fXmlFile = new File("structure.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
	 
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("element");
	 
	 
		
		/*Stoque tous les noeud contenant le theme voulu dans une arrayList pour ensuite 
		 * utiliser l'arraylist
		 */
		for (int n = 0; n < nList.getLength(); n++) {
			if( ((Element)nList.item(n)).getAttribute("theme").equalsIgnoreCase(theme)){
				listElementTheme.add((Element)nList.item(n));
			}
		}
		
		System.out.println(listElementTheme.size());
		/*choisit une question au hasard parmis les question de ce theme*/
		Element e = listElementTheme.get( (int)(Math.random()*listElementTheme.size()) );
		afficheContenuElement(e);
		
		
		
		

	    
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	  
	 
		
	}
	
	

	private void afficheContenuElement(Element eElement){
		System.out.println(eElement.getElementsByTagName("question").item(0).getTextContent());
		System.out.println(eElement.getElementsByTagName("explication").item(0).getTextContent());

		//Boucle pour les reponses
			for(int i=0; i<eElement.getElementsByTagName("answer").getLength();i++){
				Element answerElement = (Element) eElement.getElementsByTagName("answer").item(i);
		
					if(answerElement.getAttribute("j").equals("juste")){
						System.out.println(eElement.getElementsByTagName("answer").item(i).getTextContent());
					}
			}
	}

	
	public void afficherQuizz(){
		
		
	}
	
	public void verifierReponse(Reponse r){
		
		
	}
	
	
	
	
}
