package com.axis.customerservice.service;

import java.util.List;

import com.axis.customerservice.entity.Account;
import com.axis.customerservice.entity.Transaction;

public interface AccountService {
	Account getAccountByAccountNumber(long accountNumber);
	List<Account> getAllAccount();
	void addAccount(Account account);
	void deleteAccountByNumber(long accountNumber);
	void updateAccountByNumber(long accountNumber,Account account);
	Transaction deposit(long accountNumber, double amount);
	Transaction withdraw(long accountNumber, double amount);

}
