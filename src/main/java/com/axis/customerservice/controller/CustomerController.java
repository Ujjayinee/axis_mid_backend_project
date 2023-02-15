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

import com.axis.customerservice.entity.Customer;
import com.axis.customerservice.service.CustomerService;



@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

		@Autowired
		private CustomerService customerService;
		
		public CustomerController() {
			
		}
		
		public CustomerService getCustomerService() {
			return customerService;
		}


		public void setCustomerService(CustomerService customerService) {
			this.customerService = customerService;
		}


		@GetMapping("/customer/{customerId}")
		public Customer getCustomerById(@PathVariable int customerId) {
			return customerService.getCustomerById(customerId);
		}
		
		@GetMapping("/customers")
		public List<Customer> getCustomers(){
			return customerService.getCustomers();
		}
		
		@PostMapping("/customer")
		public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
			customerService.addCustomer(customer);
			return new ResponseEntity<>("Customer Added successfully..",HttpStatus.OK);
		}
		
		@DeleteMapping("/customer/{customerId}")
		public ResponseEntity<String> deleteCustomerById(@PathVariable int customerId){
			customerService.deleteCustomerById(customerId);
			return new ResponseEntity<>("Customer deleted Successfully..",HttpStatus.OK);
		}
		
		@PutMapping("/customer/{customerId}")
		public ResponseEntity<String> updateCustomerInfo(@PathVariable int customerId,@RequestBody Customer updatedCustomer){
				customerService.updateCustomerById(customerId, updatedCustomer);
				return new ResponseEntity<>("Customer Updated Successfully..",HttpStatus.OK);
		}
		
		@PostMapping("/customer/login")
		public Customer loginCustomer(@RequestBody Customer customer) {
			return customerService.validateCustomer(customer);
		}

}
