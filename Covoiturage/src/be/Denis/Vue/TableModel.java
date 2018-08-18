package be.Denis.Vue;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	private Object[][] data;
	private String[] title;

	// Constructeur
	public TableModel(Object[][] data, String[] title) {
		this.data = data;
		this.title = title;
	}

	// Retourne le nombre de colonnes
	public int getColumnCount() {
		return this.title.length;
	}

	// Retourne le nombre de lignes
	public int getRowCount() {
		return this.data.length;
	}

	// Retourne la valeur à l'emplacement spécifié
	public Object getValueAt(int row, int col) {
		return this.data[row][col];
	}

	/**
	 * Retourne le titre de la colonne à l'indice spécifié
	 */
	public String getColumnName(int col) {
		return this.title[col];
	}

	// Retourne la classe de la donnée de la colonne
	public Class getColumnClass(int col) {
		// On retourne le type de la cellule à la colonne demandée
		return this.data[0][col].getClass();
	}

	@Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
