package model;

public class Product {
	public int id;
	float price;
	int vatRate;
	public String itemDescription;
	// shelve ... isle
	
	public Product(int id, float price, int vatRate, String itemDescription) {
		this.id = id;
		this.price = price;
		this.vatRate = vatRate;
		this.itemDescription = itemDescription;
	}
}
