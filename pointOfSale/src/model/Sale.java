package model;

import java.util.ArrayList;

import dto.ProductDTO;

public class Sale {
	ArrayList<Item> items = new ArrayList<Item>();
	private float runningTotal = 0;
	private boolean saleEnded = false;
	private int customerId;
	private float discountAmount;

	public void addProduct(ProductDTO product) {
		Item item = getItem(product);
		if (item == null) {
			item = new Item(product);
			items.add(item);
		} else
			item.incrementQuantity();
		calculateRunningTotal();
	}

	private Item getItem(ProductDTO product) {
		for (Item item : items) {
			if (item.getProduct().equals(product))
				return item;
		}
		return null;
	}

	private void calculateRunningTotal() {
		this.runningTotal = 0;
		for (Item item : items) {
			this.runningTotal += item.getProduct().price * item.getQuantity(); // Borde vi ha en totalprice i item som är price *
																		// quantity?
		}
	}

	public void setQuantity(Item item, int quantity) {
		item.setQuantity(quantity);
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

	public int getCustomerId() {
		return customerId;
	}

	public boolean getSaleEnded() {
		return saleEnded;
	}

}
