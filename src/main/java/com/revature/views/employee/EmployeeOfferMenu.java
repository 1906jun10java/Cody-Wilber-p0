package com.revature.views.employee;

import java.util.ArrayList;

import com.revature.views.Menu;
import com.revature.views.offer.OfferAcceptAction;
import com.revature.views.offer.OfferListView;
import com.revature.views.offer.OfferRejectAction;

public class EmployeeOfferMenu extends Menu {
	EmployeeOfferMenu() {
		this.menuItems = new ArrayList<String>();
		this.menuItems.add("Back");
		this.menuItems.add("View Offers");
		this.menuItems.add("Accept Offer");
		this.menuItems.add("Reject Offer");
	}
	
	@Override
	public void redirect(int option) {
		EmployeeHomeMenu ehm = new EmployeeHomeMenu();
		EmployeeOfferMenu eom = new EmployeeOfferMenu();
		OfferListView olv = new OfferListView();
		OfferAcceptAction oaa = new OfferAcceptAction();
		OfferRejectAction ora = new OfferRejectAction();
		
		switch (option) {
		case 0:
			ehm.redirect(ehm.display());
			break;
		case 1:
			olv.display();
			eom.redirect(eom.display());
			break;
		case 2:
			oaa.run();
			eom.redirect(eom.display());
			break;
		case 3:
			ora.run();
			eom.redirect(eom.display());
			break;
		default:
			break;
		}
	}
}
