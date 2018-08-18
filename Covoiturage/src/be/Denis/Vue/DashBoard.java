package be.Denis.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

import be.Denis.Model.*;

@SuppressWarnings("serial")
public class DashBoard extends JFrame {

	private JPanel contentMenu;
	private JPanel contentScreen;
	private JPanel screen;
	
	private Membre membre;
	private Responsable responsable;
	private Tresorier tresorier;
	
	int xx,xy;

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
	public static void init(Personne p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard(p);
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
	public DashBoard(Personne p) {
		initialize(p);
	}
	/***
	 *  Initialize the contents of the frame.
	 */
	
	private void initialize(Personne p) {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 800);
		
		contentMenu = new JPanel();
		contentMenu.setBorder(null);
		contentMenu.setBackground(Color.DARK_GRAY);
		contentMenu.setBounds(0, 0, 400, 800);
		contentMenu.setLayout(new BorderLayout(0, 0));
		
		contentScreen = new JPanel();
		contentScreen.setBorder(null);
		contentScreen.setBackground(Color.LIGHT_GRAY);
		contentScreen.setBounds(400, 0, 880, 800);
		contentScreen.setLayout(new BorderLayout(0, 0));
		
		screen = new JPanel();
		screen.setBorder(null);
		screen.setBackground(Color.DARK_GRAY);
		screen.setBounds(0, 0, 800, 800);
		screen.setLayout(new BorderLayout(0, 0));
		
		contentScreen.add(screen, BorderLayout.CENTER);

		
		switch (p.getFonction()) {
		case "Membre" : membre = new Membre(p.getNom(), p.getPrenom(), p.getMatricule(), p.getLogin(), p.getPassword(),
	 					p.getDateNaissance(), p.getAdresse(), p.getEmail(), p.getSex(), p.getInscription(), p.getFonction());
						MenuMembre menuMembre = new MenuMembre(this);
				 		contentMenu.add(menuMembre,BorderLayout.CENTER);
				 		this.validate();
				 		break;
		case "Responsable" : MenuResponsable menuResponsable = new MenuResponsable(this);
		 					 contentMenu.add(menuResponsable,BorderLayout.CENTER);
		 					 responsable = new Responsable(p.getNom(), p.getPrenom(), p.getMatricule(), p.getLogin(), p.getPassword(),
		 		 					p.getDateNaissance(), p.getAdresse(), p.getEmail(), p.getSex(), p.getInscription(), p.getFonction());
		 					 AccueilResponsable accueil = new AccueilResponsable(responsable,this);
		 					 screen.add(accueil);
		 					 this.validate();
		 					 break;
		case "Tresorier" :  MenuTresorier menuTresorier = new MenuTresorier(this);
		 					contentMenu.add(menuTresorier,BorderLayout.CENTER);
		 					this.validate();
		 					break;
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

		
		getContentPane().setLayout(null);
		getContentPane().add(contentMenu);
		getContentPane().add(contentScreen);

	}
	
	/***
	 * Remove JPanel screen
	 */
	public void changeScreen(String targetScreen) {
		JPanel newScreen = null;
		switch(targetScreen) {
		case "profilMembre" : newScreen = new ProfilMembre(membre);
			break;
		case "profilResponsable" : newScreen = new ProfilResponsable(responsable);
		break;
		case "profilTresorier" : newScreen = new ProfilTresorier(tresorier);
		break;
		case "baladeMembre" : newScreen = new BaladeMembre(membre);
			break;
		case "planningBalade" : newScreen = new PlanningBalade(membre);
		break;
		case "baladeResponsable" : newScreen = new BaladeResponsable(responsable, this);
		break;
		case "creerBalade" : newScreen = new CreerBalade(responsable);
		break;
		case "accueilResponsable" : newScreen = new AccueilResponsable(responsable,this);
		break;
		}
		screen.removeAll();
		screen.add(newScreen,BorderLayout.CENTER);
		screen.validate();
		screen.repaint();
	}	
	
}
