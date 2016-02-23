package MVCModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	public static Database instance = new Database();

	private static Connection connection;

	private Database() {
	}

	public static Database getInstance() {
		return instance;
	}

	public static void conned() {
		if (connection != null) {
			return;
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql:// ", "root",
					"parolata");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void disconect() {
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		connection = null;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		Database.connection = connection;
	}
}
