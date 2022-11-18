package application;

import java.io.Serializable;
import java.time.LocalDateTime;

public class HiredBike extends Bike implements Serializable{

	public double deposit;
	public double total_charges;
	public int customer_id;
	public String first_name;
	public String last_name;
	public String hiring_type;
	public int expected_return_time;
	public LocalDateTime time_hired;
	public int hireId;
	
	public HiredBike(String bike_type, String gender, String size, String colour, double hour_rate, double day_rate,
			String status, double deposit, double total_charges, int customer_id, String first_name, String last_name,
			int expected_return_time,String hiring_type,LocalDateTime time_hired,int hireId) {
		super(bike_type, gender, size, colour, hour_rate, day_rate, status);
		this.deposit = deposit;
		this.total_charges = total_charges;
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.expected_return_time = expected_return_time;
		this.hiring_type = hiring_type;
		this.time_hired = time_hired;
		this.hireId = hireId;


	}
	

	public int getHireId() {
		return hireId;
	}


	public void setHireId(int hireId) {
		this.hireId = hireId;
	}


	public LocalDateTime getTime_hired() {
		return time_hired;
	}

	public void setTime_hired(LocalDateTime time_hired) {
		this.time_hired = time_hired;
	}

	public String getHiring_type() {
		return hiring_type;
	}

	public void setHiring_type(String hiring_type) {
		this.hiring_type = hiring_type;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getTotal_charges() {
		return total_charges;
	}

	public void setTotal_charges(double total_charges) {
		this.total_charges = total_charges;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

	public int getExpected_return_time() {
		return expected_return_time;
	}

	public void setExpected_return_time(int expected_return_time) {
		this.expected_return_time = expected_return_time;
	}

	
}
