package be.Denis.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DashBoard extends JFrame {

	private JPanel contentMenu;
	private JPanel contentScreen;
	private JPanel screen;
	
	int xx,xy;

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
		setUndecorated(true);
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
		
		screen = new JPanel();
		screen.setBorder(null);
		screen.setBackground(Color.GREEN);
		screen.setBounds(0, 0, 800, 800);
		
		switch (nbrMenu) {
		case 1 : MenuMembre menu = new MenuMembre(this);
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
	            DashBoard.this.setLocation(x - xx, y - xy);  
			}
		});
		
//		contentScreen.add(screen);
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
	
	public void changeScreen(String targetScreen) {
		JPanel newScreen = null;
		switch(targetScreen) {
		case "profil" : newScreen = new Profil();
			break;
		case "balade" : newScreen = new Balades();
			break;
		}
		contentScreen.remove(screen);
		screen = newScreen;
		System.out.println(targetScreen);
		contentScreen.add(screen);
		System.out.println(screen);
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
