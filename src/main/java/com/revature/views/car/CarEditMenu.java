package com.revature.views.car;

import java.util.ArrayList;

import com.revature.views.Menu;
import com.revature.views.employee.EmployeeHomeMenu;

public class CarEditMenu extends Menu {
	public CarEditMenu() {
		this.menuItems = new ArrayList<String>();
		this.menuItems.add("Back");
		this.menuItems.add("Add Car");
		this.menuItems.add("Edit Car");
		this.menuItems.add("Remove Car");
	}
	
	@Override
	public void redirect(int option) {
		CarEditMenu cem = new CarEditMenu();
		EmployeeHomeMenu ehm = new EmployeeHomeMenu();
		CarAddAction caa = new CarAddAction();
		CarRemoveAction cra = new CarRemoveAction();
		CarEditAction cea = new CarEditAction();
		
		switch (option) {
		case 0:
			ehm.redirect(ehm.display());
			break;
		case 1:
			caa.run();
			cem.redirect(cem.display());
			break;
		case 2:
			cea.run();
			cem.redirect(cem.display());
			break;
		case 3:
			cra.run();
			cem.redirect(cem.display());
			break;
		default:
			break;
		}
	}
}
