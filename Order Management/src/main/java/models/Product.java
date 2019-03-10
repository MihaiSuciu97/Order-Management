package models;

/**
 * The Class Product.
 */
public class Product {
	
	/** The id. */
	public int id;
	
	/** The name. */
	public String name;
	
	/** The price. */
	public int price;
	
	/** The quantity. */
	public int quantity;
	
	/**
	 * Instantiates a new product.
	 *
	 * @param id the id
	 * @param name the name
	 * @param price the price
	 * @param quantity the quantity
	 */
	public Product(int id,String name,int price,int quantity) {
		this.id=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(int price) {
		this.price = price;
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
