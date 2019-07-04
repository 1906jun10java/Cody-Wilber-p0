package com.revature.driver;

import com.revature.services.*;
import com.revature.views.user.UserHomeMenu;

public class Driver {	
	public static void main(String[] args) {
		// Initialize services
		CustomerService customerService = CustomerService.getInstance();
		EmployeeService employeeService = EmployeeService.getInstance();
		CarService carService = CarService.getInstance();
		OfferService offerService = OfferService.getInstance();
		PaymentService paymentService = PaymentService.getInstance();
		
		// Load data
		customerService.loadCustomers();
		employeeService.loadEmployees();
		carService.loadCars();
		offerService.loadOffers();
		paymentService.loadPayments();
		
		// Display home menu
		UserHomeMenu uhm = new UserHomeMenu();
		uhm.redirect(uhm.display());
	}
}
