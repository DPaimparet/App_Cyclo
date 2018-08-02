package be.Denis.Vue;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuMembre extends JPanel {
	
	private static final long serialVersionUID = -3785920447746616566L;
	private JButton btnListeBalade;
	private JButton btnCompte;
	private JButton btnProfil;
	private JButton btnDeconnexion;

	/**
	 * Create the panel.
	 */
	public MenuMembre(DashBoard bureau) {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		
		btnListeBalade = new JButton("Balade");
		btnListeBalade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bureau.changeScreen("balade");
				
			}
		});
		add(btnListeBalade);
		
		btnCompte = new JButton("Compte");
		btnCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("compte");
			}
		});
		add(btnCompte);
		
		btnProfil = new JButton("Profil");
		btnProfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("profil");
			}
		});
		add(btnProfil);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.dispose();
				Login.init();
			}
		});
		add(btnDeconnexion);
	}

}
