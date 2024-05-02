package integration;

import java.util.ArrayList;

import dto.ProductDTO;
import model.Receipt;

/**
 * Handles the inventory system
 */
public class InventoryHandler {
	ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();

	public InventoryHandler() {
		products.add(new ProductDTO(123, 10, 12, "apple"));
		products.add(new ProductDTO(321, 5, 12, "banana"));
	}

	// search database, return product
	public ProductDTO getProduct(int id) {
		for (ProductDTO product : this.products) {
			if (product.getId() == id)
				return product;
		}
		return null;
	}

	/**
	 * Updates the inventory system. TODO implement
	 * 
	 * @param receipt
	 */
	public void postReceipt(Receipt receipt) {
		// TODO Auto-generated method stub

	}

}
