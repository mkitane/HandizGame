package Initiation;

import java.io.File;

import java.io.IOException;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import Initiation.ElementMode;

import quizz.ElementQuizz;
import quizz.Reponse;


public class Mode {
  private static ArrayList<ElementMode> listeElement = new ArrayList<ElementMode>();
  private ElementMode eq;

    /**
     * @param theme
     * @param eq
     * @param listeElement
     */
    public Mode(String theme,ElementMode eq,ArrayList<ElementMode>listeElement) {
      choisit(theme);
      this.eq=eq;
      this.listeElement=listeElement;
      
      
    }
    
    
    public static void afficherFichier(){
        try {
        
        File fXmlFile = new File("structure.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        
        //optional, but recommended
        doc.getDocumentElement().normalize();
        
        
        NodeList nList = doc.getElementsByTagName("element");
        
        
        
        /*Stoque tous les noeud  dans une arrayList pour ensuite utiliser l'arraylist
        */
        for (int n = 0; n < nList.getLength(); n++) {
        listeElement.add(construitElement((Element) nList.item(n)));
        }
        
        //System.out.println(listElementTheme.size());
        

        
        } catch (Exception e) {
        e.printStackTrace();
        }
        
        
        
        }
        
      //System.out.println(listElementTheme.size());

    private static ElementMode construitElement(Element eElement) {
      String theme = eElement.getAttribute("theme");
      String question = eElement.getElementsByTagName("question").item(0).getTextContent();
      String explication = eElement.getElementsByTagName("explication").item(0).getTextContent();
      String r;
        for(int i=0; i<eElement.getElementsByTagName("answer").getLength();i++){
          Element answerElement = (Element) eElement.getElementsByTagName("answer").item(i);
        
            if(answerElement.getAttribute("j").equals("juste")){
              r=(eElement.getElementsByTagName("answer").item(i).getTextContent());
            }
            
      return new ElementMode(theme,question,r,explication);
      
      
      }
    }

    /**
     * @param theme
     */
    public void choisit(String theme) {
      ArrayList<ElementMode> temp = new ArrayList<ElementMode>();
      
      
      //Cree une liste des elements choisis
      for(ElementMode a : listeElement){
        if(a.getTheme().equalsIgnoreCase(theme)){
          temp.add(a);
        }
      }
    afficher(temp);
      }
      private void afficher(ArrayList liste){
          for (int i=0;i<liste.size(); i++){
            if(liste.get(i)!=null){
                System.out.println(+i+"  : " +liste.get(i).toString());
            }
            else{
                System.out.println("liste" +i+ ":vide");
            }
          }                
              
              
        
    }


}

        


