package com.revature.views.user;

<<<<<<< HEAD
 import java.util.ArrayList;

import com.revature.views.Menu;
import com.revature.views.customer.CustomerLoginAction;
import com.revature.views.employee.EmployeeLoginAction;

 public class UserLoginMenu extends Menu {
=======
import java.util.ArrayList;

import com.revature.views.Menu;

public class UserLoginMenu extends Menu {
>>>>>>> 59120d8ff72ffcff9a80418e4baaab6f55dcfad3
	public UserLoginMenu() {
		this.menuItems = new ArrayList<String>();
		this.menuItems.add("Back");
		this.menuItems.add("Customer");
		this.menuItems.add("Employee");
	}
<<<<<<< HEAD

 	@Override
	public void redirect(int option) {
 		UserHomeMenu uhm = new UserHomeMenu();
 		CustomerLoginAction cla = new CustomerLoginAction();
 		EmployeeLoginAction ela = new EmployeeLoginAction();
 		
		switch (option) {
		case 0:
			uhm.redirect(uhm.display());
			break;
		case 1:
			cla.run();
			break;
		case 2:
			ela.run();
=======
	
	@Override
	public void getResponse(int option) {
		switch (option) {
		case 0:
			UserHomeMenu uhm = new UserHomeMenu();
			uhm.getResponse(uhm.display());
			break;
		case 1:
			System.out.println("Do Customer Login");
			break;
		case 2:
			System.out.println("Do Employee Login");
>>>>>>> 59120d8ff72ffcff9a80418e4baaab6f55dcfad3
			break;
		default:
			break;
		}
	}
}
