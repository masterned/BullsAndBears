package edu.westga.cs6312.stock.testing.stockmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Provides unit tests to verify the expected behavior of StockManager's
 * getSummaryData method.
 * 
 * @author Spencer Dent
 * @version 2021-05-02
 */
public class StockManagerWhenGetSummaryData {

	/**
	 * Tests getSummaryData on a StockManager with a single StockRecord. Should
	 * return a list with the item on it three times.
	 */
	@Test
	public void testGetSummaryDataOnStockManagerWithOnlyOneStockRecord() {
		StockManager testStockManager = new StockManager();
		StockRecord testStockRecord = new StockRecord(LocalDate.parse("2020-06-09"), 23135.789063, 23185.849609,
				22933.140625, 23091.029297, 23091.029297, 91500000);
		testStockManager.addStockRecord(testStockRecord);

		ArrayList<StockRecord> expectedStockRecords = new ArrayList<StockRecord>();
		expectedStockRecords.add(testStockRecord);
		expectedStockRecords.add(testStockRecord);
		expectedStockRecords.add(testStockRecord);

		ArrayList<StockRecord> actualStockRecords = testStockManager.getSummaryData();

		assertEquals(expectedStockRecords, actualStockRecords);
	}

	/**
	 * Tests getSummaryData on a StockManager with 3 StockRecords. It should return
	 * a list identical to its internal list.
	 */
	@Test
	public void testGetSummaryDataOnStockManagerWithThreeStockRecords() {
		StockManager testStockManager = new StockManager();
		StockRecord[] stockRecordExamples = {
			new StockRecord(LocalDate.parse("2020-07-10"), 22534.970703, 22563.679688, 22285.070313, 22290.810547,
					22290.810547, 78800000),
			new StockRecord(LocalDate.parse("2020-08-03"), 21947.580078, 22214.589844, 21919.830078, 22195.380859,
					22195.380859, 84000000),
			new StockRecord(LocalDate.parse("2020-08-11"), 22505.509766, 22760.869141, 22497.070313, 22750.240234,
					22750.240234, 99300000) };
		testStockManager.addStockRecord(stockRecordExamples[0]);
		testStockManager.addStockRecord(stockRecordExamples[1]);
		testStockManager.addStockRecord(stockRecordExamples[2]);

		ArrayList<StockRecord> expectedStockRecords = new ArrayList<StockRecord>();
		expectedStockRecords.add(stockRecordExamples[0]);
		expectedStockRecords.add(stockRecordExamples[1]);
		expectedStockRecords.add(stockRecordExamples[2]);

		ArrayList<StockRecord> actualStockRecords = testStockManager.getSummaryData();

		assertEquals(expectedStockRecords, actualStockRecords);
	}

	/**
	 * Tests getSummaryData on a StockManager with an even number of StockRecords.
	 * When selecting the middle number, it rounds to the next record.
	 */
	@Test
	public void testGetSummaryDataOnStockManagerWithAnEvenNumberOfStockRecords() {
		StockManager testStockManager = new StockManager();
		StockRecord[] stockRecordExamples = {
			new StockRecord(LocalDate.parse("2020-07-10"), 22534.970703, 22563.679688, 22285.070313, 22290.810547,
					22290.810547, 78800000),
			new StockRecord(LocalDate.parse("2020-08-03"), 21947.580078, 22214.589844, 21919.830078, 22195.380859,
					22195.380859, 84000000),
			new StockRecord(LocalDate.parse("2020-08-11"), 22505.509766, 22760.869141, 22497.070313, 22750.240234,
					22750.240234, 99300000),
			new StockRecord(LocalDate.parse("2020-08-26"), 23257.050781, 23348.800781, 23203.000000, 23290.859375,
					23290.859375, 47800000) };
		testStockManager.addStockRecord(stockRecordExamples[0]);
		testStockManager.addStockRecord(stockRecordExamples[1]);
		testStockManager.addStockRecord(stockRecordExamples[2]);
		testStockManager.addStockRecord(stockRecordExamples[3]);

		ArrayList<StockRecord> expectedStockRecords = new ArrayList<StockRecord>();
		expectedStockRecords.add(stockRecordExamples[0]);
		expectedStockRecords.add(stockRecordExamples[2]);
		expectedStockRecords.add(stockRecordExamples[3]);

		ArrayList<StockRecord> actualStockRecords = testStockManager.getSummaryData();

		assertEquals(expectedStockRecords, actualStockRecords);
	}
}
