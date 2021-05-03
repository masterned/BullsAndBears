package edu.westga.cs6312.stock.view;

import java.util.Scanner;

import edu.westga.cs6312.stock.model.StockManager;

/**
 * Provides a view to communicate with the user via text in the console.
 * 
 * @author Spencer Dent
 * @version 2021-05-02
 */
public class StockTUI {
	private StockManager stockManagerModel;
	private Scanner keyboardScanner;

	/**
	 * Creates a new Textual User Interface using the provided StockManager.
	 * 
	 * @param newStockManager - the StockManager to use as the primary model
	 */
	public StockTUI(StockManager newStockManager) {
		this.stockManagerModel = newStockManager;
	}

	/**
	 * Prints a numbered list of available options to the console.
	 */
	private void displayMenu() {
		System.out.println("1 - View summary data");
		System.out.println("2 - View statistical data");
		System.out.println("3 - View all records");
		System.out.println("4 - Quit");
	}

	/**
	 * Prints the message to the console requesting user input, reads the user's
	 * input as a String, and attempts to convert the input into an integer. Repeats
	 * procedure until successful.
	 * 
	 * @param message - the request for input displayed to the user
	 * @return the user's input converted into an integer (once successful)
	 */
	private int getUserInt(String message) {
		int userInt = -1;

		return userInt;
	}

	/**
	 * Responsible for directing the user interface. Runs the prompt-read-call-print
	 * loop.
	 */
	public void run() {

	}

	/**
	 * Prints the first, middle, and last record values in the StockManager.
	 */
	private void printSummaryData() {

	}

	/**
	 * Prints the maximum, minimum, and average closing prices of the StockManager.
	 */
	private void printStatisticalData() {

	}

	/**
	 * Prints all of the StockRecords in the StockManager.
	 */
	private void printAllRecords() {

	}
}
