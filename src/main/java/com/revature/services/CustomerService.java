package com.revature.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Customer;
import com.revature.dao.CustomerDAOImpl;

public class CustomerService {
	private static CustomerService instance;
	private static Customer currentCustomer;
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	
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
	
	// Get all customers
	public ArrayList<Customer> getCustomers() {
		return customers;
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
