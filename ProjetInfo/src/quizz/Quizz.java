package quizz ; 



import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import main.Carte;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import elementsCartes.ObjetRecuperable;
import elementsCartes.Patient;


/**
 * Cette Classe modelise le Quizz du programme
 * Permet de lancer un quizz
 *
 */


public class Quizz extends JFrame implements KeyListener{
	/**Array List contenant tous les questions du fichier XML*/
	public static ArrayList<ElementQuizz> listeElementQuizz = new ArrayList<ElementQuizz>();
	/**Element de Quizz, contient la question, les reponses et lexplication*/
	private ElementQuizz eQ; 
	private Carte c; 
	private ObjetRecuperable objetAssocieAuQuizz;
	
	
	/**Partie Graphique*/
	private JLabel labelQuestion=new JLabel();
	private JPanel panelReponses = new JPanel(); 
	private JButton tableauDesReponses[];
	private JLabel indication = new JLabel("Naviguer grace a tab pour l'instant");
	
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
	public Quizz(String theme,Carte c,ObjetRecuperable o){
		choisitQuizz(theme);
		afficherQuizz();
		this.c=c;
		objetAssocieAuQuizz=o;
		
		jbInit();
		
	}
	
	
	public void jbInit(){
		/*Partie Graphique*/
		setSize(900,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		labelQuestion.setText(eQ.getQuestion());
		setLayout(new BorderLayout());
		this.add(labelQuestion,BorderLayout.NORTH);
		this.add(panelReponses,BorderLayout.CENTER);
		this.add(indication,BorderLayout.SOUTH);
		panelReponses.setLayout(new FlowLayout());
	    tableauDesReponses = new JButton[eQ.getListeReponse().size()];
	    for(Reponse a : eQ.getListeReponse()){
	    	tableauDesReponses[eQ.getListeReponse().indexOf(a)]=new JButton(a.getRep());
	    	panelReponses.add(tableauDesReponses[eQ.getListeReponse().indexOf(a)]);
	    	tableauDesReponses[eQ.getListeReponse().indexOf(a)].addKeyListener(this);
	    }
		
		setVisible(true);

	}



	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			String reponse = ((JButton) e.getSource()).getText();
			for(Reponse a : eQ.getListeReponse()){
				if(reponse.equalsIgnoreCase(a.getRep())){
					
					
					if(this.verifierReponse(a)){
						System.out.println("Bonne reponse");
						c.addObjetRecuperable(objetAssocieAuQuizz);
						c.removeObjet(objetAssocieAuQuizz);
						//reste à implementer le score qui augmente
						c.getChrono().incrementeChronometre();
					}else{
						System.out.println("Mauvaise Reponse");

						c.removePatient(objetAssocieAuQuizz.getProprietaire());
						c.removeObjet(objetAssocieAuQuizz);
						//reste à implementer le score qui diminue
						
						//Cree un nouveau Patient pour ne pas bloquer le joeuur
						int positionXObjet = (int)(Math.random()*c.getColonnes());
						int positionYObjet = (int)(Math.random()*c.getLignes());
						Patient p = new Patient(positionXObjet,positionYObjet);
						c.getListeElements().add(p);
						System.out.println("PatientCree");
						c.getChrono().decrementeChronometre();

					}	
					dispose();
					c.repaint();
					
					
					
					
					
				}
			}
			
		}
	}





	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}






	
	
	
	


	
	

	/**	Initialise le Quizz : charge en memoire toutes l'arrayList du Quizz

	 * Methode qui charge le quizz � partir d'un fichier XML contenant toutes les questions
	 * Il trie les questions suivant le theme choisit et selectionne la bonne question aleatoirement
	 */
	public static void initialiser(){
		//Vide l'arrayList au cas ou; 
		listeElementQuizz.clear();
		//Lire Fichier XML grace � un analyseur DOM (suffisant pour un petit fichier XML comme le notre)
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
			listeElementQuizz.add(construitElementQuizz((Element) nList.item(n)));
		}
		
		//System.out.println(listElementTheme.size());
		

	    
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	  
	 
		
	}
	
	
	/**
	 * Construit ElementQuizz a partir d'un des elements du fichier XML
	 * @param eElement
	 * @return 
	 */
	@SuppressWarnings("javadoc")
	private static ElementQuizz construitElementQuizz(Element eElement){
		String theme = eElement.getAttribute("theme");
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
		
		return new ElementQuizz(theme,question,lR,explication);
	
		
	}

	
	/**
	 * Choisit une Question au hasard, avec le theme desire
	 * @param theme 
	 */
	private void choisitQuizz(String theme) {
		ArrayList<ElementQuizz> temp = new ArrayList<ElementQuizz>();
		
		
		//Cree une liste des elements choisis
		for(ElementQuizz a : listeElementQuizz){
			if(a.getTheme().equalsIgnoreCase(theme)){
				temp.add(a);
			}
		}
			
		eQ=temp.get((int) (Math.random()*temp.size()));
		eQ.setListeReponse(melanger(eQ.getListeReponse()));
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
	private ArrayList<Reponse> melanger(ArrayList<Reponse> listeDepart){ 
	
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
			System.out.println("Bonne Reponse! Voici une explication :");
			System.out.println(eQ.getExplication());
		}else{
			System.out.println("Mauvaise Reponse! Voici une explication : ");
			System.out.println(eQ.getExplication());
		}
	}











	
	
}
