package initiation;

import java.awt.BorderLayout;
import java.awt.Dimension;


import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.Ressources;

import quizz.ElementQuizz;
import quizz.Quizz;
/**
 * Class panneau
 * Elle permet d'afficher toutes le questions du quizz selon le thème.
 * 
 */
public class AfficheurXml extends JPanel {

	private ArrayList<ElementQuizz> listeElements;
	private ArrayList<String> listeThemes = new ArrayList<String>();

	private JSplitPane jSplitPane1;

	private JTextArea jTextArea1 = new JTextArea();
	private JScrollPane scrollText = new JScrollPane(jTextArea1);

	private JList jListTheme;
	private JScrollPane listeThemeScroller;

	private JPanel panelSplitPane2 = new JPanel();
	private JSplitPane jSplitPane2;
	private JList jListQuestion;
	private JScrollPane listeQuestionScroller;
/**
 * Constructeur de la Class
 * 
 */
	public AfficheurXml() {

		listeElements = Quizz.listeElementQuizz;
		trouverThemes();

		jListTheme = new JList(listeThemes.toArray()); // On transforme notre
														// listeDeThemes en
														// tableau d'objets pour
														// pouvoir instancier la
														// liste
		listeThemeScroller = new JScrollPane(jListTheme);

		jListQuestion = new JList();
		listeQuestionScroller = new JScrollPane(jListQuestion);

		jbInit();

	}
/**
 * L'organiation graphique du panneau
 */
	private void jbInit() {

		// Ajout des elements
		scrollText.setPreferredSize(new Dimension(300, 500));
		jSplitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				listeQuestionScroller, scrollText);
		panelSplitPane2.setLayout(new BorderLayout());
		panelSplitPane2.add(jSplitPane2);
		jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				listeThemeScroller, panelSplitPane2);
		jSplitPane1.setOneTouchExpandable(true);

		this.add(jSplitPane1);

		// /Reglage jTextArea
		jTextArea1.setOpaque(true);
		jTextArea1.setLineWrap(true); // Permet de sauter revenir a la ligne si
										// la question est trop longue
		jTextArea1.setWrapStyleWord(true);
		jTextArea1.setEditable(false);
		jTextArea1.setBackground(Ressources.GRIS);
		// jTextArea1.setForeground(Color.WHITE);

		// Reglages de la jListTheme
		listeThemeScroller.setPreferredSize(new Dimension(150, 80));
		jListTheme.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListTheme.setFixedCellHeight(46);
		jListTheme.setBackground(Ressources.GRIS);
		// jListTheme.setForeground(Color.WHITE);

		jListTheme.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				jListThemeActionPerformed(e);
			}
		});
		// Fin Reglage de la jListTheme

		// Reglages de la jListQuestion
		listeQuestionScroller.setPreferredSize(new Dimension(250, 100));
		jListQuestion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListQuestion.setBackground(Ressources.GRIS);
		// jListQuestion.setForeground(Color.WHITE);

		jListQuestion.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				jListQuestionActionPerformed(e);
			}
		});
		// Fin Reglage de la jListQuestion

	}

	/**
	 * Action a effectuer quand on clique sur un des themes
	 * 
	 * @param e
	 */
	private void jListThemeActionPerformed(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {

			if (jListTheme.getSelectedIndex() == -1) {
			} else {
				jListQuestion.setListData((trouverQuestions(String
						.valueOf(jListTheme.getSelectedValue())).toArray()));
				listeQuestionScroller.setViewportView(jListQuestion);
				jListQuestion.setFixedCellHeight(36);
				jListQuestion.setBackground(Ressources.GRIS);

				// On raffraichit l'actionListener
				jListQuestion
						.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent e) {
								jListQuestionActionPerformed(e);
							}
						});
			}
		}

	}

	/**
	 * Action a effectuer quand on clique sur une des Questions
	 * 
	 * @param e
	 */
	private void jListQuestionActionPerformed(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {

			if (jListQuestion.getSelectedIndex() == -1) {
			} else {
				// On trouve l'elementQuizz selectionne
				ElementQuizz eQ = ((ElementQuizz) jListQuestion
						.getSelectedValue());

				String textAEcrire = "Votre Theme:\n    " + eQ.getTheme()
						+ "\n\n\nVotre Question:\n\n   " + eQ.getQuestion()
						+ "\n\n\nEt voici un indice:\n\n   "
						+ eQ.getExplication();

				// On affiche sur le jTextArea ce que l'on veut et qui
				// correspond a cet ElementQuizz
				jTextArea1.setText(textAEcrire);
			}
		}

	}

	/**
	 * Trouve toutes les Questions correspondant ï¿½ un theme
	 * 
	 * @param theme
	 * @return
	 */

	private ArrayList<ElementQuizz> trouverQuestions(String theme) {
		ArrayList<ElementQuizz> listQuestion = new ArrayList<ElementQuizz>();

		for (ElementQuizz a : listeElements) {
			if (a.getTheme().equals(theme)) {
				listQuestion.add(a);
			}
		}
		return listQuestion;

	}

	/**
	 * Remplit l'arrayList des themes pour savoir les themes qui ont etes lance
	 * pendant cette partie
	 */
	private void trouverThemes() {
		for (ElementQuizz a : listeElements) {
			if (verifierTheme(a.getTheme())) { // Si le theme n'est pas deja
												// present, dans la liste des
												// themes, on l'ajoute
				listeThemes.add(a.getTheme());
			}
		}
	}

	/**
	 * Verifie si le theme n'est pas deja present dans l'arraylist des themes
	 * 
	 * @param theme
	 * @return
	 */
	private boolean verifierTheme(String theme) {
		for (String t : listeThemes) {
			if (theme.equals(t)) {
				return false;
			}
		}

		return true;
	}

}
