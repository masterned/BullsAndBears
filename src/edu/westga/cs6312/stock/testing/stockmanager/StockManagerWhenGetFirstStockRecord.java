package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Provides unit tests to verify the expected behavior of StockManager's
 * getFirstStockRecord method.
 * 
 * @author Spencer Dent
 * @version 2021-05-02
 */
public class StockManagerWhenGetFirstStockRecord {

	/**
	 * Tests getFirstStockRecord on a StockManager with a single StockRecord. Should
	 * return that StockRecord.
	 */
	@Test
	public void testGetFirstStockRecordOnStockManagerWithOnlyOneStockRecordShouldReturnThatRecord() {
		StockRecord expectedStockRecord = new StockRecord(LocalDate.parse("2020-06-09"), 23135.789063, 23185.849609,
				22933.140625, 23091.029297, 23091.029297, 91500000);

		StockManager testStockManager = new StockManager();
		testStockManager.addStockRecord(expectedStockRecord);

		assertEquals(expectedStockRecord, testStockManager.getFirstStockRecord());
	}

	/**
	 * Tests getFirstStockRecord on a StockManager with multiple StockRecords. It
	 * should return the first StockRecord inserted.
	 */
	@Test
	public void testGetSummaryDataOnStockManagerWithMultipleStockRecordsShouldReturnFirstInsertedRecord() {
		StockRecord expectedStockRecord = new StockRecord(LocalDate.parse("2020-07-10"), 22534.970703, 22563.679688,
				22285.070313, 22290.810547, 22290.810547, 78800000);

		StockManager testStockManager = new StockManager();
		testStockManager.addStockRecord(expectedStockRecord);
		testStockManager.addStockRecord(new StockRecord(LocalDate.parse("2020-08-03"), 21947.580078, 22214.589844,
				21919.830078, 22195.380859, 22195.380859, 84000000));

		assertEquals(expectedStockRecord, testStockManager.getFirstStockRecord());
	}
}
