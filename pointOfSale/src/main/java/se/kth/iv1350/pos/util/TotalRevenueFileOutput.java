package main.java.se.kth.iv1350.pos.util;

import main.java.se.kth.iv1350.pos.model.SaleObserver;

public class TotalRevenueFileOutput implements SaleObserver {
    String fileName = "totalRevenue.txt";
    FileLogger fileLogger = new FileLogger(fileName);
    private double totalRevenue;

    @Override
    public void saleSubmitted(Double totalPrice) {
        totalRevenue += totalPrice;
        try {
            fileLogger.logTotalRevenue(totalRevenue);
        } catch (Exception e) {
            System.err.println("Could not log sale to file.");
        }
    };

}
