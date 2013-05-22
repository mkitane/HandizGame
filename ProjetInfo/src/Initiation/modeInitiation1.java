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
import main.Main;
import main.PanneauPrincipal;


public class modeInitiation1 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	
	private FenetreMode1 f = new FenetreMode1();
	private JButton JButton1=new JButton();
	private JLabel Bienvenue=new JLabel();
	private JPanel Panneau=new JPanel();
	private JPanel Panneau2=new JPanel();
	
	
    public modeInitiation1() {
       setSize(800,500);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLayout(new BorderLayout());
       JButton1.setText("RETOUR");
       add(Panneau2,BorderLayout.SOUTH);
       Panneau2.add(JButton1);
       Bienvenue.setText("<html><body><u>Bienvenue!!</u></body></html>");
       add(Panneau,BorderLayout.NORTH);
       add(f,BorderLayout.CENTER);
       JButton1.addActionListener(this);
       Panneau.add(Bienvenue);
      
      
       setVisible(true);
       
    }
    public void actionPerformed(ActionEvent e){
    	System.out.println("On retourne à la case départ");
    }

  	
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Quizz.initialiser();
        new modeInitiation1();
    }
    
    
    
    public void reglerTaille(){
   	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize =  getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible(true);
   }
    
}
