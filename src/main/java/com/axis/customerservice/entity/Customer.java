package com.axis.customerservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue			//ID automatically generated
	private int customerId;
	private String customerName;
	private Date dateOfBirth;
	private String gender;
	private String customerNationality;
	private long customerMobileNo;
	private String customerEmailId;
	private String customerPanCardNo;
	private long customerAadharCardNo;
	private String currentAddress;
	private String city;
	private int pincode;
	private String state;
	private String password;


	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Account> accounts;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn
	private List<Transaction> transactions;

	//Default Constructor
	public Customer() {

	}

	public Customer(int customerId, String customerName, Date dateOfBirth, String gender, String customerNationality,
			long customerMobileNo, String customerEmailId, String customerPanCardNo, long customerAadharCardNo,
			String currentAddress, String city, int pincode, String state, String password, List<Account> accounts,
			List<Transaction> transactions) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.customerNationality = customerNationality;
		this.customerMobileNo = customerMobileNo;
		this.customerEmailId = customerEmailId;
		this.customerPanCardNo = customerPanCardNo;
		this.customerAadharCardNo = customerAadharCardNo;
		this.currentAddress = currentAddress;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.password = password;
		this.accounts = accounts;
		this.transactions = transactions;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCustomerNationality() {
		return customerNationality;
	}

	public void setCustomerNationality(String customerNationality) {
		this.customerNationality = customerNationality;
	}

	public long getCustomerMobileNo() {
		return customerMobileNo;
	}

	public void setCustomerMobileNo(long customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getCustomerPanCardNo() {
		return customerPanCardNo;
	}

	public void setCustomerPanCardNo(String customerPanCardNo) {
		this.customerPanCardNo = customerPanCardNo;
	}

	public long getCustomerAadharCardNo() {
		return customerAadharCardNo;
	}

	public void setCustomerAadharCardNo(long customerAadharCardNo) {
		this.customerAadharCardNo = customerAadharCardNo;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", customerNationality=" + customerNationality + ", customerMobileNo="
				+ customerMobileNo + ", customerEmailId=" + customerEmailId + ", customerPanCardNo=" + customerPanCardNo
				+ ", customerAadharCardNo=" + customerAadharCardNo + ", currentAddress=" + currentAddress + ", city="
				+ city + ", pincode=" + pincode + ", state=" + state + ", accounts="
				+ accounts + ", transactions=" + transactions + "]";
	}

	
	


}
