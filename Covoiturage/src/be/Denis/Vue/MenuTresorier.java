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
	public MenuTresorier(DashBoard bureau) {
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
				bureau.changeScreen("homeTresorier");
				
			}
		});
		add(btnHomeTresorier);
		
		btnCompteDeplacement = new JButton("Frais déplacement");
		btnCompteDeplacement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("compteDeplacement");
			}
		});
		add(btnCompteDeplacement);
		
		btnCompteForfait = new JButton("Compte impayé");
		btnCompteForfait.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("compteDeplacement");
			}
		});
		add(btnCompteForfait);
		
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
