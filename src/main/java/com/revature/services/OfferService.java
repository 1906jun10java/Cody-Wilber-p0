package com.revature.services;

import com.revature.beans.Offer;
import com.revature.dao.OfferDAOImpl;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OfferService {
	private static OfferService instance;
	private static OfferDAOImpl odi = new OfferDAOImpl();
	private static Scanner sc = new Scanner(System.in);
	
	private OfferService() {}
	
	// Return singleton instance
	public static synchronized OfferService getInstance() {
		if (instance == null) {
			instance = new OfferService();
		}
		return instance;
	}

	// Get offer
	public Offer getOffer(Integer id) {
		try {
			return odi.getOffer(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Save offer to offers
	public void saveOffer(Offer o) {
		try {
			odi.saveOffer(o);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Update offer
	private void updateOffer(Offer o) {
		try {
			odi.updateOffer(o);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Get offers by car id
	public List<Offer> getOffersByCar(Integer carId) {
		try {
			return odi.getOffersByCar(carId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	// Accept offer
	public void acceptOffer(Offer o) {
		o.setStatus("Accepted");
		updateOffer(o);
	}
	
	// Reject offer
	public void rejectOffer(Offer o) {
		o.setStatus("Rejected");
		updateOffer(o);
	}
	
	// Get offer id from user
	public Integer getOfferIdInput() {
		Integer id = 0;
		while (true) {
			System.out.println("Enter offer ID number:");
			System.out.print(">>> ");
			try {
				id = sc.nextInt();
				if (getOffer(id) == null) {
					throw new Exception();
				}
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Offer " + id + " does not exist.");
			}
		}
		
		return id;
	}
}
