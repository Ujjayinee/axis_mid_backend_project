package com.axis.customerservice.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.customerservice.entity.Transaction;
import com.axis.customerservice.exception.TransactionNotFoundException;
import com.axis.customerservice.repository.TransactionRepository;


@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Transaction getTransactionById(int transactionId) {
		Optional<Transaction> tranOpt =transactionRepository.findById(transactionId);
		if(!tranOpt.isPresent()) {
			throw new TransactionNotFoundException("Transaction with id : "+transactionId+" not Found");
		}
			return tranOpt.get();
	}

	@Override
	public List<Transaction> getTransactions() {
		
		List<Transaction> trxList= (List<Transaction>) transactionRepository.findAll();
		return trxList.stream().sorted(Comparator.comparing(Transaction::getTrasactionDate).reversed()).collect(Collectors.toList());
		
	}

	@Override
	public void addTransaction(Transaction transaction) {
		transactionRepository.save(transaction);

	}

	@Override
	public List<Transaction> getTransactionsByAcc(int accountNumber) {
		List<Transaction> trxList=getTransactions();
		int size=trxList.size();
		for(int i=0;i<size;i++) {
			if(trxList.get(i).getAccountNo()!=accountNumber) {
				trxList.remove(i);
				size--;
				i--;
		}
		
		
	}
		return trxList.stream().sorted(Comparator.comparing(Transaction::getTrasactionDate).reversed()).collect(Collectors.toList());
		
	}

}
