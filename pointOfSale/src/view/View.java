package view;

import controller.Controller;
import dto.SaleDTO;

public class View {

	Controller controller;

	public View(Controller controller) {
		this.controller = controller;
	}

	public void test() {
		controller.startSale();
		SaleDTO sale = controller.inputProduct(123);
		System.out.println("running total: " + controller.sale.getRunningTotal());
		sale = controller.inputProduct(321);
		System.out.println("running total: " + controller.sale.getRunningTotal());
		controller.endSale();
		sale = controller.getDiscount(123);
		float change = controller.makePayment(20);

		System.out.println("change to give back: " + change);

	}

}
