package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CustomerList {
	
	public ArrayList<Customer> setCustomerList(ArrayList<Customer> customer_list,Customer customer) {
		// TODO Auto-generated method stub

		try {

			FileInputStream fis = new FileInputStream("customer.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    Customer customer_obj=null;
			
			while ((customer_obj=(Customer)ois.readObject())!=null) {

	        customer_list.add(customer_obj);
	    	System.out.println("Name is "+customer_obj.first_name);
	    	System.out.println("Id is "+customer_obj.customer_id);

				
			}
		
			 ois.close();
			 
			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 
		
		return customer_list;

	}
	
	public void addCustomerToFile(ArrayList<Customer> customer_list,Customer customer) {
		// TODO Auto-generated method stub

		try {
			
			FileOutputStream fos = new FileOutputStream("customer.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (int i = 0; i < customer_list.size( ); i++)
	      	{ // write one object
				customer = (Customer)customer_list.get(i);
	      		oos.writeObject(customer); // this one line writes an entire object!!!!
	      	} 
			oos.close();

			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 

	}
	
public int assignId(){
		
		int id=0;
		try {

			FileInputStream fis = new FileInputStream("customer.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    Customer customer_obj=null;
			
			while ((customer_obj=(Customer)ois.readObject())!=null) {
			
				if(customer_obj.customer_id>id){
					
				     id=customer_obj.customer_id;

				}
	
				
			}

			
			 ois.close();
			 
			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 
		return id+1;
		
	}
}
