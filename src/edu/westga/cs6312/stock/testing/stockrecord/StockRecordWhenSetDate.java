package edu.westga.cs6312.stock.testing.stockrecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Provides unit tests to verify the expected behavior of StockRecord's date's
 * mutator and accessor.
 * 
 * @author sd00070
 * @version 2021-05-02
 */
public class StockRecordWhenSetDate {

	/**
	 * Tests setDate to make sure it properly sets the date to the given value.
	 */
	@Test
	public void setDateShouldChangeDateToGivenValue() {
		StockRecord testStockRecord = new StockRecord(LocalDate.parse("2020-05-07"), 19468.519531, 19720.869141,
				19448.929688, 19674.769531, 19674.769531, 82900000);

		LocalDate expectedDate = LocalDate.parse("2021-01-23");
		testStockRecord.setDate(expectedDate);

		LocalDate actualDate = testStockRecord.getDate();

		assertEquals(expectedDate, actualDate);
	}

	/**
	 * Tests setDate again to prevent the developer from hard-coding the value.
	 */
	@Test
	public void testSetDateAgainToPreventHardCoding() {
		StockRecord testStockRecord = new StockRecord(LocalDate.parse("2020-05-08"), 19972.089844, 20179.089844,
				19894.580078, 20179.089844, 20179.089844, 82200000);

		LocalDate expectedDate = LocalDate.parse("2020-06-09");
		testStockRecord.setDate(expectedDate);

		LocalDate actualDate = testStockRecord.getDate();

		assertEquals(expectedDate, actualDate);
	}

}
