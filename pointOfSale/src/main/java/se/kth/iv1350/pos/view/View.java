package main.java.se.kth.iv1350.pos.view;

import main.java.se.kth.iv1350.pos.controller.Controller;
import main.java.se.kth.iv1350.pos.dto.SaleDTO;
import main.java.se.kth.iv1350.pos.integration.DBNotReachableException;
import main.java.se.kth.iv1350.pos.integration.ItemNotValidException;
import main.java.se.kth.iv1350.pos.model.Receipt;
import main.java.se.kth.iv1350.pos.util.FileLogger;
import main.java.se.kth.iv1350.pos.util.ConsoleLogger;

/**
 * Renders the view
 */
public class View {

	Controller controller;

	/**
	 * Creates a new instance of a View
	 * 
	 * @param controller
	 */
	public View(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Runs a test execution of the program.
	 */
	public void test() {
		SaleDTO sale = controller.startSale();

		try {
			sale = inputProduct(123);
			sale.print();
			sale = inputProduct(8584893);
			sale.print();
			sale = inputProduct(321);
			sale.print();

			sale = inputProduct(666);
			sale.print();

			sale = controller.setQuantity(sale.getItems().get(0), 5);
			sale.print();
			sale = controller.endSale();
			sale = controller.getDiscount(123);
			sale.print();
			Receipt receipt = controller.makePayment(45.0);

			receipt.print();
		} catch (Exception e) {
			printAndLogException(e);
		}

		// sale.print();

	}

	SaleDTO inputProduct(int id) throws Exception {
		try {
			SaleDTO sale = controller.inputProduct(id);
			return sale;
		} catch (ItemNotValidException | DBNotReachableException e) {
			printAndLogException(e);
			return controller.getSaleDTO();
		}

	}

	public void printAndLogException(Exception e) {
		System.err.println(e.getMessage());
		FileLogger fileLogger = new FileLogger();
		ConsoleLogger consoleLogger = new ConsoleLogger();
		fileLogger.logException(e);
		consoleLogger.logException(e);
	}
}
