package be.Denis.Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login vueLogin = new Login();
					vueLogin.setUndecorated(true);
					vueLogin.setLocationRelativeTo(null);
					vueLogin.setResizable(false);
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
		setBackground(Color.DARK_GRAY);

		btnNewButton = new JButton("Vers Accueil");
		
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		setForeground(Color.DARK_GRAY);
		setTitle("Cyclo Courcellois");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void eventHandler() {
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				DashBoard.init(1);
			}
		});
	}

}
