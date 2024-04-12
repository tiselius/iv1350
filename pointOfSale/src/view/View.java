package view;

import controller.Controller;

public class View {

	Controller controller;
	public View(Controller controller) {
		this.controller = controller;
	}
	public void test() {
		controller.startSale();
		controller.inputProduct(123);
		System.out.println("running total: " + controller.sale.getRunningTotal());
		controller.inputProduct(321);
		System.out.println("running total: " + controller.sale.getRunningTotal());
		controller.endSale();
		float change = controller.makePayment(20);
		System.out.println("change to give back: " + change);
		
		
	}
	
}
