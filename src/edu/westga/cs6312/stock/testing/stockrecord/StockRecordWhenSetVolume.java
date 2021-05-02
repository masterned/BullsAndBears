package edu.westga.cs6312.stock.testing.stockrecord;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Provides unit tests to verify the expected behavior of StockRecord's volume's
 * mutator and accessor.
 * 
 * @author sd00070
 * @version 2021-05-02
 */
public class StockRecordWhenSetVolume {

	/**
	 * Tests setVolume to make sure it properly sets the volume to the given value.
	 */
	@Test
	public void setVolumeShouldChangeVolumeToGivenValue() {
		StockRecord testStockRecord = new StockRecord(LocalDate.parse("2020-05-07"), 19468.519531, 19720.869141,
				19448.929688, 19674.769531, 19674.769531, 82900000);

		int expectedVolume = 75600000;
		testStockRecord.setVolume(expectedVolume);

		int actualVolume = testStockRecord.getVolume();

		assertEquals(expectedVolume, actualVolume);
	}

	/**
	 * Tests setVolume again to prevent the developer from hard-coding the value.
	 */
	@Test
	public void testSetVoluemAgainToPreventHardCoding() {
		StockRecord testStockRecord = new StockRecord(LocalDate.parse("2020-05-08"), 19972.089844, 20179.089844,
				19894.580078, 20179.089844, 20179.089844, 82200000);

		int expectedVolume = 82600000;
		testStockRecord.setVolume(expectedVolume);

		int actualVolume = testStockRecord.getVolume();

		assertEquals(expectedVolume, actualVolume);
	}

}
