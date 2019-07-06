package com.revature.services;

import com.revature.beans.Car;
import com.revature.beans.Payment;
import com.revature.dao.PaymentDAOImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.List;

public class PaymentService {
	private static PaymentService instance;
	private static PaymentDAOImpl pdi = new PaymentDAOImpl();
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

	// Add car payment
	public void savePayment(Payment p) {
		try {
			pdi.savePayment(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Get car payments
	public List<Payment> getCarPayments(Car c) {
		try {
			return pdi.getCarPayments(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
		List<Payment> carPayments = getCarPayments(c);
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
		System.out.println("Paid $" + p.getAmount().setScale(2, RoundingMode.HALF_UP));
	}
}
