package models;

/**
 * The Class Order.
 */
public class Order {
	
	/** The id order. */
	public int idOrder;
	
	/** The id client. */
	public int idClient;
	
	/** The id product. */
	public int idProduct;
	
	/** The quantity. */
	public int quantity;

	/**
	 * Instantiates a new order.
	 *
	 * @param idOrder the id order
	 * @param idClient the id client
	 * @param idProduct the id product
	 * @param quantity the quantity
	 */
	public Order(int idOrder, int idClient, int idProduct, int quantity) {
		this.idOrder = idOrder;
		this.idClient = idClient;
		this.idProduct = idProduct;
		this.quantity = quantity;
	}

	/**
	 * Gets the id order.
	 *
	 * @return the id order
	 */
	public int getIdOrder() {
		return idOrder;
	}

	/**
	 * Sets the id order.
	 *
	 * @param idOrder the new id order
	 */
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	/**
	 * Gets the id client.
	 *
	 * @return the id client
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * Sets the id client.
	 *
	 * @param idClient the new id client
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	/**
	 * Gets the id product.
	 *
	 * @return the id product
	 */
	public int getIdProduct() {
		return idProduct;
	}

	/**
	 * Sets the id product.
	 *
	 * @param idProduct the new id product
	 */
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
