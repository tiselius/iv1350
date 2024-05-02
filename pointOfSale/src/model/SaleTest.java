package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.math.RoundingMode;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.ProductDTO;

class SaleTest {
	Sale sale;

	@BeforeEach
	void setUp() throws Exception {
		sale = new Sale();

	}

	@AfterEach
	void tearDown() throws Exception {
		this.sale = null;

	}

	@Test
	void testSaleNotNull() {
		assertNotNull(sale, "Expected that sale was not null, but it was.");
	}

	@Test
	void canAddProduct() {
		ProductDTO testProduct = new ProductDTO(1, 99.99f, 12, "Green apple");
		sale.addProduct(testProduct);
		Item item = sale.getItem(testProduct);

		if (item == null)
			fail("is null");

		boolean expectedResult = true;
		boolean result = item.getProduct().equals(testProduct) && item.getQuantity() == 1;

		assertEquals(expectedResult, result, "The products are not equal or the quantity is not 1");
	}

	@Test
	void canIncrementItem() {
		int timesToIncrement = (int) (Math.random() * 1000);
		ProductDTO testProduct = new ProductDTO(1, 99.99, 12, "Green apple");

		for (int i = 0; i < timesToIncrement; i++) {
			sale.addProduct(testProduct);
		}
		Item item = sale.getItem(testProduct);
		if (item == null)
			fail("is null");
		boolean expectedResult = true;
		boolean result = item.getProduct().equals(testProduct) && item.getQuantity() == timesToIncrement;

		assertEquals(expectedResult, result, "The product is not equal or the quantity did not increment properly");
	}

	// Extensive test that generates a long array of random products, then
	// increments that product a random amount of times, meanwhile
	// the total cost is kept track of. The test finally sees if the
	// calculateRunning total matches with the expected total.
	@Test
	void canCalculateCorrectTotalAmount() {
		int maxItemsPossibleToFitInsideANormalStore = 10000;
		int amountOfProducts = (int) (Math.random() * maxItemsPossibleToFitInsideANormalStore);
		ProductDTO[] products = new ProductDTO[amountOfProducts];
		int reasonableMaxPriceForAProduct = 2000;
		for (int i = 0; i < amountOfProducts; i++) {

			products[i] = new ProductDTO(i, Math.random() * reasonableMaxPriceForAProduct, 12,
					"green " + String.valueOf(Math.random()));
		}

		Double totalAmount = 0.0;
		int reasonableMaximumAmountOfStockInStore = 100;
		for (ProductDTO product : products) {
			int timesToIncrement = (int) ((Math.random() * reasonableMaximumAmountOfStockInStore));
			for (int i = 0; i < timesToIncrement; i++) {
				totalAmount += product.getPrice();
				sale.addProduct(product);
			}

		}
		;
		// Margin of failure
		double epsilon = 0.001d;
		assertEquals(totalAmount, sale.getRunningTotal(), epsilon,
				"Could not count: Got: " + sale.getRunningTotal() + ", but expected: " + totalAmount);

	};

	@Test
	void canGetItem() {
		ProductDTO testProduct = new ProductDTO(1, 99.99f, 12, "Green apple");
		sale.addProduct(testProduct);
		Item item = sale.getItem(testProduct);
		assertEquals(item.getProduct(), testProduct, "products are not same");
	}

}
