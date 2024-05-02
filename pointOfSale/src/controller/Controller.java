package controller;

import dto.ProductDTO;
import integration.AccountingHandler;
import integration.DiscountHandler;
import integration.InventoryHandler;
import integration.PrinterHandler;
import model.Item;
import model.Receipt;
import model.Sale;
import dto.SaleDTO;

/**
 * Handles the communication between packages and classes
 */
public class Controller {
	private InventoryHandler inventoryHandler;
	private AccountingHandler accountingHandler;
	private PrinterHandler printerHandler;
	private DiscountHandler discountHandler;
	public Sale sale;

	/**
	 * Creates a new instance of a Controller
	 * 
	 * @param inventoryHandler
	 * @param accountingHandler
	 * @param printerHandler
	 * @param discountHandler
	 */
	public Controller(InventoryHandler inventoryHandler, AccountingHandler accountingHandler,
			PrinterHandler printerHandler, DiscountHandler discountHandler) {
		this.inventoryHandler = inventoryHandler;
		this.accountingHandler = accountingHandler;
		this.printerHandler = printerHandler;
		this.discountHandler = discountHandler;
	}

	/**
	 * Starts a new sale
	 */

	public void startSale() {
		sale = new Sale();
	}

	/**
	 * Ends the current sale
	 * 
	 * @return the sale
	 */

	public SaleDTO endSale() {
		sale.endSale();
		return new SaleDTO(sale);

	}

	/**
	 * Gets the discount for a customer and sets customer id and applies discount
	 * 
	 * @param customerId the id of the customer
	 * @return the sale with the discount applied
	 */

	public SaleDTO getDiscount(int customerId) {
		Double discount = discountHandler.getDiscountAmount(customerId, sale);
		sale.applyDiscount(discount);
		sale.setCustomerId(customerId);

		return new SaleDTO(sale);
	}

	/**
	 * Adds a product to the sale
	 * 
	 * @param id the id of the product
	 * @return the sale
	 */

	public SaleDTO inputProduct(int id) {
		ProductDTO product = inventoryHandler.getProduct(id);

		if (product == null) {
			// throw new InvalidException("Product not found");
			System.out.println("ERROR HERE"); // throw error
		}

		sale.addProduct(product);

		System.out.println("Added: " + product.getName());
		return new SaleDTO(sale);
	}

	/**
	 * Sets the quantity of an item
	 * 
	 * @param item     the item to set the quantity of
	 * @param quantity the quantity to set
	 * @return the sale
	 */
	public SaleDTO setQuantity(Item item, int quantity) {
		sale.setQuantity(item, quantity);
		SaleDTO dto = new SaleDTO(sale);
		return dto;
	}

	/**
	 * Makes a payment and posts the receipt, also updates all extenal systems with
	 * the receipt.
	 * 
	 * @param cashPaid the amount paid
	 * @return the receipt
	 */
	public Receipt makePayment(Double cashPaid) {
		Receipt receipt = new Receipt(new SaleDTO(sale), cashPaid);
		accountingHandler.postReceipt(receipt);
		inventoryHandler.postReceipt(receipt);
		printerHandler.postReceipt(receipt);
		System.out.println(receipt.toString());
		return receipt;
	}

}
