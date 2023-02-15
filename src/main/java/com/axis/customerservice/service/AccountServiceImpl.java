package com.axis.customerservice.service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.customerservice.entity.Account;
import com.axis.customerservice.entity.Transaction;
import com.axis.customerservice.exception.AccountNumberNotFoundException;
import com.axis.customerservice.exception.InsufficientFundException;
import com.axis.customerservice.exception.TransferLimitExceededException;
import com.axis.customerservice.repository.AccountRepository;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	 SecureRandom rand = new SecureRandom();
	String accStatement="Account with account number: ";
	String notFound=" not found";
	@Override
	public Account getAccountByAccountNumber(long accountNumber) {
		Optional<Account> accountOpt = accountRepository.findById(accountNumber);
		if(!accountOpt.isPresent()) {
			throw new AccountNumberNotFoundException(accStatement+accountNumber+notFound);
		}
		return accountOpt.get();
	}

	@Override
	public List<Account> getAllAccount() {
		
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	public void addAccount(Account account) {
		Account newAccount=new Account();
		accountRepository.save(newAccount);
	}

	@Override
	public void deleteAccountByNumber(long accountNumber) {
		Optional<Account> accountOpt = accountRepository.findById(accountNumber);
		if(!accountOpt.isPresent()) {
			throw new AccountNumberNotFoundException(accStatement+accountNumber+notFound);
		}
		accountRepository.deleteById(accountNumber);

	}


	@Transactional
	@Override
	public void updateAccountByNumber(long accountNumber, Account account) {
		Optional<Account> accountOpt = accountRepository.findById(accountNumber);
		if(!accountOpt.isPresent()) {
			throw new AccountNumberNotFoundException(accStatement+accountNumber+notFound);
		}
		accountRepository.updateAccount(
				account.getAccountType(),
				account.getAccountBalance(),
				account.getAccountNo()
				);
		
	}
	
	@Transactional
	@Override
	public Transaction deposit(long accountNumber, double amount) {
		Account dAccount=getAccountByAccountNumber(accountNumber);
		double amt=dAccount.getAccountBalance();
		amt+=amount;
		Date date=new Date();
		 int trxId=this.rand.nextInt(10000,99999999);
		
		Transaction depositTransaction = new Transaction();
		depositTransaction.setTransactionId(trxId);
		depositTransaction.setAccountNo(accountNumber);
		depositTransaction.setTrasactionDate(date);
		depositTransaction.setDescription("Cash deposit");
		depositTransaction.setTransactionType("Credited");
		depositTransaction.setTransactedAmount(amount);
		depositTransaction.setTotalBalance(amt);
		
		dAccount.setAccountBalance(amt);
		
		updateAccountByNumber(accountNumber, dAccount);
		return(depositTransaction);		
		}
	
	
	@Transactional
	@Override
	public Transaction withdraw(long accountNumber, double amount) {
		Account withdrawAccount=getAccountByAccountNumber(accountNumber);
		Optional<Account> accountOpt = accountRepository.findById(accountNumber);
		if(!accountOpt.isPresent()) {
			throw new AccountNumberNotFoundException(accStatement+accountNumber+notFound);
		}else if(amount>withdrawAccount.getAccountBalance()) {
			throw new InsufficientFundException("Insufficient fund in your account");
		}else if(amount>10000) {
			throw new TransferLimitExceededException("Cannot send amount greater than 10000");
		}else {
			
			double amt=withdrawAccount.getAccountBalance();
			amt-=amount;
			
			Date date=new Date();
			int withdrawTrxId=this.rand.nextInt(12210,99999999);
			Transaction withdrawTransaction = new Transaction();
			withdrawTransaction.setTransactionId(withdrawTrxId);
			withdrawTransaction.setAccountNo(accountNumber);
			withdrawTransaction.setTrasactionDate(date);
			withdrawTransaction.setDescription("Cash withdraw");
			withdrawTransaction.setTransactionType("Debited");
			withdrawTransaction.setTransactedAmount(amount);
			withdrawTransaction.setTotalBalance(amt);
			
			withdrawAccount.setAccountBalance(amt);
			
			updateAccountByNumber(accountNumber, withdrawAccount);
			return(withdrawTransaction);
		}
				
	}




}
