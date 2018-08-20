package be.Denis.Vue;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import be.Denis.DAO.AbstractDAOFactory;
import be.Denis.DAO.DAO;
import be.Denis.Model.Balade;
import be.Denis.Model.Membre;
import be.Denis.Model.Responsable;
import be.Denis.Model.Vehicule;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlanningBalade extends JPanel {

	private JTable tableau = null;
	private JPanel panel;
	private JScrollPane scrollPane;

	private Balade balade = null;

	private JTextField textFieldNumBalade;
	private JTextField textFieldLieu;
	private JTextField textFieldForfait;
	private JDateChooser dateChooser;
	private JTextArea textAreaInfo;
	private Object[][] data;
	private int ligne;
	private JLabel lblError;
	private JTextField textFieldType;
	private JTextField textFieldNbrPersonne;
	private JTextField textFieldNbrVelo;
	private JButton btnParticiper;
	private JRadioButton reserver;
	private JRadioButton proposer;
	private JButton btnReserver;
	private JButton btnProposer;
	private JComboBox<Vehicule> comboBoxFonction;
	private Vehicule vehicule;

	/**
	 * Create the panel.
	 */
	public PlanningBalade(Membre membre, DashBoard dashBoard) {
		initComponents(membre);
		evenHandler(membre, dashBoard);
	}

	public void initComponents(Membre membre) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 800, 800);
		setLayout(null);

		JLabel lblPlanning = new JLabel("Planning des balades");
		lblPlanning.setForeground(Color.WHITE);
		lblPlanning.setFont(new Font("Georgia", Font.BOLD, 25));
		lblPlanning.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanning.setBounds(200, 62, 400, 30);
		add(lblPlanning);

		String titre[] = { "Balade", "Date", "Lieu", "Forfait", "Participant", "Information", "Categorie" };
		data = dataJtable(membre);
		this.tableau = new JTable(data, titre);
		this.tableau.setRowHeight(30);

		scrollPane = new JScrollPane(tableau);
		scrollPane.setBounds(150, 103, 500, 300);
		add(scrollPane);

		JLabel lblGestionBalade = new JLabel("Gestion balade :");
		lblGestionBalade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionBalade.setForeground(Color.WHITE);
		lblGestionBalade.setFont(new Font("Georgia", Font.BOLD, 20));
		lblGestionBalade.setBounds(150, 414, 167, 30);
		add(lblGestionBalade);

		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(150, 451, 500, 300);
		panel.setLayout(null);
		add(panel);

		JLabel lblBalade = new JLabel("Balade n\u00B0 :");
		lblBalade.setBounds(84, 27, 82, 18);
		lblBalade.setHorizontalAlignment(SwingConstants.LEFT);
		lblBalade.setForeground(new Color(0, 0, 0));
		lblBalade.setFont(new Font("Georgia", Font.BOLD, 15));
		panel.add(lblBalade);

		textFieldNumBalade = new JTextField();
		textFieldNumBalade.setBounds(176, 27, 86, 20);
		textFieldNumBalade.setColumns(10);
		textFieldNumBalade.setEnabled(false);
		panel.add(textFieldNumBalade);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(176, 89, 250, 20);
		dateChooser.setEnabled(false);
		panel.add(dateChooser);

		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(121, 91, 45, 18);
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setForeground(new Color(0, 0, 0));
		lblDate.setFont(new Font("Georgia", Font.BOLD, 15));
		panel.add(lblDate);

		JLabel lblLieu = new JLabel("Lieu :");
		lblLieu.setBounds(122, 58, 44, 18);
		lblLieu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLieu.setForeground(new Color(0, 0, 0));
		lblLieu.setFont(new Font("Georgia", Font.BOLD, 15));
		panel.add(lblLieu);

		textFieldLieu = new JTextField();
		textFieldLieu.setEditable(false);
		textFieldLieu.setBounds(176, 58, 244, 20);
		textFieldLieu.setColumns(10);
		panel.add(textFieldLieu);

		JLabel lblInformation = new JLabel("Information :");
		lblInformation.setBounds(61, 120, 105, 18);
		lblInformation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInformation.setForeground(new Color(0, 0, 0));
		lblInformation.setFont(new Font("Georgia", Font.BOLD, 15));
		panel.add(lblInformation);

		textAreaInfo = new JTextArea();
		textAreaInfo.setEditable(false);
		textAreaInfo.setBounds(176, 118, 244, 98);
		panel.add(textAreaInfo);

		JLabel lblForfait = new JLabel("Forfait :");
		lblForfait.setBounds(101, 220, 63, 18);
		lblForfait.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForfait.setForeground(new Color(0, 0, 0));
		lblForfait.setFont(new Font("Georgia", Font.BOLD, 15));
		panel.add(lblInformation);

		textFieldForfait = new JTextField();
		textFieldForfait.setEditable(false);
		textFieldForfait.setBounds(176, 220, 86, 20);
		textFieldForfait.setColumns(10);
		panel.add(textFieldForfait);

		btnParticiper = new JButton("Participer");
		btnParticiper.setBounds(176, 249, 176, 40);
		btnParticiper.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		panel.add(btnParticiper);

		JLabel lblType = new JLabel("type :");
		lblType.setHorizontalAlignment(SwingConstants.LEFT);
		lblType.setForeground(Color.BLACK);
		lblType.setFont(new Font("Georgia", Font.BOLD, 15));
		lblType.setBounds(272, 27, 82, 18);
		panel.add(lblType);

		JLabel lblForfait_1 = new JLabel("Forfait :");
		lblForfait_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForfait_1.setForeground(Color.BLACK);
		lblForfait_1.setFont(new Font("Georgia", Font.BOLD, 15));
		lblForfait_1.setBounds(84, 220, 82, 18);
		panel.add(lblForfait_1);

		textFieldType = new JTextField();
		textFieldType.setEditable(false);
		textFieldType.setColumns(10);
		textFieldType.setBounds(322, 27, 86, 20);
		panel.add(textFieldType);

		lblError = new JLabel("");
		lblError.setForeground(new Color(241, 57, 83));
		lblError.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblError.setBounds(100, 760, 800, 27);
		add(lblError);

	}

	public void evenHandler(Membre membre, DashBoard dashBoard) {

		tableau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ligne = tableau.getSelectedRow();
				Date date = new Date();
				int categorie;

				int numBalade = (int) tableau.getValueAt(ligne, 0);
				String dateInString = (String) tableau.getValueAt(ligne, 1);
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				try {

					date = formatter.parse(dateInString);

				} catch (ParseException e) {
					e.printStackTrace();
				}
				String lieu = (String) tableau.getValueAt(ligne, 2);
				Double forfait = (Double) tableau.getValueAt(ligne, 3);
				int nbrParticipant = (int) tableau.getValueAt(ligne, 4);
				String infoBalade = (String) tableau.getValueAt(ligne, 5);
				String cat = (String) tableau.getValueAt(ligne, 6);
				if (cat == "Route") {
					categorie = 1;
				} else if (cat == "Descendeur") {
					categorie = 2;
				} else if (cat == "Randonneur") {
					categorie = 3;
				} else {
					categorie = 4;
				}
				balade = new Balade(numBalade, lieu, date, infoBalade, nbrParticipant, forfait, categorie);

				textFieldNumBalade.setText(String.valueOf(tableau.getValueAt(ligne, 0)));
				textFieldLieu.setText(lieu);
				dateChooser.setDate(date);
				textAreaInfo.setText(infoBalade);
				textFieldForfait.setText(String.valueOf(forfait));
				textFieldType.setText(cat);
			}
		});

		btnParticiper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (balade == null) {
					lblError.setText("Veuillez choisir une balade");
				} else if (membre.reservationExist(balade)) {
					lblError.setText("Vous avez déjà une réservation pour cette balade");
				}else if(membre.propositionExist(balade)) {
					lblError.setText("Vous participé déjà à cette balade");
				}
				else {
					// Vérifier si on n'y participe pas déjà
					removeAll();
					setBorder(new EmptyBorder(5, 5, 5, 5));
					setBackground(Color.DARK_GRAY);
					setBounds(0, 0, 800, 800);
					setLayout(null);

					String date = new SimpleDateFormat("dd-MM-YYYY").format(balade.getDateBalade());

					JLabel lblParticipation = new JLabel("Balade de " + balade.getLieu() + " du " + date);
					lblParticipation.setForeground(Color.WHITE);
					lblParticipation.setFont(new Font("Georgia", Font.BOLD, 25));
					lblParticipation.setHorizontalAlignment(SwingConstants.CENTER);
					lblParticipation.setBounds(50, 50, 700, 30);
					add(lblParticipation);

					panel.removeAll();
					panel.setForeground(new Color(0, 0, 0));
					panel.setBackground(new Color(0, 255, 255));
					panel.setBounds(100, 100, 600, 600);
					panel.setLayout(null);
					add(panel);

					JLabel lblTitre = new JLabel("Voulez-vous réserver ou proposer des places ?");
					lblTitre.setHorizontalAlignment(SwingConstants.LEFT);
					lblTitre.setForeground(Color.BLACK);
					lblTitre.setFont(new Font("Georgia", Font.BOLD, 15));
					lblTitre.setBounds(50, 50, 400, 18);
					panel.add(lblTitre);

					reserver = new JRadioButton("réserver des places");
					reserver.setForeground(Color.BLACK);
					reserver.setBackground(new Color(0, 255, 255));
					reserver.setFont(new Font("Tahoma", Font.BOLD, 15));
					reserver.setBounds(50, 100, 300, 23);
					panel.add(reserver);

					proposer = new JRadioButton("proposer des places");
					proposer.setBackground(new Color(0, 255, 255));
					proposer.setForeground(Color.BLACK);
					proposer.setFont(new Font("Tahoma", Font.BOLD, 15));
					proposer.setBounds(50, 150, 300, 23);
					panel.add(proposer);

					JPanel contentParticipation = new JPanel();
					contentParticipation.setForeground(new Color(0, 0, 0));
					contentParticipation.setBackground(Color.WHITE);
					contentParticipation.setBounds(0, 0, 600, 600);
					contentParticipation.setLayout(null);

					reserver.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							panel.remove(lblError);
							lblError.setText("");
							if (!balade.getListeVehicule().isEmpty()) {
								panel.remove(lblTitre);
								panel.remove(reserver);
								panel.remove(proposer);
								panel.repaint();
								panel.add(contentParticipation);

								JLabel lblTitreReservation = new JLabel("Réservation de places");
								lblTitreReservation.setBounds(150, 30, 400, 25);
								lblTitreReservation.setHorizontalAlignment(SwingConstants.LEFT);
								lblTitreReservation.setForeground(new Color(0, 0, 0));
								lblTitreReservation.setFont(new Font("Georgia", Font.BOLD, 25));
								contentParticipation.add(lblTitreReservation);

								JLabel lblNbrPersonne = new JLabel("Nombre de personne :");
								lblNbrPersonne.setBounds(50, 100, 250, 20);
								lblNbrPersonne.setHorizontalAlignment(SwingConstants.LEFT);
								lblNbrPersonne.setForeground(new Color(0, 0, 0));
								lblNbrPersonne.setFont(new Font("Georgia", Font.BOLD, 15));
								contentParticipation.add(lblNbrPersonne);

								textFieldNbrPersonne = new JTextField();
								textFieldNbrPersonne.setBounds(350, 100, 100, 20);
								textFieldNbrPersonne.setColumns(10);
								contentParticipation.add(textFieldNbrPersonne);

								JLabel lblNbrVelo = new JLabel("Nombre de Vélo :");
								lblNbrVelo.setBounds(50, 200, 250, 20);
								lblNbrVelo.setHorizontalAlignment(SwingConstants.LEFT);
								lblNbrVelo.setForeground(new Color(0, 0, 0));
								lblNbrVelo.setFont(new Font("Georgia", Font.BOLD, 15));
								contentParticipation.add(lblNbrVelo);

								textFieldNbrVelo = new JTextField();
								textFieldNbrVelo.setBounds(350, 200, 100, 20);
								textFieldNbrVelo.setColumns(10);
								contentParticipation.add(textFieldNbrVelo);

								btnReserver = new JButton("Réserver");
								btnReserver.setBounds(200, 400, 176, 40);
								btnReserver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
								contentParticipation.add(btnReserver);

								JLabel lblCombo = new JLabel("Véhicule :");
								lblCombo.setBounds(50, 300, 250, 20);
								lblCombo.setHorizontalAlignment(SwingConstants.LEFT);
								lblCombo.setForeground(new Color(0, 0, 0));
								lblCombo.setFont(new Font("Georgia", Font.BOLD, 15));
								contentParticipation.add(lblCombo);

								comboBoxFonction = new JComboBox<Vehicule>();
								System.out.println(balade.getListeVehicule());
								for (Vehicule v : balade.getListeVehicule()) {
									// comboBoxFonction.addItem(v);
									System.out.println(v.getImmatriculation());
								}

								comboBoxFonction.setBounds(200, 300, 250, 20);
								comboBoxFonction.setFont(new Font("Tahoma", Font.BOLD, 15));
								comboBoxFonction.setForeground(Color.WHITE);
								comboBoxFonction.setBackground(Color.DARK_GRAY);
								comboBoxFonction.setSize(220, 30);
								comboBoxFonction.setLocation(480, 299);
								comboBoxFonction.setSelectedIndex(0);
								contentParticipation.add(comboBoxFonction);

								lblError = new JLabel();
								lblError.setForeground(new Color(241, 57, 83));
								lblError.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
								lblError.setBounds(25, 500, 550, 27);
								contentParticipation.add(lblError);

								btnReserver.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										boolean error = false;
										Vehicule v = (Vehicule) comboBoxFonction.getSelectedItem();
										int nbrP = v.getNbrPlacePersonne();
										int nbrV = v.getNbrPlaceVelo();
										lblError.setText("");
										// Vérifie que l'on rentre une valeur correcte
										String pattern = "^[1-9]\\d*$";
										if (!textFieldNbrPersonne.getText().matches(pattern)
												|| !textFieldNbrVelo.getText().matches(pattern)) {
											error = true;
											lblError.setText("Entrez un nombre correcte dans les champs");
										}
										if (Integer.parseInt(textFieldNbrPersonne.getText()) > nbrP) {
											error = true;
											lblError.setText("Pas assez de place disponible");
										}
										if (!error) {
											boolean reservation = membre.reserverBalade(balade,
													Integer.parseInt(textFieldNbrPersonne.getText()),
													Integer.parseInt(textFieldNbrVelo.getText()));
											if (reservation) {
												dashBoard.changeScreen("planningBalade");
											} else {
												lblError.setText("Vous avez déjà une réservation pour cette balade");
											}
										}
									}
								});
								contentParticipation.repaint();

							}else {
								lblError.setText("Il n'y a pas encore de véhicule de disponible");
								lblError.setBounds(25, 500, 800, 27);
								panel.add(lblError);
								panel.repaint();
							}
						}
					});

					proposer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							panel.remove(lblTitre);
							panel.remove(reserver);
							panel.remove(proposer);
							panel.repaint();
							panel.add(contentParticipation);

							JLabel lblTitreProposition = new JLabel("Proposé un véhicule");
							lblTitreProposition.setBounds(150, 30, 400, 25);
							lblTitreProposition.setHorizontalAlignment(SwingConstants.LEFT);
							lblTitreProposition.setForeground(new Color(0, 0, 0));
							lblTitreProposition.setFont(new Font("Georgia", Font.BOLD, 25));
							contentParticipation.add(lblTitreProposition);

							btnProposer = new JButton("Proposer");
							btnProposer.setBounds(215, 500, 176, 40);
							btnProposer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
							contentParticipation.add(btnProposer);

							String titre[] = { "Marque", "Model", "Immatriculation", "Nbr Personne", "Nbr Vélo" };
							data = dataJtableVehicule(membre);

							tableau = new JTable(data, titre);
							tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
							tableau.setRowHeight(30);

							scrollPane = new JScrollPane(tableau);
							scrollPane.setBounds(50, 100, 500, 300);
							contentParticipation.add(scrollPane);
							
							tableau.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {

									ligne = tableau.getSelectedRow();
									String marque = (String) tableau.getValueAt(ligne, 0);
									String model = (String) tableau.getValueAt(ligne, 1);
									String immatriculation = (String) tableau.getValueAt(ligne, 2);
									int nbrPersonne = (int) tableau.getValueAt(ligne, 3);
									int nbrVelo = (int) tableau.getValueAt(ligne, 4);
									
									vehicule = new Vehicule(immatriculation, marque, model, nbrPersonne, nbrVelo);
								}
							});
							
							btnProposer.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent arg0) {
									panel.remove(lblError);
									lblError.setText("");
									if(balade != null) {
										if(!membre.getListeVehicule().isEmpty()) {
											System.out.println("appel la fonction proposerPlace");
											membre.proposerPlace(balade, vehicule);
										}else {
											lblError.setText("Vous ne disposé pas de véhicule");
											lblError.setBounds(25, 550, 800, 25);
										}
									}
								}
							});
							contentParticipation.add(lblError);
							contentParticipation.repaint();
						}
					});

				}

			}
		});

	}

	public Object[][] dataJtable(Membre membre) {
		int nbrObject = 0;
		for (Balade balade : membre.getListeBalade()) {
			Date dateNow = new Date();
			if (balade.getDateBalade().after(dateNow)) {
				nbrObject++;
			}
		}

		Object[][] data = new Object[nbrObject][7];
		int i = 0;
		for (Balade balade : membre.getListeBalade()) {
			Date dateNow = new Date();
			if (balade.getDateBalade().after(dateNow)) {
				String date = new SimpleDateFormat("dd-MM-YYYY").format(balade.getDateBalade());
				data[i][0] = balade.getNumBalade();
				data[i][1] = date;
				data[i][2] = balade.getLieu();
				data[i][3] = balade.getForfait();
				data[i][4] = balade.getNbrParticipant();
				data[i][5] = balade.getInfoBalade();
				if (balade.getCat() == 1) {
					data[i][6] = "Route";
				} else if (balade.getCat() == 2) {
					data[i][6] = "Descendeur";
				} else if (balade.getCat() == 3) {
					data[i][6] = "Randonneur";
				} else {
					data[i][6] = "Trialiste";
				}
				i++;
			}
		}
		return data;
	}
	
	public Object[][] dataJtableVehicule(Membre m) {
		int nbrObject = m.getListeVehicule().size();

		Object[][] data = new Object[nbrObject][5];
		int i = 0;
		for (Vehicule vehicule : m.getListeVehicule()) {

			data[i][0] = vehicule.getMarque();
			data[i][1] = vehicule.getModel();
			data[i][2] = vehicule.getImmatriculation();
			data[i][3] = vehicule.getNbrPlacePersonne();
			data[i][4] = vehicule.getNbrPlaceVelo();
			i++;

		}
		return data;
	}
}
