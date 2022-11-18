package application;

import javafx.beans.property.SimpleStringProperty;

public class PaymentTable {
	private  SimpleStringProperty customerDeposit;
	private  SimpleStringProperty customerName;
	private  SimpleStringProperty hireId;
	private  SimpleStringProperty customerPayment;
	
	public PaymentTable(String customerDeposit, String customerName, String hireId,
			String customerPayment) {
		this.customerDeposit = new SimpleStringProperty(customerDeposit);
		this.customerName = new SimpleStringProperty(customerName);
		this.hireId = new SimpleStringProperty(hireId);
		this.customerPayment = new SimpleStringProperty(customerPayment);
	}

	public String getCustomerDeposit() {
		return customerDeposit.get();
	}

	public void setCustomerDeposit(SimpleStringProperty customerDeposit) {
		this.customerDeposit = customerDeposit;
	}

	public String getCustomerName() {
		return customerName.get();
	}

	public void setCustomerName(SimpleStringProperty customerName) {
		this.customerName = customerName;
	}

	public String getHireId() {
		return hireId.get();
	}

	public void setHireId(SimpleStringProperty hireId) {
		this.hireId = hireId;
	}

	public String getCustomerPayment() {
		return customerPayment.get();
	}

	public void setCustomerPayment(SimpleStringProperty customerPayment) {
		this.customerPayment = customerPayment;
	}


}
