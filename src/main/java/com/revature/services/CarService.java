package com.revature.services;

import com.revature.beans.Car;
import com.revature.dao.CarDAOImpl;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CarService {
	private static CarService instance;
	private static CarDAOImpl cdi = new CarDAOImpl();
	private static Scanner sc = new Scanner(System.in);
	
	private CarService() {}
	
	// Return singleton instance
	public static synchronized CarService getInstance() {
		if (instance == null) {
			instance = new CarService();
		}
		return instance;
	}
	
	// Save car
	public void saveCar(Car c) {
		try {
			cdi.saveCar(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Get all unowned cars
	public List<Car> getUnownedCars() {
		try {
			return cdi.getUnownedCars();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Get car
	public Car getCar(Integer id) {
		try {
			return cdi.getCar(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Update car
	public void updateCar(Car c) {
		try {
			cdi.updateCar(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete car
	public void deleteCar(int id) {
		try {
			cdi.deleteCar(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Get cars owned by a customer
	public List<Car> getCustomerCars(Integer customerId) {
		try {
			return cdi.getCustomerCars(customerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Get car id from user
	public Integer getCarIdInput() {
		int id;
		while (true) {
			System.out.println("Enter vehicle's ID:");
			System.out.print(">>> ");
			try {
				id = sc.nextInt();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				sc.nextLine();
			}
		}
		
		return id;
	}
}
