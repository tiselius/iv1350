package model;

import java.util.ArrayList;
import java.util.Date;
import dto.SaleDTO;

/**
 * Represents a receipt for a sale
 */
public class Receipt {

	public Double cashPaid;
	public Date timeOfSale;
	public SaleDTO saleDTO;
	public Double change;
	public Double totalVat;
	public Double amountToPay;

	/**
	 * Creates a new instance of a receipt
	 * 
	 * @param sale     the sale to create a receipt for
	 * @param cashPaid the amount of cash paid
	 */
	public Receipt(SaleDTO sale, Double cashPaid) {
		this.cashPaid = cashPaid;
		this.timeOfSale = new Date();
		this.saleDTO = sale;
		this.totalVat = itemsToVat(sale.getItems());
		this.amountToPay = sale.getRunningTotal() - sale.getDiscountAmount();
		this.change = cashPaid - amountToPay;

	}

	private Double itemsToVat(ArrayList<Item> items) {
		totalVat = 0.0;
		for (Item item : items) {
			totalVat += (item.getProduct().getVatRate() / 100)
					* (item.getQuantity() * item.getProduct().getPrice());
		}
		return totalVat;
	}

	/**
	 * Prints the receipt to the console
	 * 
	 */
	public void print() {
		System.out.println("Time of sale: " + timeOfSale);
		System.out.println("Cash paid: " + cashPaid);
		System.out.println("Amount to pay: " + amountToPay);
		System.out.println("Change: " + change);
		System.out.println("Total VAT: " + totalVat);
		saleDTO.print();
	}
}
