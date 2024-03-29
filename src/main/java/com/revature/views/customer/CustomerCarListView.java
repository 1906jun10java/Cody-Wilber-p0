package com.revature.views.customer;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.services.CarService;
import com.revature.services.CustomerService;

import java.math.RoundingMode;
import java.util.List;

public class CustomerCarListView {
	private static CustomerService cus = CustomerService.getInstance();
	private static CarService cs = CarService.getInstance();
	
	CustomerCarListView() {}
	
	public void display() {
		Customer customer = cus.getCurrentCustomer();
		
		List<Car> cars = cs.getCustomerCars(customer.getId());
		System.out.println();
		if (cars == null) {
			System.out.println("\nNo cars to display.");
			return;
		}
		for (Car c : cars) {
			System.out.println("ID:\t\t\t" + c.getId());
			System.out.println("Year:\t\t" + c.getYear());
			System.out.println("Make:\t\t" + c.getMake());
			System.out.println("Model:\t\t" + c.getModel());
			System.out.println("Mileage:\t" + c.getMileage());
			System.out.println("Price:\t\t$" +
				c.getPrice().setScale(2, RoundingMode.HALF_UP));
			System.out.println("Balance:\t$" +
				c.getBalance().setScale(2, RoundingMode.HALF_UP));
			System.out.println();
		}
	}
}
