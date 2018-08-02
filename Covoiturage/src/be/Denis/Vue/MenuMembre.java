package be.Denis.Vue;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MenuMembre extends JPanel {
	
	private JButton btnListeBalade;
	private JButton btnCompte;
	private JButton btnProfil;
	private JButton btnDeconnexion;

	/**
	 * Create the panel.
	 */
	public MenuMembre(JPanel screen, DashBoard dashBoard) {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		
		btnListeBalade = new JButton("Balade");
		btnListeBalade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		add(btnListeBalade);
		
		btnCompte = new JButton("Compte");
		btnCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		add(btnCompte);
		
		btnProfil = new JButton("Profil");
		btnProfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Profil vueProfil = new Profil();
				vueProfil.setBounds(0, 0, 400, 600);
				screen.add(vueProfil);
			}
		});
		add(btnProfil);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dashBoard.dispose();
				Connexion conn = new Connexion();
			}
		});
		add(btnDeconnexion);
	}

}
