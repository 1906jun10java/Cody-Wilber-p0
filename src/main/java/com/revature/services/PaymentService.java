package com.revature.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import com.revature.beans.Car;
import com.revature.beans.Payment;

public class PaymentService {
	private static PaymentService instance;
	private static ArrayList<Payment> payments = new ArrayList<Payment>();
	private static Scanner sc = new Scanner(System.in);
	private static CarService cs = CarService.getInstance();
	private final BigDecimal TERM12 = BigDecimal.valueOf(12);
	private final BigDecimal TERM24 = BigDecimal.valueOf(24);
	private final BigDecimal TERM36 = BigDecimal.valueOf(36);
	private final BigDecimal TERM48 = BigDecimal.valueOf(48);
	private final BigDecimal TERM60 = BigDecimal.valueOf(60);
	private final BigDecimal TERM72 = BigDecimal.valueOf(72);
	
	private PaymentService() {}
	
	// Return singleton instance
	public static synchronized PaymentService getInstance() {
		if (instance == null) {
			instance = new PaymentService();
		}
		return instance;
	}
	
	// Load payments
	@SuppressWarnings("unchecked")
	public void loadPayments() {
		try {
			FileInputStream fis = new FileInputStream("Payments.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			payments = (ArrayList<Payment>)ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	// Save payments
	public void savePayments() {
		try {
			FileOutputStream fos = new FileOutputStream("Payments.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(payments);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Add car payment
	public void addPayment(Payment p) {
		payments.add(p);
		savePayments();
	}

	// Get car payments
	public ArrayList<Payment> getPayments(Car c) {
		ArrayList<Payment> carPayments = new ArrayList<Payment>();
		for (Payment p : payments) {
			if (p.getCarId().equals(c.getId())) {
				carPayments.add(p);
			}
		}

		return carPayments;
	}

	// Calculate monthly payments depending on car price
	public BigDecimal calcMonthlyPayment(Car c) {
		BigDecimal carPrice = c.getPrice();
		if (carPrice.compareTo(BigDecimal.valueOf(1000)) < 0) {
			return carPrice.divide(TERM12, 2, RoundingMode.HALF_UP);
		} else if (carPrice.compareTo(BigDecimal.valueOf(2000)) < 0) {
			return carPrice.divide(TERM24, 2, RoundingMode.HALF_UP);
		} else if (carPrice.compareTo(BigDecimal.valueOf(5000)) < 0) {
			return carPrice.divide(TERM36, 2, RoundingMode.HALF_UP);
		} else if (carPrice.compareTo(BigDecimal.valueOf(8500)) < 0) {
			return carPrice.divide(TERM48, 2, RoundingMode.HALF_UP);
		} else if (carPrice.compareTo(BigDecimal.valueOf(12000)) < 0) {
			return carPrice.divide(TERM60, 2, RoundingMode.HALF_UP);
		} else {
			return carPrice.divide(TERM72, 2, RoundingMode.HALF_UP);
		}
	}

	// Update balance of car
	public void updateCarBalance(Car c) {
		ArrayList<Payment> carPayments = getPayments(c);
		BigDecimal monthlyPayment = calcMonthlyPayment(c);
		BigDecimal carBalance = c.getPrice();

		for (Payment p : carPayments) {
			carBalance = carBalance.subtract(p.getAmount());
		}
		if (carBalance.compareTo(BigDecimal.ZERO) < 0) {
			carBalance = BigDecimal.valueOf(0.00);
		}
		c.setBalance(carBalance);
		cs.updateCar(c);
	}

	// Print out payment
	public void printPayment(Payment p) {
		Car c = cs.getCar(p.getCarId());
		System.out.println("\nPayment " + p.getId() + ":");
		System.out.println(c.getYear() + " " + c.getMake() + " " + c.getModel());
		System.out.println("Paid $" + p.getAmount());
	}
}
