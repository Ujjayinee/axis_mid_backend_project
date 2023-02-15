package com.axis.customerservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.customerservice.entity.Account;
import com.axis.customerservice.entity.Transaction;
import com.axis.customerservice.service.AccountService;
import com.axis.customerservice.service.TransactionService;

@RestController
@CrossOrigin(origins = "*")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	public AccountController() {
	
	}
	
	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}



	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts(){
		return accountService.getAllAccount();
	}
	
	@GetMapping("/accounts/{accountNumber}")
	public Account getAccountById(@PathVariable long accountNumber) {
		return accountService.getAccountByAccountNumber(accountNumber);
	}
	

	@PostMapping("/account")
	public ResponseEntity<String> addAccount(@RequestBody Account account){
		accountService.addAccount(account);
		return new ResponseEntity<>("Account added successfully",HttpStatus.ACCEPTED);
	} 
	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public ResponseEntity<String> deposit(@PathVariable long accountNumber,@PathVariable double amount){
		Transaction tran= accountService.deposit(accountNumber, amount);
		
		transactionService.addTransaction(tran);
		return new ResponseEntity<>("amount : "+amount+" added successfully",HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public ResponseEntity<String> withdraw(@PathVariable long accountNumber,@PathVariable double amount){
		Transaction tran= accountService.withdraw(accountNumber, amount);
		transactionService.addTransaction(tran);
		return new ResponseEntity<>("amount : "+amount+" withdrawn successfully",HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{accountNumber}")
	public ResponseEntity<String> update(@PathVariable long accountNumber,@RequestBody Account account) {
		 accountService.updateAccountByNumber(accountNumber, account);
		
		return new ResponseEntity<>("Account updated successfully",HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/account/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable long accountNumber){
		accountService.deleteAccountByNumber(accountNumber);
		return new ResponseEntity<>("Account with account number : "+accountNumber+"deleted Successfully",HttpStatus.OK);
	}
	
	
	
}
