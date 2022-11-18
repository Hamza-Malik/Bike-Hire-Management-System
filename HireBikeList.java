package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class HireBikeList {
	
	public ArrayList<HiredBike> setHireBikeList(ArrayList<HiredBike> hirebike_list,HiredBike hirebike) {
		// TODO Auto-generated method stub


		try {

			FileInputStream fis = new FileInputStream("hirebike.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    HiredBike hire_obj=null;
			
			while ((hire_obj=(HiredBike)ois.readObject())!=null) {
			
				System.out.println("---Hire Bikes Are---");

				System.out.println("Name is "+hire_obj.first_name);
				System.out.println("Last name is "+hire_obj.last_name);
				System.out.println("Hire ID is "+hire_obj.hireId);
				System.out.println("Hire Status is "+hire_obj.status);

				
				System.out.println("---Hire Bikes Finish---");


				
				hirebike_list.add(hire_obj);
				
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
		
		return hirebike_list;

	}
	
	
	
	public void addHireBikeToFile(ArrayList<HiredBike> hirebike_list,HiredBike hirebike) {
		// TODO Auto-generated method stub

		try {
			
			FileOutputStream fos = new FileOutputStream("hirebike.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (int i = 0; i < hirebike_list.size( ); i++)
	      	{ // write one object
				hirebike = (HiredBike)hirebike_list.get(i);
	      		oos.writeObject(hirebike); // this one line writes an entire object!!!!
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
	
public int assignHireId(){
		
		int hireid=0;
		try {

			FileInputStream fis = new FileInputStream("hirebike.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    HiredBike hire_obj=null;
			
			while ((hire_obj=(HiredBike)ois.readObject())!=null) {
			
				if(hire_obj.hireId>hireid){
					
					hireid=hire_obj.hireId;

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
		return hireid+1;
		
	}
 }
