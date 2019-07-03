package com.revature.views.user;

import java.util.ArrayList;

import com.revature.views.Menu;
import com.revature.views.customer.CustomerRegisterAction;
import com.revature.views.employee.EmployeeRegisterAction;

public class UserRegisterMenu extends Menu {
	public UserRegisterMenu() {
		this.menuItems = new ArrayList<String>();
		this.menuItems.add("Back");
		this.menuItems.add("Customer");
		this.menuItems.add("Employee");
	}
	
	@Override
	public void redirect(int option) {
		UserHomeMenu uhm = new UserHomeMenu();
 		CustomerRegisterAction cra = new CustomerRegisterAction();
 		EmployeeRegisterAction era = new EmployeeRegisterAction();
 		
		switch (option) {
		case 0:
			uhm.redirect(uhm.display());
			break;
		case 1:
			cra.run();
			break;
		case 2:
			era.run();
			break;
		default:
			break;
		}
	}
}
