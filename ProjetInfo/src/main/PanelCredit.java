package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelCredit extends JPanel {
	private JButton boutonRetour = new JButton("Retour");
	private JPanel panneauBas = new JPanel();

	public PanelCredit() {
		this.setLayout(new BorderLayout());
		this.add(panneauBas, BorderLayout.SOUTH);
		panneauBas.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panneauBas.add(boutonRetour);
		panneauBas.setOpaque(false);

		boutonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new PanneauPrincipal());
			}
		});
		setBackground(Ressources.GRIS);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setFont(Ressources.getQuickSand().deriveFont((float) 32.0));
		g.setColor(Color.white);

		g.drawString("Credits", (getWidth() / 2 - 50), 30);
		g.drawString("Membres du Projet :", (getWidth() / 2 - 190), 90);
		g.drawString("Remerciements a :", (getWidth() / 2 - 190), 360);

		g.setFont(Ressources.getQuickSand().deriveFont((float) 22.0));
		g.drawString("Mehdi Kitane", (getWidth() / 2 - 110), 140);
		g.drawString("Bertrand Prely", (getWidth() / 2 - 110), 190);
		g.drawString("Amine Wahbi", (getWidth() / 2 - 110), 240);
		g.drawString("Pierre Laurenson", (getWidth() / 2 - 110), 290);
		
		
		g.drawString("Art.devsader.com", (getWidth() / 2 - 110), 410);
		g.drawString("Moosader", (getWidth() / 2 ), 460);
		g.drawString("Iconfinder.com", (getWidth() / 2 - 110), 510);

		g.drawString("HandizGoud", (getWidth() / 2)-110, 560);

	}

}
