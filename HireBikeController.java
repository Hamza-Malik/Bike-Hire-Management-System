package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.itextpdf.text.Paragraph;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class HireBikeController implements Initializable{
	PdfWriteExample writePdf =new PdfWriteExample();
	Email sendmail=new Email();
	Paragraph p1 =new Paragraph();
	Paragraph p2 =new Paragraph();
	Paragraph p3 =new Paragraph();
	Paragraph p4 =new Paragraph();
	Paragraph p5 =new Paragraph();
	Paragraph p6 =new Paragraph();

	
	String pdfstring="";
	String email[]=new String[1];
	
	public ArrayList<Customer> customer_list = new ArrayList<Customer>();
	public ArrayList<Bike> bike_list = new ArrayList<Bike>();
	public ArrayList<HiredBike> hired_bike_list = new ArrayList<HiredBike>();
	
	int discountKids=0;
	int discountAdult=0;
	Customer customer;
	Bike bike;
	HiredBike hired_bike;

	@FXML
    private AnchorPane yellow_pane;
	
	@FXML
	JFXButton checkoutButton,addCartButton;
	
	
	
	@FXML
    private JFXTextField textfield_firstname;

    @FXML
    private JFXTextField textfield_id;

    @FXML
    private JFXTextField textfield_lastname;
    
    @FXML
    private JFXTextField search_textfield;
    
    @FXML
    private JFXComboBox<String> bikeTypeCombobox;

    @FXML
    private JFXComboBox<String> genderCombobox;

    @FXML
    private JFXComboBox<String> sizeCombobox;

    @FXML
    private JFXComboBox<String> colorCombobox;

    @FXML
    private JFXComboBox<String> timeframeCombobox;

    @FXML
    private JFXRadioButton hourRadioButton;

    @FXML
    private JFXRadioButton dayRadioButton;

    @FXML
    private Pane chooseBikePane,customerSelectionPane;
    
    @FXML
    private JFXListView<String> customerSelectionListView;
    
    @FXML
    private Text totalchargesText,chooseBikeText,customerSelectionText,hirePeriodText,depositText,hireIdText,discountText;

    
    private boolean status=false;
    
    double total=0,charges=0,deposit=0;
    
    ToggleGroup hireBikeRadioGroup; 
    
    DecimalFormat decFormat = new DecimalFormat("#0.00");
    
    int hirePeriod=1;
    String hireType;
    boolean recordFound=false;

    @FXML
	public  ObservableList<String> selectedItemsList=FXCollections.observableArrayList();
    
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

	  ObservableList<String> hourTimeframe=(ObservableList<String>) FXCollections.observableArrayList("2","4","6","8","10");



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		chooseBikeText.setVisible(false);
		timeframeCombobox.setVisible(false);
		customerSelectionText.setVisible(false);
		customerSelectionPane.setVisible(false);
		chooseBikePane.setVisible(false);
		
		
		
		CustomerList customerList= new CustomerList();
		BikeList bikeList= new BikeList();
		HireBikeList hireList= new HireBikeList();
		customer_list=customerList.setCustomerList(customer_list,customer);
		hired_bike_list=hireList.setHireBikeList(hired_bike_list,hired_bike);
		bike_list=bikeList.setBikeList(bike_list,bike);
		
		
		bikeTypeCombobox.setItems(bikeTypelist);
		 checkoutButton.setDisable(true);
		 hirePeriodText.setVisible(false);
		 hourRadioButton.setVisible(false);
		 dayRadioButton.setVisible(false);
		 addCartButton.setVisible(false);
		 hireIdText.setText(String.valueOf(hireList.assignHireId()));

	}
	
	
	@FXML
	   public void hourTimeSelect(){
		
		hirePeriod=Integer.parseInt(timeframeCombobox.getValue());
	}
	@FXML
	   public void timeSelect(){
		
		if(hourRadioButton.isSelected()){
			timeframeCombobox.setItems(hourTimeframe);
			timeframeCombobox.setVisible(true);
			hireType="Hours";
			

			
		}
		
		else if(dayRadioButton.isSelected()){
			
		//	timeframeCombobox.setItems(dayTimeframe);
			timeframeCombobox.setVisible(false);
			hirePeriod=1;
			hireType="Day";



		}
		
	}
	

	 @FXML
	   public void bikeCheckout(ActionEvent event) throws NumberFormatException, IOException {
		 
		 System.out.println("Works");
		 
			for( String selection:selectedItemsList){
				
				 String[] fields = selection.split(",");
				 
				 
				 for (int i = 0; i < bike_list.size( ); i++)
			      	{ // write one object
						if(fields[0].equals(bike_list.get(i).bike_type) && fields[1].equals(bike_list.get(i).gender) && 
								fields[2].equals(bike_list.get(i).size) &&  fields[3].equals(bike_list.get(i).colour) && 
								bike_list.get(i).status.equals("Available")){
							
							pdfstring=pdfstring+" "+bike_list.get(i).bike_type+" ";	 
							
							bike_list.get(i).setStatus("Not Available");	 
							hireBikeMethod(fields[0],fields[1],fields[2],fields[3],bike_list.get(i).hour_rate,bike_list.get(i).day_rate,Integer.parseInt(fields[4]),fields[5]);
							break;
			      	} 

			}
			}

			deposit=0;

			BikeList bikeList= new BikeList();
			bikeList.addBikeToFile( bike_list, bike);
			p1.add("Hire Id : "+hireIdText.getText().toString());
			p2.add("Hire Bike Types are : "+pdfstring.toString());
			p3.add("Deposit Paid : £"+depositText.getText().toString());
			p4.add("Total Charges : £"+totalchargesText.getText().toString());
			p5.add("Hired Date: "+LocalDateTime.now().toLocalDate().toString());
			p6.add("Hired Time: "+LocalDateTime.now().toLocalTime().toString());
//			
		    writePdf.writeUsingIText(p1,p2,p3,p4,p5,p6,"Invoice.pdf");
			sendmail.senddata(email,"Invoice from Northampton Hire!","Invoice.pdf");
			
			Alert confirm=new Alert(AlertType.CONFIRMATION);
			confirm.setContentText("Bike is Hired");
			confirm.showAndWait();
			 AnchorPane pane =FXMLLoader.load(getClass().getResource("HireBike.fxml"));
				yellow_pane.getChildren().setAll(pane);
				
	 }
	 
	  public void hireBikeMethod(String type,String gender, String size, String color,double hour_charges,double day_charges,int hire_period,String hire_type) throws IOException{
		  LocalDateTime dateHired=LocalDateTime.now();
		  System.out.println("Type is "+type);
		  System.out.println("Gender is "+gender);
		  System.out.println("Size is "+size);
		  System.out.println("Color is "+color);
		  System.out.println("Hourly Cahrges is "+hour_charges);
		  System.out.println("Day Cahrges is "+day_charges);
		  System.out.println("Hire Period is "+hire_period);
		  System.out.println("Hire Type is "+hire_type);
		  System.out.println("Date is "+dateHired);



		  hired_bike_list.add(new HiredBike(type,gender,size,
					color,hour_charges,day_charges,"Not Available",deposit,Double.parseDouble(totalchargesText.getText()),
					Integer.parseInt(textfield_id.getText()),   
					textfield_firstname.getText(),textfield_lastname.getText(),hire_period,hire_type,dateHired,Integer.parseInt(hireIdText.getText())));
		  
		  HireBikeList hirebikeList= new HireBikeList();
		  hirebikeList.addHireBikeToFile( hired_bike_list, hired_bike);
		 
		  //Add code to add it into file
	  }
	
	 @FXML
	   public void addtoCart(ActionEvent event) {
		 
		 
		 if(bikeTypeCombobox.getSelectionModel().isEmpty() || genderCombobox.getSelectionModel().isEmpty() || sizeCombobox.getSelectionModel().isEmpty() ||
				  colorCombobox.getSelectionModel().isEmpty() ){
			 
			 Alert error_customer=new Alert(AlertType.ERROR);
			  error_customer.setContentText("All Detials are not filled");
			  error_customer.showAndWait();
		 }
		 
		
		 else{
			 
			 if(bikeTypeCombobox.getValue().equals("Kids Bike")){
				 
				 discountKids++;
				 
			 }
			 
			 else{
				 
				 discountAdult++;
			 }
		
		checkoutButton.setDisable(false);
		 selectedItemsList.add(bikeTypeCombobox.getValue()+","+genderCombobox.getValue()+","+ sizeCombobox.getValue()+","+colorCombobox.getValue()+","+Integer.toString(hirePeriod)+","+hireType);
		 customerSelectionListView.setItems(selectedItemsList); 
		 
		 for (int i = 0; i < bike_list.size( ); i++)
	      	{
			 
			 if(bikeTypeCombobox.getValue().equals(bike_list.get(i).bike_type)){
				 
				 if(hourRadioButton.isSelected()){
					

					 charges=charges+ (bike_list.get(i).hour_rate * Integer.parseInt(timeframeCombobox.getValue()));
					 charges=charges/2;
					 
					 total=total+charges;
					}
					
					else if(dayRadioButton.isSelected()){

						charges=charges+bike_list.get(i).day_rate;
						 total=total+charges;

					}
				 
				 charges=0;
				 deposit=deposit+100;
				 break;
			 }
			 
	      	}
		 
		 if(discountKids>=2 && discountAdult>=2){
			 total= total * 0.75;
			 
			 discountText.setText("You have been given a family discount of 25%");
			 
		 }
		 
		 else{
			 
		 }
		 depositText.setText(Double.toString(deposit));

//		 genderCombobox.getItems().clear();
//			sizeCombobox.getItems().clear();
//			colorCombobox.getItems().clear();
		 
		 totalchargesText.setText(decFormat.format(total));
		 hirePeriodText.setVisible(false);
		 hourRadioButton.setVisible(false);
		 dayRadioButton.setVisible(false);
		 addCartButton.setVisible(false);
		 timeframeCombobox.setVisible(false);
		 
	 }
}
	 
	
	 @FXML
	   public void bikeSelect(){
	
			
		 System.out.println("Yes Selected");
		 
				 if(bikeTypeCombobox.getValue().equals("Kids Bike")){
					 
					 genderCombobox.setItems(genderList2);
					 sizeCombobox.setItems(size2);
					 colorCombobox.setItems(color3);

				 }
				 
				 else if(bikeTypeCombobox.getValue().equals("Sporty Mountain Bike")){
					 
					 genderCombobox.setItems(genderList1);
					 sizeCombobox.setItems(size1);
					 colorCombobox.setItems(color2);


				 }
				 
				 else if(bikeTypeCombobox.getValue().equals("Standard Hybrid Bike")){
					 
					 genderCombobox.setItems(genderList1);
					 sizeCombobox.setItems(size1);
					 colorCombobox.setItems(color1);

				 }
				 
				 else if(bikeTypeCombobox.getValue().equals("Tandem Bike")){
					  
					 genderCombobox.setItems(genderList3);
					 sizeCombobox.setItems(size4);
					 colorCombobox.setItems(color5);

				 }
		        else if(bikeTypeCombobox.getValue().equals("Adult Electric Bike")){
					 
					 genderCombobox.setItems(genderList3);
					 sizeCombobox.setItems(size3);
					 colorCombobox.setItems(color4);

				 }
			  
		  }
	 
//	  for (int i = 0; i < bike_list.size( ); i++)
//    	{ 
//	  
//	  if(bikeTypeCombobox.getValue().equals(bike_list.get(i).bike_type)){}
//		  
//		  else{
//			  
//			  Alert error_customer=new Alert(AlertType.ERROR);
//			  error_customer.setContentText("This Bike Not Available");
//			  error_customer.showAndWait();
//			  
//		  }
	  
		  

	  @FXML
	   public void checkBikeStatus(ActionEvent event) {
		  
		  
		  if(bikeTypeCombobox.getSelectionModel().isEmpty() || genderCombobox.getSelectionModel().isEmpty() || sizeCombobox.getSelectionModel().isEmpty() ||
				  colorCombobox.getSelectionModel().isEmpty()  ){
	
			  Alert error_customer=new Alert(AlertType.ERROR);
			  error_customer.setContentText("Required Details are not Selected");
			  error_customer.showAndWait();
		  }
		  else{
	 
		  for (int i = 0; i < bike_list.size(); i++)
	    	{ 
		  
		  if(bikeTypeCombobox.getValue().equals(bike_list.get(i).bike_type) && genderCombobox.getValue().equals(bike_list.get(i).gender) && 
				  sizeCombobox.getValue().equals(bike_list.get(i).size) &&  colorCombobox.getValue().equals(bike_list.get(i).colour) && 
				  bike_list.get(i).status.equals("Available"))
				  
				  {
			     status=true;
			     customerSelectionText.setVisible(true);
				 customerSelectionPane.setVisible(true);
				 hirePeriodText.setVisible(true);
				 hourRadioButton.setVisible(true);
				 dayRadioButton.setVisible(true);
				 addCartButton.setVisible(true);
				
		  }
			  
			  else{
				   //DO Nothing
				  
			  }
	    	}
		  
		  if(status){
			  
				Alert confirm=new Alert(AlertType.CONFIRMATION);
				confirm.setContentText("Bike is Available to Hire");
				confirm.showAndWait();
				status=false;
		  }
		  
		  else{
			  
			  Alert error_customer=new Alert(AlertType.ERROR);
			  error_customer.setContentText("This Bike Not Available");
			  error_customer.showAndWait();
		  }
		  
	  }
	  }  
	      	
	
	  @FXML
	   public void hire_bike(ActionEvent event) throws IOException {
		  deposit=0;
		 AnchorPane pane =FXMLLoader.load(getClass().getResource("HireBike.fxml"));
			yellow_pane.getChildren().setAll(pane);
	    }
	
	  @FXML
	   public void searchCustomer(ActionEvent event) {
		  
		  
		  if(search_textfield.getText().isEmpty()){
			  
			  
			  Alert error_customer=new Alert(AlertType.ERROR);
			  error_customer.setContentText("Search field is Empty");
			  error_customer.showAndWait();
			  
		  }
		  
		  else{
		  
		  for (int i = 0; i < customer_list.size( ); i++)
		      	{ 
			  
			  if(Integer.parseInt(search_textfield.getText())==(customer_list.get(i).customer_id)){
				  
				 chooseBikeText.setVisible(true);
			//	customerSelectionText.setVisible(true);
				chooseBikePane.setVisible(true);
			//	customerSelectionPane.setVisible(true);
				  textfield_firstname.setText(customer_list.get(i).first_name);
				  textfield_lastname.setText(customer_list.get(i).last_name);
				  textfield_id.setText(String.valueOf(customer_list.get(i).customer_id));
				  email[0]=customer_list.get(i).email;
				  recordFound=true;

			  }
			  
			  else{

				  
			  }
			  
			  
		      	}
		  
		  if(recordFound){
			  recordFound=false;
		  }
		  
		  else
		  {
			  chooseBikeText.setVisible(false);
				 customerSelectionText.setVisible(false);
				chooseBikePane.setVisible(false);
				customerSelectionPane.setVisible(false);
			  Alert error_customer=new Alert(AlertType.ERROR);
			  error_customer.setContentText("Customer Record Not Found");
			  error_customer.showAndWait();
			  recordFound=false;
		  }
		  }

	    }
	  

}
