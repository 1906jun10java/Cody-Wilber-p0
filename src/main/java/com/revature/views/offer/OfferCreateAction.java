package com.revature.views.offer;

import com.revature.beans.Car;
import com.revature.beans.Offer;
import com.revature.services.CarService;
import com.revature.services.CustomerService;
import com.revature.services.OfferService;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OfferCreateAction {
	private static OfferService os = OfferService.getInstance();
	private static CarService cs = CarService.getInstance();
	private static CustomerService cus = CustomerService.getInstance();
	private static Scanner sc = new Scanner(System.in);
	
	public OfferCreateAction() {}
	
	public void run() {
		Integer carId = getCarIdInput();
		BigDecimal offer = getOfferAmountInput();
		
		Offer o = new Offer(carId, cus.getCurrentCustomer().getId(), offer);
		os.saveOffer(o);
		System.out.println("\nOffer received.");
	}
	
	// Get car id from user
	private Integer getCarIdInput() {
		int id = 0;
		while (true) {
			System.out.println("Enter vehicle ID number:");
			System.out.print(">>> ");
			try {
				id = sc.nextInt();
				Car c = cs.getCar(id);
				System.out.println(c.getOwnerId());
				if (cs.getCar(id) == null || cs.getCar(id).getOwnerId() != 0) {
					throw new Exception();
				}
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Car " + id + " does not exist.");
			}
		}
		
		return id;
	}
	
	// Get offer amount from user
	private BigDecimal getOfferAmountInput() {
		BigDecimal offer;
		while (true) {
			System.out.println("Enter amount to offer:");
			System.out.print(">>> ");
			try {
				offer = new BigDecimal(sc.nextDouble());
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				sc.nextLine();
			}
		}
		
		return offer;
	}
}
