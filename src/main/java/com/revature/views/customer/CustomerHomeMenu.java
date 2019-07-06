package com.revature.views.customer;

import com.revature.views.Menu;
import com.revature.views.car.CarListView;
import com.revature.views.offer.OfferCreateAction;
import com.revature.views.user.UserHomeMenu;

import java.util.ArrayList;

 public class CustomerHomeMenu extends Menu {
	CustomerHomeMenu() {
		this.menuItems = new ArrayList<String>();
		this.menuItems.add("Logout");
		this.menuItems.add("View Available Cars");
		this.menuItems.add("Make Offer");
		this.menuItems.add("My Cars");
		this.menuItems.add("My Payments");
	}

 	@Override
	public void redirect(int option) {
 		CustomerHomeMenu chm = new CustomerHomeMenu();
 		CarListView clv = new CarListView();
 		OfferCreateAction oca = new OfferCreateAction();
 		UserHomeMenu uhm = new UserHomeMenu();
 		CustomerCarListView cclv = new CustomerCarListView();
 		CustomerPaymentMenu cpm = new CustomerPaymentMenu();
 		
 		switch (option) {
		case 0:
			uhm.redirect(uhm.display());
			break;
		case 1:
			clv.display();
			chm.redirect(chm.display());
			break;
		case 2:
			oca.run();
			chm.redirect(chm.display());
			break;
		case 3:
			cclv.display();
			chm.redirect(chm.display());
			break;
		case 4:
			cpm.redirect(cpm.display());
			chm.redirect(chm.display());
			break;
		default:
			break;
		}
	}
}
