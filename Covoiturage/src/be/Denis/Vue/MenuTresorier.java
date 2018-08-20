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

import be.Denis.Model.Tresorier;
@SuppressWarnings("serial")
public class MenuTresorier extends JPanel {

	private JButton btnHomeTresorier;
	private JButton btnCompteDeplacement;
	private JButton btnCompteForfait;
	private JButton btnProfil;
	private JButton btnDeconnexion;
	
	/**
	 * Create the panel.
	 */
	public MenuTresorier(DashBoard bureau, Tresorier tresorier) {
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.DARK_GRAY);
		setBorder(new LineBorder(new Color(0, 102, 255), 5, true));
		setLayout(new GridLayout(0, 1, 0, 0));
		setBounds(5,5,180,600);
		
		btnHomeTresorier = new JButton("Accueil");
		btnHomeTresorier.setForeground(Color.BLUE);
		btnHomeTresorier.setBackground(Color.WHITE);
		btnHomeTresorier.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHomeTresorier.setIcon(new ImageIcon("images\\home-icon-silhouette.png"));
		btnHomeTresorier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bureau.changeScreen("accueilTresorier");
				
			}
		});
		add(btnHomeTresorier);
		
		btnCompteDeplacement = new JButton("Frais déplacement");
		btnCompteDeplacement.setForeground(Color.BLUE);
		btnCompteDeplacement.setBackground(Color.WHITE);
		btnCompteDeplacement.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCompteDeplacement.setIcon(new ImageIcon("images\\money-wallet-icon.png"));
		btnCompteDeplacement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("compteDeplacement");
			}
		});
		add(btnCompteDeplacement);
		
		btnCompteForfait = new JButton("Cotisation");
		btnCompteForfait.setForeground(Color.BLUE);
		btnCompteForfait.setBackground(Color.WHITE);
		btnCompteForfait.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCompteForfait.setIcon(new ImageIcon("images\\Bank-icon.png"));
		btnCompteForfait.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("compteForfait");
			}
		});
		add(btnCompteForfait);
		
		btnProfil = new JButton("Profil");
		btnProfil.setForeground(Color.BLUE);
		btnProfil.setBackground(Color.WHITE);
		btnProfil.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnProfil.setIcon(new ImageIcon("images\\identity-card-icon.png"));
		btnProfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("profilTresorier");
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
				bureau.dispose();
				Login.init();
			}
		});
		add(btnDeconnexion);
	}

}
