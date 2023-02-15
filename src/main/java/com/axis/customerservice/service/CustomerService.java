package com.axis.customerservice.service;

import java.util.List;

import com.axis.customerservice.entity.Customer;




public interface CustomerService {

	Customer getCustomerById(int customerId);
	List<Customer> getCustomers();
	void addCustomer(Customer customer);
	void deleteCustomerById(int customerId);
	void updateCustomerById(int customerId,Customer customer);
	Customer validateCustomer(Customer customer);
}
