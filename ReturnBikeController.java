package application;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.itextpdf.text.Paragraph;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ReturnBikeController implements Initializable{
	public ArrayList<Customer> customer_list = new ArrayList<Customer>();
	public ArrayList<Bike> bike_list = new ArrayList<Bike>();
	public ArrayList<HiredBike> hired_bike_list = new ArrayList<HiredBike>();
	long difference;
	int customerId;
	PdfWriteExample writePdf =new PdfWriteExample();
	Email sendmail=new Email();
	Paragraph p1 =new Paragraph();
	Paragraph p2 =new Paragraph();
	Paragraph p3 =new Paragraph();
	Paragraph p4 =new Paragraph();
	Paragraph p5 =new Paragraph();
	Paragraph p6 =new Paragraph();
	
    boolean recordFound=false;
    String cusEmail[]=new String[1];

	
	 @FXML
	    private AnchorPane yellow_pane;
	 
	 @FXML 
	 private JFXRadioButton nodamageRadio,damageRadio;
	 
	    @FXML
	    private JFXTextField textfield_firstname;

	    @FXML
	    private JFXTextField textfield_id;

	    @FXML
	    private JFXButton returnButtton,totalchargesButton;

	    @FXML
	    private JFXTextField textfield_lastname,textfield_datehired,textfield_timehired;

	    @FXML
	    private JFXTextField search_textfield;

	    @FXML
	    private JFXTextField textfield_hireid;

	    @FXML
	    private JFXTextField textfield_deposit;

	    @FXML
	    private JFXTextField textfield_charges;

	    @FXML
	    private JFXTextField textfield_damagelate;


	    @FXML
	    private Text lateNoteText,chargesText,checkText,damageText;

	    @FXML
	    private JFXTextField textfield_total;

	    @FXML
	    private JFXListView<String> itemsListView;
	    
	    ToggleGroup damageRadioGroup;
	    
	    double damageLateCharges=0,totalCharges=0;
	    
	    
		public  ObservableList<String> HireBikesItems=FXCollections.observableArrayList();
		
		LocalDateTime todaydate=LocalDateTime.now();
		
		double damageCharge=0;



	Customer customer;
	Bike bike;
	HiredBike hired_bike;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	
		CustomerList customerList= new CustomerList();
		BikeList bikeList= new BikeList();
		HireBikeList hireList= new HireBikeList();
		customer_list=customerList.setCustomerList(customer_list,customer);
		hired_bike_list=hireList.setHireBikeList(hired_bike_list,hired_bike);
		bike_list=bikeList.setBikeList(bike_list,bike);
		
	

	}
	
	
	@FXML
    public void cancelButton(ActionEvent event) throws IOException {
		AnchorPane pane =FXMLLoader.load(getClass().getResource("ReturnBike.fxml"));
		yellow_pane.getChildren().setAll(pane);
	}
	
	
	@FXML
	   public void damageSelect(){
		
		if(damageRadio.isSelected()){
			
			damageText.setText("As a damage has been noticed, so deposit must be kept by the company");

			damageCharge=0;
			
		}
		
		else if(nodamageRadio.isSelected()){
			
		
			damageText.setText("No Damage charges apply");

			damageCharge=Double.parseDouble(textfield_deposit.getText());

		}
		
	}
	
	@FXML
    public void calculate_totalcharges(ActionEvent event) {
		
		 returnButtton.setDisable(false);
	if(textfield_damagelate.getText().isEmpty()){
			
			damageLateCharges=0;
		}
		
		else{
			
			damageLateCharges=Double. parseDouble(textfield_damagelate.getText());
			
		}
	
	totalCharges=damageCharge-Double.parseDouble(textfield_charges.getText())-damageLateCharges;
	
	textfield_total.setText(String.valueOf(totalCharges));
    }
   
	@FXML
    public void returnHireBikerecord(ActionEvent event) throws IOException {
		
		
	

		 
		 System.out.println("Hired Vehicle Works");
		 
			for( String selection:HireBikesItems){
				
				 String[] fields = selection.split(",");
				 
				 
				 for (int i = 0; i < hired_bike_list.size( ); i++)
			      	{ // write one object
					 
					 System.out.println("FOUND ITTTTT");
						if(fields[0].equals(hired_bike_list.get(i).bike_type) && fields[1].equals(hired_bike_list.get(i).gender) && 
								fields[2].equals(hired_bike_list.get(i).size) &&  fields[3].equals(hired_bike_list.get(i).colour) && 
								hired_bike_list.get(i).status.equals("Not Available")){
											 
							hired_bike_list.get(i).setStatus("Available");	 						
							break;
			      	} 

			}
			}
			
			for( String selection:HireBikesItems){
				
				 String[] fields = selection.split(",");
				 
				 
				 for (int i = 0; i < bike_list.size( ); i++)
			      	{ // write one object
						if(fields[0].equals(bike_list.get(i).bike_type) && fields[1].equals(bike_list.get(i).gender) && 
								fields[2].equals(bike_list.get(i).size) &&  fields[3].equals(bike_list.get(i).colour) && 
								bike_list.get(i).status.equals("Not Available")){
											 
								bike_list.get(i).setStatus("Available");	 
							break;
			      	} 

			}
			}

			

			BikeList bikeList= new BikeList();
			bikeList.addBikeToFile( bike_list, bike);
			 HireBikeList hirebikeList= new HireBikeList();
			  hirebikeList.addHireBikeToFile( hired_bike_list, hired_bike);
			  
				p1.add("Hire Id : "+textfield_hireid.getText().toString());
				p2.add(checkText.getText().toString());
				p3.add("Deposit Paid : £"+textfield_deposit.getText().toString());
				p4.add("Total Paid : £"+textfield_total.getText().toString());
				p5.add("Return Date: "+LocalDateTime.now().toLocalDate().toString()+"\n"+"Return Time: "+LocalDateTime.now().toLocalTime().toString());
				p6.add(damageText.getText());
//				
				sendReturnInvoive();
			    writePdf.writeUsingIText(p1,p2,p3,p4,p5,p6,"ReturnInvoice.pdf");
				sendmail.senddata(cusEmail,"Invoice from Northampton Hire!","ReturnInvoice.pdf");
			  
			

			
			Alert confirm=new Alert(AlertType.CONFIRMATION);
			confirm.setContentText("Bike is Returned to the Fleet");
			confirm.showAndWait();
			 AnchorPane pane =FXMLLoader.load(getClass().getResource("ReturnBike.fxml"));
				yellow_pane.getChildren().setAll(pane);
				
	 
		
	}
	
	@FXML
    public void searchHireBikerecord(ActionEvent event) {
		

		
		itemsListView.getItems().clear();

		  
		  if(search_textfield.getText().isEmpty()){
			  
			  
			  Alert error_customer=new Alert(AlertType.ERROR);
			  error_customer.setContentText("Search field is Empty");
			  error_customer.showAndWait();
			  
		  }
		  
		  else{
			  
			 
		  int n=Integer.parseInt(search_textfield.getText());

		  for (int i = 0; i < hired_bike_list.size(); i++)
		      	{ 
			  
			   if( n== hired_bike_list.get(i).hireId && hired_bike_list.get(i).status.equals("Not Available")){
				   
				   //expected_return_time+" "+hired_bike_list.get(i).hiring_type
				   customerId= hired_bike_list.get(i).customer_id;
				   
				   if(hired_bike_list.get(i).hiring_type.equals("Day")){
					   difference=java.time.Duration.between(hired_bike_list.get(i).time_hired, todaydate).toDays();
					   
				   }
				   
				   else if(hired_bike_list.get(i).hiring_type.equals("Hours")){
					   difference=java.time.Duration.between(hired_bike_list.get(i).time_hired, todaydate).toHours();

					   
				   }
				   
				   if(difference>hired_bike_list.get(i).expected_return_time){
					   
					   checkText.setText("Bikes are Late, So penality charges applies");
					   textfield_damagelate.setText("50");
					   System.out.println("Bikes are Late by"+difference);

					   
				   }
				   
				   else{
					   
					   checkText.setText("Bikes are on Time");
					   System.out.println("Bikes are On Time");

				   }
				   
				   totalchargesButton.setDisable(false);
				   HireBikesItems.add(hired_bike_list.get(i).bike_type+","+hired_bike_list.get(i).gender+","+ hired_bike_list.get(i).size+","+hired_bike_list.get(i).colour+","+
				   hired_bike_list.get(i).expected_return_time+" "+hired_bike_list.get(i).hiring_type);
				   itemsListView.setItems(HireBikesItems); 
				   System.out.println("Return date is "+hired_bike_list.get(i).time_hired);


				  textfield_firstname.setText(hired_bike_list.get(i).first_name);
				  textfield_lastname.setText(hired_bike_list.get(i).last_name);
				  textfield_id.setText(String.valueOf(hired_bike_list.get(i).customer_id));
				  textfield_hireid.setText(String.valueOf(hired_bike_list.get(i).hireId));
				  textfield_deposit.setText(Double. toString(hired_bike_list.get(i).deposit) );
				  textfield_charges.setText(Double. toString(hired_bike_list.get(i).total_charges) );
				  textfield_datehired.setText((hired_bike_list.get(i).time_hired.toLocalDate()).toString());
				  textfield_timehired.setText((hired_bike_list.get(i).time_hired.toLocalTime()).toString());
				  recordFound=true;


			  }
			  
			  else{

			  }
			    
			  
			  
		      	}
		  
		  if(recordFound){
			//  recordFound=false;
		  }
		  
		  else
		  {
			   totalchargesButton.setDisable(true);

			  Alert error_customer=new Alert(AlertType.ERROR);
			  error_customer.setContentText("Hire Bike Record Not Found");
			  error_customer.showAndWait();
			  recordFound=false;
		  }
		  }

	    

    }


	private void sendReturnInvoive() {
		 for (int i = 0; i < customer_list.size( ); i++)
	      	{
                   if(customer_list.get(i).customer_id==customerId){
                	   cusEmail[0]=customer_list.get(i).email;
                	   
                   }
	      	}
	}
	
}
	      			
	

