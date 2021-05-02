package edu.westga.cs6312.stock.model;

import java.time.LocalDate;

/**
 * Provides a model that stores the information of a particular stock on a given
 * day.
 * 
 * I know that in a real stock application I would not be using a double to
 * store all of the price values. Due to rounding issues found in floating point
 * values, storing monetary values in them can get people in a lot of trouble.
 * But, for the sake of this assignment, using a BigDecimal along side of a
 * Currency may be beyond the scope of this class. We are only displaying the
 * values not changing them. Using floats like this should be OK for the
 * purposes of this assignment.
 * 
 * @author Spencer Dent
 * @version 2021-05-01
 */
public class StockRecord {
	private LocalDate date;
	private double openingPrice;
	private double highPrice;
	private double lowPrice;
	private double closingPrice;
	private double adjustedClosingPrice;
	private int volume;

	/**
	 * Creates a new StockRecord with the provided values.
	 * 
	 * @param newDate                 - the date of the new StockRecord
	 * @param newOpeningPrice         - the opening price of the new StockRecord
	 * @param newHighPrice            - the high price of the new StockRecord
	 * @param newLowPrice             - the low price of the new StockRecord
	 * @param newClosingPrice         - the closing price of the new StockRecord
	 * @param newAdjustedClosingPrice - the adjusted closingPrice of the new
	 *                                StockRecord
	 * @param newVolume               - the volume of the new StockRecord
	 * @precondition newDate is not null, all prices are greater than zero, high
	 *               price highest, low price lowest
	 * @throws IllegalArgumentException if newDate is null, any of the prices are
	 *                                  less than or equal to zero, the high price
	 *                                  is lower than any of the others, or the low
	 *                                  price is higher than any of the others
	 */
	public StockRecord(LocalDate newDate, double newOpeningPrice, double newHighPrice, double newLowPrice,
			double newClosingPrice, double newAdjustedClosingPrice, int newVolume) {
		if (newDate == null) {
			throw new IllegalArgumentException("Invalid date: date cannot be null");
		}

		if (newOpeningPrice <= 0) {
			throw new IllegalArgumentException("Invalid opening price: must be greater than zero");
		}
		if (newHighPrice <= 0) {
			throw new IllegalArgumentException("Invalid high price: must be greater than zero");
		}
		if (newLowPrice <= 0) {
			throw new IllegalArgumentException("Invalid low price: must be greater than zero");
		}
		if (newClosingPrice <= 0) {
			throw new IllegalArgumentException("Invalid closing price: must be greater than zero");
		}
		if (newAdjustedClosingPrice <= 0) {
			throw new IllegalArgumentException("Invalid adjusted closing price: must be greater than zero");
		}

		if (newHighPrice < newOpeningPrice || newHighPrice < newLowPrice || newHighPrice < newClosingPrice
				|| newHighPrice < newAdjustedClosingPrice) {
			throw new IllegalArgumentException("Invalid arguments: high price must be greatest price");
		}

		if (newLowPrice > newOpeningPrice || newLowPrice > newHighPrice || newLowPrice > newClosingPrice
				|| newLowPrice > newAdjustedClosingPrice) {
			throw new IllegalArgumentException("Invalid arguments: low price must be least price");
		}

		this.date = newDate;
		this.openingPrice = newOpeningPrice;
		this.highPrice = newHighPrice;
		this.lowPrice = newLowPrice;
		this.closingPrice = newClosingPrice;
		this.adjustedClosingPrice = newAdjustedClosingPrice;
		this.volume = newVolume;
	}

	/**
	 * Accesses the StockRecord's date
	 * 
	 * @return the StockRecord's date
	 */
	public LocalDate getDate() {
		return this.date;
	}

	/**
	 * Changes the StockRecord's date to the given value
	 * 
	 * @param date - the new date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Accesses the StockRecord's opening price
	 * 
	 * @return the StockRecord's opening price
	 */
	public double getOpeningPrice() {
		return this.openingPrice;
	}

	/**
	 * Changes the StockRecord's opening price to the given value
	 * 
	 * @param newOpeningPrice - the new opening price
	 * @precondition newOpeningPrice is greater than or equal to lowPrice and less
	 *               than or equal to highPrice
	 * @throws IllegalArgumentException if newOpeningPrice is less than lowPrice or
	 *                                  greater than highPrice
	 */
	public void setOpeningPrice(double newOpeningPrice) {
		if (newOpeningPrice > this.highPrice) {
			throw new IllegalArgumentException("Invalid opening price: cannot be greater than high price");
		}
		if (newOpeningPrice < this.lowPrice) {
			throw new IllegalArgumentException("Invalid opening price: cannot be less than low price");
		}

		this.openingPrice = newOpeningPrice;
	}

	/**
	 * Accesses the StockRecord's high price
	 * 
	 * @return the StockRecord's high price
	 */
	public double getHighPrice() {
		return this.highPrice;
	}

	/**
	 * Changes the StockRecord's high price to the given value
	 * 
	 * @param newHighPrice - the new high price
	 * @precondition newHighPrice is greater than all other prices
	 * @throws IllegalArgumentException if newHighPrice is less than any other price
	 */
	public void setHighPrice(double newHighPrice) {
		if (newHighPrice < this.openingPrice || newHighPrice < this.lowPrice || newHighPrice < this.closingPrice
				|| newHighPrice < this.adjustedClosingPrice) {
			throw new IllegalArgumentException("Invalid high price: must be greater than all other prices");
		}

		this.highPrice = newHighPrice;
	}

	/**
	 * Accesses the StockRecord's low price
	 * 
	 * @return the StockRecord's low price
	 */
	public double getLowPrice() {
		return this.lowPrice;
	}

	/**
	 * Changes the StockRecord's low price to the given value
	 * 
	 * @param newLowPrice - the new low price
	 * @precondition newLowPrice is lesser than all other prices
	 * @throws IllegalArgumentException if newLowPrice is greater than any other
	 *                                  price
	 */
	public void setLowPrice(double newLowPrice) {
		if (newLowPrice > this.openingPrice || newLowPrice > this.highPrice || newLowPrice > this.closingPrice
				|| newLowPrice > this.adjustedClosingPrice) {
			throw new IllegalArgumentException("Invalid low price: must be lesser than all other prices");
		}
		this.lowPrice = newLowPrice;
	}

	/**
	 * Accesses the StockRecord's closing price
	 * 
	 * @return the StockRecord's closing price
	 */
	public double getClosingPrice() {
		return this.closingPrice;
	}

	/**
	 * Changes the StockRecord's closing price to the given value
	 * 
	 * @param newClosingPrice - the new closing price
	 * @precondition newClosingPrice is greater than or equal to lowPrice and less
	 *               than or equal to highPrice
	 * @throws IllegalArgumentException if newClosingPrice is less than lowPrice or
	 *                                  greater than highPrice
	 */
	public void setClosingPrice(double newClosingPrice) {
		if (newClosingPrice > this.highPrice) {
			throw new IllegalArgumentException("Invalid closing price: cannot be greater than high price");
		}
		if (newClosingPrice < this.lowPrice) {
			throw new IllegalArgumentException("Invalid closing price: cannot be less than low price");
		}

		this.closingPrice = newClosingPrice;
	}

	/**
	 * Accesses the StockRecord's adjusted closing price
	 * 
	 * @return the StockRecord's adjusted closing price
	 */
	public double getAdjustedClosingPrice() {
		return this.adjustedClosingPrice;
	}

	/**
	 * Changes the StockRecord's adjusted closing price to the given value
	 * 
	 * @param newAdjustedClosingPrice - the new adjusted closing price
	 * @precondition newAdjustedClosingPrice is greater than or equal to lowPrice
	 *               and less than or equal to highPrice
	 * @throws IllegalArgumentException if newAdjustedClosingPrice is less than
	 *                                  lowPrice or greater than highPrice
	 */
	public void setAdjustedClosingPrice(double newAdjustedClosingPrice) {
		if (newAdjustedClosingPrice > this.highPrice) {
			throw new IllegalArgumentException("Invalid adjusted closing price: cannot be greater than high price");
		}
		if (newAdjustedClosingPrice < this.lowPrice) {
			throw new IllegalArgumentException("Invalid adjusted closing price: cannot be less than low price");
		}

		this.adjustedClosingPrice = newAdjustedClosingPrice;
	}

	/**
	 * Accesses the StockRecord's volume
	 * 
	 * @return the StockRecord's volume
	 */
	public int getVolume() {
		return this.volume;
	}

	/**
	 * Changes the StockRecord's volume to the given value
	 * 
	 * @param volume - the new volume
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}

	/**
	 * Returns a String containing all of the instance variables of the StockRecord.
	 * 
	 * I decided to shorten the length of the line by following the phraseology used
	 * in the input files.
	 * 
	 * @return a String that represents the StockRecord object
	 */
	@Override
	public String toString() {
		return "Date: " + this.date.toString() + ", Open: " + this.openingPrice + ", High: " + this.highPrice
				+ ", Low: " + this.lowPrice + ", Close: " + this.closingPrice + ", Adj Close: "
				+ this.adjustedClosingPrice + ", Volume: " + this.volume;
	}
}
