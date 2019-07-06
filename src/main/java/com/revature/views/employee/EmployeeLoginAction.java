package com.revature.views.employee;

import com.revature.beans.Employee;
import com.revature.services.EmployeeService;
import com.revature.views.user.UserHomeMenu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class EmployeeLoginAction {
	private static EmployeeService es = EmployeeService.getInstance();
	private static Scanner sc = new Scanner(System.in);
	private final static Logger logger = LogManager.getLogger(EmployeeLoginAction.class);
	
	public EmployeeLoginAction() {}
	
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
			es.setCurrentEmployee(validateCredentials(username, password));
			if (es.getCurrentEmployee() != null) {
				notValidLogin = false;
				System.out.println("\nCredentials accepted. Logging in...");
				logger.info("EMPLOYEE " + es.getCurrentEmployee().getId() +
						" LOGGED IN");
				
				// Redirect to customer home menu
				EmployeeHomeMenu ehm = new EmployeeHomeMenu();
				ehm.redirect(ehm.display());
			} else {
				loginCount++;
			}
		}
		
		// Login failed, redirect to home menu
		UserHomeMenu uhm = new UserHomeMenu();
		uhm.redirect(uhm.display());
	}
	
	private Employee validateCredentials(String un, String pw) {
		Employee e = es.getEmployee(un);
		if (e != null && e.getUsername().equals(un)) {
			if (e.getPassword().equals(pw)) {
				return e;
			} else {
				System.out.println("\nInvalid credentials.");
				return null;
			}
		}
		System.out.println("No employee \"" + un + "\" found.");
		return null;
	}
}
