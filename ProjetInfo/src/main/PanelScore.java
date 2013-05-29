package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import quizz.ElementQuizz;

//Gerer le fait qu'il n'y ai aucune reponse
/**
 *Classe Jpanel permettant de créer un panneaux où les scores sont affichées.
 *
 *
 */
public class PanelScore extends JPanel {
	private ArrayList<ElementQuizz> listeBonnesReponses; 
	private ArrayList<ElementQuizz> listeMauvaisesReponses;
	private ArrayList<String> listeThemes=new ArrayList<String>();
	private String themeLacune;

	private Image imgBarreVide = Images.get("BarreVide");
	private Image imgdelta = Images.get("petitProgression");
	private Image imgdeltaFin  = Images.get("petitBout");
	
	private JPanel panelBtn = new JPanel();
	private JButton btnRetour = new JButton("Retour Accueil");
	private JButton btnRejouer = new JButton("Rejouer");
	/**
	 *
	 *
	 *Constructeur du panneau score
	 *
	 */
	public PanelScore(ArrayList<ElementQuizz> lB,ArrayList<ElementQuizz> lM){
		setBackground(Fenetre.GRIS);

		listeBonnesReponses=lB;
		listeMauvaisesReponses=lM;

		trouverThemes();

		themeLacune = trouverLacune();
		
			
		this.setLayout(new BorderLayout());
		this.add(panelBtn,BorderLayout.SOUTH);
		
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(btnRetour);
		panelBtn.add(btnRejouer);
		panelBtn.setBackground(Fenetre.GRIS);
		
		
	
		btnRetour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new PanneauPrincipal());
			}
		});
		btnRejouer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new Fenetre());
			}
		});
	}
	/**
	 * Méthode graphique
	 * elle dessine les différents éléments du panneau
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.white);


		
		
		dessinerScore(g);
		dessinerBarreJustesse(g);
		
		int y=270; //Permet de positionner toute la partie Detail en fonction de cette position en y

		
		g.setFont(new Font("Helvetica Neue Light",Font.ITALIC,30));
		g.drawString("Details :", getWidth()/2-65, y);
		//pour chaque theme, on regarde le pourcentage de bonnes reponses
		for(String theme: listeThemes){
			y=y+60;
			dessinerBarreTheme(g,y,theme,rapportBonnesReponses(theme));
		}
		
		y=y+60;
		
		
		g.setFont(new Font("Helvetica Neue",Font.PLAIN,30));
		if(themeLacune==null){
			g.drawString("Vous n'avez rien � am�liorer ;)", 40, getHeight()-45);
		}else{
			g.drawString("Il faut que vous approfondissiez vos connaissances sur le theme: " + themeLacune + ".", 40, getHeight()-45);
		}
	}	
	
	
	
	
	/**
	 * Dessine le score 
	 * @param g
	 */
	private void dessinerScore(Graphics g){
		int positionX=670;
		int positionY=120;
		g.setFont(new Font("SansSerif",Font.PLAIN,50));
		String s = String.valueOf(listeBonnesReponses.size());
		g.drawString(s, positionX, positionY);
		
		
		 //chaque fois que le nombre de chiffre du score augmente, on augmente de 30 la position du score total;
		int xPositionString= positionX + 31*s.length(); 
		s="/" + (listeBonnesReponses.size()+listeMauvaisesReponses.size());
		g.setFont(new Font("SansSerif",Font.PLAIN,20));
		g.drawString(s, xPositionString, positionY-20);
	}
	
	
	
	/**Dessine la barre du nombre de bonnes reponses total
	 * 
	 * @param g
	 */
	private void dessinerBarreJustesse(Graphics g){
		int positionX=600; 
		int positionY = 160;
		g.drawString("Justesse", positionX+60, positionY-10);
		g.drawImage(imgBarreVide, positionX, positionY, 212, 20, null);
		
		
		float p = (float)(listeBonnesReponses.size())/(float)(listeBonnesReponses.size()+listeMauvaisesReponses.size());
		
		for(int i=0;i<pourcentage(p)*2;i++){
			g.drawImage(imgdelta, positionX+6+i, positionY+4, 1, 11,null);

		}		
		//on dessine le petit bout � droite
		if(pourcentage(p)*2==200){
			g.drawImage(imgdeltaFin,positionX+205,positionY+3,5,11,null);
		}
		
		
		g.setFont(new Font("SansSerif",Font.PLAIN,12));
		g.drawString(pourcentage(p)+"%", positionX+177, positionY+13);
		
		
		g.setFont(new Font("SansSerif",Font.PLAIN,40));
		if(pourcentage(p)>50){
			g.drawString("Bravo!",getWidth()/2-70, 50);
		}else{
			g.drawString("Vous pouvez encore vous ameliorer ! ;)",60, 50);
		}
		
	}
	
	/**Dessine la barre du nombre de bonnes reponses par theme 
	 * 
	 * @param g
	 * @param y
	 * @param theme
	 * @param pourcentageBonnesReponses
	 */
	private void dessinerBarreTheme(Graphics g,int y,String theme,float pourcentageBonnesReponses){
		//int positionX=80; 
		int positionX=getWidth()/2-110;
		int positionY = y;
		
		g.drawImage(imgBarreVide, positionX, positionY, 212, 20, null);
		
		
		
		for(int i=0;i<pourcentage(pourcentageBonnesReponses)*2;i++){
			g.drawImage(imgdelta, positionX+6+i, positionY+4, 1, 11,null);

		}	
		//on dessine le petit bout � droite
		if(pourcentage(pourcentageBonnesReponses)*2==200){
			g.drawImage(imgdeltaFin,positionX+205,positionY+3,5,11,null);
		}
		
		
		g.setFont(new Font("SansSerif",Font.PLAIN,12));
		//g.drawString("------------------------------", positionX, positionY-30);
		g.drawString(theme, positionX+60, positionY-10);
		g.drawString(pourcentage(pourcentageBonnesReponses)+"%", positionX+175, positionY+13);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Convertit un nombre a virgule en pourcentage 
	 * @param f
	 * @return
	 */
	private int pourcentage(float f){
		int i = (int) (f*100);
		return i;
	}
	
	/**
	 * Remplit l'arrayList des themes pour savoir les themes qui ont etes lance pendant cette partie
	 */
	private void trouverThemes(){
		for(ElementQuizz a: listeBonnesReponses){
			if(verifierTheme(a.getTheme())){   //Si le theme n'est pas deja present, dans la liste des themes, on l'ajoute
				listeThemes.add(a.getTheme());
			}
		}
		for(ElementQuizz a: listeMauvaisesReponses){
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
	
	
	/**
	 * Nous donne le rapport de bonnes reponses sur le nombre totale de reponses pour un theme donne
	 */
	private float rapportBonnesReponses(String theme){
		ArrayList<ElementQuizz> listeBonnesReponsesTheme = new ArrayList<ElementQuizz>();
		ArrayList<ElementQuizz> listeMauvaisesReponsesTheme = new ArrayList<ElementQuizz>();
		
		for(ElementQuizz a : listeBonnesReponses){
			if(a.getTheme().equals(theme)){
				listeBonnesReponsesTheme.add(a);
			}
		}
		
		for(ElementQuizz a : listeMauvaisesReponses){
			if(a.getTheme().equals(theme)){
				listeMauvaisesReponsesTheme.add(a);
			}
		}
		
		float p = (float) listeBonnesReponsesTheme.size() / (float)(listeBonnesReponsesTheme.size()+listeMauvaisesReponsesTheme.size());
		
		return p;
	}
	
	
	/**
	 * Nous donne le theme ou le joueur a eu le plus de difficulte
	 * @return
	 */
	private String trouverLacune(){
		String themeLacune = null;
		int rBLacune = 100;
		
		for (String theme:listeThemes){
			int rBActuel = pourcentage(rapportBonnesReponses(theme));
			if(rBActuel<rBLacune){  //si le rapport du theme actuel est plus petit, on met son theme dans la lacune
				themeLacune=theme;
				rBLacune=rBActuel;
			}
			
			System.out.println("-------");		
			System.out.println(themeLacune);
			System.out.println(rBLacune);
			System.out.println(theme);
			System.out.println(rBActuel);
		}
	
		
		
		System.out.println("Le theme le plus faible est " + themeLacune);
		return themeLacune;
		
	}

	
	
	
}
