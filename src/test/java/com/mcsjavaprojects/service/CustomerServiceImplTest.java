package com.mcsjavaprojects.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

import org.joda.time.LocalDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mcsjavaprojects.dao.CustomerDao;
import com.mcsjavaprojects.model.Customer;
import com.mcsjavaprojects.service.CustomerServiceImpl;

public class CustomerServiceImplTest {

	@Mock
	CustomerDao dao;
	
	@InjectMocks
	CustomerServiceImpl customerService;
	
	@Spy
	List<Customer> customers = new ArrayList<Customer>();
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		customers = getCustomerList();
	}

	@Test
	public void findById(){
		Customer cus = customers.get(0);
		when(dao.findById(anyInt())).thenReturn(cus);
		Assert.assertEquals(customerService.findById(cus.getId()),cus);
	}

	@Test
	public void saveCustomer(){
		doNothing().when(dao).saveCustomer(any(Customer.class));
		customerService.saveCustomer(any(Customer.class));
		verify(dao, atLeastOnce()).saveCustomer(any(Customer.class));
	}
	
	@Test
	public void updateCustomer(){
		Customer cus = customers.get(0);
		when(dao.findById(anyInt())).thenReturn(cus);
		customerService.updateCustomer(cus);
		verify(dao, atLeastOnce()).findById(anyInt());
	}

	@Test
	public void deleteCustomerByEmail(){
		doNothing().when(dao).deleteCustomerByEmail(anyString());
		customerService.deleteCustomerByEmail(anyString());
		verify(dao, atLeastOnce()).deleteCustomerByEmail(anyString());
	}
	
	@Test
	public void findAllCustomers(){
		when(dao.findAllCustomers()).thenReturn(customers);
		Assert.assertEquals(customerService.findAllCustomers(), customers);
	}
	
	@Test
	public void findCustomerByEmail(){
		Customer cus = customers.get(0);
		when(dao.findCustomerByEmail(anyString())).thenReturn(cus);
		Assert.assertEquals(customerService.findCustomerByEmail(anyString()), cus);
	}

	@Test
	public void isCustomerEmailUnique(){
		Customer cus = customers.get(0);
		when(dao.findCustomerByEmail(anyString())).thenReturn(cus);
		Assert.assertEquals(customerService.isCustomerEmailUnique(cus.getId(), cus.getEmail()), true);
	}
	
	
	public List<Customer> getCustomerList(){
		Customer c1 = new Customer();
		c1.setName("John Doe");
		c1.setAddress("Address03");
		c1.setZip(new Integer(33333));		
		c1.setContactPerson("ContactPerson03");
		c1.setPosition("Position03");
		c1.setPhone("333333333");
		c1.setEmail("johndoe@xyz.com");
		c1.setLastContact(new LocalDate());
		c1.setNextContact(new LocalDate());
		c1.setLeadStatus("Cold");
		c1.setNotes("Notes03");
		
		
		Customer c2 = new Customer();
		c2.setId(2);						
		c2.setName("Jane Doe");
		c2.setAddress("Address04");
		c2.setZip(new Integer(44444));		
		c2.setContactPerson("ContactPerson04");
		c2.setPosition("Position04");
		c2.setPhone("444444444");
		c2.setEmail("janedoe@xyz.com");
		c2.setLastContact(new LocalDate());
		c2.setNextContact(new LocalDate());
		c2.setLeadStatus("Cold");
		c2.setNotes("Notes04");
		
		customers.add(c1);
		customers.add(c2);
		return customers;
	}
	
}
