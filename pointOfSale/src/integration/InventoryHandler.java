package integration;

import java.util.ArrayList;

import dto.ProductDTO;
import model.Receipt;

/**
 * Handles the inventory system
 */
public class InventoryHandler {
	ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();

	/**
	 * Creates an instance of InventoryHandler. Currently only used for testing.
	 */
	public InventoryHandler() {
		products.add(new ProductDTO(123, 10, 12, "apple"));
		products.add(new ProductDTO(321, 5, 12, "banana"));
	}

	/**
	 * Searches the database and returns the product if it exists.
	 * @param id of the product to fetch.
	 * @return ProductDTO, the ProductDTO to return. Is null if it does not exist.
	 */
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
	 * @param receipt that is sent to the inventory system.
	 */
	public void postReceipt(Receipt receipt) {
		// TODO Auto-generated method stub

	}

}
