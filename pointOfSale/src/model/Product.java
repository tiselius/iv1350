package model;

public class Product {
	public int id;
	float price;
	int vatRate;
	public String name;
	// shelve ... isle
	
	public Product(int id, float price, int vatRate, String name) {
		this.id = id;
		this.price = price;
		this.vatRate = vatRate;
		this.name = name;
	}
}
