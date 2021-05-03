package edu.westga.cs6312.stock.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import edu.westga.cs6312.stock.model.StockManager;
import edu.westga.cs6312.stock.model.StockRecord;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

		this.drawDateTexts();
		this.drawDateLines();

		this.drawPriceTexts();
		this.drawPriceLines();

		this.drawAllClosingPriceMarkers();

		this.drawAverageStockPriceLine();
	}

	/**
	 * Draws the stock name above the middle date.
	 */
	private void drawStockName() {
		Text stockNameText = new Text(this.stockManagerModel.getStockName());
		stockNameText.xProperty().bind(this.widthProperty().multiply(0.5).subtract(25));
		stockNameText.yProperty().bind(this.heightProperty().multiply(0).add(25));
		stockNameText.setStroke(Color.BLACK);

		this.getChildren().add(stockNameText);
	}

	/**
	 * Draws the three dates along the horizontal axis in the margin.
	 */
	private void drawDateTexts() {
		Text firstDateText = new Text(this.formatDate(this.stockManagerModel.getFirstStockRecord().getDate()));
		firstDateText.xProperty().set(25);
		firstDateText.yProperty().bind(this.heightProperty().subtract(25));
		firstDateText.setStroke(Color.BLACK);

		Text middleDateText = new Text(this.formatDate(this.stockManagerModel.getMiddleStockRecord().getDate()));
		middleDateText.xProperty().bind(this.widthProperty().multiply(0.5).subtract(25));
		middleDateText.yProperty().bind(this.heightProperty().subtract(25));
		middleDateText.setStroke(Color.BLACK);

		Text lastDateText = new Text(this.formatDate(this.stockManagerModel.getLastStockRecord().getDate()));
		lastDateText.xProperty().bind(this.widthProperty().subtract(100));
		lastDateText.yProperty().bind(this.heightProperty().subtract(25));
		lastDateText.setStroke(Color.BLACK);

		this.getChildren().addAll(firstDateText, middleDateText, lastDateText);
	}

	/**
	 * Draws the lines corresponding to each of the three dates.
	 */
	private void drawDateLines() {
		Line firstDateLine = new Line();
		firstDateLine.startXProperty().set(50);
		firstDateLine.endXProperty().set(50);
		firstDateLine.startYProperty().set(50);
		firstDateLine.endYProperty().bind(this.heightProperty().subtract(50));
		firstDateLine.setStroke(Color.BLACK);

		Line middleDateLine = new Line();
		middleDateLine.startXProperty().bind(this.widthProperty().multiply(0.5));
		middleDateLine.endXProperty().bind(this.widthProperty().multiply(0.5));
		middleDateLine.startYProperty().set(50);
		middleDateLine.endYProperty().bind(this.heightProperty().subtract(50));
		middleDateLine.setStroke(Color.BLACK);

		Line lastDateLine = new Line();
		lastDateLine.startXProperty().bind(this.widthProperty().subtract(50));
		lastDateLine.endXProperty().bind(this.widthProperty().subtract(50));
		lastDateLine.startYProperty().set(50);
		lastDateLine.endYProperty().bind(this.heightProperty().subtract(50));
		lastDateLine.setStroke(Color.BLACK);

		this.getChildren().addAll(firstDateLine, middleDateLine, lastDateLine);
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

		Text highMidPriceText = new Text(this.formatPrice(this.spacePriceLine(0.75)));
		highMidPriceText.xProperty().set(25);
		highMidPriceText.yProperty().bind(this.heightProperty().multiply(0.25).add(25));
		highMidPriceText.setStroke(Color.BLACK);

		Text middlePriceText = new Text(this.formatPrice(this.spacePriceLine(0.5)));
		middlePriceText.xProperty().set(25);
		middlePriceText.yProperty().bind(this.heightProperty().multiply(0.5));
		middlePriceText.setStroke(Color.BLACK);

		Text lowMidPriceText = new Text(this.formatPrice(this.spacePriceLine(0.25)));
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
		highPriceLine.startXProperty().set(50);
		highPriceLine.endXProperty().bind(this.widthProperty().subtract(50));
		highPriceLine.startYProperty().set(50);
		highPriceLine.endYProperty().set(50);
		highPriceLine.setStroke(Color.BLACK);

		Line highMidPriceLine = new Line();
		highMidPriceLine.startXProperty().set(50);
		highMidPriceLine.endXProperty().bind(this.widthProperty().subtract(50));
		highMidPriceLine.startYProperty().bind(this.heightProperty().multiply(0.25).add(25));
		highMidPriceLine.endYProperty().bind(this.heightProperty().multiply(0.25).add(25));
		highMidPriceLine.setStroke(Color.BLACK);

		Line middlePriceLine = new Line();
		middlePriceLine.startXProperty().set(50);
		middlePriceLine.endXProperty().bind(this.widthProperty().subtract(50));
		middlePriceLine.startYProperty().bind(this.heightProperty().multiply(0.5));
		middlePriceLine.endYProperty().bind(this.heightProperty().multiply(0.5));
		middlePriceLine.setStroke(Color.BLACK);

		Line lowMidPriceLine = new Line();
		lowMidPriceLine.startXProperty().set(50);
		lowMidPriceLine.endXProperty().bind(this.widthProperty().subtract(50));
		lowMidPriceLine.startYProperty().bind(this.heightProperty().multiply(0.75).subtract(25));
		lowMidPriceLine.endYProperty().bind(this.heightProperty().multiply(0.75).subtract(25));
		lowMidPriceLine.setStroke(Color.BLACK);

		Line lowPriceLine = new Line();
		lowPriceLine.startXProperty().set(50);
		lowPriceLine.endXProperty().bind(this.widthProperty().subtract(50));
		lowPriceLine.startYProperty().bind(this.heightProperty().subtract(50));
		lowPriceLine.endYProperty().bind(this.heightProperty().subtract(50));
		lowPriceLine.setStroke(Color.BLACK);

		this.getChildren().addAll(highPriceLine, highMidPriceLine, middlePriceLine, lowMidPriceLine, lowPriceLine);
	}

	/**
	 * Draws red circles representing each of the closing prices of the StockRecords
	 * in the StockManager.
	 */
	private void drawAllClosingPriceMarkers() {
		for (StockRecord currentStockRecord : this.stockManagerModel.getAllStockRecords()) {
			Circle currentStockRecordMarker = new Circle();
			currentStockRecordMarker.setRadius(7);
			currentStockRecordMarker.setStroke(Color.RED);
			currentStockRecordMarker.setFill(Color.RED);

			currentStockRecordMarker.centerXProperty().bind(this.widthProperty().divide(2));

			double priceRatio = this.getPriceRatio(currentStockRecord.getClosingPrice());
			System.out.println(priceRatio);

			currentStockRecordMarker.centerYProperty().bind(this.heightProperty().multiply(priceRatio));

			this.getChildren().add(currentStockRecordMarker);
		}
	}

	/**
	 * Draws the average closing price line across the chart in blue.
	 */
	private void drawAverageStockPriceLine() {
		double averagePrice = this.stockManagerModel.getAverageClosingPrice();
		Line averageStockPriceLine = new Line();
		averageStockPriceLine.startXProperty().set(50);
		averageStockPriceLine.endXProperty().bind(this.widthProperty().subtract(50));
		averageStockPriceLine.startYProperty().bind(this.heightProperty().multiply(this.getPriceRatio(averagePrice)));
		averageStockPriceLine.endYProperty().bind(this.heightProperty().multiply(this.getPriceRatio(averagePrice)));
		averageStockPriceLine.setStroke(Color.BLUE);

		this.getChildren().add(averageStockPriceLine);
	}

	/**
	 * Helper method used to calculate equidistant prices for display
	 * 
	 * @param ratio - the percentage (from 0.0 to 1.0) between of new value
	 * @return the new value at the ratio between the min and max
	 */
	private double spacePriceLine(double ratio) {
		return (this.stockManagerModel.getMaximumClosingPrice() - this.stockManagerModel.getMinimumClosingPrice())
				* ratio + this.stockManagerModel.getMinimumClosingPrice();
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

	/**
	 * Calculates the ratio of the current closing price to place properly on the
	 * display.
	 * 
	 * @param currentPrice - the price of the current StockRecord
	 * @return the ratio of the current price between the high and low prices
	 */
	private double getPriceRatio(double currentPrice) {
		return (currentPrice - this.stockManagerModel.getMinimumClosingPrice())
				/ (this.stockManagerModel.getMaximumClosingPrice() - this.stockManagerModel.getMinimumClosingPrice());
	}
}
