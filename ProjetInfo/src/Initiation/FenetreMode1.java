package Initiation;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import quizz.ElementQuizz;
import quizz.Quizz;



public class FenetreMode1 extends JPanel {

	private ArrayList<ElementQuizz> listeElements;
	private ArrayList<String> listeThemes=new ArrayList<String>();

    private JSplitPane jSplitPane1;
    
    private JTextArea jTextArea1 = new JTextArea();
    private JScrollPane scrollText = new JScrollPane(jTextArea1);
    
    private JList jListTheme ;
    private JScrollPane listeThemeScroller;
    
	private JPanel panelSplitPane2 = new JPanel();
    private JSplitPane jSplitPane2;
    private JList jListQuestion;
    private JScrollPane listeQuestionScroller;

    public FenetreMode1() {
    	listeElements=Quizz.listeElementQuizz;
    	trouverThemes();
    
    	jListTheme=new JList(listeThemes.toArray()); //On transforme notre listeDeThemes en tableau d'objets pour pouvoir instancier la liste
    	listeThemeScroller = new JScrollPane(jListTheme);
    	
    	jListQuestion = new JList();
    	listeQuestionScroller = new JScrollPane(jListQuestion);
    	
    	jbInit();
     
    }

    private void jbInit() {
        //setSize(800,500);

        scrollText.setPreferredSize(new Dimension(300,500));
        jSplitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listeQuestionScroller,scrollText);
        panelSplitPane2.setLayout(new BorderLayout());
        panelSplitPane2.add(jSplitPane2);
        jSplitPane1= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listeThemeScroller, panelSplitPane2);
        jSplitPane1.setOneTouchExpandable(true);
        
        this.add(jSplitPane1);

        
        ///Reglage jTextArea
        jTextArea1.setOpaque(true);
        jTextArea1.setLineWrap(true);  //Permet de sauter revenir a la ligne si la question est trop longue
	    jTextArea1.setWrapStyleWord(true);
        jTextArea1.setEditable(false);

        //Reglages de la jListTheme
        listeThemeScroller.setPreferredSize(new Dimension(150, 80));  
        jListTheme.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListTheme.setBackground(Color.LIGHT_GRAY);

        
        jListTheme.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				jListThemeActionPerformed(e);
			}
        });
        //Fin Reglage de la jListTheme
        
        //Reglages de la jListQuestion
        listeQuestionScroller.setPreferredSize(new Dimension(250,100));
        jListQuestion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListQuestion.setBackground(Color.LIGHT_GRAY);
        
        
        jListQuestion.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				jListQuestionActionPerformed(e);
			}
        });
        //Fin Reglage de la jListQuestion
        
       }

   
    
    
    /**Action a effectuer quand on clique sur un des themes
     * 
     * @param e
     */
    private void jListThemeActionPerformed(ListSelectionEvent e) {
    	if (e.getValueIsAdjusting() == false) {

            if (jListTheme.getSelectedIndex() == -1) {
            	jTextArea1.setText("lol");
            } else {
            	jListQuestion=new JList(trouverQuestions(String.valueOf(jListTheme.getSelectedValue())).toArray());
            	listeQuestionScroller.setViewportView(jListQuestion);

            	//On raffraichit l'actionListener
            	 jListQuestion.addListSelectionListener(new ListSelectionListener() {
         			public void valueChanged(ListSelectionEvent e) {
         				jListQuestionActionPerformed(e);
         			}
                 });
            }
        }
    	
	}
    
    
    
    /**Action a effectuer quand on clique sur une des Questions
     * 
     * @param e
     */
	private void jListQuestionActionPerformed(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {

            if (jListQuestion.getSelectedIndex() == -1) {
            } else {
            	//On trouve l'elementQuizz  selectionne
            	ElementQuizz eQ = ((ElementQuizz) jListQuestion.getSelectedValue());
				
				
            	
            	String textAEcrire= "Votre Thème:\n"+eQ.getTheme() + "\nVotreQuestion:\n" + eQ.getQuestion() + "\nEt voici l'explication:" + eQ.getExplication();

            	//On affiche sur le jTextArea ce que l'on veut et qui correspond � cet ElementQuizz
            	jTextArea1.setText(textAEcrire);
            }
        }
		
	}
    
    
    
    
   /** Trouve toutes les Questions correspondant � un theme
   * 
   * @param theme
   * @return
   */
    
    private ArrayList<ElementQuizz> trouverQuestions(String theme){
    	ArrayList<ElementQuizz> listQuestion = new ArrayList<ElementQuizz>();
    	
    	for(ElementQuizz a: listeElements){
			if(a.getTheme().equals(theme)){
				listQuestion.add(a);
			}
		}
		return listQuestion;
    	
    }
    

    /**
	 * Remplit l'arrayList des themes pour savoir les themes qui ont etes lance pendant cette partie
	 */
	private void trouverThemes(){
		for(ElementQuizz a: listeElements){
			if(verifierTheme(a.getTheme())){   //Si le theme n'est pas deja present, dans la liste des themes, on l'ajoute
				listeThemes.add(a.getTheme());
			}
		}
	}
	
	/**
	 * Verifie si le theme n'est pas deja present dans l'arraylist des themes
	 * @param theme
	 * @return
	 */
	private boolean verifierTheme(String theme){
		for(String t : listeThemes){
			if(theme.equals(t)){
				return false;
			}
		}
		
		return true;
	}
	
	
	
}
