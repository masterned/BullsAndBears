package edu.westga.cs6312.stock.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.model.StockRecord;

/**
 * Provides functionality to read data from an external file and populate a
 * StockManager.
 * 
 * @author Spencer Dent
 * @version 2021-05-03
 */
public class FileInteractor {

	/**
	 * Opens the specified file, reads the data in the file, creates a StockManager,
	 * and fills the StockManager with the data from the file.
	 * 
	 * I really wish I had access to map and pipe functions. I think that they would
	 * vastly clean up this code.
	 * 
	 * @param fileName - the name of the file to read the data from
	 * @return a new StockManager filled with the data from the data file
	 * @throws FileNotFoundException if the file cannot at the given path cannot be
	 *                               found
	 */
	public static StockManager readData(String fileName) throws FileNotFoundException {
		StockManager generatedStockManager = new StockManager(fileName);

		File dataFile = new File(fileName);
		Scanner dataFileReader = new Scanner(dataFile);

		if (dataFileReader.hasNextLine()) {
			dataFileReader.nextLine();
		}

		while (dataFileReader.hasNextLine()) {
			String rawStockDataLine = dataFileReader.nextLine();
			String[] stockDataLineParts = rawStockDataLine.split(",");
			try {
				StockRecord newStockRecord = new StockRecord(LocalDate.parse(stockDataLineParts[0].trim()),
						Double.parseDouble(stockDataLineParts[1].trim()),
						Double.parseDouble(stockDataLineParts[2].trim()),
						Double.parseDouble(stockDataLineParts[3].trim()),
						Double.parseDouble(stockDataLineParts[4].trim()),
						Double.parseDouble(stockDataLineParts[5].trim()),
						Integer.parseInt(stockDataLineParts[6].trim()));
				generatedStockManager.addStockRecord(newStockRecord);
			} catch (Exception catchallException) {
			}
		}
		
		dataFileReader.close();

		return generatedStockManager;
	}
}
