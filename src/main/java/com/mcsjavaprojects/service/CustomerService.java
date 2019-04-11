package com.mcsjavaprojects.service;

import java.util.List;

import com.mcsjavaprojects.model.Customer;


public interface CustomerService {

	Customer findById(int id);
	
	void saveCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomerByEmail(String email);

	List<Customer> findAllCustomers(); 
	
	Customer findCustomerByEmail(String email);

	boolean isCustomerEmailUnique(Integer id, String email);
	
}
