package com.revature.views.customer;

import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.services.CustomerService;

public class CustomerRegisterAction {
	private static CustomerService cs = CustomerService.getInstance();
	private Scanner sc = new Scanner(System.in);
	
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
		
		// Redirect to login
		CustomerLoginAction cla = new CustomerLoginAction();
		cla.run();
	}
	
	// Get username from user
	public String getUsername() {
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
	public String getPassword() {
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
	public boolean validateUsername(String un) {
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
	public boolean validatePassword(String pw) {
		if (pw.length() < 6) {
			System.out.println("Password must be at least 6 characters.");
			return false;
		}
		
		return true;
	}
}
