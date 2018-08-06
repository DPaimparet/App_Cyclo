package be.Denis.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessDB {
	private static Connection snglConnection = null;

    private AccessDB() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            String url = "jdbc:ucanaccess://db\\clubCycliste.accdb";
            snglConnection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
        	System.out.println(e);
        }

        if (snglConnection == null) {
        	System.out.println("Aucune connection");
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
