package com.axis.customerservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axis.customerservice.entity.Transaction;



@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Integer>{

}
