package dto;

import model.Sale;
import model.Item;
import java.util.ArrayList;

public class SaleDTO{
    public ArrayList<Item> items;
    public float runningTotal;
    public boolean saleEnded;
    public int customerId;
    public float discountAmount;

    public SaleDTO(Sale sale) {
        this.items = sale.getItems();
        this.runningTotal = sale.getRunningTotal();
        this.saleEnded = sale.getSaleEnded();
        this.customerId = sale.getCustomerId();
        this.discountAmount = sale.getDiscountAmount();
    }

}
