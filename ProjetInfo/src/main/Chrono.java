package main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Chrono extends JPanel implements ActionListener {
	private Fenetre f;
	private Timer t = new Timer(1000,this);
	private int compteur=200;
	private JLabel labelTime = new JLabel(String.valueOf(compteur));
	
	public Chrono(Fenetre f){
		this.f=f;
		setLayout(new FlowLayout());
		add(labelTime);
	}

	
	
	public void start(){
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		compteur--;
		labelTime.setText(String.valueOf(compteur));

		if(compteur<=0){
			System.exit(0);
			;
		}
		
		
	}
	
	public void incremente(){
		compteur+=10;
	}
	
	public void decremente(){
		compteur-=10;
	}
}
