package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class BikeStockController implements Initializable{
	
	public ArrayList<Bike> bikelist = new ArrayList<Bike>();

	Bike bike;
	
	int kids=0,sporty=0,hybrid=0,tandem=0,adult=0;
	
	   @FXML
	    private AnchorPane yellow_pane;
	   
	    @FXML
	    private TableView<StockTable> stockTable;

	    @FXML
	    private TableColumn<StockTable, String> bikeTypeColumn;

	    @FXML
	    private TableColumn<StockTable, String> quantityColumn;
	    
	    @FXML
		public  ObservableList<StockTable> stockList=FXCollections.observableArrayList();

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			BikeList bikeList= new BikeList();
			bikelist=bikeList.setBikeList(bikelist,bike);
			setQuanity();
			setList();
			populateTable();
			
		}
		
		
		public void populateTable() {
			bikeTypeColumn.setCellValueFactory(new PropertyValueFactory<StockTable,String>("stockItem"));
			quantityColumn.setCellValueFactory(new PropertyValueFactory<StockTable,String>("stockQuantity"));
			stockTable.setItems(stockList);
		}
		
		public void setQuanity() {

			for (int i = 0; i < bikelist.size( ); i++)
		  	{ 
				 
		if(bikelist.get(i).bike_type.equals("Kids Bike")){
			
			kids++;
		}
		
		else if(bikelist.get(i).bike_type.equals("Sporty Mountain Bike")){
			
			sporty++;
		}
		
	    else if(bikelist.get(i).bike_type.equals("Standard Hybrid Bike")){
			
	    	hybrid++;
		}
		
	    else if(bikelist.get(i).bike_type.equals("Tandem Bike")){
			
	    	tandem++;
		}
		
	    else if(bikelist.get(i).bike_type.equals("Adult Electric Bike")){
			
	    	adult++;
		}
		  	

		}

		
			
		}
		
		public void setList() {
			
			stockList.add(new StockTable("Kids Bike",Integer.toString(kids)));
			stockList.add(new StockTable("Sporty Mountain Bike",Integer.toString(sporty)));
			stockList.add(new StockTable("Standard Hybrid Bike",Integer.toString(hybrid)));
			stockList.add(new StockTable("Tandem Bike",Integer.toString(tandem)));
			stockList.add(new StockTable("Adult Electric Bike",Integer.toString(adult)));	
		}

}
