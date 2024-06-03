package main.java.se.kth.iv1350.pos.view;

import main.java.se.kth.iv1350.pos.model.ReceiptObserver;
import main.java.se.kth.iv1350.pos.util.ConsoleLogger;

public class TotalRevenueView implements ReceiptObserver {
    ConsoleLogger consoleLogger = new ConsoleLogger();
    Double totalMoney = 0.0d;

    @Override
    public void receiptSubmitted(Double totalPrice) {
        totalMoney += totalPrice;
        consoleLogger.logTotalRevenue(totalMoney);
    }

}
