package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Provides unit tests to verify the expected behavior of StockManager's
 * getMiddleStockRecord method.
 * 
 * @author Spencer Dent
 * @version 2021-05-02
 */
public class StockManagerWhenGetMiddleStockRecord {

	/**
	 * Tests getMiddleStockRecord on a StockManager with a single StockRecord.
	 * Should return that StockRecord.
	 */
	@Test
	public void testGetMiddleStockRecordOnStockManagerWithOnlyOneStockRecordShouldReturnThatRecord() {
		StockRecord expectedStockRecord = new StockRecord(LocalDate.parse("2020-06-09"), 23135.789063, 23185.849609,
				22933.140625, 23091.029297, 23091.029297, 91500000);

		StockManager testStockManager = new StockManager("Nikkei");
		testStockManager.addStockRecord(expectedStockRecord);

		assertEquals(expectedStockRecord, testStockManager.getMiddleStockRecord());
	}

	/**
	 * Tests getMiddleStockRecord on a StockManager with an odd number of
	 * StockRecords. It should return the StockRecord in the middle of the list.
	 */
	@Test
	public void testGetMiddleStockRecordOnStockManagerWithOddStockRecordsShouldReturnRecordInMiddleOfList() {
		StockRecord expectedStockRecord = new StockRecord(LocalDate.parse("2020-07-10"), 22534.970703, 22563.679688,
				22285.070313, 22290.810547, 22290.810547, 78800000);

		StockManager testStockManager = new StockManager("Nikkei");
		testStockManager.addStockRecord(new StockRecord(LocalDate.parse("2020-08-03"), 21947.580078, 22214.589844,
				21919.830078, 22195.380859, 22195.380859, 84000000));
		testStockManager.addStockRecord(expectedStockRecord);
		testStockManager.addStockRecord(new StockRecord(LocalDate.parse("2021-04-16"), 29789.080078, 29789.080078,
				29621.830078, 29683.369141, 29683.369141, 49100000));

		assertEquals(expectedStockRecord, testStockManager.getMiddleStockRecord());
	}

	/**
	 * Tests getMiddleStockRecord on a StockManager with an even number of
	 * StockRecords. It should return the StockRecord after the center of the list.
	 */
	@Test
	public void testGetMiddleStockRecordOnStockManagerWithEvenStockRecordsShouldReturnRecordAfterListCenter() {
		StockRecord expectedStockRecord = new StockRecord(LocalDate.parse("2020-07-10"), 22534.970703, 22563.679688,
				22285.070313, 22290.810547, 22290.810547, 78800000);

		StockManager testStockManager = new StockManager("Nikkei");
		testStockManager.addStockRecord(new StockRecord(LocalDate.parse("2021-03-18"), 30148.480469, 30485.000000,
				30041.500000, 30216.750000, 30216.750000, 95400000));
		testStockManager.addStockRecord(new StockRecord(LocalDate.parse("2020-08-03"), 21947.580078, 22214.589844,
				21919.830078, 22195.380859, 22195.380859, 84000000));
		testStockManager.addStockRecord(expectedStockRecord);
		testStockManager.addStockRecord(new StockRecord(LocalDate.parse("2021-04-16"), 29789.080078, 29789.080078,
				29621.830078, 29683.369141, 29683.369141, 49100000));

		assertEquals(expectedStockRecord, testStockManager.getMiddleStockRecord());
	}
}
