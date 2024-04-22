package model;

import java.util.ArrayList;
import java.util.Date;
import dto.SaleDTO;


public class Receipt {

	public float cashPaid; 
	public Date timeOfSale;
	public SaleDTO saleDTO;
	public float change;
	public float totalVat;
	public float amountToPay;
	


	public Receipt(SaleDTO sale, float cashPaid) {
		this.cashPaid = cashPaid;
		this.timeOfSale = new Date();
		this.saleDTO = sale;
		this.totalVat = itemsToVat(sale.items);
		this.amountToPay = sale.runningTotal - sale.discountAmount;
		this.change = cashPaid - amountToPay;



	}

	private float itemsToVat(ArrayList<Item> items) {
		totalVat = 0;
		for(Item item : items) {
			totalVat += item.getProduct().vatRate * item.getQuantity();
		}
		return totalVat;
	}




	@Override public String toString() {
		return "Receipt: " + timeOfSale.toString() + "\n" 
		+ " Cash paid: " + cashPaid + "\n" +
		" Change: " + change + "\n";
		
	}

}
