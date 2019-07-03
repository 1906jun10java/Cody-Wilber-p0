package com.revature.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

import com.revature.beans.Car;

public class CarService {
	private static CarService instance;
	private static ArrayList<Car> cars = new ArrayList<Car>();
	private static Scanner sc = new Scanner(System.in);
	
	private CarService() {}
	
	// Return singleton instance
	public static synchronized CarService getInstance() {
		if (instance == null) {
			instance = new CarService();
		}
		return instance;
	}
	
	// Load cars
	@SuppressWarnings("unchecked")
	public void loadCars() {
		try {
			FileInputStream fis = new FileInputStream("Cars.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			cars = (ArrayList<Car>)ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Save cars
	public void saveCars() {
		try {
			FileOutputStream fos = new FileOutputStream("Cars.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cars);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Get all cars
	public ArrayList<Car> getCars() {
		return cars;
	}
	
	// Save car to cars
	public void saveCar(Car c) {
		cars.add(c);
		saveCars();
	}
	
	// Get car from cars
	public Car getCar(Integer id) {
		for (Car c : cars) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	// Get cars owned by a customer
	public ArrayList<Car> getCustomerCars(Integer customerId) {
		ArrayList<Car> customerCars = new ArrayList<Car>();
		
		for (Car c : cars) {
			if (c.getOwnerId().equals(customerId)) {
				customerCars.add(c);
			}
		}
		
		return customerCars;
	}
	
	// Update car
	public void updateCar(Car c) {
		ListIterator<Car> it = cars.listIterator();
		while (it.hasNext()) {
			if (it.next().getId().equals(c.getId())) {
				it.remove();
				it.add(c);
				saveCars();
				break;
			}
		}
	}
	
	// Delete car from cars
	public void deleteCar(Integer id) {
		ListIterator<Car> it = cars.listIterator();
		while (it.hasNext()) {
			if (it.next().getId().equals(id)) {
				it.remove();
				saveCars();
				break;
			}
		}
	}
	
	// Get car id from user
	public Integer getCarIdInput() {
		Integer id = 0;
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
