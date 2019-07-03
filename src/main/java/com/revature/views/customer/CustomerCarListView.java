package com.revature.views.customer;

import java.util.ArrayList;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.services.CarService;
import com.revature.services.CustomerService;

public class CustomerCarListView {
	private static CustomerService cus = CustomerService.getInstance();
	private static CarService cs = CarService.getInstance();
	
	public CustomerCarListView() {}
	
	public void display() {
		Customer customer = cus.getCurrentCustomer();
		
		ArrayList<Car> cars = cs.getCustomerCars(customer.getId());
		System.out.println();
		for (Car c : cars) {
			System.out.println("ID:\t\t\t" + c.getId());
			System.out.println("Year:\t\t" + c.getYear());
			System.out.println("Make:\t\t" + c.getMake());
			System.out.println("Model:\t\t" + c.getModel());
			System.out.println("Mileage:\t" + c.getMileage());
			System.out.println("Price:\t\t$" + c.getPrice().setScale(2));
			System.out.println("Balance:\t$" + c.getBalance().setScale(2));
			System.out.println();
		}
	}
}
