package dataAccessOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import mysql.ConnectionFactory;
import models.Product;

/**
 * The Class ProductDAO.
 */
public class ProductDAO {

	/**
	 * Insert product.
	 *
	 * @param p the p
	 */
	public static void insertProduct(Product p) {
		final String insertStatementString = "INSERT INTO products(idProduct,nameProduct,price,quantity)"
				+ "values(?,?,?,?)";
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString);
			insertStatement.setInt(1, p.getId());
			insertStatement.setString(2, p.getName());
			insertStatement.setInt(3, p.getPrice());
			insertStatement.setInt(4, p.getQuantity());

			insertStatement.execute();
			ConnectionFactory.close(insertStatement);
			System.out.println("Product added");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update product.
	 *
	 * @param p  the p
	 */
	public static void updateProduct(Product p) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		try {
			String updateStatementString = "UPDATE products SET idProduct = ?, nameProduct = ?, price = ?,quantity = ? WHERE idProduct= ?";
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setInt(1, p.getId());
			updateStatement.setString(2, p.getName());
			updateStatement.setInt(3, p.getPrice());
			updateStatement.setInt(4, p.getQuantity());

			updateStatement.setInt(5, p.getId());

			updateStatement.execute();

			ConnectionFactory.close(updateStatement);

			System.out.println("Product updated");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Delete client.
	 *
	 * @param id  the id
	 */
	public static void deleteClient(int id) {
		final String deleteStatementString = "DELETE FROM products WHERE idProduct=?";
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setInt(1, id);
			deleteStatement.execute();

			ConnectionFactory.close(deleteStatement);

			System.out.println("Product deleted");
		} catch (Exception e) {
			System.out.println("Client not available");
		}
	}

	/**
	 * Show products.
	 *
	 * @return the list
	 */
	public static List<Product> showProducts() {
		final String showStatementString = "SELECT * FROM products";
		List<Product> products = new ArrayList<Product>();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement showStatement = null;
		ResultSet rs = null;
		int i = 0;
		try {
			showStatement = dbConnection.prepareStatement(showStatementString);
			rs = showStatement.executeQuery();
			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				products.add(i, p);
				i++;
			}
			ConnectionFactory.close(showStatement);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
