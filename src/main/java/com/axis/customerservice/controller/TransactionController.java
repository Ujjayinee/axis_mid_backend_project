package com.axis.customerservice.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.axis.customerservice.entity.Transaction;
import com.axis.customerservice.service.TransactionService;




@RestController
@CrossOrigin(origins = "*")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	public TransactionController() {
		
	}
	public TransactionService getTransactionService() {
		return transactionService;
	}
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}


	@GetMapping("/transaction/{transactionId}")
	public Transaction getTransactionById(@PathVariable int transactionId) {
		return transactionService.getTransactionById(transactionId);
	}
	
	@GetMapping("/transactions")
	public List<Transaction> getTransactions(){
		return transactionService.getTransactions();
	}
	
	@GetMapping("/transaction/account/{accountNumber}")
	public List<Transaction> getTransactionByAccount(@PathVariable int accountNumber){
		return transactionService.getTransactionsByAcc(accountNumber);
	}
	
	@PostMapping("/transaction")
	public ResponseEntity<String> addTransaction(Transaction transaction){
		transactionService.addTransaction(transaction);
		return new ResponseEntity<>("Transaction Successful..",HttpStatus.OK);
	}

}
