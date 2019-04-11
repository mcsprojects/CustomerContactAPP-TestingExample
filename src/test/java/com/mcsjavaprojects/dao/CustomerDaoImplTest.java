package com.mcsjavaprojects.dao;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mcsjavaprojects.model.Customer;


public class CustomerDaoImplTest extends EntityDaoImplTest{

	@Autowired
	CustomerDao customerDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Customer.xml"));
		return dataSet;
	}
	
	
	@Test
	public void findById(){
		Assert.assertNotNull(customerDao.findById(1));
		Assert.assertNull(customerDao.findById(3));
	}

	
	@Test
	public void saveCustomer(){
		customerDao.saveCustomer(getSampleCustomer());
		Assert.assertEquals(customerDao.findAllCustomers().size(), 3);
	}
	
	@Test
	public void deleteCustomerByEmail(){
		customerDao.deleteCustomerByEmail("customer01@xyz.com");
		Assert.assertEquals(customerDao.findAllCustomers().size(), 1);
	}
	
	@Test
	public void deleteCustomerByInvalidEmail(){
		customerDao.deleteCustomerByEmail("customer05@xyz.com");
		Assert.assertEquals(customerDao.findAllCustomers().size(), 2);
	}
	
	

	@Test
	public void findAllCustomers(){
		Assert.assertEquals(customerDao.findAllCustomers().size(), 2);
	}
	
	@Test
	public void findCustomerByEmail(){
		Assert.assertNotNull(customerDao.findCustomerByEmail("customer01@xyz.com"));
		Assert.assertNull(customerDao.findCustomerByEmail("customer05@xyz.com"));
	}

	public Customer getSampleCustomer(){
		Customer customer = new Customer();						
		customer.setName("Sam Spade");
		customer.setAddress("Address07");
		customer.setZip(new Integer(77777));		
		customer.setContactPerson("ContactPerson07");
		customer.setPosition("");
		customer.setPhone("777777777");
		customer.setEmail("samspade@xyz.com");
		customer.setLastContact(new LocalDate());
		customer.setNextContact(new LocalDate());
		customer.setLeadStatus("Cold");
		customer.setNotes("Notes07");
		return customer;
	}

}
