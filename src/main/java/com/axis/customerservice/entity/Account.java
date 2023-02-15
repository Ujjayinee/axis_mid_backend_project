package com.axis.customerservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	private long accountNo;
	private String accountType;
	private double accountBalance;
	

	
	//default Constructor
	public Account() {	
	}



	public Account(long accountNo, String accountType, double accountBalance) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}



	public long getAccountNo() {
		return accountNo;
	}



	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}



	public String getAccountType() {
		return accountType;
	}



	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	public double getAccountBalance() {
		return accountBalance;
	}



	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}



	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + "]";
	}
	
	
	

}
