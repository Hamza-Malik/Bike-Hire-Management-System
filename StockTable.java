package application;

import javafx.beans.property.SimpleStringProperty;

public class StockTable {
	private  SimpleStringProperty stockItem;
	private  SimpleStringProperty stockQuantity;
	
	
	public StockTable(String stockItem, String stockQuantity) {
		this.stockItem = new SimpleStringProperty(stockItem);
		this.stockQuantity = new SimpleStringProperty(stockQuantity);
		
	}
	
	public String getStockItem() {
		return stockItem.get();
	}


	public void setStockItem(SimpleStringProperty stockItem) {
		this.stockItem = stockItem;
	}


	public String getStockQuantity() {
		return stockQuantity.get();
	}


	public void setStockQuantity(SimpleStringProperty stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
