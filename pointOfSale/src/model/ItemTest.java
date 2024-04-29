package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {
	private Product testProduct; 
	private Item item;

	@BeforeEach
	void setUp() throws Exception {
		testProduct = new Product(123, 99.90f, 12, "Apple, Red");
		item = new Item(testProduct);
	}

	@AfterEach
	void tearDown() throws Exception {
		testProduct = null;
		item = null;
	}

	@Test
	void testItemNotNull() {
		assertNotNull(item, "Expected that item was not null, but it was.");
		}

	@Test
	void testIncrementQuantityEqual() {
		item.incrementQuantity();
		int expectedAmount = 2;
		assertEquals(item.quantity, expectedAmount, "Expected that the quantity would be incremented to 2, but it was not.");
	}
	
	@Test
	void testIncrementQuantityNotEqual() {
		item.incrementQuantity();
		int notExpectedAmount = 1;
		assertNotEquals(item.quantity, notExpectedAmount,  "Expected that the incremented quantity would be 2, but it was not.");
	}

}
