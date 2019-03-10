package dataAccessOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;

import Presentation.View;
import mysql.ConnectionFactory;
import models.Order;
import models.Product;

/**
 * The Class OrderDAO.
 */
public class OrderDAO {
	
	/** The view. */
	static View view=new View();
	
	
	/**
	 * Insert order.
	 *
	 * @param o the o
	 * @param ok the ok
	 */
	public static void insertOrder(Order o,boolean ok) {
		ok=true;
		final String insertStatementString = "INSERT INTO comenzi(idOrder,idClient,idProduct,quantities)"
				+ "values(?,?,?,?)";
		final String checkStatementString ="SELECT idProduct,nameProduct,price,quantity FROM products WHERE idProduct=?";
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		PreparedStatement checkStatement=null;
		ResultSet rs=null;
		int idProduct;
		String nameProduct;
		int price;
		int quantity=0;
		try {
			checkStatement=dbConnection.prepareStatement(checkStatementString);
			checkStatement.setInt(1, o.getIdProduct());
			rs=checkStatement.executeQuery();
			rs.next();
			idProduct=rs.getInt(1);
			nameProduct=rs.getString(2);
			price =rs.getInt(3);
			quantity=rs.getInt(4);
			//System.out.println(quantity);
			ConnectionFactory.close(checkStatement);
			
			insertStatement = dbConnection.prepareStatement(insertStatementString);
			insertStatement.setInt(1, o.getIdOrder());
			insertStatement.setInt(2, o.getIdClient());
			insertStatement.setInt(3, o.getIdProduct());
			insertStatement.setInt(4, o.getQuantity());
			
			if(o.getQuantity()>quantity)
				ok=false;
				
			if(ok) {
				insertStatement.execute();
				Product p= new Product(idProduct,nameProduct,price,quantity-o.getQuantity());
				ProductDAO.updateProduct(p);
				JOptionPane.showMessageDialog(view, "Added and Product's quantity updated");
			}
			else {
				JOptionPane.showMessageDialog(view, "Not enought quantity");
			}
			ConnectionFactory.close(insertStatement);
			//System.out.println("Order added");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update order.
	 *
	 * @param o the o
	 */
	public static void updateOrder(Order o) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		try {
			String updateStatementString = "UPDATE comenzi SET idOrder = ?, idClient = ?, idProduct = ?,quantities = ? WHERE idOrder= ?";
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setInt(1, o.getIdOrder());
			updateStatement.setInt(2, o.getIdClient());
			updateStatement.setInt(3, o.getIdProduct());
			updateStatement.setInt(4, o.getQuantity());

			updateStatement.setInt(5, o.getIdOrder());

			updateStatement.execute();

			ConnectionFactory.close(updateStatement);

			System.out.println("Order updated");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Delete order.
	 *
	 * @param id the id
	 */
	public static void deleteOrder(int id) {
		final String deleteStatementString = "DELETE FROM comenzi WHERE idOrder=?";
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setInt(1, id);
			deleteStatement.execute();

			ConnectionFactory.close(deleteStatement);

			System.out.println("Order deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Show orders.
	 *
	 * @return the list
	 */
	public static List<Order> showOrders() {
		final String showStatementString = "SELECT * FROM comenzi";
		List<Order> orders = new ArrayList<Order>();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement showStatement = null;
		ResultSet rs = null;
		int i = 0;
		try {
			showStatement = dbConnection.prepareStatement(showStatementString);
			rs = showStatement.executeQuery();
			while (rs.next()) {
				Order o = new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
				orders.add(i, o);
				i++;
			}
			ConnectionFactory.close(showStatement);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
}
