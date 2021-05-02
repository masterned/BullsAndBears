package edu.westga.cs6312.stock.testing.stockrecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Provides unit tests to verify the expected behavior of StockRecord's
 * lowPrice's mutator and accessor.
 * 
 * @author sd00070
 * @version 2021-05-02
 */
public class StockRecordWhenSetLowPrice {

	/**
	 * Tests setLowPrice to make sure it properly sets the low price to the given
	 * value.
	 */
	@Test
	public void setLowPriceShouldChangeLowPriceToGivenValue() {
		StockRecord testStockRecord = new StockRecord(LocalDate.parse("2020-05-07"), 19468.519531, 19720.869141,
				19448.929688, 19674.769531, 19674.769531, 82900000);

		double expectedLowPrice = 19368.517531;
		testStockRecord.setLowPrice(expectedLowPrice);

		double actualLowPrice = testStockRecord.getLowPrice();

		assertEquals(expectedLowPrice, actualLowPrice);
	}

	/**
	 * Tests setLowPrice again to prevent the developer from hard-coding the value.
	 */
	@Test
	public void testSetLowPriceAgainToPreventHardCoding() {
		StockRecord testStockRecord = new StockRecord(LocalDate.parse("2020-05-08"), 19972.089844, 20179.089844,
				19894.580078, 20179.089844, 20179.089844, 82200000);

		double expectedLowPrice = 19448.929688;
		testStockRecord.setLowPrice(expectedLowPrice);

		double actualLowPrice = testStockRecord.getLowPrice();

		assertEquals(expectedLowPrice, actualLowPrice);
	}

}
