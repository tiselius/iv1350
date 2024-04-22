package integration;

import java.util.ArrayList;

import dto.SaleDTO;
import model.Item;
import model.Sale;

public class DiscountHandler {

  public DiscountHandler() {

  }

  private float getItemsDiscount(ArrayList<Item> items) {
    float discount = 0;

    for (Item item : items) {
      if (item.getProduct().getId() == 123) {
        discount += item.getProduct().getPrice() * item.getQuantity() * 0.1;
      }
      // Real system has more discount rules
    }

    return discount;
  }

  private float getDiscountOnEntireSale(float runningTotal) {
    float discount = 0;

    discount = (float) (runningTotal * 0.1);

    return discount;
  }

  private float getCustomerDiscountPercentage(int customerID) {
    float discount = 0;

    if (customerID == 123) {
      discount = 2;
    }
    // Real system has more discount rules

    return discount;
  }

  public float getDiscountAmount(int customerID, Sale sale) {

    float customerDiscount = (getCustomerDiscountPercentage(customerID) / 100) * sale.getRunningTotal();
    // System.out.println("The price is now: " + (sale.getRunningTotal() -
    // customerDiscount));
    float itemDiscount = getItemsDiscount(sale.getItems());
    // System.out.println("The price is now: " + (sale.getRunningTotal() -
    // customerDiscount - itemDiscount));

    float saleDiscount = getDiscountOnEntireSale(sale.getRunningTotal());
    /*
     * System.out
     * .println("The price is now: " + (sale.getRunningTotal() - customerDiscount -
     * itemDiscount - saleDiscount));
     */

    return customerDiscount + itemDiscount + saleDiscount;

  }
}
