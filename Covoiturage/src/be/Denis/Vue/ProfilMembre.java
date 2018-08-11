package be.Denis.Vue;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import be.Denis.Model.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class ProfilMembre extends JPanel {

	private JPanel form;
	private JLabel lblPrenom;
	private JLabel lblMail;
	private JLabel lblAdress;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JLabel lblSexe;
	private JLabel lblError;
	private JLabel lblFonction;
	private JLabel lblDateDeNaissance;
	private JLabel lblName;
	private JTextField fieldName;
	private JTextField textFieldPwd;
	private JTextField textFieldLogin;
	private JTextField textFieldMail;
	private JTextField textFieldPrenom;
	private JButton btnAnnuler;
	private JButton btnConfirm;
	private JRadioButton rdbtnFemme;
	private JRadioButton rdbtnHomme;
	private JTextArea textAreaAdress;
	private JComboBox<String> comboBoxFonction;
	private JDateChooser dateAnniversaire;

	/**
	 * Create the panel.
	 */
	public ProfilMembre( Membre p) {
		
		String sexSelected = p.getSex();
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.CYAN);
		setBounds(0,0,800,800);
		setLayout(new BorderLayout(0, 0));
		
		form = new JPanel();
		form.setBackground(Color.DARK_GRAY);
		form.setBounds(0,0,800,800);
		add(form);
		form.setLayout(null);
		
		
		lblName = new JLabel("Nom :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(156, 51, 43, 30);
		form.add(lblName);
		
		fieldName = new JTextField(p.getNom());
		lblName.setLabelFor(fieldName);
		fieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fieldName.setBounds(222, 56, 220, 20);
		form.add(fieldName);
		fieldName.setColumns(10);
		
		lblPrenom = new JLabel("Pr\u00E9nom :");
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrenom.setBounds(133, 92, 66, 40);
		form.add(lblPrenom);
		
		textFieldPrenom = new JTextField(p.getPrenom());
		textFieldPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(222, 102, 220, 20);
		form.add(textFieldPrenom);
		
		lblMail = new JLabel("E-Mail :");
		lblMail.setForeground(Color.WHITE);
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMail.setBounds(143, 141, 56, 40);
		form.add(lblMail);
		
		textFieldMail = new JTextField(p.getEmail());
		textFieldMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(222, 153, 220, 20);
		form.add(textFieldMail);
		
		lblLogin = new JLabel("Login :");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(149, 192, 50, 40);
		form.add(lblLogin);
		
		textFieldLogin = new JTextField(p.getLogin());
		textFieldLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldLogin.setColumns(10);
		textFieldLogin.setBounds(222, 204, 220, 20);
		form.add(textFieldLogin);
		
		lblPassword = new JLabel("Mot de passe :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(93, 243, 106, 40);
		form.add(lblPassword);
		
		textFieldPwd = new JTextField(p.getPassword());
		textFieldPwd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPwd.setColumns(10);
		textFieldPwd.setBounds(222, 255, 220, 20);
		form.add(textFieldPwd);
		
		lblAdress = new JLabel("Adresse :");
		lblAdress.setForeground(Color.WHITE);
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdress.setBounds(480, 46, 80, 40);
		form.add(lblAdress);
		
		lblSexe = new JLabel("Sexe : ");
		lblSexe.setForeground(Color.WHITE);
		lblSexe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSexe.setBounds(143, 299, 56, 40);
		form.add(lblSexe);
		
		rdbtnFemme = new JRadioButton("F\u00E9minin");
		rdbtnFemme.setForeground(Color.WHITE);
		rdbtnFemme.setBackground(Color.DARK_GRAY);
		rdbtnFemme.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnFemme.setBounds(342, 308, 100, 23);
		form.add(rdbtnFemme);
		
		rdbtnHomme = new JRadioButton("Masculin");
		rdbtnHomme.setBackground(Color.DARK_GRAY);
		rdbtnHomme.setForeground(Color.WHITE);
		rdbtnHomme.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnHomme.setBounds(222, 308, 100, 23);
		form.add(rdbtnHomme);
		
		if (sexSelected == "F") {
			rdbtnFemme.setSelected(true);
			rdbtnHomme.setSelected(false);
		}else {
			rdbtnHomme.setSelected(true);
			rdbtnFemme.setSelected(false);
		}
		
		textAreaAdress = new JTextArea(p.getAdresse());
		textAreaAdress.setBounds(480, 102, 300, 133);
		form.add(textAreaAdress);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblError.setBounds(175, 493, 413, 99);
		form.add(lblError);
		
		comboBoxFonction = new JComboBox<String>();
		comboBoxFonction.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxFonction.setForeground(Color.WHITE);
		comboBoxFonction.setBackground(Color.DARK_GRAY);
		comboBoxFonction.setSize(220, 30);
		comboBoxFonction.setLocation(480, 299);
		comboBoxFonction.setModel(new DefaultComboBoxModel<String>(new String[] {"Membre", "Responsable", "Tresorier"}));
		comboBoxFonction.setSelectedIndex(0);
		form.add(comboBoxFonction);
		
		lblFonction = new JLabel("Fonction");
		lblFonction.setForeground(Color.WHITE);
		lblFonction.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFonction.setBounds(480, 243, 66, 40);
		form.add(lblFonction);
		
		lblDateDeNaissance = new JLabel("Date de naissance");
		lblDateDeNaissance.setForeground(Color.WHITE);
		lblDateDeNaissance.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateDeNaissance.setBounds(57, 376, 142, 40);
		form.add(lblDateDeNaissance);
		
		dateAnniversaire = new JDateChooser(p.getDateNaissance());
		dateAnniversaire.setBounds(222, 386, 220, 30);
		form.add(dateAnniversaire);
		
		btnConfirm = new JButton("Confirmer");
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConfirm.setBounds(172, 651, 150, 50);
		form.add(btnConfirm);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAnnuler.setBounds(436, 651, 150, 50);
		form.add(btnAnnuler);
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String nom = fieldName.getText();
					String prenom = textFieldPrenom.getText();
					String sexe;
					String login = textFieldLogin.getText().toLowerCase();
					String password = textFieldPwd.getText();
					String fonction = (String) comboBoxFonction.getSelectedItem();
					Date anniversaire = dateAnniversaire.getDate();
					String adresse = textAreaAdress.getText();
					String email = textFieldMail.getText().toLowerCase();
					Boolean error = false;
					lblError.setText("");
					lblError.repaint();
					

					if(rdbtnHomme.isSelected()) {
						sexe="H";
					}
					else {
						sexe="F";
					}
					
					if(nom.equals("") || prenom.equals("") || login.equals("") || password.equals("") || anniversaire == null || adresse.equals("") ){
						lblError.setText("Tous les champs ne sont pas remplis");
						error = true;
					}

				if (!error) {
					if(!p.exist(login, email)) {
						p.updateInfo(nom, prenom, login, password, anniversaire, sexe, adresse, email, fonction);
						lblError.setText("Les donn�es sont mises � jour");
					}else
						lblError.setText("Un compte existe d�j� avec ce login ou mot de passe");
					}
				}
		});
	}
	
	

}
