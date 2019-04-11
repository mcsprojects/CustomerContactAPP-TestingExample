package com.mcsjavaprojects.dao;

import java.util.List;

import com.mcsjavaprojects.model.Customer;

public interface CustomerDao { 
	
    
    Customer findById(int id);

	void saveCustomer(Customer customer);
	
	void deleteCustomerByEmail(String email);
	
	List<Customer> findAllCustomers();

	Customer findCustomerByEmail(String email);

	    
}


