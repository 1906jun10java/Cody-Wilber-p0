package com.revature.views.car;

import com.revature.services.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarRemoveAction {
	private static CarService cs = CarService.getInstance();
	final static Logger logger = LogManager.getLogger(CarRemoveAction.class);
	
	CarRemoveAction() {}
	
	public void run() {
		Integer carId = cs.getCarIdInput();
		
		if (carId != null) {
			cs.deleteCar(carId);
			System.out.println("\nCar deleted.");
			logger.info("CAR " + carId + " DELETED");
		} else {
			System.out.println("\nCar " + carId + " does not exist.");
		}
	}
}
