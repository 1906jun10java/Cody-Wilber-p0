package com.revature.views.car;

import com.revature.beans.Car;
import com.revature.services.CarService;

public class CarListView {
	private static CarService cs = CarService.getInstance();
	
	public CarListView() {}
	
	public void display() {
		int count = 0;
		System.out.println();
		for (Car c : cs.getCars()) {
			if (c.getOwnerId() == null) {
				System.out.println("ID:\t\t" + c.getId());
				System.out.println("Year:\t\t" + c.getYear());
				System.out.println("Make:\t\t" + c.getMake());
				System.out.println("Model:\t\t" + c.getModel());
				System.out.println("Mileage:\t" + c.getMileage());
				System.out.println("Price:\t\t$" + c.getPrice().setScale(2));
				System.out.println();
				count++;
			}
		}
		if (count == 0) {
			System.out.println("No cars currently on the lot.");
			System.out.println("Come back soon.");
		}
	}
}
