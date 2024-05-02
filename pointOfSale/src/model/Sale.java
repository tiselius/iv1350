package model;

import java.util.ArrayList;

import dto.ProductDTO;

/**
 * Represents a sale
 */
public class Sale {
	ArrayList<Item> items = new ArrayList<Item>();
	private Double runningTotal = 0.0;
	private boolean saleEnded = false;
	private int customerId;
	private Double discountAmount;

	/**
	 * Adds a product to the sale
	 * 
	 * @param product the product to add
	 */
	public void addProduct(ProductDTO product) {
		Item item = getItem(product);
		if (item == null) {
			item = new Item(product);
			items.add(item);
		} else
			item.incrementQuantity();
		calculateRunningTotal();
	}

	protected Item getItem(ProductDTO product) {
		for (Item item : items) {
			if (item.getProduct().equals(product))
				return item;
		}
		return null;
	}

	/**
	 * Calculates the running total of the sale
	 */
	private void calculateRunningTotal() {
		runningTotal = 0.0;
		for (Item item : items) {
			this.runningTotal += item.getProduct().getPrice() * item.getQuantity(); 

		}
	}

	/**
	 * Sets quantity and recalculates running total
	 * @param item     the item to set the quantity of
	 * @param quantity the quantity to set
	 */

	public void setQuantity(Item item, int quantity) {
		item.setQuantity(quantity);
		this.calculateRunningTotal();

	}

	/**
	 * 
	 * @return the total price of the sale
	 */

	public Double getDiscountAmount() {
		return (Double) discountAmount;
	}

	/**
	 * 
	 * @param discountAmount the amount to discount the sale
	 */

	public void applyDiscount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	/**
	 * 
	 * @param customerId the id of the customer
	 */

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * Sets saleEnded to true
	 */

	public void endSale() {
		this.saleEnded = true;
	}

	/**
	 * 
	 * @return the running total of the sale
	 */

	public Double getRunningTotal() {
		return runningTotal;
	}

	/**
	 * 
	 * @return true if the sale has ended, false if it has not
	 */
	public boolean isSaleEnded() {
		return saleEnded;
	}

	/**
	 * 
	 * @return the items in the sale
	 */

	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * 
	 * @return the customer id
	 */

	public int getCustomerId() {
		return customerId;
	}

	/**
	 * 
	 * @return true if the sale has ended, false if it has not
	 */
	public boolean getSaleEnded() {
		return saleEnded;
	}

}
