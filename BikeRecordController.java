package application;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BikeRecordController implements Initializable{
	public ArrayList<Bike> bike_list = new ArrayList<Bike>();

	Bike bike;
	
	@FXML
    private AnchorPane yellow_pane;

    @FXML
    private JFXTextField dayTextField;

    @FXML
    private JFXTextField hourTextField;

    @FXML
    private JFXComboBox<String> bikeTypeCombobox;

    @FXML
    private JFXComboBox<String> genderCombobox;

    @FXML
    private JFXComboBox<String> sizeCombobox;

    @FXML
    private JFXComboBox<String> colorCombobox;

    ObservableList<String> bikeTypelist=(ObservableList<String>)FXCollections.observableArrayList("Kids Bike","Sporty Mountain Bike","Standard Hybrid Bike","Tandem Bike","Adult Electric Bike");
	  ObservableList<String> genderList1=(ObservableList<String>) FXCollections.observableArrayList("Men","Women");
	  ObservableList<String> genderList2=(ObservableList<String>) FXCollections.observableArrayList("Boy","Girl");
	  ObservableList<String> genderList3=(ObservableList<String>) FXCollections.observableArrayList("Unisex");
	  
	  
	  ObservableList<String> size1=(ObservableList<String>) FXCollections.observableArrayList("Small","Medium","Large","XLarge");
	  ObservableList<String> size2=(ObservableList<String>) FXCollections.observableArrayList("Small","Medium","Large");
	  ObservableList<String> size3=(ObservableList<String>) FXCollections.observableArrayList("Small","Medium");
	  ObservableList<String> size4=(ObservableList<String>) FXCollections.observableArrayList("Medium");
	  
	  
	  ObservableList<String> color1=(ObservableList<String>) FXCollections.observableArrayList("Red","Blue");
	  ObservableList<String> color2=(ObservableList<String>) FXCollections.observableArrayList("Black","Blue");
	  ObservableList<String> color3=(ObservableList<String>) FXCollections.observableArrayList("Blue","Pink");
	  ObservableList<String> color4=(ObservableList<String>) FXCollections.observableArrayList("Blue");
	  ObservableList<String> color5=(ObservableList<String>) FXCollections.observableArrayList("Black");
	  
	  
	  @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			BikeList bikeList= new BikeList();
			bike_list=bikeList.setBikeList(bike_list,bike);
			bikeTypeCombobox.setItems(bikeTypelist);
		}
    
	  
	  @FXML
	   public void goHome(ActionEvent event) throws IOException {
		  ((Node)event.getSource()).getScene().getWindow().hide();

			
			Stage primaryStage=new Stage();
			FXMLLoader loader=new FXMLLoader();
			Pane root =FXMLLoader.load(getClass().getResource("SalesPersonMain.fxml")); 
			//Admin_Function ad_f=(Admin_Function)loader.getController();
			Scene scene2 = new Scene(root);
			primaryStage.setScene(scene2);
			primaryStage.show();
	    }
	  @FXML
    public void addBike(ActionEvent event) throws IOException {

			
			
			if(bikeTypeCombobox.getValue()==null || genderCombobox.getValue()==null || colorCombobox.getValue()==null || sizeCombobox.getValue()==null
					
				|| hourTextField.getText().isEmpty() || dayTextField.getText().isEmpty()){
				
				  Alert error_customer=new Alert(AlertType.ERROR);
				  error_customer.setContentText("All Fields are not Filled");
				  error_customer.showAndWait();
				
			}
			else{

														//Adding Customer To File when new customer is added
			bike_list.add(new Bike(bikeTypeCombobox.getValue(),genderCombobox.getValue(),sizeCombobox.getValue(),
					colorCombobox.getValue(),Double.parseDouble(hourTextField.getText()),Double.parseDouble(dayTextField.getText()),"Available"));
			
			BikeList bikeList= new BikeList();
			bikeList.addBikeToFile( bike_list, bike);
			
			Alert confirm=new Alert(AlertType.CONFIRMATION);
			confirm.setContentText("Bike has been added");
			confirm.showAndWait();
			
			  ((Node)event.getSource()).getScene().getWindow().hide();

				Stage primaryStage=new Stage();
				FXMLLoader loader=new FXMLLoader();
				Pane root =FXMLLoader.load(getClass().getResource("BikeRecord.fxml")); 
				Scene scene2 = new Scene(root);
				primaryStage.setScene(scene2);
				primaryStage.show();
		
		}
			  
			  

	    

    }
	  
	  @FXML
	    public void addBikeFleet(ActionEvent event) throws IOException {
		  ((Node)event.getSource()).getScene().getWindow().hide();

			Stage primaryStage=new Stage();
			FXMLLoader loader=new FXMLLoader();
			Pane root =FXMLLoader.load(getClass().getResource("BikeRecord.fxml")); 
			Scene scene2 = new Scene(root);
			primaryStage.setScene(scene2);
			primaryStage.show();
	    }

    
	
    
	
	
	@FXML
    public void bikeSelect(ActionEvent event) {

		 
				 if(bikeTypeCombobox.getValue().equals("Kids Bike")){
					 
					 genderCombobox.setItems(genderList2);
					 sizeCombobox.setItems(size2);
					 colorCombobox.setItems(color3);
					 dayTextField.setText("6.99");
					 hourTextField.setText("9.99");
				 }
				 
				 else if(bikeTypeCombobox.getValue().equals("Sporty Mountain Bike")){
					 
					 genderCombobox.setItems(genderList1);
					 sizeCombobox.setItems(size1);
					 colorCombobox.setItems(color2);
					 dayTextField.setText("14.99");
					 hourTextField.setText("22.99");

				 }
				 
				 else if(bikeTypeCombobox.getValue().equals("Standard Hybrid Bike")){
					 
					 genderCombobox.setItems(genderList1);
					 sizeCombobox.setItems(size1);
					 colorCombobox.setItems(color1);
					 dayTextField.setText("14.99");
					 hourTextField.setText("22.99");
				 }
				 
				 else if(bikeTypeCombobox.getValue().equals("Tandem Bike")){
					  
					 genderCombobox.setItems(genderList3);
					 sizeCombobox.setItems(size4);
					 colorCombobox.setItems(color5);
					 dayTextField.setText("29.99");
					 hourTextField.setText("39.99");
				 }
		        else if(bikeTypeCombobox.getValue().equals("Adult Electric Bike")){
					 
					 genderCombobox.setItems(genderList3);
					 sizeCombobox.setItems(size3);
					 colorCombobox.setItems(color4);
					 dayTextField.setText("19.99");
					 hourTextField.setText("29.99");
				 }
    }
	
	 @FXML
	   public void ReturnBike(ActionEvent event) throws IOException {
		 AnchorPane pane =FXMLLoader.load(getClass().getResource("ReturnBike.fxml"));
			yellow_pane.getChildren().setAll(pane);
	    }
	
	 @FXML
	   public void hire_bike(ActionEvent event) throws IOException {
		 AnchorPane pane =FXMLLoader.load(getClass().getResource("HireBike.fxml"));
			yellow_pane.getChildren().setAll(pane);
	    }
	 
	 @FXML
	   public void bikeSales(ActionEvent event) throws IOException {
		 AnchorPane pane =FXMLLoader.load(getClass().getResource("BikeSales.fxml"));
			yellow_pane.getChildren().setAll(pane);
	    }
	 
	 @FXML
	   public void bikeStock(ActionEvent event) throws IOException {
		 AnchorPane pane =FXMLLoader.load(getClass().getResource("BikeStock.fxml"));
		 yellow_pane.getChildren().setAll(pane);
	    }

}
