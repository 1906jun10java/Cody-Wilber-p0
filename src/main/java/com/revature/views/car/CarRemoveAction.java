package com.revature.views.car;

import com.revature.services.CarService;

public class CarRemoveAction {
	private static CarService cs = CarService.getInstance();
	
	CarRemoveAction() {}
	
	public void run() {
		Integer carId = cs.getCarIdInput();
		
		if (carId != null) {
			cs.deleteCar(carId);
			System.out.println("\nCar deleted.");
		} else {
			System.out.println("\nCar " + carId + " does not exist.");
		}
	}
}
