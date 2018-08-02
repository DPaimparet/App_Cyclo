package be.Denis.Vue;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

public class Login extends JFrame {

	private JButton btnNewButton;
	
	private int xx, xy;

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
		setForeground(Color.DARK_GRAY);
		setTitle("Cyclo Courcellois");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnNewButton = new JButton("Vers Accueil");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);

		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Login.this.setLocation(x - xx, y - xy);  
			}
		});
		
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.setBackground(Color.WHITE);
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(241, 57, 83));
		lbl_close.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbl_close.setBounds(750, 0, 50, 50);
		
		
		getContentPane().add(lbl_close);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
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
