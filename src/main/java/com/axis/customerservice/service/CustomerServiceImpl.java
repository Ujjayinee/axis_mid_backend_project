package com.axis.customerservice.service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.customerservice.entity.Account;
import com.axis.customerservice.entity.Customer;
import com.axis.customerservice.exception.CustomerNotFoundException;
import com.axis.customerservice.repository.CustomerRepository;



@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	SecureRandom rand = new SecureRandom();
	String customerNot="Customer Not Found with Customer Id ";
	Logger logger =Logger.getLogger("No user found with given employee id");
	@Override
	public Customer getCustomerById(int customerId) {
		Optional<Customer> customerOpt = customerRepository.findById(customerId);
		if(!customerOpt.isPresent())
			throw new CustomerNotFoundException(customerNot+customerId);
		return customerOpt.get();
	}

	@Override
	public List<Customer> getCustomers() {
		
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public void addCustomer(Customer customer) {
		List<Account> accountList = customer.getAccounts();
		
		long accno=this.rand.nextLong(120001,999999);
		for(Account acc:accountList) {
			acc.setAccountNo(accno);
			
		}
		customerRepository.save(customer);
		
	}

	@Override
	public void deleteCustomerById(int customerId) {
		Optional<Customer> customerOpt = customerRepository.findById(customerId);
		if(!customerOpt.isPresent())
			throw new CustomerNotFoundException(customerNot+customerId);
		customerRepository.deleteById(customerId);

	}

	@Transactional
	@Override
	public void updateCustomerById(int customerId, Customer updatedCustomer) {
		Optional<Customer> customerOpt = customerRepository.findById(customerId);
		if(!customerOpt.isPresent())
			throw new CustomerNotFoundException(customerNot+customerId);
		customerRepository.updateCustomerInfo(
				
				updatedCustomer.getCustomerName(),
				updatedCustomer.getDateOfBirth(),
				updatedCustomer.getGender(),
				updatedCustomer.getCustomerNationality(),
				updatedCustomer.getCustomerMobileNo(),
				updatedCustomer.getCustomerEmailId(),
				updatedCustomer.getCustomerPanCardNo(),
				updatedCustomer.getCustomerAadharCardNo(),
				updatedCustomer.getCurrentAddress(),
				updatedCustomer.getCity(),
				updatedCustomer.getPincode(),
				updatedCustomer.getState(),
				customerId);

	}

	@Override
	public Customer validateCustomer(Customer customer) {
		List<Customer> customerList=getCustomers();
		for(Customer cus:customerList) {
			if(cus.getCustomerId() == customer.getCustomerId()) {
				if(cus.getPassword().equals(customer.getPassword())) {

					return cus;
				}else {
					
					return null;
				}
				
			}
		}
		logger.log(Level.WARNING,"No user found with given employee id");
		
		return null;
		
	}
	

}
