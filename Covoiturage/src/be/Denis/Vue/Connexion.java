package be.Denis.Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Connexion {

	private JFrame containerConnexion;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion window = new Connexion();
					window.containerConnexion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Connexion() {
		initialize();
		eventHandler();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		containerConnexion = new JFrame();
		containerConnexion.getContentPane().setBackground(Color.DARK_GRAY);
		
		btnNewButton = new JButton("Vers Accueil");
		
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		containerConnexion.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		containerConnexion.setForeground(Color.DARK_GRAY);
		containerConnexion.setTitle("Cyclo Courcellois");
		containerConnexion.setBounds(100, 100, 800, 600);
		containerConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void eventHandler() {
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				containerConnexion.dispose();
				DashBoard.init(1);
			}
		});
	}

}
