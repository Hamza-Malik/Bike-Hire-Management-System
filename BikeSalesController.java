package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class BikeSalesController implements Initializable{
	
	public ArrayList<HiredBike> hired_bike_list = new ArrayList<HiredBike>();
	HiredBike hired_bike;
	
	String[] bikeList = {"Kids Bike", "Sporty Mountain Bike", "Standard Hybrid Bike","Tandem Bike","Adult Electric Bike"};
	int kids=0,sporty=0,hybrid=0,tandem=0,adult=0;
	
	@FXML
    private PieChart bikePieChart;
	
	ObservableList<javafx.scene.chart.PieChart.Data> getlist;
	 PieChart.Data slice[];
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		HireBikeList hireList= new HireBikeList();
		hired_bike_list=hireList.setHireBikeList(hired_bike_list,hired_bike);
		findSales();
		setChart();
		
		
	} 
	
	
	public void findSales() {
		for (int i = 0; i < hired_bike_list.size( ); i++)
	  	{ 
			 
	if(hired_bike_list.get(i).bike_type.equals("Kids Bike")){
		
		kids++;
	}
	
	else if(hired_bike_list.get(i).bike_type.equals("Sporty Mountain Bike")){
		
		sporty++;
	}
	
    else if(hired_bike_list.get(i).bike_type.equals("Standard Hybrid Bike")){
		
    	hybrid++;
	}
	
    else if(hired_bike_list.get(i).bike_type.equals("Tandem Bike")){
		
    	tandem++;
	}
	
    else if(hired_bike_list.get(i).bike_type.equals("Adult Electric Bike")){
		
    	adult++;
	}
	  	

	}

	}
	
	
	public void setChart() {
		getlist=FXCollections.observableArrayList(
				new PieChart.Data("Kids Bike", kids),
				new PieChart.Data("Sporty Mountain Bike", sporty),
				new PieChart.Data("Standard Hybrid Bike", hybrid),
				new PieChart.Data("Tandem Bike", tandem),
				new PieChart.Data("Adult Electric Bike",adult )
				);
				bikePieChart.setData(getlist);

	}

}
