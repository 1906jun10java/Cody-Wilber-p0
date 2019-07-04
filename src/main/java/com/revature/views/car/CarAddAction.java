package com.revature.views.car;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.beans.Car;
import com.revature.services.CarService;

public class CarAddAction {
	private static CarService cs = CarService.getInstance();
	private static Scanner sc = new Scanner(System.in);
	
	public CarAddAction() {}
	
	public void run() {
		Integer year = getYearInput();
		String make = getMakeInput();
		String model = getModelInput();
		Integer mileage = getMileageInput();
		BigDecimal price = getPriceInput();
		
		Car c = new Car(year, make, model, mileage, price);
		cs.saveCar(c);
		System.out.println("\nCar added.");
	}
	
	// Get vehicle year
	private Integer getYearInput() {
		int year = 0;
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
		String make = "";
		System.out.println("Enter vehicle's make:");
		System.out.print(">>> ");
		make = sc.nextLine();
		
		return make;
	}
	
	// Get vehicle model from user
	private String getModelInput() {
		String model = "";
		System.out.println("Enter vehicle's model:");
		System.out.print(">>> ");
		model = sc.nextLine();
		
		return model;
	}
	
	// Get vehicle mileage from user
	private Integer getMileageInput() {
		int mileage = 0;
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
