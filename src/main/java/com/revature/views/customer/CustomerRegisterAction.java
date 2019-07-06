package com.revature.views.customer;

import com.revature.beans.Customer;
import com.revature.services.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CustomerRegisterAction {
	private static CustomerService cs = CustomerService.getInstance();
	private static Scanner sc = new Scanner(System.in);
	private final static Logger logger = LogManager.getLogger(CustomerRegisterAction.class);
	
	public CustomerRegisterAction() {}
	
	public void run() {
		String username = getUsername();
		String password = getPassword();
		
		// First name, last name
		System.out.println("Enter your first name:");
		System.out.print(">>> ");
		String firstName = sc.nextLine();
		System.out.println("Enter your last name:");
		System.out.print(">>> ");
		String lastName = sc.nextLine();
		
		// Create customer and save
		Customer c = new Customer(firstName, lastName, username, password);
		cs.saveCustomer(c);
		logger.info("NEW CUSTOMER REGISTERED");
		
		// Redirect to login
		CustomerLoginAction cla = new CustomerLoginAction();
		cla.run();
	}
	
	// Get username from user
	private String getUsername() {
		String username = "";
		
		boolean notValidUsername = true;
		while (notValidUsername) {
			System.out.println("Enter a username:");
			System.out.print(">>> ");
			username = sc.nextLine();
			if (validateUsername(username)) {
				notValidUsername = false;
			}
		}
		
		return username;
	}
	
	// Get password from user
	private String getPassword() {
		String password = "";
		
		boolean notValidPassword = true;
		String p0, p1;
		while (notValidPassword) {
			System.out.println("Enter a password:");
			System.out.print(">>> ");
			p0 = sc.nextLine();
			if (validatePassword(p0)) {
				System.out.println("Confirm password:");
				System.out.print(">>> ");
				p1 = sc.nextLine();
				if (p0.equals(p1)) {
					password = p0;
					notValidPassword = false;
				} else {
					System.out.println("Passwords do not match.");
				}
			}
		}
		
		return password;
	}
	
	// Validate username
	private boolean validateUsername(String un) {
		if (un.length() < 6) {
			System.out.println("Username must be at least 6 characters.");
			return false;
		}
		
		for (Customer c : cs.getCustomers()) {
			if (c.getUsername().equals(un)) {
				System.out.println("Username is taken.");
				return false;
			}
		}
		
		return true;
	}
	
	// Validate password
	private boolean validatePassword(String pw) {
		if (pw.length() < 6) {
			System.out.println("Password must be at least 6 characters.");
			return false;
		}
		
		return true;
	}
}
