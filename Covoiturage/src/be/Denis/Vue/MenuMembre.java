package be.Denis.Vue;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;

import be.Denis.Model.Membre;
@SuppressWarnings("serial")
public class MenuMembre extends JPanel {
	
	private JButton btnListeBalade;
	private JButton btnMesBalades;
	private JButton btnMesVehicules;
	private JButton btnCompte;
	private JButton btnProfil;
	private JButton btnDeconnexion;

	/**
	 * Create the panel.
	 */
	public MenuMembre(DashBoard bureau, Membre membre) {
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.DARK_GRAY);
		setBorder(new LineBorder(new Color(0, 102, 255), 5, true));
		setLayout(new GridLayout(0, 1, 0, 0));
		setBounds(5,5,180,600);
		
		
		btnListeBalade = new JButton("Balade");
		btnListeBalade.setForeground(Color.BLUE);
		btnListeBalade.setBackground(Color.WHITE);
		btnListeBalade.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnListeBalade.setIcon(new ImageIcon("images\\search-icon.png"));
		btnListeBalade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bureau.changeScreen("planningBalade");
			}
		});
		add(btnListeBalade);
		
		btnMesBalades = new JButton("Mes balades");
		btnMesBalades.setForeground(Color.BLUE);
		btnMesBalades.setBackground(Color.WHITE);
		btnMesBalades.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMesBalades.setIcon(new ImageIcon("images\\GPS-icon.png"));
		btnMesBalades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("baladeMembre");
			}
		});
		add(btnMesBalades);
		
		btnMesVehicules = new JButton("Mes véhicules");
		btnMesVehicules.setForeground(Color.BLUE);
		btnMesVehicules.setBackground(Color.WHITE);
		btnMesVehicules.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMesVehicules.setIcon(new ImageIcon("images\\bmw-mini-icon.png"));
		btnMesVehicules.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("vehiculeMembre");
			}
		});
		add(btnMesVehicules);
		
		btnCompte = new JButton("Compte");
		btnCompte.setForeground(Color.BLUE);
		btnCompte.setBackground(Color.WHITE);
		btnCompte.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCompte.setIcon(new ImageIcon("images\\money-wallet-icon.png"));
		btnCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("compteMembre");
			}
		});
		add(btnCompte);
		
		
		
		btnProfil = new JButton("Profil");
		btnProfil.setForeground(Color.BLUE);
		btnProfil.setBackground(Color.WHITE);
		btnProfil.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnProfil.setIcon(new ImageIcon("images\\identity-card-icon.png"));
		btnProfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("profilMembre");
			}
		});
		add(btnProfil);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setForeground(Color.BLUE);
		btnDeconnexion.setBackground(Color.WHITE);
		btnDeconnexion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDeconnexion.setIcon(new ImageIcon("images\\logout-icon.png"));
		btnDeconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				membre.updateInfo();
				bureau.dispose();
				Login.init();
			}
		});
		add(btnDeconnexion);
	}

}
