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
						MenuMembre menuMembre = new MenuMembre(this, membre);
						contentMenu.add(menuMembre,BorderLayout.CENTER);
						AccueilMembre accueilMembre = new AccueilMembre(membre,this);
						screen.add(accueilMembre);
				 		this.validate();
				 		break;
				 		
		case "Responsable" : responsable = new Responsable(p.getNom(), p.getPrenom(), p.getMatricule(), p.getLogin(), p.getPassword(),
		 		 			 p.getDateNaissance(), p.getAdresse(), p.getEmail(), p.getSex(), p.getInscription(), p.getFonction());
		 					 MenuResponsable menuResponsable = new MenuResponsable(this, responsable);
		 					 contentMenu.add(menuResponsable,BorderLayout.CENTER);
		 					 AccueilResponsable accueilResponsable = new AccueilResponsable(responsable,this);
		 					 screen.add(accueilResponsable);
		 					 this.validate();
		 					 break;
		case "Tresorier" :  tresorier = new Tresorier(p.getNom(), p.getPrenom(), p.getMatricule(), p.getLogin(), p.getPassword(),
		 		 			 p.getDateNaissance(), p.getAdresse(), p.getEmail(), p.getSex(), p.getInscription(), p.getFonction());
							MenuTresorier menuTresorier = new MenuTresorier(this,tresorier);
							contentMenu.add(menuTresorier,BorderLayout.CENTER);
							AccueilTresorier acceuilTresorier = new AccueilTresorier(tresorier,this);
		 					screen.add(acceuilTresorier);
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
		case "profilMembre" : newScreen = new ProfilMembre(membre, this);
			break;
		case "profilResponsable" : newScreen = new ProfilResponsable(responsable);
		break;
		case "profilTresorier" : newScreen = new ProfilTresorier(tresorier);
		break;
		case "baladeMembre" : newScreen = new BaladeMembre(membre, this);
			break;
		case "planningBalade" : newScreen = new PlanningBalade(membre, this);
		break;
		case "baladeResponsable" : newScreen = new BaladeResponsable(responsable, this);
		break;
		case "creerBalade" : newScreen = new CreerBalade(responsable);
		break;
		case "accueilResponsable" : newScreen = new AccueilResponsable(responsable,this);
		break;
		case "accueilMembre" : newScreen = new AccueilMembre(membre,this);
		break;
		case "accueilTresorier" : newScreen = new AccueilTresorier(tresorier,this);
		break;
		case "vehiculeMembre" : newScreen = new VehiculeMembre(membre,this);
		break;
		case "compteMembre" : newScreen = new CompteMembre(membre,this);
		break;
		case "compteDeplacement" : newScreen = new CompteDeplacement(tresorier,this);
		break;
		case "compteForfait" : newScreen = new CompteForfait(tresorier,this);
		break;
		}
		screen.removeAll();
		screen.add(newScreen,BorderLayout.CENTER);
		screen.validate();
		screen.repaint();
	}	
	
}
