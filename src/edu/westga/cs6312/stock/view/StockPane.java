package edu.westga.cs6312.stock.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import edu.westga.cs6312.stock.model.StockManager;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

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

		this.setPrefSize(640, 480);

		this.drawStockName();
		this.drawPriceTexts();
		this.drawPriceLines();
		this.drawDateTexts();
	}

	/**
	 * Draws the stock name above the middle date.
	 */
	private void drawStockName() {
		Text stockNameText = new Text(this.stockManagerModel.getStockName());
		stockNameText.xProperty().bind(this.widthProperty().divide(2).subtract(25));
		stockNameText.yProperty().bind(this.heightProperty().multiply(0).add(25));
		stockNameText.setStroke(Color.BLACK);

		this.getChildren().add(stockNameText);
	}

	/**
	 * Draws the three dates along the horizontal axis in the margin.
	 */
	private void drawDateTexts() {
		Text firstDateText = new Text(this.formatDate(this.stockManagerModel.getFirstStockRecord().getDate()));

		Text middleDateText = new Text(this.formatDate(this.stockManagerModel.getMiddleStockRecord().getDate()));

		Text lastDateText = new Text(this.formatDate(this.stockManagerModel.getLastStockRecord().getDate()));

		this.getChildren().addAll(firstDateText, middleDateText, lastDateText);
	}

	/**
	 * Draws the five prices along the vertical axis in the margin.
	 */
	private void drawPriceTexts() {
		double maximumPrice = this.stockManagerModel.getMaximumClosingPrice();
		double minimumPrice = this.stockManagerModel.getMinimumClosingPrice();

		Text highPriceText = new Text(this.formatPrice(maximumPrice));
		highPriceText.xProperty().set(25);
		highPriceText.yProperty().set(50);
		highPriceText.setStroke(Color.BLACK);

		Text highMidPriceText = new Text(this.formatPrice(this.spacePriceLine(maximumPrice, minimumPrice, 0.75)));
		highMidPriceText.xProperty().set(25);
		highMidPriceText.yProperty().bind(this.heightProperty().multiply(0.25).add(25));
		highMidPriceText.setStroke(Color.BLACK);

		Text middlePriceText = new Text(this.formatPrice(this.spacePriceLine(maximumPrice, minimumPrice, 0.5)));
		middlePriceText.xProperty().set(25);
		middlePriceText.yProperty().bind(this.heightProperty().multiply(0.5));
		middlePriceText.setStroke(Color.BLACK);

		Text lowMidPriceText = new Text(this.formatPrice(this.spacePriceLine(maximumPrice, minimumPrice, 0.25)));
		lowMidPriceText.xProperty().set(25);
		lowMidPriceText.yProperty().bind(this.heightProperty().multiply(0.75).subtract(25));
		lowMidPriceText.setStroke(Color.BLACK);

		Text lowPriceText = new Text(this.formatPrice(minimumPrice));
		lowPriceText.xProperty().set(25);
		lowPriceText.yProperty().bind(this.heightProperty().subtract(50));
		lowPriceText.setStroke(Color.BLACK);

		this.getChildren().addAll(highPriceText, highMidPriceText, middlePriceText, lowMidPriceText, lowPriceText);
	}

	/**
	 * Draws each of the lines corresponding to the displayed prices.
	 */
	private void drawPriceLines() {
		Line highPriceLine = new Line();

		Line highMidPriceLine = new Line();

		Line middlePriceLine = new Line();

		Line lowMidPriceLine = new Line();

		Line lowPriceLine = new Line();

		this.getChildren().addAll(highPriceLine, highMidPriceLine, middlePriceLine, lowMidPriceLine, lowPriceLine);
	}

	/**
	 * Helper method used to calculate equidistant prices for display
	 * 
	 * @param max   - highest price
	 * @param min   - lowest price
	 * @param ratio - the percentage (from 0.0 to 1.0) between of new value
	 * @return the new value at the ratio between the min and max
	 */
	private double spacePriceLine(double max, double min, double ratio) {
		return (max - min) * ratio + min;
	}

	/**
	 * Formats the prices to make them uniform.
	 * 
	 * @param priceToFormat - the price to format
	 * @return the formatted price
	 */
	private String formatPrice(double priceToFormat) {
		return String.format("%.2f", priceToFormat);
	}

	/**
	 * Formats the given Date object to the format outlined in the specification.
	 * 
	 * @param dateToConvert - the date to format
	 * @return
	 */
	private String formatDate(LocalDate dateToFormat) {
		return dateToFormat.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	}
}
