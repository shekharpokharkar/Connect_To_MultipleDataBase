package com.seleniumexpress.postgresql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String customerCity;
	private String customerCreditCardDetails;
	private String customerName;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerCreditCardDetails() {
		return customerCreditCardDetails;
	}

	public void setCustomerCreditCardDetails(String customerCreditCardDetails) {
		this.customerCreditCardDetails = customerCreditCardDetails;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerCity=" + customerCity + ", customerCreditCardDetails="
				+ customerCreditCardDetails + ", customerName=" + customerName + "]";
	}

	public Customer(Integer customerId, String customerCity, String customerCreditCardDetails, String customerName) {

		this.customerId = customerId;
		this.customerCity = customerCity;
		this.customerCreditCardDetails = customerCreditCardDetails;
		this.customerName = customerName;
	}

	public Customer() {

	}

}
