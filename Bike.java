package application;

import java.io.Serializable;

public class Bike implements Serializable{
 public String bike_type;
 public String gender;
 public String size;
 public String colour;
 public double hour_rate;
 public double day_rate;	
 public String status;
 
 									// Constructor//
public Bike(String bike_type, String gender, String size, String colour, double hour_rate,double day_rate,String status) {
	
	this.bike_type = bike_type;
	this.gender = gender;
	this.size = size;
	this.colour = colour;
	this.hour_rate = hour_rate;
	this.day_rate = day_rate;
	this.status = status;

}

public double getHour_rate() {
	return hour_rate;
}

public void setHour_rate(double hour_rate) {
	this.hour_rate = hour_rate;
}


public double getDay_rate() {
	return day_rate;
}

public void setDay_rate(double day_rate) {
	this.day_rate = day_rate;
}

public String getBike_type() {
	return bike_type;
}

public void setBike_type(String bike_type) {
	this.bike_type = bike_type;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getSize() {
	return size;
}

public void setSize(String size) {
	this.size = size;
}

public String getColour() {
	return colour;
}

public void setColour(String colour) {
	this.colour = colour;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


//@Override
//public String toString() {
//	return "Bike [bike_type=" + bike_type + ", gender=" + gender + ", size=" + size + ", colour=" + colour + ", rate="
//			+ rate + ", quantity=" + quantity + "]";
//}
}
