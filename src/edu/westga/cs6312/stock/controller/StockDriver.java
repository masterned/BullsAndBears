package edu.westga.cs6312.stock.controller;

/**
 * Acts as the starting point for the application. Contains the main class and
 * calls VersionChooser's chooseVersion method.
 * 
 * @author Spencer Dent
 * @version 2021-05-02
 */
public class StockDriver {

	/**
	 * This method is the entry point of the application
	 *
	 * @param args Command-line arguments, not used
	 */
	public static void main(String[] args) {
		VersionChooser versionChooserController = new VersionChooser();
		versionChooserController.chooseVersion();
	}
}
