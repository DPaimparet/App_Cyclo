package be.Denis.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AccessDB {
	private static Connection snglConnection = null;

    private AccessDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String url = "jdbc:ucanaccess://db\\clubCycliste.accdb";
            snglConnection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "JDBC driver introuvable : " + e.getMessage());
			System.exit(0);
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage());
        }

        if (snglConnection == null) {
        	JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données, fermeture du programme.");
            System.exit(0);
        }
    }

    public static Connection getInstance() {
        if (snglConnection == null) {
            new AccessDB();
        }
        return snglConnection;
    }
    
}
