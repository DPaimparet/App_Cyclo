package be.Denis.Vue;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class Balades extends JPanel {
	private JTable tblBalades;

	/**
	 * Create the panel.
	 */
	public Balades() {
		setBorder(null);
		setBackground(Color.LIGHT_GRAY);
		
		tblBalades = new JTable();
		tblBalades.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Lieu", "Date", "Nbr Km", "Cat\u00E9gorie", "button"
			}
		));
		tblBalades.setBackground(Color.WHITE);
		add(tblBalades);

	}

}
