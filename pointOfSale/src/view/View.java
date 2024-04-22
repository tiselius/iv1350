package view;

import controller.Controller;
import dto.SaleDTO;
import model.Receipt;

public class View {

	Controller controller;

	public View(Controller controller) {
		this.controller = controller;
	}

	public void test() {
		controller.startSale();
		SaleDTO sale = controller.inputProduct(123);
		sale.print();
		sale = controller.inputProduct(321);
		sale.print();
		// maybe fix
		controller.setQuantity(sale.getItems().get(0), 5);
		sale.print();
		sale = controller.endSale();
		sale.print();
		sale = controller.getDiscount(123);
		sale.print();
		Receipt receipt = controller.makePayment(45);

		receipt.print();

	}

}
