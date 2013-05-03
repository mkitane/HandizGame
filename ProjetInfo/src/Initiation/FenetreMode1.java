package Initiation;

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



public class FenetreMode1 extends JFrame {

	private ArrayList<ElementQuizz> listeElements;
	private ArrayList<String> listeThemes=new ArrayList<String>();

	
    private JSplitPane jSplitPane1;
    private JTextArea jTextArea1 = new JTextArea();
    
    private JList jListTheme ;
    private JScrollPane listeThemeScroller;

    public FenetreMode1() {
    	listeElements=Quizz.listeElementQuizz;
    	trouverThemes();
    
    	jListTheme=new JList(listeThemes.toArray()); //On transforme notre listeDeThemes en tableau d'objets pour pouvoir instancier la liste
    	listeThemeScroller = new JScrollPane(jListTheme);
    	
    	jbInit();
     
    }

    private void jbInit() {
        setSize(new Dimension(642, 377));
        jSplitPane1= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listeThemeScroller, jTextArea1);
        jSplitPane1.setOneTouchExpandable(true);

        
        this.getContentPane().add(jSplitPane1);
        
        //Reglages de la jListTheme
        listeThemeScroller.setPreferredSize(new Dimension(150, 80));
        listeThemeScroller.setBackground(Color.LIGHT_GRAY);
        
   
        jListTheme.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListTheme.setBackground(Color.LIGHT_GRAY);

        
        jListTheme.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				jListThemeActionPerformed(e);
			}
        });
        //Fin Reglage de la jListTheme
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
            	jTextArea1.setText((String) jListTheme.getSelectedValue());

            }
        }
    	
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
