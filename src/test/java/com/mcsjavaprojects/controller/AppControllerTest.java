package com.mcsjavaprojects.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.atLeastOnce;

import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mcsjavaprojects.controller.AppController;
import com.mcsjavaprojects.model.Customer;
import com.mcsjavaprojects.service.CustomerService;

public class AppControllerTest {

	@Mock
	CustomerService service;
	
	@Mock
	MessageSource message;
	
	@InjectMocks
	AppController appController;
	
	@Spy
	List<Customer> customers = new ArrayList<Customer>();

	@Spy
	ModelMap model;
	
	@Mock
	BindingResult result;
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		customers = getCustomerList();
	}
	
	@Test
	public void listCustomers(){
		when(service.findAllCustomers()).thenReturn(customers);
		Assert.assertEquals(appController.listCustomers(model), "customerslist");
		Assert.assertEquals(model.get("customers"), customers);
		verify(service, atLeastOnce()).findAllCustomers();
	}
	
	@Test
	public void newCustomer(){
		Assert.assertEquals(appController.newCustomer(model), "registration");
		Assert.assertNotNull(model.get("customer"));
		Assert.assertFalse((Boolean)model.get("edit"));		
		Assert.assertEquals(Integer.valueOf(((Customer)model.get("customer")).getId()), Integer.valueOf(0));
		
	}

	@Test
	public void saveCustomerWithValidationError(){
		when(result.hasErrors()).thenReturn(true);
		doNothing().when(service).saveCustomer(any(Customer.class));
		Assert.assertEquals(appController.saveCustomer(customers.get(0), result, model), "registration");
	}

	@Test
	public void saveCustomerWithValidationErrorNonUniqueSSN(){
		when(result.hasErrors()).thenReturn(false);
		when(service.isCustomerEmailUnique(anyInt(), anyString())).thenReturn(false);
		Assert.assertEquals(appController.saveCustomer(customers.get(0), result, model), "registration");
	}

	
	@Test
	public void saveCustomerWithSuccess(){
		when(result.hasErrors()).thenReturn(false);
		when(service.isCustomerEmailUnique(anyInt(), anyString())).thenReturn(true);
		doNothing().when(service).saveCustomer(any(Customer.class));
		Assert.assertEquals(appController.saveCustomer(customers.get(0), result, model), "success");
		Assert.assertEquals(model.get("success"), "Customer John Doe registered successfully");
	}

	@Test
	public void editCustomer(){
		Customer custo = customers.get(0);
		when(service.findCustomerByEmail(anyString())).thenReturn(custo);
		Assert.assertEquals(appController.editCustomer(anyString(), model), "registration");
		Assert.assertNotNull(model.get("customer"));
		Assert.assertTrue((Boolean)model.get("edit"));		
		Assert.assertEquals(Integer.valueOf(((Customer)model.get("customer")).getId()), Integer.valueOf(1));
		
	}

	@Test
	public void updateCustomerWithValidationError(){
		when(result.hasErrors()).thenReturn(true);
		doNothing().when(service).updateCustomer(any(Customer.class));
		Assert.assertEquals(appController.updateCustomer(customers.get(0), result, model,""), "registration");
	}

	@Test
	public void updateCustomerWithValidationErrorNonUniqueEmail(){
		when(result.hasErrors()).thenReturn(false);
		when(service.isCustomerEmailUnique(anyInt(), anyString())).thenReturn(false);
		Assert.assertEquals(appController.updateCustomer(customers.get(0), result, model,""), "registration");
	}

	@Test
	public void updateEmployeeWithSuccess(){
		when(result.hasErrors()).thenReturn(false);
		when(service.isCustomerEmailUnique(anyInt(), anyString())).thenReturn(true);
		doNothing().when(service).updateCustomer(any(Customer.class));
		Assert.assertEquals(appController.updateCustomer(customers.get(0), result, model, ""), "success");
		Assert.assertEquals(model.get("success"), "Customer John Doe updated successfully");
	}
	
	
	@Test
	public void deleteEmployee(){
		doNothing().when(service).deleteCustomerByEmail(anyString());
		Assert.assertEquals(appController.deleteCustomer("customer03@xyx.com"), "redirect:/list");
	}

	public List<Customer> getCustomerList(){
		Customer c1 = new Customer();		
		c1.setId(1);						
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
