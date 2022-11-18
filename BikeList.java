package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BikeList {
	public ArrayList<Bike> setBikeList(ArrayList<Bike> bike_list,Bike bike) {
		// TODO Auto-generated method stub
	//	ArrayList<Customer> customer_list = new ArrayList<Customer>();

		try {

			FileInputStream fis = new FileInputStream("bike.dat");
			ObjectInputStream bike_ois = new ObjectInputStream(fis);
			Bike bike_obj=null;
			
			while ((bike_obj=(Bike)bike_ois.readObject())!=null) {
			
				
				System.out.println("Type is "+bike_obj.bike_type);
				System.out.println("Gender is "+bike_obj.gender);
				System.out.println("Color is "+bike_obj.colour);
				System.out.println("Color is "+bike_obj.size);



				System.out.println("Status is "+bike_obj.status);

				//System.out.println("Last name is "+adultelectric_obj.last_name);

				
				bike_list.add(bike_obj);
				
			}

			
			bike_ois.close();
			 
			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 
		
		return bike_list;

	}
	
	public void addBikeToFile(ArrayList<Bike> bike_list,Bike bike) {
		// TODO Auto-generated method stub

		try {
			
			FileOutputStream fos = new FileOutputStream("bike.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (int i = 0; i < bike_list.size( ); i++)
	      	{ // write one object
				bike = (Bike)bike_list.get(i);
	      		oos.writeObject(bike); // this one line writes an entire object!!!!
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
}
