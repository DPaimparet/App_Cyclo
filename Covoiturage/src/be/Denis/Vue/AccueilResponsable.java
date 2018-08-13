package be.Denis.Vue;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.Denis.Model.Cyclo;
import be.Denis.Model.Descente;
import be.Denis.Model.Randonneur;
import be.Denis.Model.Responsable;
import be.Denis.Model.Trialiste;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JButton;

public class AccueilResponsable extends JPanel {
	
	private JPanel accueil;
	private JButton btnCategorie;
	private String choix = "route";

	/**
	 * Create the panel.
	 */
	public AccueilResponsable(Responsable responsable, DashBoard bureau) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.DARK_GRAY);
		setBounds(0,0,800,800);
		setLayout(null);
		
		accueil = new JPanel();
		accueil.setBackground(Color.DARK_GRAY);
		accueil.setBounds(5,5,790,790);
		accueil.setLayout(null);
		add(accueil);
		
		if(responsable.getCat() == null) {
			JLabel lblNewLabel = new JLabel("Vous n'avez pas encore de cat\u00E9gorie");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(210, 56, 380, 35);
			accueil.add(lblNewLabel);
			
			JLabel lblChoissezUneCatgorie = new JLabel("choissez une cat\u00E9gorie ");
			lblChoissezUneCatgorie.setForeground(Color.WHITE);
			lblChoissezUneCatgorie.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblChoissezUneCatgorie.setBounds(75, 145, 243, 35);
			accueil.add(lblChoissezUneCatgorie);
			
			JRadioButton rdbtnRoute = new JRadioButton("route");
			rdbtnRoute.setFont(new Font("Tahoma", Font.BOLD, 15));
			rdbtnRoute.setBounds(178, 213, 137, 23);
			rdbtnRoute.setSelected(true);
			accueil.add(rdbtnRoute);
			
			JLabel lblCyclo = new JLabel("Cyclo :");
			lblCyclo.setForeground(Color.WHITE);
			lblCyclo.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblCyclo.setBounds(75, 205, 73, 35);
			accueil.add(lblCyclo);
			
			JLabel lblVtt = new JLabel("VTT :");
			lblVtt.setForeground(Color.WHITE);
			lblVtt.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblVtt.setBounds(75, 280, 73, 35);
			accueil.add(lblVtt);
			
			JRadioButton rdbtnDescendeur = new JRadioButton("descendeur");
			rdbtnDescendeur.setFont(new Font("Tahoma", Font.BOLD, 15));
			rdbtnDescendeur.setBounds(178, 288, 137, 23);
			accueil.add(rdbtnDescendeur);
			
			JRadioButton rdbtnRandonneur = new JRadioButton("randonneur");
			rdbtnRandonneur.setFont(new Font("Tahoma", Font.BOLD, 15));
			rdbtnRandonneur.setBounds(178, 348, 137, 23);
			accueil.add(rdbtnRandonneur);
			
			JRadioButton rdbtnTrialiste = new JRadioButton("trialiste");
			rdbtnTrialiste.setFont(new Font("Tahoma", Font.BOLD, 15));
			rdbtnTrialiste.setBounds(178, 408, 137, 23);
			accueil.add(rdbtnTrialiste);
			
			btnCategorie = new JButton("Ajouter une catégorie");
			btnCategorie.setBackground(new Color(241, 57, 83));
			btnCategorie.setForeground(Color.WHITE);
			btnCategorie.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnCategorie.setBounds(250, 700, 300, 30);
			accueil.add(btnCategorie);
			
			rdbtnRoute.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnDescendeur.setSelected(false);
					rdbtnRandonneur.setSelected(false);
					rdbtnTrialiste.setSelected(false);
					choix = rdbtnRoute.getText();
				}
			});
			
			rdbtnDescendeur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnRoute.setSelected(false);
					rdbtnRandonneur.setSelected(false);
					rdbtnTrialiste.setSelected(false);
					choix = rdbtnDescendeur.getText();
				}
			});
			
			rdbtnRandonneur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnDescendeur.setSelected(false);
					rdbtnRoute.setSelected(false);
					rdbtnTrialiste.setSelected(false);
					choix = rdbtnRandonneur.getText();
				}
			});

			rdbtnTrialiste.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnDescendeur.setSelected(false);
					rdbtnRandonneur.setSelected(false);
					rdbtnRoute.setSelected(false);
					choix = rdbtnTrialiste.getText();
				}
			});
			
			btnCategorie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch (choix) {
					case "route" : Cyclo cyclo = new Cyclo("route");
								   responsable.ajouterCategorie(cyclo);
					break;
					case "descendeur" : Descente descente = new Descente("descendeur");
										responsable.ajouterCategorie(descente);
					break;
					case "randonneur": Randonneur randonneur = new Randonneur("randonneur");
									   responsable.ajouterCategorie(randonneur);
					break;
					case "trialiste" : Trialiste trialiste = new Trialiste("trialiste");
									   responsable.ajouterCategorie(trialiste);
					break;
					}
					bureau.changeScreen("accueilResponsable");
				}
			});
			
		}
		else {
			JLabel lblBienvenu = new JLabel("Bienvenue " + responsable.getPrenom());
			lblBienvenu.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblBienvenu.setForeground(Color.WHITE);
			lblBienvenu.setBackground(Color.DARK_GRAY);
			lblBienvenu.setBounds(250, 249, 300, 31);
			accueil.add(lblBienvenu);
			
			JLabel lblVoiciVotreTableau = new JLabel("Voici votre tableau de bord, il vous permet de g\u00E9rer votre ");
			lblVoiciVotreTableau.setForeground(Color.WHITE);
			lblVoiciVotreTableau.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblVoiciVotreTableau.setBackground(Color.DARK_GRAY);
			lblVoiciVotreTableau.setBounds(36, 334, 724, 74);
			accueil.add(lblVoiciVotreTableau);
			
			JLabel lblRleDeResponsable = new JLabel("r\u00F4le de responsable");
			lblRleDeResponsable.setForeground(Color.WHITE);
			lblRleDeResponsable.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblRleDeResponsable.setBackground(Color.DARK_GRAY);
			lblRleDeResponsable.setBounds(262, 393, 258, 51);
			accueil.add(lblRleDeResponsable);
			
			JLabel lblVosBalade = new JLabel("Vos balades : permet de g\u00E9rer vos balades actives");
			lblVosBalade.setForeground(Color.WHITE);
			lblVosBalade.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblVosBalade.setBackground(Color.DARK_GRAY);
			lblVosBalade.setBounds(36, 493, 724, 51);
			accueil.add(lblVosBalade);
			
			JLabel lblCrerBalade = new JLabel("Cr\u00E9er balade : permet de cr\u00E9er des balades");
			lblCrerBalade.setForeground(Color.WHITE);
			lblCrerBalade.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblCrerBalade.setBackground(Color.DARK_GRAY);
			lblCrerBalade.setBounds(36, 555, 724, 51);
			accueil.add(lblCrerBalade);
			
			JLabel lblProfilPermet = new JLabel("Profil : permet de mettre \u00E0 jour vos donn\u00E9es");
			lblProfilPermet.setForeground(Color.WHITE);
			lblProfilPermet.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblProfilPermet.setBackground(Color.DARK_GRAY);
			lblProfilPermet.setBounds(36, 617, 724, 51);
			accueil.add(lblProfilPermet);
			
		}
		

	}
}
