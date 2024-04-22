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
		this.totalVat = itemsToVat(sale.getItems());
		this.amountToPay = sale.getRunningTotal() - sale.getDiscountAmount();
		this.change = cashPaid - amountToPay;

	}

	private float itemsToVat(ArrayList<Item> items) {
		totalVat = 0;
		for (Item item : items) {
			totalVat += ((double) item.getProduct().getVatRate() / 100)
					* (item.getQuantity() * item.getProduct().getPrice());
		}
		return totalVat;
	}

	public void print() {
		System.out.println("Time of sale: " + timeOfSale);
		System.out.println("Cash paid: " + cashPaid);
		System.out.println("Amount to pay: " + amountToPay);
		System.out.println("Change: " + change);
		System.out.println("Total VAT: " + totalVat);
		saleDTO.print();
	}
}
