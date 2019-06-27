package com.revature.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Customer;

public class CustomerService {
	private static CustomerService instance;
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static Customer currentCustomer;
	
	// Singleton constructor
	private CustomerService() {}
	
	// Return singleton instance
	private static synchronized CustomerService getInstance() {
		if (instance == null) {
			instance = new CustomerService();
		}
		return instance;
	}
	
	// Load customers from database
	public static void loadCustomers() {
		// TODO: Implement loading from database
	}
	
	// Save customers to database
	public static void saveCustomers() {
		// TODO: Implement save to database
	}
}
