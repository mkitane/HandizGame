
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


/**
 * Cette Classe modelise le Quizz du programme
 * Permet de lancer un quizz
 *
 */


public class Quizz {


	/**Element de Quizz, contient la question, les reponses et lexplication*/
	private ElementQuizz eQ; 
	
	
	/**Getter Quizz
	 * @return ElementQuizz
	 */
	public ElementQuizz geteQ() {
		return eQ;
	}





	/**
	 * Charge le Quizz a partir d'un theme defini
	 * @param theme
	 */
	public Quizz(String theme){
		chargerQuizz(theme);
		afficherQuizz();
	}
	
	
	
	
	/**
	 * Methode qui charge le quizz ˆ partir d'un fichier XML contenant toutes les questions
	 * Il trie les questions suivant le theme choisit et selectionne la bonne question aleatoirement
	 * @param theme  theme de la question
	 */
	public void chargerQuizz(String theme){
		ArrayList<Element> listElementTheme = new ArrayList<Element>();
		
		//Lire Fichier XML grace ˆ un analyseur DOM (suffisant pour un petit fichier XML comme le notre)
	    try {
	 
		File fXmlFile = new File("structure.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
	 
		//optional, but recommended
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
		
		//System.out.println(listElementTheme.size());
		
		/*choisit une question au hasard parmis les question de ce theme*/
		Element e = listElementTheme.get( (int)(Math.random()*listElementTheme.size()) );
		
		//afficheContenuElement(e);
		construitElementQuizz(e,theme);
		
		
		

	    
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	  
	 
		
	}
	
	
	/**
	 * Construit ElementQuizz ˆ partir d'un des elements du fichier XML
	 * @param eElement
	 * @param theme
	 */
	private void construitElementQuizz(Element eElement,String theme){
		String question = eElement.getElementsByTagName("question").item(0).getTextContent();
		String explication = eElement.getElementsByTagName("explication").item(0).getTextContent();
		ArrayList<Reponse> lR = new ArrayList<Reponse>();
		
		
		//Boucle pour les reponses
		for(int i=0; i<eElement.getElementsByTagName("answer").getLength();i++){
			Element answerElement = (Element) eElement.getElementsByTagName("answer").item(i);
	
				if(answerElement.getAttribute("j").equals("juste")){
					lR.add(new Reponse(eElement.getElementsByTagName("answer").item(i).getTextContent(),true));
				}else{
					lR.add(new Reponse(eElement.getElementsByTagName("answer").item(i).getTextContent(),false));

				}
		}
		
		lR=melanger(lR);
		eQ=new ElementQuizz(theme,question,lR,explication);
		
		
	}

	
	/**
	 * Methode Test pour afficher le contenu d'un des elements du fichier XML
	 * @param eElement
	 */
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

	
	
	/**
	 * Affiche le quizz sur le terminal (pour l'instant)
	 */
	public void afficherQuizz(){
		System.out.println(eQ.getTheme());
		System.out.println(eQ.getQuestion());
		System.out.println();
		System.out.println(eQ.getListeReponse());		
	}
	
	
	
	/**
	 * Melange une arraylist de reponses afin d'afficher les reponses dans un ordre aleatoire
	 * @param listeDepart
	 * @return ArrayList<Reponse>
	 */
	public ArrayList<Reponse> melanger(ArrayList<Reponse> listeDepart){ 
	
		List<Reponse> nouvelle = new ArrayList<Reponse>(listeDepart); 
		Collections.shuffle(nouvelle); 
		return (ArrayList<Reponse>) nouvelle; 
		
	}
	
	
	/**
	 * Verifie si la reponse donnee en parametre est correcte
	 * @param r
	 * @return boolean
	 */
	public boolean verifierReponse(Reponse r){
		return r.isJustesse(); 	
	}
	
	/**
	 * Affiche la correction pour l'instant sur le terminal
	 * @param r
	 */
	public void afficherCorrection(Reponse r){
		if(verifierReponse(r)){
			System.out.println("Bonne Reponse!");
		}else{
			System.out.println("Mauvaise Reponse");
			System.out.println("Voici une explication : ");
			System.out.println(eQ.getExplication());
		}
	}
	
	
}
