package main.java.se.kth.iv1350.pos.model;

public interface ReceiptObserver {
    public void receiptSubmitted(Double totalPrice);

}
