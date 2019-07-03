package com.revature.views.user;

import java.util.ArrayList;

import com.revature.views.Menu;

public class UserLoginMenu extends Menu {
	public UserLoginMenu() {
		this.menuItems = new ArrayList<String>();
		this.menuItems.add("Back");
		this.menuItems.add("Customer");
		this.menuItems.add("Employee");
	}
	
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
			break;
		default:
			break;
		}
	}
}
