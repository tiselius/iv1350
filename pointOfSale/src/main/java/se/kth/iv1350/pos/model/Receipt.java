package main.java.se.kth.iv1350.pos.model;

import java.util.ArrayList;
import java.util.Date;
import main.java.se.kth.iv1350.pos.dto.SaleDTO;

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
    totalVat = 0.0d;
    for (Item item : items) {
      totalVat += ((double) item.getProduct().getVatRate() / 100.0d)
          * ((double) item.getQuantity() * item.getProduct().getPrice());
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
    System.out.printf("Change: %5.2f%n", change);
    System.out.println("Total VAT: " + totalVat);
    saleDTO.print();
  }
}
