package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Provides unit tests to verify the expected behavior of StockRecord's
 * addStockRecord method.
 * 
 * @author Spencer Dent
 * @version 2021-05-02
 */
public class StockManagerWhenAddStockRecord {

	/**
	 * Tests addStockRecord on a StockManager with an empty list.
	 */
	@Test
	public void testAddStockRecordToEmptyListShouldAddRecordToList() {
		StockManager testStockManager = new StockManager();
		StockRecord testStockRecord = new StockRecord(LocalDate.parse("2020-05-07"), 19468.519531, 19720.869141,
				19448.929688, 19674.769531, 19674.769531, 82900000);

		ArrayList<StockRecord> expectedStockRecordList = new ArrayList<StockRecord>();
		expectedStockRecordList.add(testStockRecord);

		testStockManager.addStockRecord(testStockRecord);
		ArrayList<StockRecord> actualStockRecordList = testStockManager.getAllStockRecords();

		assertEquals(expectedStockRecordList, actualStockRecordList);
	}

	/**
	 * Tests addStockRecord on a StockManager with values in its list.
	 */
	@Test
	public void testAddStockRecordOnStockManagerWithAListWithValuesShouldAppendNewRecord() {
		StockManager testStockManager = new StockManager();
		StockRecord firstTestStockRecord = new StockRecord(LocalDate.parse("2020-05-11"), 20333.730469, 20534.880859,
				20285.039063, 20390.660156, 20390.660156, 76200000);
		StockRecord secondTestStockRecord = new StockRecord(LocalDate.parse("2020-06-24"), 22541.009766, 22663.289063,
				22479.859375, 22534.320313, 22534.320313, 67000000);

		ArrayList<StockRecord> expectedStockRecordList = new ArrayList<StockRecord>();
		expectedStockRecordList.add(firstTestStockRecord);
		expectedStockRecordList.add(secondTestStockRecord);

		testStockManager.addStockRecord(firstTestStockRecord);
		testStockManager.addStockRecord(secondTestStockRecord);
		ArrayList<StockRecord> actualStockRecordList = testStockManager.getAllStockRecords();

		assertEquals(expectedStockRecordList, actualStockRecordList);
	}
}
