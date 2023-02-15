package com.axis.customerservice.service;

import java.util.List;

import com.axis.customerservice.entity.Transaction;

public interface TransactionService {
	
	Transaction getTransactionById(int transactionId);
	List<Transaction> getTransactions();
	List<Transaction> getTransactionsByAcc(int accountNumber);
	void addTransaction(Transaction transaction);
}
