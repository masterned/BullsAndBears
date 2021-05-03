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

		boolean validInput = false;
		while (!validInput) {
			System.out.print(message);
			String userInput = this.keyboardScanner.nextLine();
			try {
				userInt = Integer.parseInt(userInput);
				validInput = true;
			} catch (NumberFormatException cannotParseInput) {
				System.out.println("Invalid input. Please enter valid integer value.");
			}
		}

		return userInt;
	}

	/**
	 * Responsible for directing the user interface. Runs the prompt-read-call-print
	 * loop.
	 */
	public void run() {
		System.out.println("Welcome to the Stock Manager Console Application");

		int userSelection = -1;

		do {
			this.displayMenu();
			userSelection = this.getUserInt("Please make a selection: ");

			switch (userSelection) {
				case 1:
					this.printSummaryData();
					break;
				case 2:
					this.printStatisticalData();
					break;
				case 3:
					this.printAllRecords();
					break;
				case 4:
					System.out.println("Thank you for using the Stock Manager Console Application");
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("That is not a valid menu option. Please select a value in the menu.");
					break;
			}
			
			System.out.println();
		} while (userSelection != 4);
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
