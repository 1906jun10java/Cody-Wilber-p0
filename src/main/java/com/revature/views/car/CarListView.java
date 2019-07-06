package com.revature.views.car;

import com.revature.beans.Car;
import com.revature.services.CarService;

import java.math.RoundingMode;
import java.util.List;

public class CarListView {
	private static CarService cs = CarService.getInstance();
	
	public CarListView() {}
	
	public void display() {
		List<Car> cars = cs.getUnownedCars();
		if (cars == null) {
			System.out.println("\nNo cars currently on the lot.");
			System.out.println("Come back soon.");
			return;
		}

		for (Car c : cs.getUnownedCars()) {
			System.out.println("\nID:\t\t\t" + c.getId());
			System.out.println("Year:\t\t" + c.getYear());
			System.out.println("Make:\t\t" + c.getMake());
			System.out.println("Model:\t\t" + c.getModel());
			System.out.println("Mileage:\t" + c.getMileage());
			System.out.println("Price:\t\t$" +
				c.getPrice().setScale(2, RoundingMode.HALF_UP));
		}
	}
}
