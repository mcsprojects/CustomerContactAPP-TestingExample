package com.mcsjavaprojects.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcsjavaprojects.dao.CustomerDao;
import com.mcsjavaprojects.model.Customer;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;
	
	public Customer findById(int id) {
		return dao.findById(id);
	}

	public void saveCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}
	
	public void updateCustomer(Customer customer) {
		Customer entity = dao.findById(customer.getId());
		if(entity!=null){
			entity.setEmail(customer.getEmail());				
			entity.setName(customer.getName());
			entity.setAddress(customer.getAddress());
			entity.setZip(customer.getZip());
			entity.setAddress(customer.getAddress());
			entity.setContactPerson(customer.getContactPerson());
			entity.setPosition(customer.getPosition());
			entity.setPhone(customer.getPhone());
			entity.setEmail(customer.getEmail());
			entity.setLastContact(customer.getLastContact());
			entity.setNextContact(customer.getNextContact());
			entity.setLeadStatus(customer.getLeadStatus());
			entity.setNotes(customer.getNotes());
		}
	}

	public void deleteCustomerByEmail(String email) {
		dao.deleteCustomerByEmail(email);
	}
	
	public List<Customer> findAllCustomers() {
		return dao.findAllCustomers();
	}

	public Customer findCustomerByEmail(String email) {
		return dao.findCustomerByEmail(email);
	}

	public boolean isCustomerEmailUnique(Integer id, String email) {
		Customer customer = findCustomerByEmail(email);
		return ( customer == null || ((id != null) && (customer.getId() == id)));
	}
	
}
