package main.java.se.kth.iv1350.pos.integration;

import java.util.ArrayList;

import main.java.se.kth.iv1350.pos.dto.SaleDTO;
import main.java.se.kth.iv1350.pos.model.Item;
import main.java.se.kth.iv1350.pos.model.Sale;

/**
 * Handles the discount system
 */
public class DiscountHandler {

  /**
   * Creates a new instance of a discount handler. TODO implement
   */
  public DiscountHandler() {

  }

  private double getItemsDiscount(ArrayList<Item> items) {
    double discount = 0;

    for (Item item : items) {
      if (item.getProduct().getId() == 123) {
        discount += item.getProduct().getPrice() * item.getQuantity() * 0.1;
      }
      // Real system has more discount rules
    }

    return discount;
  }

  private double getDiscountOnEntireSale(double runningTotal) {
    double discount = 0;

    discount = (double) (runningTotal * 0.1);

    return discount;
  }

  private double getCustomerDiscountPercentage(int customerID) {
    double discount = 0;

    if (customerID == 123) {
      discount = 2;
    }
    // Real system has more discount rules

    return discount;
  }

  /**
   * Calculates the discount amount for a sale
   * 
   * @param customerID the id of the customer
   * @param sale       the sale to calculate the discount for
   * @return the discount amount
   */
  public double getDiscountAmount(int customerID, Sale sale) {
    double customerDiscount = (getCustomerDiscountPercentage(customerID) / 100) * sale.getRunningTotal();
    double itemDiscount = getItemsDiscount(sale.getItems());
    double saleDiscount = getDiscountOnEntireSale(sale.getRunningTotal());

    return customerDiscount + itemDiscount + saleDiscount;

  }
}
