package com.axis.customerservice.repository;

import java.util.Date;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axis.customerservice.entity.Customer;



@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

	@Modifying

	
	@Query("update Customer set customerName=?1,dateOfBirth=?2,gender=?3,customerNationality=?4,"
			+ "customerMobileNo=?5,customerEmailId=?6, customerPanCardNo=?7,customerAadharCardNo=?8,"
			+ "currentAddress=?9,city=?10,pincode=?11,state=?12 where customerId=?13")
	void updateCustomerInfo(
							String customerName,
							Date dateOfBirth,
							String gender,
							String customerNationality,
							long customerMobileNo,
							String customerEmailId,
							String customerPanCardNo,
							long customerAadharCardNo,
							String currentAddress,
							String city,
							int pincode,
							String state,
							int customerId);
	
	

	
}
