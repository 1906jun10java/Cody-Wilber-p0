package com.revature.services;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAOImpl;

import java.sql.SQLException;

public class CustomerService {
	private static CustomerService instance;
	private static Customer currentCustomer;

	private CustomerService() {}
	
	// Return singleton instance
	public static synchronized CustomerService getInstance() {
		if (instance == null) {
			instance = new CustomerService();
		}
		return instance;
	}
	
	// Set current customer
	public void setCurrentCustomer(Customer c) {
		currentCustomer = c;
	}
	
	// Get current customer
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
	
	// Save customer to customers
	public void saveCustomer(Customer c) {
		CustomerDAOImpl cdi = new CustomerDAOImpl();
		try {
			cdi.saveCustomer(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Get customer from customers
	public Customer getCustomer(String username) {
		CustomerDAOImpl cdi = new CustomerDAOImpl();
		try {
			return cdi.getCustomer(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
