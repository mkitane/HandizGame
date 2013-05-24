package Initiation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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
import main.FrameLevel;
import main.Main;
import main.PanneauPrincipal;


public class modeInitiation1 extends JPanel{
	/**
	 * 
	 */
	
	private FenetreMode1 f = new FenetreMode1();
	private JButton JButton1=new JButton();
	private JLabel Bienvenue=new JLabel();
	private JPanel Panneau=new JPanel();
	private JPanel Panneau2=new JPanel();
	
	
    public modeInitiation1() {
       setLayout(new BorderLayout());
       JButton1.setText("RETOUR");
       add(Panneau2,BorderLayout.SOUTH);
       Panneau2.add(JButton1);
       Bienvenue.setText("<html><body><u>Bienvenue!!</u></body></html>");
       add(Panneau,BorderLayout.NORTH);
       add(f,BorderLayout.CENTER);
       Panneau.add(Bienvenue);
      
       JButton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new PanneauPrincipal());
			}
		});
       
       setVisible(true);
       
    }  	
 
    
}
