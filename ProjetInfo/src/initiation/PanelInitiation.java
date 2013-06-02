package initiation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;
import main.PanelPrincipal;
import main.Ressources;

/**
 * Classe lancant le panel initiation
 */
public class PanelInitiation extends JPanel {

	private AfficheurXml f = new AfficheurXml();
	private JButton btnRetour = new JButton();
	private JLabel lblBienvenue = new JLabel();
	private JLabel lblExplication = new JLabel(
			"Ici vous pourrez approfondir vos connaissances sur le monde du handicap, tout en ayant la possibilite d'ameliorer votre score dans le Jeu.");
	private JPanel panelH = new JPanel();
	private JPanel panelBtn = new JPanel();

	/**
	 * Le constructeur de PanelInitiation Contient l'organisation graphique du
	 * panneau.
	 */
	public PanelInitiation() {
		setLayout(new BorderLayout());
		add(panelH, BorderLayout.NORTH);
		add(f, BorderLayout.CENTER);
		add(panelBtn, BorderLayout.SOUTH);

		panelH.setLayout(new FlowLayout());
		panelH.setPreferredSize(new Dimension(50, 50));
		panelH.add(lblBienvenue);
		panelH.add(lblExplication);
		lblBienvenue
				.setText("<html><body><u>Bienvenue au mode Initiation!!</u></body></html>");

		panelBtn.add(btnRetour);

		btnRetour.setText("Retour");

		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setPane(new PanelPrincipal());
			}
		});

		// Couleur
		setBackground(Ressources.GRIS);
		f.setBackground(Ressources.GRIS);
		lblBienvenue.setForeground(Color.white);
		lblExplication.setForeground(Color.white);
		panelBtn.setOpaque(false);
		panelH.setOpaque(false);

		setVisible(true);

	}

}
