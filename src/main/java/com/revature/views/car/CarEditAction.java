package com.revature.views.car;

import com.revature.beans.Car;
import com.revature.services.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarEditAction {
	private static CarService cs = CarService.getInstance();
	private static Scanner sc = new Scanner(System.in);
	private final static Logger logger = LogManager.getLogger(CarEditAction.class);
	
	CarEditAction() {}
	
	public void run() {
		Integer carId = cs.getCarIdInput();
		
		Car c = cs.getCar(carId);
		int option = 0;
		if (c != null) {
			System.out.println("\nWhich component to edit?");
			System.out.println("0. Back");
			System.out.println("1. Year");
			System.out.println("2. Make");
			System.out.println("3. Model");
			System.out.println("4. Mileage");
			System.out.println("5. Price");
			System.out.print(">>> ");
			try {
				option = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
			}
		}
		
		switch (option) {
		case 0:
			return;
		case 1:
			c.setYear(getYearInput());
			break;
		case 2:
			c.setMake(getMakeInput());
			break;
		case 3:
			c.setModel(getModelInput());
			break;
		case 4:
			c.setMileage(getMileageInput());
			break;
		case 5:
			c.setPrice(getPriceInput());
		default:
			break;
		}
		
		cs.updateCar(c);
		System.out.println("\nCar updated.");
		logger.info("CAR " + carId + " UPDATED");
	}
	
	// Get vehicle year
	private Integer getYearInput() {
		int year;
		while (true) {
			System.out.println("Enter vehicle's year:");
			System.out.print(">>> ");
			try {
				year = sc.nextInt();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				sc.nextLine();
			}
		}
		
		return year;
	}
	
	// Get vehicle make from user
	private String getMakeInput() {
		String make;
		System.out.println("Enter vehicle's make:");
		System.out.print(">>> ");
		make = sc.nextLine();
		
		return make;
	}
	
	// Get vehicle model from user
	private String getModelInput() {
		String model;
		System.out.println("Enter vehicle's model:");
		System.out.print(">>> ");
		model = sc.nextLine();
		
		return model;
	}
	
	// Get vehicle mileage from user
	private Integer getMileageInput() {
		int mileage;
		while (true) {
			System.out.println("Enter vehicle's mileage:");
			System.out.print(">>> ");
			try {
				mileage = sc.nextInt();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				sc.nextLine();
			}
		}
		
		return mileage;
	}
	
	// Get vehicle price from user
	private BigDecimal getPriceInput() {
		BigDecimal price;
		while (true) {
			System.out.println("Enter vehicle's price:");
			System.out.print(">>> ");
			try {
				price = new BigDecimal(sc.nextDouble());
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				sc.nextLine();
			}
		}
		
		return price;
	}
}
