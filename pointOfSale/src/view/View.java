package view;

import controller.Controller;
import dto.SaleDTO;
import integration.ItemNotValidException;
import model.Receipt;

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
			System.err.println("An unexpected error occured: " + e.getMessage());
		}

		sale.print();

	}

	SaleDTO inputProduct(int id) throws Exception {
		try {
			SaleDTO sale = controller.inputProduct(id);
			return sale;
		} catch (ItemNotValidException e) {
			System.err.println(e.getMessage());
			return controller.getSaleDTO();
		}

	}
}
