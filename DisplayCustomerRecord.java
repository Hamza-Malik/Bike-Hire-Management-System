package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.AnchorPane;

public class DisplayCustomerRecord implements Initializable{
	public ArrayList<Customer> customer_list = new ArrayList<Customer>();
	 Customer customer;
	 
		public ArrayList<HiredBike> hired_bike_list = new ArrayList<HiredBike>();
		
		public List<String> firstList= new ArrayList();
		public List<String> secondList= new ArrayList();


		HiredBike hired_bike;
	
	  @FXML
	    private AnchorPane yellow_pane;
	  
	  @FXML
	    private JFXButton showpaymentButton;

	    @FXML
	    private JFXTabPane main_tab;

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
	    private JFXTextField textfield_email;

	    @FXML
	    private JFXTextField search_textfield;

	    @FXML
	    private Tab payment_tab;
	    
	    @FXML
	    private Tab search_customer_tab;

	    @FXML
	    private TableView<PaymentTable> customer_table;

	    @FXML
	    private TableColumn<PaymentTable,String> depositColumn;
//
//	    @FXML
//	    private TableColumn<PaymentTable, String> customernameColumn;

	    @FXML
	    private TableColumn<PaymentTable,String> hireidColumn;

	    @FXML
	    private TableColumn<PaymentTable, String> paymentColumn;
	    
	    boolean recordFound=false;

		public  ObservableList<PaymentTable> paymentList=FXCollections.observableArrayList();

	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		payment_tab.setDisable(true);
		showpaymentButton.setVisible(false);

		CustomerList customerlist= new CustomerList();
		customer_list=customerlist.setCustomerList(customer_list,customer);	
		HireBikeList hireList= new HireBikeList();
		hired_bike_list=hireList.setHireBikeList(hired_bike_list,hired_bike);
		 hireIDS();
		 removeDuplicates();
		 setList();
	   // customerdetails_tab.setDisable(false);

	}
	
	
	public void setList() {
		

		
		 for (int i = 0; i < secondList.size( ); i++)
		  	{
			   
			 for (int j = 0; j < hired_bike_list.size( ); j++)
			  	{
				   
				 if(secondList.get(i).equals(Integer.toString(hired_bike_list.get(j).hireId))){

					 paymentList.add(new PaymentTable(Double.toString(hired_bike_list.get(j).deposit),hired_bike_list.get(j).first_name,Integer.toString(hired_bike_list.get(j).hireId),
							 Double.toString(hired_bike_list.get(j).total_charges)));

					 break;
					 
				 }
				   
			  	}		  	}

		 
	}
	
	public void populateTable() {
		hireidColumn.setCellValueFactory(new PropertyValueFactory<PaymentTable,String>("hireId"));
		paymentColumn.setCellValueFactory(new PropertyValueFactory<PaymentTable,String>("customerPayment"));
		depositColumn.setCellValueFactory(new PropertyValueFactory<PaymentTable,String>("customerDeposit"));
		customer_table.setItems(paymentList);
	}
	
	
	 
	   public void hireIDS() {
		   for (int i = 0; i < hired_bike_list.size( ); i++)
		  	{
			   
			   
			   firstList.add(Integer.toString(hired_bike_list.get(i).hireId));
		  	}	
		
	}
	   
	   public void removeDuplicates() {
		  
		   secondList=firstList.stream().distinct().collect(Collectors.toList());
		   for (int i = 0; i < secondList.size( ); i++)
		  	{
			   
			  System.out.println("This isss"+secondList.get(i));
		  	}
	}
	
	
	  @FXML
	   public void showpayments(ActionEvent event) {
			payment_tab.setDisable(false);

		  SingleSelectionModel<Tab> selected_Tab = main_tab.getSelectionModel();
		    main_tab.getTabs();
		    selected_Tab.select(1);	
			 populateTable();

		
	}
	  
	  @FXML
	   public void searchCustomer(ActionEvent event) {
			showpaymentButton.setVisible(false);

		  
		  if(search_textfield.getText().isEmpty()){
			  
			  Alert error_customer=new Alert(AlertType.ERROR);
			  error_customer.setContentText("Search field is Empty");
			  error_customer.showAndWait();
			  
		  }
		  
		  else{
		  
		  for (int i = 0; i < customer_list.size( ); i++)
		      	{ 
			  
			  if(Integer.parseInt(search_textfield.getText())==(customer_list.get(i).customer_id)){
				  
				  
				  textfield_firstname.setText(customer_list.get(i).first_name);
				  textfield_lastname.setText(customer_list.get(i).last_name);
				  textfield_id.setText(String.valueOf(customer_list.get(i).customer_id));
				  textfield_street.setText(customer_list.get(i).street);
				  textfield_postcode.setText(customer_list.get(i).postcode);
				  text_houseno.setText(customer_list.get(i).house_no);
				  textfield_email.setText(customer_list.get(i).email);
				  recordFound=true;
					showpaymentButton.setVisible(true);

			  }
			  
			  else{
				  
//				  Alert error_customer=new Alert(AlertType.ERROR);
//				  error_customer.setContentText("Customer Record Not Found");
//				  error_customer.showAndWait();
				  
			  }
			  
			  
		      	}
		  
		  if(recordFound){
			  recordFound=false;
		  }
		  
		  else
		  {
				payment_tab.setDisable(true);

			  textfield_firstname.setText("");
			  textfield_lastname.setText("");
			  textfield_id.setText("");
			  textfield_street.setText("");
			  textfield_postcode.setText("");
			  text_houseno.setText("");
			  textfield_email.setText("");
			  Alert error_customer=new Alert(AlertType.ERROR);
			  error_customer.setContentText("Customer Record Not Found");
			  error_customer.showAndWait();
			  recordFound=false;
		  }
		  }

	    }

}
