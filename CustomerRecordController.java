package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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


public class CustomerRecordController implements Initializable{
	
	public ArrayList<Customer> customer_list = new ArrayList<Customer>();
	Customer customer;
	int automatic_customerid;
	
	   @FXML
	    private JFXTextField textfield_firstname;

	    @FXML
	    private JFXTextField textfield_id;

	    @FXML
	    private JFXTextField textfield_postcode;

	    @FXML
	    private JFXTextField textfield_street;

	    @FXML
	    private JFXTextField textfield_lastname;

	    @FXML
	    private JFXTextField text_houseno;

	    @FXML
	    private JFXComboBox<String> comboboxcity;
	    
	    @FXML
	    private JFXTextField textfield_email;
	    
	    @FXML
	    private AnchorPane yellow_pane;
	    
		  ObservableList<String> city_list=(ObservableList<String>) FXCollections.observableArrayList("London","Northampton","Coventry","Milton Keyens","Sheffield");


	  

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		comboboxcity.setItems(city_list);
		CustomerList customerList= new CustomerList();


		automatic_customerid= customerList.assignId();
		textfield_id.setText(Integer.toString(automatic_customerid));
		customer_list=customerList.setCustomerList(customer_list,customer);
		

		
		

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
	   public void display_customer_record(ActionEvent event) throws IOException {
		 AnchorPane pane =FXMLLoader.load(getClass().getResource("DisplayCustomerRecord.fxml"));
			yellow_pane.getChildren().setAll(pane);
	    }
	 
	 @FXML
	    public void customerAdd(ActionEvent event) throws IOException {
		 
		 ((Node)event.getSource()).getScene().getWindow().hide();

			Stage primaryStage=new Stage();
			FXMLLoader loader=new FXMLLoader();
			Pane root =FXMLLoader.load(getClass().getResource("CustomerRecord.fxml")); 
			Scene scene2 = new Scene(root);
			primaryStage.setScene(scene2);
			primaryStage.show();

	    }
	
	@FXML
    public void add_customer(ActionEvent event) throws IOException {
		
		
		if(comboboxcity.getValue()==null || textfield_firstname.getText().isEmpty() || textfield_lastname.getText().isEmpty() || textfield_id.getText().isEmpty()
				
			|| textfield_street.getText().isEmpty() || text_houseno.getText().isEmpty() || textfield_postcode.getText().isEmpty() || textfield_email.getText().isEmpty()){
			
			  Alert error_customer=new Alert(AlertType.ERROR);
			  error_customer.setContentText("All Fields are not Filled");
			  error_customer.showAndWait();
			
		}
		else{
			
		if( textfield_firstname.getText().matches(".*\\d+.*") || textfield_lastname.getText().matches(".*\\d+.*")){
					  Alert error_customer=new Alert(AlertType.ERROR);
					  error_customer.setContentText("Names cannot have numbers");
					  error_customer.showAndWait();
					
				}
			
			else{
			if(textfield_email.getText().contains("@")  && textfield_email.getText().contains(".com")){
		
				
				customer_list.add(new Customer(textfield_firstname.getText(),textfield_lastname.getText(),Integer.parseInt(textfield_id.getText()),
						textfield_street.getText(),comboboxcity.getValue(),text_houseno.getText(),textfield_postcode.getText(),textfield_email.getText()));

				CustomerList customerList= new CustomerList();
				customerList.addCustomerToFile( customer_list, customer);
				
				
				Alert confirm=new Alert(AlertType.CONFIRMATION);
				confirm.setContentText("Customer has been added");
				confirm.showAndWait();
				
				automatic_customerid= customerList.assignId();
		    	textfield_id.setText(Integer.toString(automatic_customerid));

				
				textfield_firstname.setText("");
				textfield_lastname.setText("");
				textfield_street.setText("");
				text_houseno.setText("");
				textfield_postcode.setText("");
				textfield_email.setText("");
				
			}
			
			else{
				  Alert error_customer=new Alert(AlertType.ERROR);
				  error_customer.setContentText("Wrong Email");
				  error_customer.showAndWait();
				
			}
			}
			
	}
		  
		  

    }
	

	
	

}
