package application;

import java.io.Serializable;

public class Payment extends Customer implements Serializable{
	
	public int hireId;
	public double deposit;
	public double total_charges;
	public String payment_status;
	
	public Payment(String first_name, String last_name, int customer_id, String street, String city, String house_no,
			String postcode, String email, int hireId, double deposit, double total_charges,String payment_status) {
		super(first_name, last_name, customer_id, street, city, house_no, postcode, email);
		this.hireId = hireId;
		this.deposit = deposit;
		this.total_charges = total_charges;
		this.payment_status = payment_status;

	}

	public int getHireId() {
		return hireId;
	}

	public void setHireId(int hireId) {
		this.hireId = hireId;
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

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}


}
