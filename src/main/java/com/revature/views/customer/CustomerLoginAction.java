package com.revature.views.customer;

import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.services.CustomerService;
import com.revature.views.user.UserHomeMenu;

public class CustomerLoginAction {
	private static CustomerService cs = CustomerService.getInstance();
	private static Scanner sc = new Scanner(System.in);
	
	public CustomerLoginAction() {}
	
	public void run() {
		int loginCount = 0;
		boolean notValidLogin = true;
		while (notValidLogin && loginCount < 3) {
			System.out.println();
			System.out.println("Please log in");
			System.out.println("Enter username:");
			System.out.print(">>> ");
			String username = sc.nextLine();
			System.out.println("Enter password:");
			System.out.print(">>> ");
			String password = sc.nextLine();
			
			// Validate
			cs.setCurrentCustomer(validateCredentials(username, password));
			if (cs.getCurrentCustomer() != null) {
				notValidLogin = false;
				System.out.println("\nCredentials accepted. Logging in...");
				
				// Redirect to customer home menu
				CustomerHomeMenu chm = new CustomerHomeMenu();
				chm.redirect(chm.display());
			} else {
				loginCount++;
			}
		}
		
		// Login failed, redirect to home menu
		UserHomeMenu uhm = new UserHomeMenu();
		uhm.redirect(uhm.display());
	}
	
	private Customer validateCredentials(String un, String pw) {
		Customer c = cs.getCustomer(un);
		if (c != null && c.getUsername().equals(un)) {
			if (c.getPassword().equals(pw)) {
				return c;
			} else {
				System.out.println("Invalid credentials.");
				return null;
			}
		}
		System.out.println("No user \"" + un + "\" found.");
		return null;
	}
}
