package com.revature.driver;

import com.revature.views.user.UserHomeMenu;

public class Driver {
	public static void main(String[] args) {
		// Initialize services
		
		// Display home menu
		UserHomeMenu uhm = new UserHomeMenu();
		uhm.getResponse(uhm.display());
	}
}
