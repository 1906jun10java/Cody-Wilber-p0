package com.revature.driver;

import com.revature.services.CarService;
import com.revature.services.CustomerService;
import com.revature.services.EmployeeService;
import com.revature.services.OfferService;
import com.revature.views.user.UserHomeMenu;

public class Driver {	
	public static void main(String[] args) {
		// Initialize services
		CustomerService customerService = CustomerService.getInstance();
		EmployeeService employeeService = EmployeeService.getInstance();
		CarService carService = CarService.getInstance();
		OfferService offerService = OfferService.getInstance();
		
		// Load data
		customerService.loadCustomers();
		employeeService.loadEmployees();
		carService.loadCars();
		offerService.loadOffers();
		
		// Display home menu
		UserHomeMenu uhm = new UserHomeMenu();
		uhm.redirect(uhm.display());
	}
}
