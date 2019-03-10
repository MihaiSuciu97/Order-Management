package models;

/**
 * The Class Client.
 */
public class Client {
	
	/** The id. */
	public int id;
	
	/** The name. */
	public String name;
	
	/** The mail. */
	public String mail;
	
	/** The address. */
	public String address;

	/**
	 * Instantiates a new client.
	 *
	 * @param id the id
	 * @param name the name
	 * @param mail the mail
	 * @param address the address
	 */
	public Client(int id, String name, String mail, String address) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.address = address;
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
	 * Gets the mail.
	 *
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Sets the mail.
	 *
	 * @param mail the new mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
