package startup;

import controller.Controller;
import integration.*;
import view.View; 

public class Main {
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
