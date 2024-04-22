package dto;

public class ProductDTO {
	public int id;
	public float price;
	public int vatRate;
	public String name;
	
	public ProductDTO(int id, float price, int vatRate, String name) {
		this.id = id;
		this.price = price;
		this.vatRate = vatRate;
		this.name = name;
	}
}

