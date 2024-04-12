package model;

import java.util.Date;

public class Receipt {

	private float cashPaid; 
	private Date timeOfSale;
	public Receipt(Sale sale, float cashPaid) {
		this.cashPaid = cashPaid;
		timeOfSale = new Date();
	}

}
