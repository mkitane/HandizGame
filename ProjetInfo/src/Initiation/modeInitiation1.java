package Initiation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import quizz.Quizz;
import main.Carte;
import main.Fenetre;
import main.FrameLevel;
import main.Main;
import main.PanneauPrincipal;


public class modeInitiation1 extends JPanel{
	/**
	 * 
	 */
	
	private FenetreMode1 f = new FenetreMode1();
	private JButton btnRetour=new JButton();
	private JLabel lblBienvenue=new JLabel();
	private JLabel lblExplication = new JLabel("Ici vous pourrez approfondir vos connaissances sur le monde du handicap, tout en ayant la possibilite d'ameliorer votre score dans le Jeu.");
	private JPanel panelH=new JPanel();
	private JPanel panelBtn=new JPanel();
	
	
    public modeInitiation1() {
       setLayout(new BorderLayout());
       add(panelH,BorderLayout.NORTH);
       add(f,BorderLayout.CENTER);
       add(panelBtn,BorderLayout.SOUTH);
       
       panelH.setLayout(new FlowLayout());
       panelH.setPreferredSize(new Dimension(50,50));
       panelH.add(lblBienvenue);
       panelH.add(lblExplication);
       lblBienvenue.setText("<html><body><u>Bienvenue au mode Initiation!!</u></body></html>");

       
     
       
       panelBtn.add(btnRetour);

       btnRetour.setText("Retour");

       btnRetour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new PanneauPrincipal());
			}
		});
       
       setVisible(true);
       
    }  	
 
    
}
