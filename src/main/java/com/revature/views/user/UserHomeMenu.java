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
}
