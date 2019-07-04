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

import com.revature.beans.Offer;

public class OfferService {
	private static OfferService instance;
	private static ArrayList<Offer> offers = new ArrayList<Offer>();
	private static Scanner sc = new Scanner(System.in);
	
	private OfferService() {}
	
	// Return singleton instance
	public static synchronized OfferService getInstance() {
		if (instance == null) {
			instance = new OfferService();
		}
		return instance;
	}
	
	// Load offers
	@SuppressWarnings("unchecked")
	public void loadOffers() {
		try {
			FileInputStream fis = new FileInputStream("Offers.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			offers = (ArrayList<Offer>)ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	// Save offers
	public void saveOffers() {
		try {
			FileOutputStream fos = new FileOutputStream("Offers.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(offers);
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Get all offers
	public ArrayList<Offer> getOffers() {
		return offers;
	}
	
	// Save offer to offers
	public void saveOffer(Offer o) {
		offers.add(o);
		saveOffers();
	}
	
	// Update offer
	public void updateOffer(Offer o) {
		ListIterator<Offer> it = offers.listIterator();
		while (it.hasNext()) {
			if (it.next().getId().equals(o.getId())) {
				it.remove();
				it.add(o);
				saveOffers();
				break;
			}
		}
	}
	
	// Get offer from offers
	public Offer getOffer(Integer id) {
		for (Offer o : offers) {
			if (o.getId().equals(id)) {
				return o;
			}
		}
		return null;
	}
	
	// Get offers by car id
	public ArrayList<Offer> getOffersByCar(Integer carId) {
		ArrayList<Offer> offers = new ArrayList<Offer>();
		
		ListIterator<Offer> it = offers.listIterator();
		while (it.hasNext()) {
			if (it.next().getCarId().equals(carId)) {
				offers.add(it.next());
			}
		}
		
		return offers;
	}
	
	// Accept offer
	public void acceptOffer(Integer id) {
		Offer o = getOffer(id);
		o.setStatus("Accepted");
		updateOffer(o);
	}
	
	// Reject offer
	public void rejectOffer(Integer id) {
		Offer o = getOffer(id);
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
