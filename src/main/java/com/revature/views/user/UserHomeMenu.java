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
	public void redirect(int option) {
		UserLoginMenu ulm = new UserLoginMenu();
		UserRegisterMenu urm = new UserRegisterMenu();
		
		switch (option) {
		case 0:
			System.out.println("\nGoodbye.");
			System.exit(0);
		case 1:
			ulm.redirect(ulm.display());
			break;
		case 2:
			urm.redirect(urm.display());
			break;
		default:
			break;
		}
	}
}
