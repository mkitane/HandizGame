package elementsCartes;
import java.util.ArrayList;

import main.Carte;


public class Patient extends ElementCarte {
	private final String[] listeHandicapPossible = {"Handicap et entreprise","celebrite","surdite"};
	private String handicap;
	/**Permet de reconnaitre un patient cree*/
	private static int lastID = 0 ; 
	private int ID; 

	


	public Patient(int positionX, int positionY) {
		super(positionX, positionY, "Patient");

		int nbAleatoire = (int)(Math.random()*(listeHandicapPossible.length)) ;
		
		/*String image = listeHandicapPossible[nbAleatoire];
		super.setNomImage(image);*/
		handicap=listeHandicapPossible[nbAleatoire];
		
		lastID++;
		ID=lastID; 

		
	}
	
	
	/**
	 * Methode qui demande au joueur de lui ramenner l'objet
	 * @param x
	 * @param y
	 */
	
	
	/*A faire : action que l'on effectue quand on touche un patient 
	 * Si on a l'objet dont le patient est proprietaire : lui rendre
	 * 	Le patient est efface de l'arrayList (il disparait)
	 * On enleve l'objet de larrayList objet recupere
	 * 
	 * Si on a pas d'objet dont il est proprietaire : il nous demande de lui ramenner
	 * un objet qu'il veut et on le voit apparaitre sur la map 
	 * 		Math.random() pour cree lobjet ÔøΩ une position definie, ne pas oublier de verifier
	 * 		quil ny a pas deja quelquechose labas+ (ajout dans larrayList listeElements)
	 * 
	 */
	public void action(Carte c){
		//si on a un objet que le patient veut !
		//on reprend l'objet
		//on enleve le patient et on remet un nouveau patient pour ne jamais être a cours de patients

		if(c.verifierProprietaire(this)){
			//a revoir
			System.out.println("Objet Donne");
			c.removeObjet(c.getObjet(this));
			c.removePatient(this);	
			
			
			int positionXObjet = (int)(Math.random()*c.getColonnes());
			int positionYObjet = (int)(Math.random()*c.getLignes());
			Patient p = new Patient(positionXObjet,positionYObjet);
			c.getListeElements().add(p);
			System.out.println("PatientCree");
			c.repaint();
			
		}else{
			//si on a pas d'objet on le cree en relation avec le handicap 
			//reste a gerer la gestion des erreurs de placement et ne pas creer l'objet dans un endroit deja remplis
			//idee pour verifier, arraylist listeElements à verifier et comparer pour voir
			System.out.println("Va me rammener cet objet");
			int positionXObjet = (int)(Math.random()*c.getColonnes());
			int positionYObjet = (int)(Math.random()*c.getLignes());

			ObjetRecuperable[] listeObjet = {new Canne(positionXObjet,positionYObjet,this),new Infirmier(positionXObjet,positionYObjet,this),new Lunette(positionXObjet,positionYObjet,this),new Prothese(positionXObjet,positionYObjet,this)};
			
			c.addObjet(choisirBonObjet(listeObjet));
			
		}
		
	}

	
	/**
	 * Choisit un objet au hasard parmis les objets qui correspondent au handicap du patient
	 * @param liste
	 * @return
	 */
	public ObjetRecuperable choisirBonObjet(ObjetRecuperable[] liste){
		ArrayList<ObjetRecuperable> l = new ArrayList<ObjetRecuperable>();
		for(int i=0;i<liste.length;i++){
			if(liste[i].getHandicapAssocie().equalsIgnoreCase(handicap)){
				l.add(liste[i]);
			}
		}
		
		return l.get((int) (l.size()*Math.random()));
	}
	
	
	
	
	
	
	public String toString(){
		return "P";
		
	}
	
	public String getHandicap() {
		return handicap;
	}

	public int getID() {
		return ID;
	}
	
	
	
}
