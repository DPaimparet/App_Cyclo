package be.Denis.Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;


public class DashBoard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void init(int i) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard(i);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DashBoard(int type) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contentMenu = new JPanel();
		contentMenu.setBackground(Color.DARK_GRAY);
		contentMenu.setForeground(Color.WHITE);
		contentMenu.setBounds(0, 0, 400, 800);
		contentMenu.setLayout(null);
		

		JPanel contentScreen = new JPanel();
		contentScreen.setBackground(Color.LIGHT_GRAY);
		contentScreen.setBounds(400, 0, 880, 800);
		contentScreen.setLayout(null);
		
		switch (type) {
		case 1 : MenuMembre menu = new MenuMembre(contentMenu, this);
				 menu.setBounds(0, 0, 400, 600);
				 contentMenu.add(menu);
			break;
		case 2 :
			;
			break;
		case 3 :
			;
			break;
		default : ;
		}
		contentPane.add(contentScreen);
		contentPane.add(contentMenu);
		
	}

}
