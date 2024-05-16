package main.java.se.kth.iv1350.pos.startup;

import main.java.se.kth.iv1350.pos.controller.*;
import main.java.se.kth.iv1350.pos.integration.*;
import main.java.se.kth.iv1350.pos.view.View;

class Main {

	/**
	 * Starts the program by creating all of the classes and passing the controller
	 * to the view.
	 * 
	 */
	public static void main(String[] args) {
		InventoryHandler inventoryHandler = new InventoryHandler();
		AccountingHandler accountingHandler = new AccountingHandler();
		PrinterHandler printerHandler = new PrinterHandler();
		DiscountHandler discountHandler = new DiscountHandler();
		Controller controller = new Controller(inventoryHandler, accountingHandler, printerHandler, discountHandler);
		View view = new View(controller);
		view.test();
	}
}
