package be.Denis.Vue;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.Denis.Model.Balade;
import be.Denis.Model.Membre;
import be.Denis.Model.Responsable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class BaladeMembre extends JPanel {
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

	/**
	 * Create the panel.
	 */
	public BaladeMembre(Membre membre, DashBoard dashBoard) {

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 800, 800);
		setLayout(null);

		JLabel lblPlanning = new JLabel("Planning de vos balades");
		lblPlanning.setForeground(Color.WHITE);
		lblPlanning.setFont(new Font("Georgia", Font.BOLD, 25));
		lblPlanning.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanning.setBounds(200, 62, 400, 30);
		add(lblPlanning);

		

		String titre[] = { "Balade", "Date", "Lieu", "Forfait", "Participant", "Information" , "cat" };
		data = dataJtable(membre);

		this.tableau = new JTable(data, titre);
		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.tableau.setRowHeight(30);

		scrollPane = new JScrollPane(tableau);
		scrollPane.setBounds(150, 103, 500, 300);
		add(scrollPane);

		JLabel lblGestionBalade = new JLabel("Information de la balade :");
		lblGestionBalade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionBalade.setForeground(Color.WHITE);
		lblGestionBalade.setFont(new Font("Georgia", Font.BOLD, 20));
		lblGestionBalade.setBounds(150, 410, 303, 30);
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
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnSupprimer.setBounds(162, 251, 176, 40);
		panel.add(btnSupprimer);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(150, 762, 500, 27);
		add(lblError);
		
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
				
				balade = new Balade(numBalade, lieu, date, infoBalade, nbrParticipant, forfait, categorie );
				
				textFieldNumBalade.setText(String.valueOf(tableau.getValueAt(ligne, 0)));
				textFieldLieu.setText(lieu);
				dateChooser.setDate(date);
				textAreaInfo.setText(infoBalade);
				textFieldForfait.setText(String.valueOf(forfait));
			}
		});
		
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(balade != null) {
					for(Balade b : membre.getListeBalade()) {
						if(b.equals(balade)) {
							membre.annulerBalade(b);
							membre.getListeBalade().remove(b);
							dashBoard.changeScreen("baladeMembre");
						}
					}
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
		int cat;
		String nomCat;
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
				cat = balade.getCat();
				
				if (cat == 1) {
					nomCat = "route";
				} else if (cat == 2) {
					nomCat = "descendeur";
				} else if (cat == 3) {
					nomCat = "randonneur";
				} else {
					nomCat = "trialiste";
				}

				data[i][6] = nomCat;
				i++;
			}
		}
		return data;
	}
}
