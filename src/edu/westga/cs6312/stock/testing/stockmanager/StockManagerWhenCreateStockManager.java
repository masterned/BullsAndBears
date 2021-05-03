package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Provides a unit test to verify the expected behavior of StockManager's
 * constructor.
 * 
 * As the constructor is does not take any arguments, testing multiple times
 * will not yeild different results.
 * 
 * @author Spencer Dent
 * @version 2021-05-02
 */
public class StockManagerWhenCreateStockManager {

	/**
	 * Tests the constructor to make sure it creates a new StockManager with an
	 * empty list.
	 */
	@Test
	public void stockManagerConstructorShouldCreateNewStockManagerWithEmptyList() {
		StockManager testStockManager = new StockManager();
		ArrayList<StockRecord> expectedStockRecords = new ArrayList<StockRecord>();

		assertEquals(expectedStockRecords, testStockManager.getAllStockRecords());
	}

}
