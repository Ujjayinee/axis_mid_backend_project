package com.axis.customerservice.entity;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Transaction {

	@Id
	private int transactionId;
	private Date trasactionDate;
	private long accountNo;
	private String description;
	private String transactionType;
	private double transactedAmount;
	private double totalBalance;
	public Transaction() {
		
	}
	public Transaction(int transactionId, Date trasactionDate, long accountNo, String description, String transactionType,
			double transactedAmount, double totalBalance) {
		this.transactionId = transactionId;
		this.trasactionDate = trasactionDate;
		this.accountNo = accountNo;
		this.description = description;
		this.transactionType = transactionType;
		this.transactedAmount = transactedAmount;
		this.totalBalance = totalBalance;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Date getTrasactionDate() {
		return trasactionDate;
	}
	public void setTrasactionDate(Date trasactionDate) {
		this.trasactionDate = trasactionDate;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTransactedAmount() {
		return transactedAmount;
	}
	public void setTransactedAmount(double transactedAmount) {
		this.transactedAmount = transactedAmount;
	}
	public double getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", trasactionDate=" + trasactionDate + ", accountNo="
				+ accountNo + ", description=" + description + ", transactionType=" + transactionType
				+ ", transactedAmount=" + transactedAmount + ", totalBalance=" + totalBalance + "]";
	}
	
	
	
	
	
	
}
