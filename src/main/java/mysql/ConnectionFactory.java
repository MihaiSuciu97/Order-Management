package mysql;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Connection;

/**
 * A factory for creating Connection objects.
 */
public class ConnectionFactory {
	
	/** The Constant DRIVER. */
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	/** The connection. */
	private static Connection connection = null;

	/**
	 * Instantiates a new connection factory.
	 */
	public ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a new Connection object.
	 *
	 * @return the connection
	 */
	public static Connection createConnection() {
		try {
			connection = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/hw3?autoReconnect=true&useSSL=false", "root", "Maimuta1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (connection != null)
			System.out.println("Connection created");
		else
			System.out.println("Connection error");
		return connection;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public static Connection getConnection() {
		return connection;
	}

	/**
	 * Close.
	 *
	 * @param statement the statement
	 */
	public static void close(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
