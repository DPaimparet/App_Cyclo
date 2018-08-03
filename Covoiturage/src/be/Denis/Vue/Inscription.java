package be.Denis.Vue;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Inscription extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_close;
	private JPanel title;
	private JPanel form;
	private JLabel lblPrenom;
	private JLabel lblMail;
	private JLabel lblAdress;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JLabel lblSexe;
	private JLabel lblError;
	private JTextField fieldName;
	private JTextField textFieldConfirmPwd;
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

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription vueInscription = new Inscription();
					vueInscription.setLocationRelativeTo(null);
					vueInscription.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inscription() {
		initialize();
		eventHandler();
	}
	
	private void initialize() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 800);
		setBackground(Color.DARK_GRAY);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		title = new JPanel();
		title.setBackground(new Color(0, 128, 0));
		title.setBounds(0, 0, 500, 75);
		contentPane.add(title);
		title.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setForeground(new Color(152, 251, 152));
		lblNewLabel.setBounds(29, 11, 164, 53);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		title.add(lblNewLabel);
		
		form = new JPanel();
		form.setBackground(Color.DARK_GRAY);
		form.setBounds(0, 75, 500, 725);
		contentPane.add(form);
		form.setLayout(null);
		
		
		JLabel lblName = new JLabel("Nom :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(156, 11, 43, 30);
		form.add(lblName);
		
		fieldName = new JTextField();
		lblName.setLabelFor(fieldName);
		fieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fieldName.setBounds(222, 16, 220, 20);
		form.add(fieldName);
		fieldName.setColumns(10);
		
		lblPrenom = new JLabel("Pr\u00E9nom :");
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrenom.setBounds(133, 52, 66, 40);
		form.add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(222, 62, 220, 20);
		form.add(textFieldPrenom);
		
		lblMail = new JLabel("E-Mail :");
		lblMail.setForeground(Color.WHITE);
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMail.setBounds(143, 101, 56, 40);
		form.add(lblMail);
		
		textFieldMail = new JTextField();
		textFieldMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(222, 113, 220, 20);
		form.add(textFieldMail);
		
		lblLogin = new JLabel("Login :");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(149, 152, 50, 40);
		form.add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldLogin.setColumns(10);
		textFieldLogin.setBounds(222, 164, 220, 20);
		form.add(textFieldLogin);
		
		lblPassword = new JLabel("Mot de passe :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(93, 203, 106, 40);
		form.add(lblPassword);
		
		textFieldPwd = new JTextField();
		textFieldPwd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPwd.setColumns(10);
		textFieldPwd.setBounds(222, 215, 220, 20);
		form.add(textFieldPwd);
		
		JLabel lblConfirmMotDe = new JLabel("Confirm mot de passe :");
		lblConfirmMotDe.setForeground(Color.WHITE);
		lblConfirmMotDe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConfirmMotDe.setBounds(30, 254, 169, 40);
		form.add(lblConfirmMotDe);
		
		textFieldConfirmPwd = new JTextField();
		textFieldConfirmPwd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldConfirmPwd.setColumns(10);
		textFieldConfirmPwd.setBounds(222, 266, 220, 20);
		form.add(textFieldConfirmPwd);
		
		lblAdress = new JLabel("Adresse :");
		lblAdress.setForeground(Color.WHITE);
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdress.setBounds(30, 356, 80, 40);
		form.add(lblAdress);
		
		lblSexe = new JLabel("Sexe : ");
		lblSexe.setForeground(Color.WHITE);
		lblSexe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSexe.setBounds(156, 305, 56, 40);
		form.add(lblSexe);
		
		rdbtnFemme = new JRadioButton("F\u00E9minin");
		rdbtnFemme.setForeground(Color.WHITE);
		rdbtnFemme.setBackground(Color.DARK_GRAY);
		rdbtnFemme.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnFemme.setBounds(342, 314, 100, 23);
		form.add(rdbtnFemme);
		
		rdbtnHomme = new JRadioButton("Masculin");
		rdbtnHomme.setSelected(true);
		rdbtnHomme.setBackground(Color.DARK_GRAY);
		rdbtnHomme.setForeground(Color.WHITE);
		rdbtnHomme.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnHomme.setBounds(222, 314, 100, 23);
		form.add(rdbtnHomme);
		
		textAreaAdress = new JTextArea();
		textAreaAdress.setBounds(142, 366, 300, 152);
		form.add(textAreaAdress);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblError.setBounds(30, 593, 412, 49);
		form.add(lblError);
		
		btnConfirm = new JButton("Confirmer");
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConfirm.setBounds(75, 653, 150, 50);
		form.add(btnConfirm);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAnnuler.setBounds(275, 653, 150, 50);
		form.add(btnAnnuler);
		
		lbl_close = new JLabel("X");
		lbl_close.setBounds(450, 0, 50, 50);
		lbl_close.setBackground(Color.WHITE);
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(240, 230, 140));
		lbl_close.setFont(new Font("Tahoma", Font.BOLD, 25));
		title.add(lbl_close);
		
		comboBoxFonction = new JComboBox<String>();
		comboBoxFonction.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBoxFonction.setForeground(Color.WHITE);
		comboBoxFonction.setBackground(Color.DARK_GRAY);
		comboBoxFonction.setSize(220, 30);
		comboBoxFonction.setLocation(222, 552);
		comboBoxFonction.setModel(new DefaultComboBoxModel<String>(new String[] {"Membre", "Responsable", "Tresorier"}));
		comboBoxFonction.setSelectedIndex(0);
		form.add(comboBoxFonction);
		
		JLabel lblFonction = new JLabel("Fonction");
		lblFonction.setForeground(Color.WHITE);
		lblFonction.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFonction.setBounds(133, 547, 66, 40);
		form.add(lblFonction);
	}
	
	private void eventHandler() {
		
		btnAnnuler.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				dispose();
				Login.init();
			}
		});
		
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Login.init();
			}
		});
		
		rdbtnFemme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnHomme.setSelected(false);
			}
		});
		
		rdbtnHomme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnFemme.setSelected(false);
			}
		});
	}
}
