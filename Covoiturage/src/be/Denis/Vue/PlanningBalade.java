package be.Denis.Vue;

import java.awt.Color;

import java.awt.Font;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import be.Denis.DAO.AbstractDAOFactory;
import be.Denis.DAO.DAO;
import be.Denis.Model.Balade;
import be.Denis.Model.Membre;

public class PlanningBalade extends JPanel {

	private JPanel listBalade;
	private JTable table;
	private AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private DAO<Balade> BaladeDAO = adf.getBaladeDAO();

	/**
	 * Create the panel.
	 */
	public PlanningBalade(Membre membre) {
		initComponents(membre);
	}

	public void initComponents(Membre membre) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 800, 800);
		setLayout(null);

		listBalade = new JPanel();
		listBalade.setBackground(Color.DARK_GRAY);
		listBalade.setBounds(0, 0, 800, 800);
		listBalade.setLayout(null);
		add(listBalade);

		JLabel lblPlanning = new JLabel("Planning des balades");
		lblPlanning.setForeground(Color.WHITE);
		lblPlanning.setFont(new Font("Georgia", Font.BOLD, 25));
		lblPlanning.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanning.setBounds(200, 62, 400, 30);
		listBalade.add(lblPlanning);

		Object[] titre = { "Date", "Lieu", "Forfait", "Participant", "" };
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(UIManager.getBorder("ScrollPane.border"));

		JScrollPane titleTable = new JScrollPane(table);
		titleTable.setLocation(150, 150);
		titleTable.setSize(500, 500);

		DefaultTableModel model = new DefaultTableModel(titre, 0);
		Object rowData[] = new Object[5];

		for (Balade balade : BaladeDAO.findAllBalade(membre.getMatricule())) {
			Date dateNow = new Date();
			if (balade.getDateBalade().after(dateNow)) {
				String date = new SimpleDateFormat("dd-MM-YYYY").format(balade.getDateBalade());
				rowData[0] = date;
				rowData[1] = balade.getLieu();
				rowData[2] = balade.getForfait();
				rowData[3] = balade.getNbrParticipant();
				rowData[4] = balade.getNumBalade();
				model.addRow(rowData);
			}
		}
		table.setModel(model);
		table.setBounds(161, 111, 460, 282);
		table.setEnabled(false);

		this.table.getColumn("").setCellRenderer(new ButtonRenderer());

		listBalade.add(titleTable);

	}

}
