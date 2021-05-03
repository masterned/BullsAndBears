package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;

/**
 * Provides unit tests to verify the expected behavior of StockManager's
 * constructor.
 * 
 * @author Spencer Dent
 * @version 2021-05-02
 */
public class StockManagerWhenCreateStockManager {

	/**
	 * Tests the constructor to make sure it creates a new StockManager with the given name.
	 */
	@Test
	public void testStockManagerConstructorShouldCreateNewStockManagerWithEmptyList() {
		StockManager testStockManager = new StockManager("Nikkei");

		assertEquals("Nikkei", testStockManager.getStockName());
	}

	/**
	 * Tests the constructor again to prevent the developer from hard-coding the
	 * values.
	 */
	@Test
	public void testStockManagerConstructorAgainToPreventHardCoding() {
		StockManager testStockManager = new StockManager("AAPL");
		
		assertEquals("AAPL", testStockManager.getStockName());
	}
}
