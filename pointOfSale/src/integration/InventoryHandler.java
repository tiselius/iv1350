package integration;

import java.util.ArrayList;
import model.Product;
import model.Receipt;

public class InventoryHandler {
    ArrayList<Product> products = new ArrayList<Product>();

    public InventoryHandler() {
        products.add(new Product(123, 10, 12, "apple"));
        products.add(new Product(321, 5, 12, "banana"));
    }
	// search database, return product
	public Product getProduct(int id) {
		for(Product product : this.products) {
			if(product.id == id)
				return product;
		}
		return null;
	}

	public void postReceipt(Receipt receipt) {
		// TODO Auto-generated method stub
		
	}

}
