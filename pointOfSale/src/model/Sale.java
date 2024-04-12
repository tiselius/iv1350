package model;

import java.util.ArrayList;

public class Sale {
    ArrayList<Item> items = new ArrayList<Item>();
    private int runningTotal = 0;
	private boolean saleEnded = false;

	public void addProduct(Product product) {
		Item item = getItem(product);
		if(item == null) {
			item = new Item(product);
			items.add(item);
		}
		else
			item.incrementQuantity();
		calculateRunningTotal();
	}

	private Item getItem(Product product) {
		for (Item item : items) {
			if(item.product.equals(product))
				return item;
		}
		return null;
	}
	
	private void calculateRunningTotal() {
		for (Item item : items) {
			this.runningTotal += item.product.price * item.quantity; //Borde vi ha en totalprice i item som är price * quantity? 
		}
	}

	public void setQuantity(Item item, int quantity) {
		item.quantity = quantity;
		this.calculateRunningTotal();
		
	}

	public void endSale() {
		this.saleEnded  = true;		
	}
	
	
	public float getRunningTotal() {
		return runningTotal;
	}

	
}
