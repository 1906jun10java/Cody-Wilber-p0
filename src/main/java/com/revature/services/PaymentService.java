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
	private final BigDecimal TERM = BigDecimal.valueOf(48);
	
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
		ListIterator<Payment> it = payments.listIterator();
		while (it.hasNext()) {
			Payment p = it.next();
			if (p.getCarId().equals(c.getId())) {
				carPayments.add(p);
			}
		}

		return carPayments;
	}

	// Calculate monthly payments
	public BigDecimal calcMonthlyPayment(Car c) {
		return c.getPrice().divide(TERM, 2, RoundingMode.HALF_UP);
	}

	// Update balance of car
	public BigDecimal getNewCarBalance(Car c) {
		ArrayList<Payment> carPayments = getPayments(c);
		BigDecimal monthlyPayment = calcMonthlyPayment(c);
		BigDecimal carBalance = c.getPrice();

		for (Payment p : carPayments) {
			carBalance = carBalance.subtract(p.getAmount());
		}

		return carBalance;
	}
}
