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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JFrame vueLogin;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel img_accueil;
	private JPanel containerMenu;
	private JLabel lblL;
	private JLabel lblConnexion;
	private JPanel containerInfo;
	private JButton button;
	private JLabel lblPassword;
	private JLabel lblLogin;
	private JLabel lblCrerUnCompte;
	private JLabel lbl_close;
	
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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setBounds(300, 150, 300, 30);
		textField.setColumns(10);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setBounds(300, 250, 131, 31);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField.setBounds(300, 300, 300, 30);
		
		button = new JButton("Connexion");
		button.setBounds(300, 450, 300, 40);
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		
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
		
		containerInfo.setLayout(null);
		containerInfo.add(lblLogin);
		containerInfo.add(textField);
		containerInfo.add(lblPassword);
		containerInfo.add(passwordField);
		containerInfo.add(button);
		containerInfo.add(lblCrerUnCompte);
		containerInfo.add(lbl_close);
		
	
		
	}
	
	public void eventHandler() {
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				dispose();
				DashBoard.init(1);
			}
		});
		
		lblCrerUnCompte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//todo créer compte
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
