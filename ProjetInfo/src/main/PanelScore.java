package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import quizz.ElementQuizz;

//Gerer le fait qu'il n'y ai aucune reponse
public class PanelScore extends JPanel {
	private ArrayList<ElementQuizz> listeBonnesReponses; 
	private ArrayList<ElementQuizz> listeMauvaisesReponses;
	private ArrayList<String> listeThemes=new ArrayList<String>();
	private String themeLacune;

	
	private Image imgBarreVide;
	private Image imgdelta;
	private Image imgdeltaFin;
	private JPanel panelBtn = new JPanel();
	private JButton btnRetour = new JButton("Retour Accueil");
	private JLabel labelThemeLacune=new JLabel();
	
	public PanelScore(ArrayList<ElementQuizz> lB,ArrayList<ElementQuizz> lM){
		readImages();
		setBackground(Color.getHSBColor(Float.parseFloat("27"), Float.parseFloat("0.08"), Float.parseFloat("0.42")));

		listeBonnesReponses=lB;
		listeMauvaisesReponses=lM;

		trouverThemes();

		themeLacune = trouverLacune();
		
		labelThemeLacune.setForeground(Color.WHITE);
		if(themeLacune==null){
			labelThemeLacune.setText("Il n'y a rien a ameliorer ! ;)") ;
		}else{
			labelThemeLacune.setText("Le theme a ameliorer est : "+themeLacune);
		}
			
		this.setLayout(new BorderLayout());
		this.add(panelBtn,BorderLayout.SOUTH);
		panelBtn.add(labelThemeLacune);
		panelBtn.add(btnRetour);
		panelBtn.setBackground(Color.getHSBColor(Float.parseFloat("27"), Float.parseFloat("0.08"), Float.parseFloat("0.42")));
		
		
	
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(new Font("SansSerif",Font.PLAIN,40));
		g.drawString("Bravo!",getWidth()/2-70, 50);

		
		
		dessinerScore(g);
		dessinerBarreJustesse(g);
		
		int y=250; //Permet de positionner toute la partie Detail en fonction de cette position en y

		
		g.setFont(new Font("SansSerif",Font.ITALIC,30));
		g.drawString("Detail", getWidth()/2-55, y);
		//pour chaque theme, on regarde le pourcentage de bonnes reponses
		for(String theme: listeThemes){
			y=y+60;
			dessinerBarreTheme(g,y,theme,rapportBonnesReponses(theme));
		}
		
		y=y+60;
		g.setFont(new Font("SansSerif",Font.ITALIC,25));
		//g.drawString("Le theme a ameliorer est : " + themeLacune, 70, y);
		
		
		//this.getRootPane().getParent().setSize(Carte.COTE*15,y+80);
	}	
	
	
	
	
	/**
	 * Dessine le score 
	 * @param g
	 */
	private void dessinerScore(Graphics g){
		int positionX=390;
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
		int positionX=300; 
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
	/**
	 * Met les images en memoire
	 */
	private void readImages(){
		try {
			imgBarreVide = ImageIO.read(new File("./images/BarreVide.png"));
			imgdelta = ImageIO.read(new File("./images/petitProgression.png"));
			imgdeltaFin = ImageIO.read(new File("./images/petitBout.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}