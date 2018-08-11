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
public class MenuResponsable extends JPanel {
	
	private JButton btnListeBalade;
	private JButton btnCreerBalade;
	private JButton btnProfil;
	private JButton btnDeconnexion;
	
	/**
	 * Create the panel.
	 */
	public MenuResponsable(DashBoard bureau) {
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.DARK_GRAY);
		setBorder(new LineBorder(new Color(0, 102, 255), 5, true));
		setLayout(new GridLayout(0, 1, 0, 0));
		setBounds(5,5,180,600);
		
		btnListeBalade = new JButton("Balade");
		btnListeBalade.setForeground(Color.BLUE);
		btnListeBalade.setBackground(Color.WHITE);
		btnListeBalade.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnListeBalade.setIcon(new ImageIcon("images\\home-icon-silhouette.png"));
		btnListeBalade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bureau.changeScreen("balade");
				
			}
		});
		add(btnListeBalade);
		
		btnCreerBalade = new JButton("Creer une balade");
		btnCreerBalade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bureau.changeScreen("creerBalade");
			}
		});
		add(btnCreerBalade);
		
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
