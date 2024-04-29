package dto;

import model.Sale;
import model.Item;
import java.util.ArrayList;

public class SaleDTO {
    private final ArrayList<Item> items;
    private final float runningTotal;
    private final boolean saleEnded;
    private final int customerId;
    private final float discountAmount;

    public SaleDTO(Sale sale) {
        this.items = sale.getItems();
        this.runningTotal = sale.getRunningTotal();
        this.saleEnded = sale.getSaleEnded();
        this.customerId = sale.getCustomerId();
        this.discountAmount = sale.getDiscountAmount();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public float getRunningTotal() {
        return runningTotal;
    }

    public boolean getSaleEnded() {
        return saleEnded;
    }

    public int getCustomerId() {
        return customerId;
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public void print() {
        System.out.println("runningTotal: " + runningTotal);
        System.out.println("saleEnded: " + saleEnded);
        System.out.println("customerId: " + customerId);
        System.out.println("discountAmount: " + discountAmount);
        System.out.println("Item" + "   " + "Quantity" + "   " +
                "Price" + "   " + "Total");
        for (Item item : items) {
            item.print();
        }
        System.out.println();
        System.out.println();

    }

}
