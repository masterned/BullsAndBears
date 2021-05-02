package edu.westga.cs6312.stock.testing.stockrecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Provides unit tests to verify the expected behavior of StockRecord's
 * constructor and toString methods.
 * 
 * I really should only be testing a single method in this class, but each one
 * would be quite difficult to test without the other.
 * 
 * @author Spencer Dent
 * @version 2021-05-02
 */
public class StockRecordWhenCreateStockRecord {

	/**
	 * Test StockRecord's constructor to make sure it creates a new StockRecord with
	 * the correct values, and tests its toString method to make sure it returns the
	 * correct String.
	 */
	@Test
	public void testStockRecordConstructorShouldCreateNewStockRecordWithGivenValues() {
		StockRecord testStockRecord = new StockRecord(LocalDate.parse("2021-04-12"), 132.520004, 132.850006, 130.630005,
				131.240005, 131.240005, 91420000);
		String actualOutput = testStockRecord.toString();
		
		String expectedOutput = "Date: 2021-04-12, Open: 132.520004, High: 132.850006, Low: 130.630005, Close: 131.240005, Adj Close: 131.240005, Volume: 91420000";

		assertEquals(expectedOutput, actualOutput);
	}

	/**
	 * Test StockRecord's constructor and toString method again to prevent the
	 * developer from hard-coding values.
	 */
	@Test
	public void testStockRecordConstructorAgainToPreventHardCoding() {
		StockRecord testStockRecord = new StockRecord(LocalDate.parse("2021-04-13"), 132.440002, 134.660004, 131.929993,
				134.429993, 134.429993, 91266500);
		String actualOutput = testStockRecord.toString();

		String expectedOutput = "Date: 2021-04-13, Open: 132.440002, High: 134.660004, Low: 131.929993, Close: 134.429993, Adj Close: 134.429993, Volume: 91266500";

		assertEquals(expectedOutput, actualOutput);
	}
}
