package edu.westga.cs6312.stock.controller;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.view.StockPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Acts as the main controller for the GUI portion of the application. Creates
 * the needed components to start a JavaFX application, and launches the GUI.
 * 
 * @author Spencer Dent
 * @version 2021-05-03
 */
public class StockGUI extends Application {

	private static StockManager stockManagerModel;

	/**
	 * This method is called at the beginning of the JavaFX application. It sets up
	 * the main Scene and Pane and paints them.
	 */
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("CS6312 - Stock Manager");

		StockPane primaryPane = new StockPane(StockGUI.stockManagerModel);

		Scene rootScene = new Scene(primaryPane);

		primaryStage.setScene(rootScene);

		primaryStage.show();
	}
	
	/**
	 * This method is the entry point of the JavaFX application
	 *
	 * @param args Command-line arguments, not used
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Sets the static StockManager model to the provided StockManager.
	 * 
	 * @param newStockManager - the new StockManager to use as the model
	 */
	public static void setManager(StockManager newStockManager) {
		StockGUI.stockManagerModel = newStockManager;
	}
}
