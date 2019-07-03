package com.revature.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Payment;

public class PaymentService {
	private static PaymentService instance;
	private static ArrayList<Payment> payments = new ArrayList<Payment>();
	private static Scanner sc = new Scanner(System.in);
	
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
}
