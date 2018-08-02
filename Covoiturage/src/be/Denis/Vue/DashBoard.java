package be.Denis.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DashBoard extends JFrame {

	private JPanel contentMenu;
	private JPanel contentScreen;

	public void setContentMenu(JPanel contentMenu) {
		this.contentMenu = contentMenu;
	}

	public void setContentScreen(JPanel contentScreen) {
		this.contentScreen = contentScreen;
	}

	public JPanel getContentMenu() {
		return contentMenu;
	}

	public JPanel getContentScreen() {
		return contentScreen;
	}

	/**
	 * Launch the application.
	 */
	public static void init(int nbr) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard(nbr);
					frame.setLocationRelativeTo(null);
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
	public DashBoard(int i) {
		initialize(i);
		
	}
	/***
	 *  Initialize the contents of the frame.
	 */
	
	private void initialize(int nbrMenu) {
		setUndecorated(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 800);
		
		contentMenu = new JPanel();
		contentMenu.setBorder(null);
		contentMenu.setBackground(Color.DARK_GRAY);
		contentMenu.setBounds(0, 0, 400, 800);
		
		contentScreen = new JPanel();
		contentScreen.setBorder(null);
		contentScreen.setBackground(Color.LIGHT_GRAY);
		contentScreen.setBounds(400, 0, 880, 800);
		
		switch (nbrMenu) {
		case 1 : MenuMembre menu = new MenuMembre(this);
				 //menu.setBounds(0, 0, 400, 600);
				 contentMenu.add(menu);
				 this.validate();
			break;
		case 2 :
			;
			break;
		case 3 :
			;
			break;
		default : ;
		}
		
		
		add(contentMenu, BorderLayout.WEST);
		add(contentScreen, BorderLayout.CENTER);

	}
	
	/***
	 * Remove JPanel screen
	 */
	
	public void removeScreen () {
		this.remove(contentScreen);
		this.validate();
	}
//	
//	/***
//	 * Added new JPanel as new screen
//	 */
//	public void addNewScreen(JPanel panel) {
//		dashBoard
//	}
}
