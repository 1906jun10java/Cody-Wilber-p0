package com.revature.views.customer;

import java.util.ArrayList;

import com.revature.views.Menu;

public class CustomerPaymentMenu extends Menu {
	public CustomerPaymentMenu() {
		this.menuItems = new ArrayList<String>();
		this.menuItems.add("Back");
		this.menuItems.add("Display Payments");
		this.menuItems.add("Make a Payment");
	}
	
	@Override
	public void redirect(int option) {
		CustomerPaymentMenu cpm = new CustomerPaymentMenu();
		CustomerHomeMenu chm = new CustomerHomeMenu();
		CustomerPaymentAction cpa = new CustomerPaymentAction();
		
		switch (option) {
		case 0:
			chm.redirect(chm.display());
			break;
		case 1:
			System.out.println("Do Display Payments");
			cpm.redirect(cpm.display());
			break;
		case 2:
			cpa.run();
			cpm.redirect(cpm.display());
			break;
		default:
			break;
		}
	}
}
