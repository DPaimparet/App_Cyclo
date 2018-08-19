package be.Denis.Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import be.Denis.Model.Membre;
import be.Denis.Model.Vehicule;

public class VehiculeMembre extends JPanel {

	private JTable tableau = null;
	private JPanel panel;
	private JScrollPane scrollPane;

	private Vehicule vehicule = null;

	private JTextField textFieldImmatriculation;
	private JTextField textFieldMarque;
	private Object[][] data;
	private int ligne;
	private JLabel lblError;
	private JTextField textFieldModel;
	private JTextField textFieldPersonne;
	private JTextField textFieldVelo;
	private JButton btnAjouter;
	private JButton btnSupprimer;

	private boolean error = false;

	/**
	 * Create the panel.
	 */
	public VehiculeMembre(Membre m, DashBoard dashBoard) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 800, 800);
		setLayout(null);

		JLabel lblListing = new JLabel("Listing de vos v\u00E9hicules");
		lblListing.setForeground(Color.WHITE);
		lblListing.setFont(new Font("Georgia", Font.BOLD, 25));
		lblListing.setHorizontalAlignment(SwingConstants.CENTER);
		lblListing.setBounds(200, 62, 400, 30);
		add(lblListing);

		String titre[] = { "Marque", "Model", "Immatriculation", "Nbr Personne", "Nbr Vélo" };
		data = dataJtable(m);

		this.tableau = new JTable(data, titre);
		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.tableau.setRowHeight(30);

		scrollPane = new JScrollPane(tableau);
		scrollPane.setBounds(150, 103, 500, 300);
		add(scrollPane);

		JLabel lblGestionVehicule = new JLabel("Gestion v\u00E9hicule :");
		lblGestionVehicule.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionVehicule.setForeground(Color.WHITE);
		lblGestionVehicule.setFont(new Font("Georgia", Font.BOLD, 20));
		lblGestionVehicule.setBounds(150, 414, 247, 30);
		add(lblGestionVehicule);

		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(150, 451, 500, 300);
		panel.setLayout(null);
		add(panel);

		JLabel lblImmatriculation = new JLabel("Immatriculation :");
		lblImmatriculation.setBounds(93, 46, 156, 18);
		lblImmatriculation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImmatriculation.setForeground(new Color(0, 0, 0));
		lblImmatriculation.setFont(new Font("Georgia", Font.BOLD, 15));
		panel.add(lblImmatriculation);

		textFieldImmatriculation = new JTextField();
		textFieldImmatriculation.setBounds(259, 46, 139, 20);
		textFieldImmatriculation.setColumns(10);
		panel.add(textFieldImmatriculation);

		JLabel lblModel = new JLabel("Model :");
		lblModel.setBounds(173, 110, 76, 18);
		lblModel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblModel.setForeground(new Color(0, 0, 0));
		lblModel.setFont(new Font("Georgia", Font.BOLD, 15));
		panel.add(lblModel);

		JLabel lblMarque = new JLabel("Marque :");
		lblMarque.setBounds(163, 77, 86, 18);
		lblMarque.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarque.setForeground(new Color(0, 0, 0));
		lblMarque.setFont(new Font("Georgia", Font.BOLD, 15));
		panel.add(lblMarque);

		textFieldMarque = new JTextField();
		textFieldMarque.setBounds(259, 77, 139, 20);
		textFieldMarque.setColumns(10);
		panel.add(textFieldMarque);

		JLabel lblPlacePersonne = new JLabel("Nbr Personne :");
		lblPlacePersonne.setBounds(110, 139, 139, 18);
		lblPlacePersonne.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlacePersonne.setForeground(new Color(0, 0, 0));
		lblPlacePersonne.setFont(new Font("Georgia", Font.BOLD, 15));
		panel.add(lblPlacePersonne);

		JLabel lblForfait = new JLabel("Forfait :");
		lblForfait.setBounds(101, 220, 63, 18);
		lblForfait.setHorizontalAlignment(SwingConstants.RIGHT);
		lblForfait.setForeground(new Color(0, 0, 0));
		lblForfait.setFont(new Font("Georgia", Font.BOLD, 15));
		panel.add(lblPlacePersonne);

		textFieldModel = new JTextField();
		textFieldModel.setColumns(10);
		textFieldModel.setBounds(259, 110, 139, 20);
		panel.add(textFieldModel);

		textFieldPersonne = new JTextField();
		textFieldPersonne.setColumns(10);
		textFieldPersonne.setBounds(259, 139, 61, 20);
		panel.add(textFieldPersonne);

		JLabel lblPlaceVelo = new JLabel("Nbr V\u00E9lo :");
		lblPlaceVelo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlaceVelo.setForeground(Color.BLACK);
		lblPlaceVelo.setFont(new Font("Georgia", Font.BOLD, 15));
		lblPlaceVelo.setBounds(144, 168, 105, 18);
		panel.add(lblPlaceVelo);

		textFieldVelo = new JTextField();
		textFieldVelo.setColumns(10);
		textFieldVelo.setBounds(259, 168, 61, 20);
		panel.add(textFieldVelo);

		lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblError.setBounds(50, 211, 500, 27);
		panel.add(lblError);
		lblError.setForeground(Color.RED);

		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(61, 249, 176, 40);
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		panel.add(btnAjouter);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnSupprimer.setBounds(271, 249, 176, 40);
		panel.add(btnSupprimer);

		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				if(vehicule == null) {
					lblError.setText("Vous ne disposez pas de véhicule");
				}
				else {
					m.retirerVehicule(vehicule);
					m.getListeVehicule().remove(vehicule);
					dashBoard.changeScreen("vehiculeMembre");
				}
			}
		});

		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				error = false;
				lblError.setText("");
				String pattern = "^\\d+$";
				if (textFieldMarque.getText().isEmpty() || textFieldModel.getText().isEmpty()
						|| textFieldImmatriculation.getText().isEmpty() || textFieldPersonne.getText().isEmpty()
						|| textFieldVelo.getText().isEmpty()) {
					lblError.setText("Tous les champs doivent être remplis");
					error = true;

				}

				if (!textFieldPersonne.getText().matches(pattern)) {
					lblError.setText("entrée un nombre de places de personne correcte");
					error = true;
				}
				if (!textFieldVelo.getText().matches(pattern)) {
					lblError.setText("entrée un nombre de places de vélo correcte");
					error = true;
				}
				if (!error) {
					String marque = textFieldMarque.getText();
					String model = textFieldModel.getText();
					String immatriculation = textFieldImmatriculation.getText();
					int nbrPersonne = Integer.parseInt(textFieldPersonne.getText());
					int nbrVelo = Integer.parseInt(textFieldVelo.getText());

					vehicule = new Vehicule(immatriculation, marque, model, nbrPersonne, nbrVelo);
					m.ajouterVehicule(vehicule);
					dashBoard.changeScreen("vehiculeMembre");
				}
			}
		});

		tableau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ligne = tableau.getSelectedRow();
				String marque = (String) tableau.getValueAt(ligne, 0);
				String model = (String) tableau.getValueAt(ligne, 1);
				String immatriculation = (String) tableau.getValueAt(ligne, 2);
				int nbrPersonne = (int) tableau.getValueAt(ligne, 3);
				int nbrVelo = (int) tableau.getValueAt(ligne, 4);

				textFieldImmatriculation.setText(immatriculation);
				textFieldMarque.setText(marque);
				textFieldModel.setText(model);
				textFieldPersonne.setText(String.valueOf(nbrPersonne));
				textFieldVelo.setText(String.valueOf(nbrVelo));
				
				vehicule = new Vehicule(immatriculation, marque, model, nbrPersonne, nbrVelo);
			}
		});

	}

	public Object[][] dataJtable(Membre m) {
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
