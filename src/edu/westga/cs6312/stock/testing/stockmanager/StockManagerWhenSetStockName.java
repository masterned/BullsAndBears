package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;

/**
 * Provides unit tests to verify the expected behavior of StockManager's
 * setStockName method.
 * 
 * @author Spencer Dent
 * @version 2021-05-03
 */
public class StockManagerWhenSetStockName {

	/**
	 * Tests setStockName to make sure it properly sets the stockName instance
	 * variable in a StockManager object.
	 */
	@Test
	public void testSetStockNameShouldChangeStockNameToGivenString() {
		StockManager testStockManager = new StockManager("");
		testStockManager.setStockName("Nikkei");

		assertEquals("Nikkei", testStockManager.getStockName());
	}

	/**
	 * Tests setStockName again to prevent the developer from hard-coding the return
	 * value.
	 */
	@Test
	public void testSetStockNameAgainToPreventHardCoding() {
		StockManager testStockManager = new StockManager("Nikkei");
		testStockManager.setStockName("AAPL");

		assertEquals("AAPL", testStockManager.getStockName());
	}
}
