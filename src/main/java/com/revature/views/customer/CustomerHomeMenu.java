package com.revature.views.customer;

import java.util.ArrayList;

import com.revature.views.Menu;
import com.revature.views.user.UserHomeMenu;

public class CustomerHomeMenu extends Menu {
	public CustomerHomeMenu() {
		this.menuItems = new ArrayList<String>();
		this.menuItems.add("Logout");
		this.menuItems.add("View Available Cars");
		this.menuItems.add("Make Offer");
		this.menuItems.add("View My Cars");
		this.menuItems.add("View My Payments");
	}
	
	@Override
	public void getResponse(int option) {
		switch (option) {
		case 0:
			UserHomeMenu uhm = new UserHomeMenu();
			uhm.getResponse(uhm.display());
			break;
		case 1:
			System.out.println("Do View Available Cars");
			break;
		case 2:
			System.out.println("Do Make Offer");
			break;
		case 3:
			System.out.println("Do View My Cars");
			break;
		case 4:
			System.out.println("Do View My Payments");
			break;
		default:
			break;
		}
	}
}
