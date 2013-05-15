package main;
import java.awt.*;

import javax.swing.*;

public class PanneauPrincipal extends JFrame {
	private JPanel panel = new JPanel();
	private JPanel panneauboutons = new JPanel();
	private JButton bouton1 =new JButton("Mode Initiation");
	private JButton bouton2 =new JButton("Mode Jeu");
	private JButton bouton3 =new JButton("Choix niveau");
	
	public PanneauPrincipal(){
		setTitle("HandizGame");
		setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jbInit();
   
        setVisible(true);
	}

	private void jbInit() {
		
		this.setContentPane(panel);
		this.setBackground(Color.lightGray);
		panel.setLayout(new BorderLayout());
		panel.add(panneauboutons, BorderLayout.EAST);
		
	
		panneauboutons.setPreferredSize(new Dimension(150,600));
		panneauboutons.setLayout(new FlowLayout());
		bouton1.setPreferredSize(new Dimension(140,60));
		bouton2.setPreferredSize(new Dimension(140,60));
		bouton3.setPreferredSize(new Dimension(140,60));
		panneauboutons.add(bouton1);
		panneauboutons.add(bouton2);
		panneauboutons.add(bouton3);
		
				
		
	}

}
