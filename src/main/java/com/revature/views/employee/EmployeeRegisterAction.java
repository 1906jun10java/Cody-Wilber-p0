package com.revature.views.employee;

import com.revature.beans.Employee;
import com.revature.services.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class EmployeeRegisterAction {
	private static EmployeeService es = EmployeeService.getInstance();
	private Scanner sc = new Scanner(System.in);
	private final static Logger logger = LogManager.getLogger(EmployeeRegisterAction.class);
	
	public EmployeeRegisterAction() {}
	
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
		
		// Create employee and save
		Employee e = new Employee(firstName, lastName, username, password);
		es.saveEmployee(e);
		logger.info("NEW EMPLOYEE REGISTERED");
		
		// Redirect to login
		EmployeeLoginAction cla = new EmployeeLoginAction();
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

		Employee e = es.getEmployee(un);
		if (e != null) {
			System.out.println("Username is taken.");
			return false;
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