package application;

import java.io.Serializable;

public class Customer implements Serializable{
public String first_name;
public String last_name;
public int customer_id;
public String street;
public String city;
public String house_no;
public String postcode;
public String email;


public Customer(String first_name,String last_name, int customer_id, String street, String city, String house_no, String postcode,
		String email) {
	super();
	this.first_name = first_name;
	this.last_name = last_name;
	this.customer_id = customer_id;
	this.street = street;
	this.city = city;
	this.house_no = house_no;
	this.postcode = postcode;
	this.email = email;
}


public String getFirst_name() {
	return first_name;
}


public void setFirst_name(String first_name) {
	this.first_name = first_name;
}


public String getLast_name() {
	return last_name;
}


public void setLast_name(String last_name) {
	this.last_name = last_name;
}


public int getCustomer_id() {
	return customer_id;
}


public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}


public String getStreet() {
	return street;
}


public void setStreet(String street) {
	this.street = street;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public String getHouse_no() {
	return house_no;
}


public void setHouse_no(String house_no) {
	this.house_no = house_no;
}


public String getPostcode() {
	return postcode;
}


public void setPostcode(String postcode) {
	this.postcode = postcode;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}

}
