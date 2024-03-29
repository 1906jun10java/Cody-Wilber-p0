package com.revature.views.offer;

import com.revature.beans.Offer;
import com.revature.services.CarService;
import com.revature.services.OfferService;

import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OfferListView {
	private static OfferService os = OfferService.getInstance();
	private static CarService cs = CarService.getInstance();
	private static Scanner sc = new Scanner(System.in);
	
	public OfferListView() {}
	
	public void display() {
		Integer carId = getCarIdInput();
		System.out.println();
		System.out.println("Offers for " + carId + ":\n");
		for (Offer o : os.getOffersByCar(carId)) {
			System.out.println("Offer:\t\t" + o.getId());
			System.out.println("Customer:\t" + o.getCustomerId());
			System.out.println("Amount:\t\t$" +
				o.getAmount().setScale(2, RoundingMode.HALF_UP));
			System.out.println("Status:\t\t" + o.getStatus());
			System.out.println();
		}
	}
	
	// Get car id from user
	private Integer getCarIdInput() {
		Integer id = 0;
		while (true) {
			System.out.println("Enter vehicle ID number:");
			System.out.print(">>> ");
			try {
				id = sc.nextInt();
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
}
