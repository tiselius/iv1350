package controller;

import integration.AccountingHandler;
import integration.DiscountHandler;
import integration.InventoryHandler;
import integration.PrinterHandler;
import model.Item;
import model.Product;
import model.Receipt;
import model.Sale;
import model.Sale.SaleDTO;

public class Controller {
	InventoryHandler inventoryHandler = new InventoryHandler();
	AccountingHandler accountingHandler = new AccountingHandler();
	PrinterHandler printerHandler = new PrinterHandler();
	DiscountHandler discountHandler = new DiscountHandler();
	public Sale sale;
	
	public SaleDTO startSale() {
		sale = new Sale();

		return sale.makeDTO();
	}
	public void endSale() {
		sale.endSale();
	}
	
    public Sale inputProduct(int id) {
        Product product = inventoryHandler.getProduct(id);

        if (product == null) {
					throw new InvalidException("Product not found");
          System.out.println("ERROR HERE"); //throw error
        }

        sale.addProduct(product);

        System.out.println("Added: " + product.name);
        return sale;
      }
    
    public Sale setQuantity(Item item, int quantity) {

    	sale.setQuantity(item, quantity);
    	return sale;
    }
    
    public float makePayment(float cashPaid) {
    	Receipt receipt = new Receipt(sale, cashPaid);
    	accountingHandler.postReceipt(receipt);
    	inventoryHandler.postReceipt(receipt);
    	printerHandler.postReceipt(receipt);
		return sale.getRunningTotal() - cashPaid;
    }
	
}
