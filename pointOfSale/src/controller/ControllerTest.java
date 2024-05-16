package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integration.AccountingHandler;
import integration.DiscountHandler;
import integration.InventoryHandler;
import integration.ItemNotValidException;
import integration.PrinterHandler;
import model.Item;

class ControllerTest {
	Controller controller;

	@BeforeEach
	void setUp() throws Exception {
		InventoryHandler inventoryHandler = new InventoryHandler();
		AccountingHandler accountingHandler = new AccountingHandler();
		PrinterHandler printerHandler = new PrinterHandler();
		DiscountHandler discountHandler = new DiscountHandler();
		controller = new Controller(inventoryHandler, accountingHandler, printerHandler, discountHandler);

	}

	@AfterEach
	void tearDown() throws Exception {
		controller = null;
	}

	@Test
	void cannotAddItemThatDoesNotExist() {
		int testID = 4999;
		controller.startSale();
		assertThrows(ItemNotValidException.class, () -> controller.inputProduct(testID),

				"Expected that an ItemNotValidException would be thrown when trying to add an item that does not exist, but it was not.");
	}
	@Test
	void cannotAddItemThatDoesExist() {
		int testID = 123;
		controller.startSale();

		assertDoesNotThrow(() -> controller.inputProduct(testID),

				"Expected that an exception would not be thrown when trying to add an item that exists, but an exception was thrown.");
	}
}
