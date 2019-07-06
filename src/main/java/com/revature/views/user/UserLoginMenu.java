package com.revature.views.user;

 import java.util.ArrayList;

import com.revature.views.Menu;
import com.revature.views.customer.CustomerLoginAction;
import com.revature.views.employee.EmployeeLoginAction;

 public class UserLoginMenu extends Menu {
	UserLoginMenu() {
		this.menuItems = new ArrayList<String>();
		this.menuItems.add("Back");
		this.menuItems.add("Customer");
		this.menuItems.add("Employee");
	}

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
			break;
		default:
			break;
		}
	}
}
