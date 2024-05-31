package main.java.se.kth.iv1350.pos.dto;

import java.util.ArrayList;
import main.java.se.kth.iv1350.pos.model.Item;
import main.java.se.kth.iv1350.pos.model.Sale;

/**
 * Represents an immutable sale
 */
public class SaleDTO {
    private final ArrayList<Item> items;
    private final Double runningTotal;
    private final boolean saleEnded;
    private final int customerId;
    private final Double discountAmount;

    /**
     * Creates a new instance of a SaleDTO
     * 
     * @param sale
     */
    public SaleDTO(Sale sale) {
        this.items = copyItems(sale.getItems());
        this.runningTotal = sale.getRunningTotal();
        this.saleEnded = sale.getSaleEnded();
        this.customerId = sale.getCustomerId();
        this.discountAmount = sale.getDiscountAmount();
    }

    // This method is used to create a copy, so that the original list can't be
    // changed. For example the View cant change quantity directly.
    private ArrayList<Item> copyItems(ArrayList<Item> items) {
        ArrayList<Item> itemsCopy = new ArrayList<>();
        for (Item item : items) {
            itemsCopy.add(new Item(item.getProduct(), item.getQuantity()));
        }
        return itemsCopy;
    }

    /**
     *
     * @return the items in the sale
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     *
     * @return the running total of the sale
     */

    public Double getRunningTotal() {
        return runningTotal;
    }

    /**
     *
     * @return true if the sale has ended, false if it has not
     */

    public boolean getSaleEnded() {
        return saleEnded;
    }

    /**
     *
     * @return the current customer id
     */

    public int getCustomerId() {
        return customerId;
    }

    /**
     *
     * @return the discount amount
     */

    public Double getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Prints the sale to the console
     * 
     */

    public void print() {
        System.out.println("Total price: " + runningTotal);
        System.out.println("CustomerId: " + customerId);
        System.out.println("DiscountAmount: " + discountAmount);
        System.out.printf("%-15s %-8s %-8s %-8s\n", "Item", "Quantity", "Price", "Total");

        for (Item item : items) {
            item.print();
        }
        System.out.println();
        System.out.println();

    }

}
