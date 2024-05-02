package dto;

public class ProductDTO {
	private final int id;
	private final double price;
	private final int vatRate;
	private final String name;

	public ProductDTO(int id, double price, int vatRate, String name) {
		this.id = id;
		this.price = price;
		this.vatRate = vatRate;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public int getVatRate() {
		return vatRate;
	}

	public String getName() {
		return name;
	}

}
