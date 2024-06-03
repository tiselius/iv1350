package main.java.se.kth.iv1350.pos.view;

import main.java.se.kth.iv1350.pos.controller.Controller;
import main.java.se.kth.iv1350.pos.dto.SaleDTO;
import main.java.se.kth.iv1350.pos.integration.DBNotReachableException;
import main.java.se.kth.iv1350.pos.integration.ItemNotValidException;
import main.java.se.kth.iv1350.pos.model.Receipt;
import main.java.se.kth.iv1350.pos.util.ConsoleLogger;
import main.java.se.kth.iv1350.pos.util.FileLogger;
import main.java.se.kth.iv1350.pos.util.TotalRevenueFileOutput;

/**
 * Renders the view
 */
public class View {

  Controller controller;
  String fileName = "log.txt";
  FileLogger fileLogger;
  ConsoleLogger consoleLogger;

  /**
   * Creates a new instance of a View
   * 
   * @param controller
   */
  public View(Controller controller) {
    this.controller = controller;
    fileLogger = new FileLogger(fileName);
    consoleLogger = new ConsoleLogger();
    controller.addObserverToReceipt(new TotalRevenueView());
    controller.addObserverToReceipt(new TotalRevenueFileOutput());
  }

  /**
   * Runs a test execution of the program.
   */
  public void test() {
    try {
      SaleDTO sale = controller.startSale();

      sale = inputProduct(123);
      sale.print();
      sale = inputProduct(8584893);
      sale.print();
      sale = inputProduct(321);
      sale.print();

      sale = inputProduct(666);
      sale.print();
      sale = controller.setQuantity(123, 5);
      // sale = controller.setQuantity(sale.getItems().get(0), 5);
      sale.print();
      sale = controller.endSale();
      sale = controller.getDiscount(123);
      sale.print();
      Receipt receipt = controller.makePayment(45.0);

      receipt.print();

      // sale.print();

    } catch (Exception generalException) {
      logException(generalException);
      System.exit(1);
    }
  }

  SaleDTO inputProduct(int id) {
    try {
      SaleDTO sale = controller.inputProduct(id);
      return sale;
    } catch (ItemNotValidException | DBNotReachableException e) {
      logException(e);
      return controller.getSaleDTO();
    }
  }

  public void logException(Exception e) {
    fileLogger.logException(e);
    consoleLogger.logException(e);
  }
}
