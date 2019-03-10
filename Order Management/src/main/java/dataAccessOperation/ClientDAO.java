package dataAccessOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import mysql.ConnectionFactory;
import models.Client;

/**
 * The Class ClientDAO.
 */
public class ClientDAO {


	/**
	 * Insert client.
	 *
	 * @param c the c
	 */
	public static void insertClient(Client c) {
		final String insertStatementString = "INSERT INTO client(idClient,nameClient,mail,address)"
				+ "values(?,?,?,?)";
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString);
			insertStatement.setInt(1, c.getId());
			insertStatement.setString(2, c.getName());
			insertStatement.setString(3, c.getMail());
			insertStatement.setString(4, c.getAddress());

			insertStatement.execute();
			ConnectionFactory.close(insertStatement);
			System.out.println("Client added");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update client.
	 *
	 * @param c the c
	 */
	public static void updateClient(Client c) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		try {
			String updateStatementString = "UPDATE client SET idClient = ?, nameClient = ?, mail = ?,address = ? WHERE idClient= ?";
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setInt(1, c.getId());
			updateStatement.setString(2, c.getName());
			updateStatement.setString(3, c.getMail());
			updateStatement.setString(4, c.getAddress());
			updateStatement.setInt(5, c.getId());

			updateStatement.execute();

			ConnectionFactory.close(updateStatement);

			System.out.println("Client updated");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * Delete client.
	 *
	 * @param id the id
	 */
	public static void deleteClient(int id) {

		final String deleteStatementString = "DELETE FROM client WHERE idClient=?";
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setInt(1, id);
			deleteStatement.execute();

			ConnectionFactory.close(deleteStatement);

			System.out.println("Client deleted");
		} catch (Exception e) {
			System.out.println("Client not available");
		}
	}

	/**
	 * Show clients.
	 *
	 * @return the list
	 */
	public static List<Client> showClients() {
		final String showStatementString = "SELECT * FROM client";
		List<Client> clients = new ArrayList<Client>();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement showStatement = null;
		ResultSet rs = null;
		int i = 0;
		try {
			showStatement = dbConnection.prepareStatement(showStatementString);
			rs = showStatement.executeQuery();
			while (rs.next()) {
				Client c = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				clients.add(i, c);
				i++;
			}
			ConnectionFactory.close(showStatement);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return clients;
	}
}
