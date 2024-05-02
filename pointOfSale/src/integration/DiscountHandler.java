package integration;

import java.util.ArrayList;

import dto.SaleDTO;
import model.Item;
import model.Sale;

public class DiscountHandler {

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

  public double getDiscountAmount(int customerID, Sale sale) {

    double customerDiscount = (getCustomerDiscountPercentage(customerID) / 100) * sale.getRunningTotal();
    // System.out.println("The price is now: " + (sale.getRunningTotal() -
    // customerDiscount));
    double itemDiscount = getItemsDiscount(sale.getItems());
    // System.out.println("The price is now: " + (sale.getRunningTotal() -
    // customerDiscount - itemDiscount));

    double saleDiscount = getDiscountOnEntireSale(sale.getRunningTotal());
    /*
     * System.out
     * .println("The price is now: " + (sale.getRunningTotal() - customerDiscount -
     * itemDiscount - saleDiscount));
     */

    return customerDiscount + itemDiscount + saleDiscount;

  }
}
