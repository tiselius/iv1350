package model;

import java.util.ArrayList;

public class Sale {
	ArrayList<Item> items = new ArrayList<Item>();
	private float runningTotal = 0;
	private boolean saleEnded = false;
	private int customerId;
	private float discountAmount;

	public void addProduct(Product product) {
		Item item = getItem(product);
		if (item == null) {
			item = new Item(product);
			items.add(item);
		} else
			item.incrementQuantity();
		calculateRunningTotal();
	}

	private Item getItem(Product product) {
		for (Item item : items) {
			if (item.product.equals(product))
				return item;
		}
		return null;
	}

	private void calculateRunningTotal() {
		this.runningTotal = 0;
		for (Item item : items) {
			this.runningTotal += item.product.price * item.quantity; // Borde vi ha en totalprice i item som är price *
																																// quantity?
		}
	}

	public void setQuantity(Item item, int quantity) {
		item.quantity = quantity;
		this.calculateRunningTotal();

	}

	public float getDiscountAmount() {
		return discountAmount;
	}

	public void applyDiscount(float discountAmount) {
		this.discountAmount = discountAmount;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void endSale() {
		this.saleEnded = true;
	}

	public float getRunningTotal() {
		return runningTotal;
	}

	public boolean isSaleEnded() {
		return saleEnded;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public int getCustomerId	() {
		return customerId;
	}

}
