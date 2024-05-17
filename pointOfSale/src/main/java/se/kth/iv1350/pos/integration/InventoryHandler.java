package main.java.se.kth.iv1350.pos.integration;

import java.util.ArrayList;

import main.java.se.kth.iv1350.pos.dto.ProductDTO;
import main.java.se.kth.iv1350.pos.model.Receipt;

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
	 * Searches the database and returns the product if it exists. throws exception
	 * otherwise
	 * 
	 * @param id of the product to fetch.
	 * @return ProductDTO, the ProductDTO to return.
	 * @throws DBNotReachableException
	 */
	public ProductDTO getProduct(int id) throws ItemNotValidException, DBNotReachableException {
		if (id == 666) {
			throw new DBNotReachableException("Product catalog is not reachable. ");
		}
		for (ProductDTO product : this.products) {
			if (product.getId() == id)
				return product;
		}

		throw new ItemNotValidException("Product with number " + id + " was not found in the product catalog. ");
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
