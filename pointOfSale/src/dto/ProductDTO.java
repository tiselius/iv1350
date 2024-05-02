package dto;

/**
 * Represents an immutable product
 */
public class ProductDTO {
	private final int id;
	private final double price;
	private final int vatRate;
	private final String name;

	/**
	 * Creates a new instance of a ProductDTO
	 * 
	 * @param id      the id of the product
	 * @param price   the price of the product
	 * @param vatRate the vat rate of the product
	 * @param name    the name of the product
	 */
	public ProductDTO(int id, double price, int vatRate, String name) {
		this.id = id;
		this.price = price;
		this.vatRate = vatRate;
		this.name = name;
	}

	/**
	 * 
	 * @return the id of the product
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return the price of the product
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
	 * @return the vat rate of the product
	 */
	public int getVatRate() {
		return vatRate;
	}

	/**
	 * 
	 * @return the name of the product
	 */
	public String getName() {
		return name;
	}

}
