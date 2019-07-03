package com.revature.views.employee;

import java.util.ArrayList;

import com.revature.views.Menu;
import com.revature.views.car.CarEditMenu;
import com.revature.views.car.CarListView;
import com.revature.views.user.UserHomeMenu;

public class EmployeeHomeMenu extends Menu {
	public EmployeeHomeMenu() {
		this.menuItems = new ArrayList<String>();
		this.menuItems.add("Logout");
		this.menuItems.add("View Cars");
		this.menuItems.add("Add/Remove/Edit Car");
		this.menuItems.add("Accept/Reject Offer");
		this.menuItems.add("View Customer Payments");
	}
	
	@Override
	public void redirect(int option) {
		EmployeeHomeMenu ehm = new EmployeeHomeMenu();
		CarListView clv = new CarListView();
		UserHomeMenu uhm = new UserHomeMenu();
		CarEditMenu cem = new CarEditMenu();
		EmployeeOfferMenu eom = new EmployeeOfferMenu();
		
		switch (option) {
		case 0:
			uhm.redirect(uhm.display());
			break;
		case 1:
			clv.display();
			ehm.redirect(ehm.display());
			break;
		case 2:
			cem.redirect(cem.display());
			ehm.redirect(ehm.display());
			break;
		case 3:
			eom.redirect(eom.display());
			ehm.redirect(ehm.display());
			break;
		case 4:
			System.out.println("Do View Customer Payments");
			ehm.redirect(ehm.display());
			break;
		default:
			break;
		}
	}
}
