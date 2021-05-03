package edu.westga.cs6312.stock.model;

import java.util.ArrayList;

/**
 * Provides a model for keeping up with one or more historical records about a
 * particular stock.
 * 
 * @author sd00070
 * @version 2021-05-02
 */
public class StockManager {
	private ArrayList<StockRecord> dailyStockRecords;

	/**
	 * Creates a new empty StockManager, instantiating its list of StockRecords.
	 */
	public StockManager() {
		this.dailyStockRecords = new ArrayList<StockRecord>();
	}

	/**
	 * Adds a new StockRecord to the list of daily StockRecords.
	 * 
	 * @param newStockRecord - the new StockRecord
	 */
	public void addStockRecord(StockRecord newStockRecord) {
		if (newStockRecord == null) {
			throw new IllegalArgumentException("Invalid StockRecord: cannot be null");
		}

		this.dailyStockRecords.add(newStockRecord);
	}

	/**
	 * Returns a list containing the first, middle, and last StockRecord in the list
	 * of daily StockRecords.
	 * 
	 * @return summaryList
	 * @precondition dailyStockRecords has at least one record
	 * @throws IllegalStateException if dailyStockRecords is empty
	 */
	public ArrayList<StockRecord> getSummaryData() {
		if (this.dailyStockRecords.size() < 1) {
			throw new IllegalStateException("Cannot obtain summary data on empty list");
		}

		ArrayList<StockRecord> summaryList = new ArrayList<StockRecord>();
		summaryList.add(this.dailyStockRecords.get(0));
		summaryList.add(this.dailyStockRecords.get(this.dailyStockRecords.size() / 2));
		summaryList.add(this.dailyStockRecords.get(this.dailyStockRecords.size() - 1));
		return summaryList;
	}

	/**
	 * Calculates and returns the maximum, minimum, and average closing prices.
	 * 
	 * @return an array containing the maximum, minimum, and average closing prices
	 * @precondition dailyStockRecords has at least one record
	 * @throws IllegalStateException if dailyStockRecords is empty
	 */
	public double[] getStatisticalData() {
		if (this.dailyStockRecords.size() < 1) {
			throw new IllegalStateException("Cannot obtain statistical data on empty list");
		}

		double[] statisticalData = { this.getMaximumClosingPrice(), this.getMinimumClosingPrice(),
				this.getAverageClosingPrice() };
		return statisticalData;
	}

	/**
	 * Finds the highest closing price in the list of daily StockRecords.
	 * 
	 * @return maximumClosingPrice
	 */
	private double getMaximumClosingPrice() {
		double maximumClosingPrice = this.dailyStockRecords.get(0).getClosingPrice();
		for (StockRecord currentStockRecord : this.dailyStockRecords) {
			double currentClosingPrice = currentStockRecord.getClosingPrice();
			if (currentClosingPrice > maximumClosingPrice) {
				maximumClosingPrice = currentClosingPrice;
			}
		}
		return maximumClosingPrice;
	}

	/**
	 * Finds the lowest closing price in the list of daily StockRecords.
	 * 
	 * @return minimumClosingPrice
	 */
	private double getMinimumClosingPrice() {
		double minimumClosingPrice = this.dailyStockRecords.get(0).getClosingPrice();
		for (StockRecord currentStockRecord : this.dailyStockRecords) {
			double currentClosingPrice = currentStockRecord.getClosingPrice();
			if (currentClosingPrice < minimumClosingPrice) {
				minimumClosingPrice = currentClosingPrice;
			}
		}
		return minimumClosingPrice;
	}

	/**
	 * Finds the average closing price in the list of daily StockRecords.
	 * 
	 * @return averageClosingPrice
	 */
	private double getAverageClosingPrice() {
		double totalClosingPrice = 0.0;
		for (StockRecord currentStockRecord : this.dailyStockRecords) {
			totalClosingPrice += currentStockRecord.getClosingPrice();
		}

		return totalClosingPrice / this.dailyStockRecords.size();
	}

	/**
	 * Returns the whole list of StockRecords contained in the StockManager.
	 * 
	 * I was going to clone the ArrayList so that it cannot be modified by the
	 * caller, but clone is only a shallow copy. Changing any of the StockRecords in
	 * the list will mutate the original list as well...
	 * 
	 * @return the list all of the StockRecords
	 */
	public ArrayList<StockRecord> getAllStockRecords() {
		return this.dailyStockRecords;
	}
}
