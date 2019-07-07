package com.revature.services;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAOImpl;

import java.sql.SQLException;

public class CustomerService {
	private static CustomerService instance;
	private static Customer currentCustomer;
	private static CustomerDAOImpl cdi = new CustomerDAOImpl();

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
	
	// Save customer
	public void saveCustomer(Customer c) {
		try {
			cdi.saveCustomer(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Get customer
	public Customer getCustomer(String username) {
		try {
			return cdi.getCustomer(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Delete customer
	public void deleteCustomer(String username) {
		try {
			cdi.deleteCustomer(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
