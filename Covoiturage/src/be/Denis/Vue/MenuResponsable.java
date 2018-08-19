package be.Denis.Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import be.Denis.Model.Responsable;

import javax.swing.UIManager;
@SuppressWarnings("serial")
public class MenuResponsable extends JPanel {
	
	private JButton btnListeBalade;
	private JButton btnCreerBalade;
	private JButton btnProfil;
	private JButton btnDeconnexion;
	
	/**
	 * Create the panel.
	 */
	public MenuResponsable(DashBoard bureau, Responsable responsable) {
		setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setBorder(UIManager.getBorder("Button.border"));
		setLayout(new GridLayout(0, 1, 0, 0));
		setBounds(5,5,180,600);
		
		btnListeBalade = new JButton("Balades");
		btnListeBalade.setForeground(Color.BLUE);
		btnListeBalade.setBackground(Color.WHITE);
		btnListeBalade.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnListeBalade.setIcon(new ImageIcon("images\\search-icon.png"));
		
		btnListeBalade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bureau.changeScreen("baladeResponsable");
			}
		});
		add(btnListeBalade);
		
		btnCreerBalade = new JButton("Creer une balade");
		btnCreerBalade.setForeground(Color.BLUE);
		btnCreerBalade.setBackground(Color.WHITE);
		btnCreerBalade.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCreerBalade.setIcon(new ImageIcon("images\\Apps-menu-editor-icon.png"));
		btnCreerBalade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("creerBalade");
			}
		});
		add(btnCreerBalade);
		
		btnProfil = new JButton("Profil");
		btnProfil.setForeground(Color.BLUE);
		btnProfil.setBackground(Color.WHITE);
		btnProfil.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnProfil.setIcon(new ImageIcon("images\\identity-card-icon.png"));
		btnProfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("profilResponsable");
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
				responsable.updateInfo();
				bureau.dispose();
				Login.init();
			}
		});
		add(btnDeconnexion);
	}

}
