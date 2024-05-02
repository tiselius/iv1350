package model;

import dto.ProductDTO;

/**
 * Represents an item in a sale
 */
public class Item {
	private ProductDTO product;
	private int quantity = 1;

	/**
	 * Prints the item to the console
	 */
	public void print() {
	    System.out.printf("%-15s %-8d %-8.2f %-8.2f\n", product.getName(), quantity, product.getPrice(), product.getPrice() * quantity);
	}
	/**
	 * Creates a new instance of an item
	 * 
	 * @param product the product to create an item of
	 */
	Item(ProductDTO product) {
		this.product = product;
	}

	/**
	 * Increments the quantity of the item
	 */
	void incrementQuantity() {
		this.quantity++;
	}

	/**
	 * Sets the quantity of the item
	 * 
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 
	 * @return the product of the item
	 */
	public ProductDTO getProduct() {
		return product;
	}

	/**
	 * 
	 * @return the quantity of the item
	 */
	public int getQuantity() {
		return quantity;
	}
}
