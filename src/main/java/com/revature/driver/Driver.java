package com.revature.driver;

import com.revature.views.user.UserHomeMenu;

public class Driver {
	public static void main(String[] args) {
		// Initialize services
		
		// Display home menu
		UserHomeMenu uhm = new UserHomeMenu();
		switch (uhm.display()) {
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
