package com.mcsjavaprojects.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mcsjavaprojects.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {
	
	

	public Customer findById(int id) {
		return getByKey(id);
	}

	public void saveCustomer(Customer customer) {
		persist(customer);
	}
	
	public void deleteCustomerByEmail(String email) {		
		Query query = getSession().createSQLQuery("DELETE FROM CUSTOMER WHERE email = :email");
		query.setString("email", email);
		query.executeUpdate();
	}	
	

	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomers() {
		Criteria criteria = createEntityCriteria();
		return (List<Customer>) criteria.list();
	}

	public Customer findCustomerByEmail(String email) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("email", email));
		return (Customer) criteria.uniqueResult();
	}
	
	
}
