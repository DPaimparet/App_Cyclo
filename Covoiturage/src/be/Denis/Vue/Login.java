package be.Denis.Vue;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import be.Denis.Model.*;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginOuEmail;
	private JPasswordField passwordField;
	private JPanel img_accueil;
	private JPanel containerMenu;
	private JLabel lblL;
	private JLabel lblConnexion;
	private JPanel containerInfo;
	private JLabel lblPassword;
	private JLabel lblLogin;
	private JLabel lblCrerUnCompte;
	private JLabel lbl_close;
	private JLabel lblErreur;
	private JButton btnConnexion;
	
	private int xx, xy;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login vueLogin = new Login();
					vueLogin.setLocationRelativeTo(null);
					vueLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		eventHandler();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setAlwaysOnTop(true);
		setResizable(false);
		setUndecorated(true);
		setTitle("Cyclo Courcellois");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);

		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBounds(0, 0, 600, 800);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		containerMenu = new JPanel();
		containerMenu.setBorder(null);
		containerMenu.setBackground(Color.GRAY);
		containerMenu.setBounds(0, 0, 400, 800);
		containerMenu.setLayout(null);
		contentPane.add(containerMenu);
		
		img_accueil = new JPanel();
		img_accueil.setBorder(null);
		img_accueil.setBackground(Color.DARK_GRAY);
		img_accueil.setBounds(-1, -27, 401, 717);
		containerMenu.add(img_accueil);
		
		lblL = new JLabel("");
		img_accueil.add(lblL);
		lblL.setBackground(Color.GRAY);
		lblL.setIcon(new ImageIcon("images\\img_accueil.jpg"));
		lblL.setBounds(0,0,400,800);
		
		lblConnexion = new JLabel("Cyclo Courcellois");
		lblConnexion.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 30));
		lblConnexion.setBounds(100, 700, 185, 68);
		containerMenu.add(lblConnexion);
				
		containerInfo = new JPanel();
		containerInfo.setBorder(null);
		containerInfo.setBackground(Color.DARK_GRAY);
		containerInfo.setBounds(400, 0, 880, 800);
		contentPane.add(containerInfo);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.LIGHT_GRAY);
		lblLogin.setBounds(300, 100, 73, 31);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		txtLoginOuEmail = new JTextField("Insérez votre login ou votre mail");
		txtLoginOuEmail.setForeground(Color.LIGHT_GRAY);
		txtLoginOuEmail.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtLoginOuEmail.setBounds(300, 150, 300, 30);
		txtLoginOuEmail.setColumns(10);
		
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setBounds(300, 250, 131, 31);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField.setBounds(300, 300, 300, 30);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(300, 450, 300, 40);
		btnConnexion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConnexion.setForeground(Color.WHITE);
		btnConnexion.setBackground(new Color(241, 57, 83));
		
		lblCrerUnCompte = new JLabel("Cr\u00E9er un nouvel utilisateur");
		lblCrerUnCompte.setBounds(333, 545, 236, 25);
		lblCrerUnCompte.setForeground(Color.YELLOW);
		lblCrerUnCompte.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
		lbl_close = new JLabel("X");
		lbl_close.setBounds(830, 0, 50, 50);
		lbl_close.setBackground(Color.WHITE);
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(Color.RED);
		lbl_close.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		lblErreur = new JLabel("");
		lblErreur.setForeground(Color.RED);
		lblErreur.setBounds(270, 600, 400, 100);
		lblErreur.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		containerInfo.setLayout(null);
		containerInfo.add(lblLogin);
		containerInfo.add(txtLoginOuEmail);
		containerInfo.add(lblPassword);
		containerInfo.add(passwordField);
		containerInfo.add(lblErreur);
		containerInfo.add(btnConnexion);
		containerInfo.add(lblCrerUnCompte);
		containerInfo.add(lbl_close);
		
	
		
	}
	
	public void eventHandler() {
		
		/***
		 * Connexion
		 */
		
		btnConnexion.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ev){
				if(!txtLoginOuEmail.getText().equals("") && !passwordField.getText().equals("")){
					Personne p = new Personne(txtLoginOuEmail.getText().toLowerCase(),passwordField.getText().toLowerCase());
					try {
						if(p.connexion()){
							dispose();
						}else {
							lblErreur.setText("login ou mot de passe incorrect");
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					lblErreur.setText("Veuillez remplir tous les champs");
				}
			}	
		});
		
		txtLoginOuEmail.addMouseListener(new MouseListener(){
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				JTextField txtLoginOuEmail = ((JTextField)e.getSource());
				txtLoginOuEmail.setText("");
				txtLoginOuEmail.getFont().deriveFont(Font.PLAIN);
				txtLoginOuEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
				txtLoginOuEmail.setForeground(Color.black);
				txtLoginOuEmail.removeMouseListener(this);
			}
		});
		
		lblCrerUnCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Inscription.init();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCrerUnCompte.setForeground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCrerUnCompte.setForeground(Color.YELLOW);
			}
		});
		
		
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Login.this.setLocation(x - xx, y - xy);  
			}
		});
		
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
	}

}
