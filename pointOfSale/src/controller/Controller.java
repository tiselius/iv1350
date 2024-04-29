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

public class Controller {
	private InventoryHandler inventoryHandler;
	private AccountingHandler accountingHandler;
	private PrinterHandler printerHandler;
	private DiscountHandler discountHandler;
	public Sale sale;

	public Controller(InventoryHandler inventoryHandler, AccountingHandler accountingHandler,
			PrinterHandler printerHandler, DiscountHandler discountHandler) {
		this.inventoryHandler = inventoryHandler;
		this.accountingHandler = accountingHandler;
		this.printerHandler = printerHandler;
		this.discountHandler = discountHandler;
	}

	public void startSale() {
		sale = new Sale();
	}

	public SaleDTO endSale() {
		sale.endSale();
		return new SaleDTO(sale);

	}


	public SaleDTO getDiscount(int customerId) {
		float discount = discountHandler.getDiscountAmount(customerId, sale);
		sale.applyDiscount(discount);
		sale.setCustomerId(customerId);

		return new SaleDTO(sale);
	}

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

	public SaleDTO setQuantity(Item item, int quantity) {

		sale.setQuantity(item, quantity);
		return new SaleDTO(sale);
	}

	public Receipt makePayment(float cashPaid) {
		Receipt receipt = new Receipt(new SaleDTO(sale), cashPaid);
		accountingHandler.postReceipt(receipt);
		inventoryHandler.postReceipt(receipt);
		printerHandler.postReceipt(receipt);
		System.out.println(receipt.toString());
		return receipt;
	}

}
