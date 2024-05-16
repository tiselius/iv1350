package main.java.se.kth.iv1350.pos.view;

import main.java.se.kth.iv1350.pos.model.SaleObserver;
import main.java.se.kth.iv1350.pos.util.ConsoleLogger;

public class TotalRevenueView implements SaleObserver {
    ConsoleLogger consoleLogger = new ConsoleLogger();
    Double totalMoney = 0.0d;

    @Override
    public void saleSubmitted(Double totalPrice) {
        totalMoney += totalPrice;
        System.out.println("Total revenue after previous sale: " + totalMoney + " SEK.");
        consoleLogger.logTotalRevenue(totalMoney);
    }

}
