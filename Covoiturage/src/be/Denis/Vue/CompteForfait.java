package be.Denis.Vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import be.Denis.Model.Transaction;
import be.Denis.Model.Tresorier;

@SuppressWarnings("serial")
public class CompteForfait extends JPanel {

	private JTable tableau = null;
	private Transaction transaction;
	private JScrollPane scrollPane;
	private Object[][] data;
	private int ligne;
	private JLabel lblError;
	private JTextField textFieldType;
	private JTextField textFieldValeur;
	private JButton btnPayer;
	private Membre membre;
	/**
	 * Create the panel.
	 */
	public CompteForfait(Tresorier tresorier, DashBoard bureau) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.DARK_GRAY);
		setBounds(0,0,800,800);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Compte");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(62, 48, 654, 42);
		add(lblNewLabel);
		
		String titre[] = { "Date", "Type", "Montant", "Status"};
		data = dataJtable(tresorier);

		this.tableau = new JTable(data, titre);
		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.tableau.setRowHeight(30);

		scrollPane = new JScrollPane(tableau);
		scrollPane.setBounds(150, 101, 500, 300);
		add(scrollPane);
		
		JLabel lblGestionDesTransactions = new JLabel("Gestion des transactions");
		lblGestionDesTransactions.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDesTransactions.setForeground(Color.WHITE);
		lblGestionDesTransactions.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblGestionDesTransactions.setBounds(62, 435, 654, 42);
		add(lblGestionDesTransactions);
		
		JPanel panelAction = new JPanel();
		panelAction.setBackground(new Color(255, 250, 250));
		panelAction.setBounds(150, 481, 500, 267);
		add(panelAction);
		panelAction.setLayout(null);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Georgia", Font.BOLD, 20));
		lblType.setForeground(Color.BLACK);
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(23, 48, 102, 29);
		panelAction.add(lblType);
		
		textFieldType = new JTextField();
		textFieldType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldType.setBounds(152, 51, 301, 29);
		textFieldType.setEnabled(false);
		panelAction.add(textFieldType);
		textFieldType.setColumns(10);
		
		JLabel labelValeur = new JLabel("Valeur :");
		labelValeur.setHorizontalAlignment(SwingConstants.RIGHT);
		labelValeur.setForeground(Color.BLACK);
		labelValeur.setFont(new Font("Georgia", Font.BOLD, 20));
		labelValeur.setBounds(23, 104, 102, 29);
		panelAction.add(labelValeur);
		
		textFieldValeur = new JTextField();
		textFieldValeur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldValeur.setColumns(10);
		textFieldValeur.setBounds(152, 107, 301, 29);
		textFieldValeur.setEnabled(false);
		panelAction.add(textFieldValeur);
		
		btnPayer = new JButton("Payer");
		btnPayer.setForeground(new Color(255, 255, 255));
		btnPayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPayer.setBackground(new Color(160, 82, 45));
		btnPayer.setBounds(145, 156, 220, 49);
		panelAction.add(btnPayer);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Georgia", Font.BOLD, 20));
		lblError.setBounds(33, 227, 420, 29);
		panelAction.add(lblError);
		
		tableau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ligne = tableau.getSelectedRow();
				Date date = new Date();
				Integer idPersonne = (Integer) tableau.getValueAt(ligne, 0);
				String dateInString = (String) tableau.getValueAt(ligne, 1);
				String type = (String) tableau.getValueAt(ligne, 2);
				Double valeur = (Double) tableau.getValueAt(ligne, 3);
				String status = (String) tableau.getValueAt(ligne, 4);
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				try {

					date = formatter.parse(dateInString);

				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				boolean paye;
				if(status.equals("Payé")) {
					paye = true;
				}else {
					paye = false;
				}
				
				textFieldType.setText(type);
				textFieldValeur.setText(String.valueOf(valeur));
				
				transaction = new Transaction(idPersonne, date, valeur, type, paye);
				
				

			}
		});

		btnPayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblError.setText("");
				if(transaction != null) {
					
					bureau.changeScreen("compteMembre");
				}else {
					lblError.setText("Choissiez une transaction pour la régler");
				}
			}
		});
		
	}
	
	public Object[][] dataJtable(Tresorier tresorier) {
		int nbrObject = tresorier.getFraisDeplacement().size();
		Object[][] data = new Object[nbrObject][5];
		int i = 0;
		membre = new Membre();
		for (Transaction t : tresorier.getFraisDeplacement()) {
			if(!t.isPayer()) {
				membre.getMembre(t.getIdPersonne());
				String date = new SimpleDateFormat("dd-MM-YYYY").format(t.getDateTransaction());
				data[i][0] = membre.getMatricule();
				data[i][1] = date;
				data[i][2] = t.getType();
				data[i][3] = t.getValeur();
				data[i][4] = "Non Payé";
			}
			i++;
		}
		return data;
	}
}
