package com.revature.views.user;

import java.util.ArrayList;

import com.revature.views.Menu;

public class UserHomeMenu extends Menu {
	public UserHomeMenu() {
		this.menuItems = new ArrayList<String>();
		this.menuItems.add("Exit");
		this.menuItems.add("Login");
		this.menuItems.add("Register");
	}

	@Override
	public void getResponse(int option) {
		switch (option) {
		case 0:
			return;
		case 1:
			System.out.println("Do Login");
			break;
		case 2:
			System.out.println("Do Registration");
			break;
		default:
			break;
		}
	}
}
