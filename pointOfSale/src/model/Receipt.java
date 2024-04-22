package model;

import java.util.Date;


public class Receipt {

	private float cashPaid; 
	private Date timeOfSale;
	private int customerId;
	private float change;
	private float totalVat;
	private float totalCost;
	private float totalDiscount;
	private float amountToPay;

	


	public Receipt(Sale sale, float cashPaid) {
		this.cashPaid = cashPaid;
		this.customerId = sale.getCustomerId();
		timeOfSale = new Date();


	}

	public float getChange() {
		return change;
	}



	@Override public String toString() {
		return "Receipt: " + timeOfSale.toString() + "\n" 
		+ " Cash paid: " + cashPaid + "\n" +
		" Change: " + change + "\n";
		
	}

}
