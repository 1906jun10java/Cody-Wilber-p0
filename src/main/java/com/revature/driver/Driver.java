package com.revature.driver;

import com.revature.views.user.UserHomeMenu;

public class Driver {	
	public static void main(String[] args) {
		UserHomeMenu uhm = new UserHomeMenu();
		uhm.redirect(uhm.display());
	}
}
