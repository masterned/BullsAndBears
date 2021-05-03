package edu.westga.cs6312.stock.view;

import edu.westga.cs6312.stock.model.StockManager;
import javafx.scene.layout.Pane;

/**
 * Provides a view to display StockManager data to a JavaFX GUI.
 * 
 * @author Spencer Dent
 * @version 2021-05-03
 */
public class StockPane extends Pane {
	private StockManager stockManagerModel;

	/**
	 * Creates a new StockPane with the provided StockManager.
	 * 
	 * @param newStockManager - the StockManager model used to create the StockPane
	 * @precondition newStockManager is not null
	 * @throws IllegalArgumentException if newStockManager is null
	 */
	public StockPane(StockManager newStockManager) {
		if (newStockManager == null) {
			throw new IllegalArgumentException("Invalid StockManager: cannot be null");
		}
		this.stockManagerModel = newStockManager;
	}
}
