package main.java.se.kth.iv1350.pos.controller;

import main.java.se.kth.iv1350.pos.dto.ProductDTO;
import main.java.se.kth.iv1350.pos.integration.AccountingHandler;
import main.java.se.kth.iv1350.pos.integration.DiscountHandler;
import main.java.se.kth.iv1350.pos.integration.InventoryHandler;
import main.java.se.kth.iv1350.pos.integration.ItemNotValidException;
import main.java.se.kth.iv1350.pos.integration.PrinterHandler;
import main.java.se.kth.iv1350.pos.model.Item;
import main.java.se.kth.iv1350.pos.model.Receipt;
import main.java.se.kth.iv1350.pos.model.Sale;
import main.java.se.kth.iv1350.pos.dto.SaleDTO;

/**
 * Handles the communication between packages and classes
 */
public class Controller {
	private InventoryHandler inventoryHandler;
	private AccountingHandler accountingHandler;
	private PrinterHandler printerHandler;
	private DiscountHandler discountHandler;
	/**
	 * The current Sale that the Controller handles.
	 */
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

	public SaleDTO startSale() {
		sale = new Sale();
		return new SaleDTO(sale);
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

	public SaleDTO getSaleDTO() {
		return new SaleDTO(this.sale);
	}

	public SaleDTO inputProduct(int id) throws Exception {
		ProductDTO product = inventoryHandler.getProduct(id);

		sale.addProduct(product);

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
