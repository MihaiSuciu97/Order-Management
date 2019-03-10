package Presentation;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;

//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * The Class View.
 */
@SuppressWarnings("serial")
public class View extends JFrame {

	/** The frame. */
	private JPanel frame;

	/** The clientid. */
	// TextFields for client
	public JTextField clientid;

	/** The clientname. */
	public JTextField clientname;

	/** The clientmail. */
	public JTextField clientmail;

	/** The clientaddress. */
	public JTextField clientaddress;

	/** The productid. */
	// TextFields for product
	public JTextField productid;

	/** The productname. */
	public JTextField productname;

	/** The productprice. */
	public JTextField productprice;

	/** The productquantity. */
	public JTextField productquantity;

	/** The orderid. */
	// TextFields for order
	public JTextField orderid;

	/** The orderidclient. */
	public JTextField orderidclient;

	/** The orderidproduct. */
	public JTextField orderidproduct;

	/** The orderquantity. */
	public JTextField orderquantity;

	/** The table. */
	// table
	public JTable table;

	/** The insert client. */
	// Buttons for clients
	private JButton insertClient;

	/** The update client. */
	private JButton updateClient;

	/** The delete client. */
	private JButton deleteClient;

	/** The view clients. */
	private JButton viewClients;

	/** The insert product. */
	// Buttons for products
	private JButton insertProduct;

	/** The update product. */
	private JButton updateProduct;

	/** The delete product. */
	private JButton deleteProduct;

	/** The view products. */
	private JButton viewProducts;

	/** The insert order. */
	// Button for order
	private JButton insertOrder;

	/** The update order. */
	private JButton updateOrder;

	/** The delete order. */
	private JButton deleteOrder;

	/** The view orders. */
	private JButton viewOrders;

	/**
	 * Instantiates a new view.
	 */
	public View() {

		this.setTitle("Mihai's Shop");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 960, 550);
		frame = new JPanel();
		frame.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(frame);
		frame.setLayout(null);
		frame.setVisible(true);

		// CLIENT VIEW
		JLabel labelServeMin = new JLabel("Client");
		labelServeMin.setBounds(60, 10, 100, 15);
		frame.add(labelServeMin);

		JLabel labelidclient = new JLabel("Id:");
		labelidclient.setBounds(20, 40, 100, 15);
		frame.add(labelidclient);

		JLabel labelName = new JLabel("Name:");
		labelName.setBounds(20, 65, 100, 15);
		frame.add(labelName);

		JLabel labelMail = new JLabel("Mail:");
		labelMail.setBounds(20, 90, 100, 15);
		frame.add(labelMail);

		JLabel labelAddress = new JLabel("Address:");
		labelAddress.setBounds(20, 115, 100, 15);
		frame.add(labelAddress);

		clientid = new JTextField();
		clientid.setBounds(90, 40, 150, 20);
		frame.add(clientid);

		clientname = new JTextField();
		clientname.setBounds(90, 65, 150, 20);
		frame.add(clientname);

		clientmail = new JTextField();
		clientmail.setBounds(90, 90, 150, 20);
		frame.add(clientmail);

		clientaddress = new JTextField();
		clientaddress.setBounds(90, 115, 150, 20);
		frame.add(clientaddress);

		// PRODUCT VIEW
		JLabel labelProduct = new JLabel("Product");
		labelProduct.setBounds(60, 150, 100, 15);
		frame.add(labelProduct);

		JLabel labelidproduct = new JLabel("Id:");
		labelidproduct.setBounds(20, 180, 100, 15);
		frame.add(labelidproduct);

		JLabel labelNameProduct = new JLabel("Name:");
		labelNameProduct.setBounds(20, 205, 100, 15);
		frame.add(labelNameProduct);

		JLabel labelPrice = new JLabel("Price:");
		labelPrice.setBounds(20, 230, 100, 15);
		frame.add(labelPrice);

		JLabel labelQuantity = new JLabel("Quantity:");
		labelQuantity.setBounds(20, 255, 100, 15);
		frame.add(labelQuantity);

		productid = new JTextField();
		productid.setBounds(90, 180, 150, 20);
		frame.add(productid);

		productname = new JTextField();
		productname.setBounds(90, 205, 150, 20);
		frame.add(productname);

		productprice = new JTextField();
		productprice.setBounds(90, 230, 150, 20);
		frame.add(productprice);

		productquantity = new JTextField();
		productquantity.setBounds(90, 255, 150, 20);
		frame.add(productquantity);

		// ORDER VIEW
		JLabel labelOrder = new JLabel("Order");
		labelOrder.setBounds(60, 290, 100, 15);
		frame.add(labelOrder);

		JLabel labelIdOrder = new JLabel("Id:");
		labelIdOrder.setBounds(20, 320, 100, 15);
		frame.add(labelIdOrder);

		JLabel labelIdClientOrder = new JLabel("Client id:");
		labelIdClientOrder.setBounds(20, 345, 100, 15);
		frame.add(labelIdClientOrder);

		JLabel labelIdProductOrder = new JLabel("Product id:");
		labelIdProductOrder.setBounds(20, 370, 100, 15);
		frame.add(labelIdProductOrder);

		JLabel labelOrderQuantity = new JLabel("Quantity:");
		labelOrderQuantity.setBounds(20, 395, 100, 15);
		frame.add(labelOrderQuantity);

		orderid = new JTextField();
		orderid.setBounds(90, 320, 150, 20);
		frame.add(orderid);

		orderidclient = new JTextField();
		orderidclient.setBounds(90, 345, 150, 20);
		frame.add(orderidclient);

		orderidproduct = new JTextField();
		orderidproduct.setBounds(90, 370, 150, 20);
		frame.add(orderidproduct);

		orderquantity = new JTextField();
		orderquantity.setBounds(90, 395, 150, 20);
		frame.add(orderquantity);

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(450, 40, 450, 400);
		frame.setVisible(true);
		frame.add(scrollPane);
		// Buttons for Client
		insertClient = new JButton("Insert Client");
		insertClient.setBounds(270, 40, 150, 20);
		frame.add(insertClient);

		updateClient = new JButton("Update Client");
		updateClient.setBounds(270, 65, 150, 20);
		frame.add(updateClient);

		deleteClient = new JButton("Delete Client");
		deleteClient.setBounds(270, 90, 150, 20);
		frame.add(deleteClient);

		viewClients = new JButton("View Clients");
		viewClients.setBounds(270, 115, 150, 20);
		frame.add(viewClients);

		// Buttons for Product
		insertProduct = new JButton("Insert Product");
		insertProduct.setBounds(270, 180, 150, 20);
		frame.add(insertProduct);

		updateProduct = new JButton("Update Product");
		updateProduct.setBounds(270, 205, 150, 20);
		frame.add(updateProduct);

		deleteProduct = new JButton("Delete Product");
		deleteProduct.setBounds(270, 230, 150, 20);
		frame.add(deleteProduct);

		viewProducts = new JButton("View Products");
		viewProducts.setBounds(270, 255, 150, 20);
		frame.add(viewProducts);

		// Buttons for Orders
		insertOrder = new JButton("Insert Order");
		insertOrder.setBounds(270, 320, 150, 20);
		frame.add(insertOrder);

		updateOrder = new JButton("Update Order");
		updateOrder.setBounds(270, 345, 150, 20);
		frame.add(updateOrder);

		deleteOrder = new JButton("Delete Order");
		deleteOrder.setBounds(270, 370, 150, 20);
		frame.add(deleteOrder);

		viewOrders = new JButton("View Orders");
		viewOrders.setBounds(270, 395, 150, 20);
		frame.add(viewOrders);
	}

	/**
	 * Insert client action.
	 *
	 * @param a
	 *            the a
	 */
	// Client Buttons
	public void insertClientAction(ActionListener a) {
		insertClient.addActionListener(a);
	}

	/**
	 * Delete client action.
	 *
	 * @param a
	 *            the a
	 */
	public void deleteClientAction(ActionListener a) {
		deleteClient.addActionListener(a);
	}

	/**
	 * Update client action.
	 *
	 * @param a
	 *            the a
	 */
	public void updateClientAction(ActionListener a) {
		updateClient.addActionListener(a);
	}

	/**
	 * View clients action.
	 *
	 * @param a
	 *            the a
	 */
	public void viewClientsAction(ActionListener a) {
		viewClients.addActionListener(a);
	}

	/**
	 * Insert product action.
	 *
	 * @param a
	 *            the a
	 */
	// Product Buttons
	public void insertProductAction(ActionListener a) {
		insertProduct.addActionListener(a);
	}

	/**
	 * Delete product action.
	 *
	 * @param a
	 *            the a
	 */
	public void deleteProductAction(ActionListener a) {
		deleteProduct.addActionListener(a);
	}

	/**
	 * Update product action.
	 *
	 * @param a
	 *            the a
	 */
	public void updateProductAction(ActionListener a) {
		updateProduct.addActionListener(a);
	}

	/**
	 * View products action.
	 *
	 * @param a
	 *            the a
	 */
	public void viewProductsAction(ActionListener a) {
		viewProducts.addActionListener(a);
	}

	/**
	 * Insert order action.
	 *
	 * @param a
	 *            the a
	 */
	// Order Buttons
	public void insertOrderAction(ActionListener a) {
		insertOrder.addActionListener(a);
	}

	/**
	 * Delete order action.
	 *
	 * @param a
	 *            the a
	 */
	public void deleteOrderAction(ActionListener a) {
		deleteOrder.addActionListener(a);
	}

	/**
	 * Update order action.
	 *
	 * @param a
	 *            the a
	 */
	public void updateOrderAction(ActionListener a) {
		updateOrder.addActionListener(a);
	}

	/**
	 * View orders action.
	 *
	 * @param a
	 *            the a
	 */
	public void viewOrdersAction(ActionListener a) {
		viewOrders.addActionListener(a);
	}

	/**
	 * Creates the table.
	 *
	 * @param <T> the generic type
	 * @param objects the objects
	 * @param show the show
	 * @throws IllegalArgumentException the illegal argument exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public static <T> void createTable(List<T> objects, JTable show)
			throws IllegalArgumentException, IllegalAccessException {
		DefaultTableModel tableModel = new DefaultTableModel();
		Object[] data = new Object[10];
		Object object = objects.get(0);
		for (Field field : object.getClass().getDeclaredFields()) {
			field.getName();
			tableModel.addColumn(field.getName());
		}
		for (int i = 0; i < objects.size(); i++) {
			object = objects.get(i);
			int j = 0;
			for (Field field : object.getClass().getDeclaredFields()) {
				Object value = field.get(object);
				data[j] = value;
				j++;
			}
			tableModel.addRow(data);
			show.setModel(tableModel);
			show.setVisible(true);
		}
	}
}