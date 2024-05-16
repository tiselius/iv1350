package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.Controller;
import dto.ProductDTO;

class ItemTest {
	private ProductDTO testProduct;
	private Item item;

	@BeforeEach
	void setUp() throws Exception {
		testProduct = new ProductDTO(123, 99.90f, 12, "Apple, Red");
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
	void testQuantityEqualAfterIncrement() {
		item.incrementQuantity();
		int expectedAmount = 2;
		assertEquals(item.getQuantity(), expectedAmount,
				"Expected that the quantity would be incremented to 2, but it was not.");
	}

	@Test
	void testQuantityNotEqualAfterIncrement() {
		item.incrementQuantity();
		int notExpectedAmount = 1;
		assertNotEquals(item.getQuantity(), notExpectedAmount,
				"Expected that the incremented quantity would be 2, but it was not.");
	}

	@Test
	void testQuantityEqualAfterSet() {
		int newQuantity = 0;
		item.setQuantity(newQuantity);
		int expectedAmount = 0;
		assertEquals(item.getQuantity(), expectedAmount, "Expected that the incremented quantity would be "
				+ expectedAmount + ", but it was " + item.getQuantity());
	}

	@Test
	void testQuantityNotEqualAfterSet() {
		int newQuantity = 10;
		item.setQuantity(newQuantity);
		boolean result = item.getQuantity() != newQuantity;
		boolean expectedResult = false;
		assertEquals(result, expectedResult,
				"Expected that the incremented quantity would be " + newQuantity + ", but it was not.");
	}
}
