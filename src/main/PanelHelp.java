package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Classe creant le mode aide du jeu
 */
public class PanelHelp extends JPanel implements KeyListener {
	private JPanel panelBtn = new JPanel();
	private JButton btnAvancer = new JButton(">");
	private JButton btnReculer = new JButton("<");
	private int numeroDiapo;

	/**
	 * constructeur du mode aide
	 */
	public PanelHelp() {
		numeroDiapo = 0;

		setBackground(Ressources.GRIS);
		setLayout(new BorderLayout());
		add(panelBtn, BorderLayout.SOUTH);

		panelBtn.setOpaque(false);
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(btnReculer);
		panelBtn.add(btnAvancer);

		btnAvancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAvancerActionPerformed();
			}
		});

		btnReculer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnReculerActionPerformed();
			}
		});

		this.addKeyListener(this);
		btnReculer.addKeyListener(this);
		btnAvancer.addKeyListener(this);
	}

	/**
	 * Methode graphic component dessinant les diapositives
	 * 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.setFont(Ressources.getQuickSand().deriveFont((float) 32.0));

		g.drawString("Regles du Jeu", 330, 60);
		dessinerPanel(g);
	}

	/**
	 * Dessin des differentes diapos du mode aide en fonction du numero de diapo
	 * 
	 */
	private void dessinerPanel(Graphics g) {
		switch (numeroDiapo) {
		case -1:
			Main.setPane(new PanelPrincipal());
		case 0:
			g.drawString("Comment Jouer?", (getWidth() / 2 - 140),
					getHeight() / 2);
			break;
		case 1:
			g.drawString("Vous incarnez un Personnage ! ", 180, 200);
			g.drawString("Vous navez quune seule mission !", 160, 250);
			g.drawImage(Ressources.getImage("Personnage/Face1"), 420, 350, null);
			break;
		case 2:
			g.drawString("Vous avez 200 secondes !  ", 250, getHeight() / 2);
			break;
		case 3:
			g.drawString("Aidez les personnages qui apparaissent ! ", 120, 200);
			g.drawImage(Ressources.getImage("Patients/Patient3"), 150, 350,
					null);
			g.drawImage(Ressources.getImage("Patients/Patient1"), 285, 350,
					null);
			g.drawImage(Ressources.getImage("Patients/Patient2"), 420, 350,
					null);
			g.drawImage(Ressources.getImage("Patients/Patient5"), 555, 350,
					null);
			g.drawImage(Ressources.getImage("Patients/Patient4"), 690, 350,
					null);
			break;
		case 4:
			g.drawString("Recuperez ce qu'ils vous demandent de leur", 80, 200);
			g.drawString(" rammener !", 330, 250);
			g.drawImage(Ressources.getImage("Lunette"), 270, 350, 60, 50, null);
			g.drawImage(Ressources.getImage("Infirmier"), 430, 350, null);
			g.drawImage(Ressources.getImage("Canne"), 590, 350, null);
			break;
		case 5:
			g.drawString("Repondez a la question liee au handicap!", 100, 200);
			g.drawString("Attention, si vous repondez faux", 180, 350);
			g.drawString(" vous perdez du temps!", 240, 400);
			break;
		case 6:
			g.drawString("Rammenez leur l'objet !", 270, getHeight() / 2);
			break;
		case 7:
			g.drawString("Evitez les trous !", 320, getHeight() / 2 - 50);
			g.drawImage(Ressources.getImage("Trou"), 400, 320, 100, 100, null);
			break;
		case 8:
			g.drawString("Plus votre score augmente,", 100, 200);
			g.drawString("Plus le nombre de Trous", 180, 350);
			g.drawString("et de Patients augmente! ", 240, 400);
			break;
		case 9:
			g.drawString("A vous de jouer ;)", 320, getHeight() / 2);
			break;
		case 10:
			Main.setPane(new PanelPrincipal());
			break;
		}

	}

	/**
	 * Evenement du bouton permettant de reculer dans la series des diapositives
	 * 
	 */
	private void btnReculerActionPerformed() {
		numeroDiapo--;
		repaint();
	}

	/**
	 * Evenement du bouton permettant d'avancer dans les diapositives
	 */
	private void btnAvancerActionPerformed() {
		numeroDiapo++;
		repaint();
	}


	public void keyPressed(KeyEvent e) {

	}


	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			btnReculerActionPerformed();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			btnAvancerActionPerformed();
		}
	}


	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
