package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;
public class SalesPersonMainController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	@FXML
    public void open_customer_ecord(ActionEvent event) throws IOException {
	  ((Node)event.getSource()).getScene().getWindow().hide();

		
		Stage primaryStage=new Stage();
		FXMLLoader loader=new FXMLLoader();
		Pane root =FXMLLoader.load(getClass().getResource("CustomerRecord.fxml")); 
		//Admin_Function ad_f=(Admin_Function)loader.getController();
		Scene scene2 = new Scene(root);
		primaryStage.setScene(scene2);
		primaryStage.show();
		//  ((Node)event.getSource()).getScene().getWindow().hide();
		  
		  
		  

    }

	@FXML
    public void logoutListener(ActionEvent event) throws IOException {
	  ((Node)event.getSource()).getScene().getWindow().hide();

		
		Stage primaryStage=new Stage();
		FXMLLoader loader=new FXMLLoader();
		Pane root =FXMLLoader.load(getClass().getResource("LoginPage.fxml")); 
		//Admin_Function ad_f=(Admin_Function)loader.getController();
		Scene scene2 = new Scene(root);
		primaryStage.setScene(scene2);
		primaryStage.show();
		//  ((Node)event.getSource()).getScene().getWindow().hide();
		  
		  
		  

    }
	@FXML
    public void open_bike_record(ActionEvent event) throws IOException {
	  ((Node)event.getSource()).getScene().getWindow().hide();

		
		Stage primaryStage=new Stage();
		FXMLLoader loader=new FXMLLoader();
		Pane root =FXMLLoader.load(getClass().getResource("BikeRecord.fxml")); 
		//Admin_Function ad_f=(Admin_Function)loader.getController();
		Scene scene2 = new Scene(root);
		primaryStage.setScene(scene2);
		primaryStage.show();
		//  ((Node)event.getSource()).getScene().getWindow().hide();
		  
		  
		  

    }
}