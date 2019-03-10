package Presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import dataAccessOperation.ClientDAO;
import dataAccessOperation.OrderDAO;
import dataAccessOperation.ProductDAO;
import models.Client;
import models.Order;
import models.Product;
import mysql.ConnectionFactory;

/**
 * The Class Controller.
 */
public class Controller {
	
	/** The ok. */
	boolean ok;

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {

		View view = new View();
		view.setVisible(true);

		@SuppressWarnings("unused")
		ConnectionFactory c = new ConnectionFactory();
		@SuppressWarnings("unused")
		Connection con = ConnectionFactory.createConnection();
		view.viewClientsAction(e -> {
			try {
				List<Client> clients = new ArrayList<Client>();
				clients = ClientDAO.showClients();
				View.createTable(clients, view.table);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view, "Free list");
			}
		});
		view.viewProductsAction(e -> {
			try {
				List<Product> products = new ArrayList<Product>();
				products = ProductDAO.showProducts();
				View.createTable(products, view.table);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view, "Free list");
			}
		});
		view.viewOrdersAction(e -> {
			try {List<Order> orders = new ArrayList<Order>();
			orders = OrderDAO.showOrders();
			View.createTable(orders, view.table);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view, "Free list");
			}
		});
		// Client Buttons actions
		view.insertClientAction(e -> {
			try {
				int id;
				String name;
				String mail;
				String address;
				id = Integer.parseInt(view.clientid.getText());
				name = view.clientname.getText();
				mail = view.clientmail.getText();
				address = view.clientaddress.getText();
				Client client = new Client(id, name, mail, address);
				ClientDAO.insertClient(client);
				JOptionPane.showMessageDialog(view, "Client added");
				view.table.setVisible(false);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view, "No information detected");
			}

		});
		view.updateClientAction(e -> {
			try {
				int id;
				String name;
				String mail;
				String address;
				id = Integer.parseInt(view.clientid.getText());
				name = view.clientname.getText();
				mail = view.clientmail.getText();
				address = view.clientaddress.getText();
				Client client = new Client(id, name, mail, address);
				ClientDAO.updateClient(client);
				JOptionPane.showMessageDialog(view, "Client updated");
				view.table.setVisible(false);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view, "No information detected");
			}
		});
		view.deleteClientAction(e -> {
			try {
				int id;
				id = Integer.parseInt(view.clientid.getText());
				ClientDAO.deleteClient(id);
				JOptionPane.showMessageDialog(view, "Client deleted");
				view.table.setVisible(false);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view, "No id detected");
			}
		});
		// Product Buttons actions
		view.insertProductAction(e -> {
			try {
				int id;
				String name;
				int price;
				int quantity;
				id = Integer.parseInt(view.productid.getText());
				name = view.productname.getText();
				price = Integer.parseInt(view.productprice.getText());
				quantity = Integer.parseInt(view.productquantity.getText());
				Product product = new Product(id, name, price, quantity);
				ProductDAO.insertProduct(product);
				JOptionPane.showMessageDialog(view, "Product added");
				view.table.setVisible(false);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view, "No information detected");
			}
		});
		view.updateProductAction(e -> {
			try {
				int id;
				String name;
				int price;
				int quantity;
				id = Integer.parseInt(view.productid.getText());
				name = view.productname.getText();
				price = Integer.parseInt(view.productprice.getText());
				quantity = Integer.parseInt(view.productquantity.getText());
				Product product = new Product(id, name, price, quantity);
				ProductDAO.updateProduct(product);
				JOptionPane.showMessageDialog(view, "Product updated");
				view.table.setVisible(false);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view, "No information detected");
			}
		});
		view.deleteProductAction(e -> {
			try {
				int id;
				id = Integer.parseInt(view.productid.getText());
				ProductDAO.deleteClient(id);
				JOptionPane.showMessageDialog(view, "Product deleted");
				view.table.setVisible(false);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view, "No id detected");
			}
		});
		// Order Buttons actions
		view.insertOrderAction(e -> {
			try {
				int idOrder;
				int idClient;
				int idProduct;
				int quantity;
				idOrder = Integer.parseInt(view.orderid.getText());
				idClient = Integer.parseInt(view.orderidclient.getText());
				idProduct = Integer.parseInt(view.orderidproduct.getText());
				quantity = Integer.parseInt(view.orderquantity.getText());
				Order order = new Order(idOrder, idClient, idProduct, quantity);
				OrderDAO.insertOrder(order, ok);
				if (ok) {
					// JOptionPane.showMessageDialog(view, "Order added");
				} else {
					// JOptionPane.showMessageDialog(view, "No enought quantity");
				}
				view.table.setVisible(false);

			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view, "No information detected");
			}
		});
		view.updateOrderAction(e -> {
			try {
				int idOrder;
				int idClient;
				int idProduct;
				int quantity;
				idOrder = Integer.parseInt(view.orderid.getText());
				idClient = Integer.parseInt(view.orderidclient.getText());
				idProduct = Integer.parseInt(view.orderidproduct.getText());
				quantity = Integer.parseInt(view.orderquantity.getText());
				Order order = new Order(idOrder, idClient, idProduct, quantity);
				OrderDAO.updateOrder(order);
				JOptionPane.showMessageDialog(view, "Order updated");
				view.table.setVisible(false);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view, "No information detected");
			}
		});
		view.deleteOrderAction(e -> {
			try {

				int id;
				id = Integer.parseInt(view.orderid.getText());
				OrderDAO.deleteOrder(id);
				JOptionPane.showMessageDialog(view, "Order deleted");
				view.table.setVisible(false);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(view, "No id detected");
			}
		});
	}

}
