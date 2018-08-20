package be.Denis.Vue;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.Denis.Model.Tresorier;

@SuppressWarnings("serial")
public class AccueilTresorier extends JPanel {

	/**
	 * Create the panel.
	 */
	public AccueilTresorier(Tresorier tresorier, DashBoard bureau) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.DARK_GRAY);
		setBounds(0,0,800,800);
		setLayout(null);
		
		JLabel lblBienvenu = new JLabel("Bienvenue " + tresorier.getPrenom());
		lblBienvenu.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBienvenu.setForeground(Color.WHITE);
		lblBienvenu.setBackground(Color.DARK_GRAY);
		lblBienvenu.setBounds(250, 50, 300, 31);
		add(lblBienvenu);
		
		JLabel lblVoiciVotreTableau = new JLabel("Voici votre tableau de bord, il vous permet de g\u00E9rer votre ");
		lblVoiciVotreTableau.setForeground(Color.WHITE);
		lblVoiciVotreTableau.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblVoiciVotreTableau.setBackground(Color.DARK_GRAY);
		lblVoiciVotreTableau.setBounds(36, 150, 724, 74);
		add(lblVoiciVotreTableau);
		
		JLabel lblRleDeResponsable = new JLabel("r\u00F4le de " + tresorier.getFonction());
		lblRleDeResponsable.setForeground(Color.WHITE);
		lblRleDeResponsable.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRleDeResponsable.setBackground(Color.DARK_GRAY);
		lblRleDeResponsable.setBounds(36, 250, 258, 51);
		add(lblRleDeResponsable);
		
		JLabel lblCompteCotisation = new JLabel("Cotisation : permet de voir les cotisation impay\u00E9es");
		lblCompteCotisation.setForeground(Color.WHITE);
		lblCompteCotisation.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCompteCotisation.setBackground(Color.DARK_GRAY);
		lblCompteCotisation.setBounds(36, 487, 724, 51);
		add(lblCompteCotisation);
		
		JLabel lblFraisBalade = new JLabel("Frais d\u00E9placement : permet de g\u00E9rer les d\u00E9placement");
		lblFraisBalade.setForeground(Color.WHITE);
		lblFraisBalade.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblFraisBalade.setBackground(Color.DARK_GRAY);
		lblFraisBalade.setBounds(36, 377, 724, 51);
		add(lblFraisBalade);
		
		JLabel lblProfilPermet = new JLabel("Profil : permet de mettre \u00E0 jour vos donn\u00E9es");
		lblProfilPermet.setForeground(Color.WHITE);
		lblProfilPermet.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProfilPermet.setBackground(Color.DARK_GRAY);
		lblProfilPermet.setBounds(36, 600, 724, 51);
		add(lblProfilPermet);
	}

}
