package model;

public class Item {
	Product product;
	int quantity = 1;

	Item(Product product){
		this.product = product;
	}
	void incrementQuantity(){
		this.quantity++;
	}
}