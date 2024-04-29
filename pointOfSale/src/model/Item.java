package model;

import dto.ProductDTO;

public class Item {
	private ProductDTO product;
	private int quantity = 1;

	public void print() {
		System.out.println(product.getName() + "   " + quantity + "   " +
				product.getPrice() + "   " + product.getPrice() * quantity);
	}

	Item(ProductDTO product) {
		this.product = product;
	}

	void incrementQuantity() {
		this.quantity++;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}
}
