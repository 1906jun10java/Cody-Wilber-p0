package com.revature.views.offer;

import java.util.ArrayList;
import com.revature.beans.Car;
import com.revature.beans.Offer;
import com.revature.services.CarService;
import com.revature.services.OfferService;

public class OfferAcceptAction {
	private static OfferService os = OfferService.getInstance();
	private static CarService cs = CarService.getInstance();
	
	public OfferAcceptAction() {}
	
	public void run() {
		Integer offerId = os.getOfferIdInput();
		Offer offer = os.getOffer(offerId);
		
		os.acceptOffer(offerId);
		
		// Assign car to customer
		Car c = cs.getCar(os.getOffer(offerId).getCarId());
		c.setOwnerId(os.getOffer(offerId).getCustomerId());
		c.setPrice(offer.getAmount());
		cs.updateCar(c);
		
		// Reject other offers for same car
		ArrayList<Offer> carOffers = os.getOffersByCar(c.getId());
		for (Offer o : carOffers) {
			if (o.getId().equals(offerId)) {
				os.rejectOffer(o.getId());
			}
		}
		
		System.out.println("\nOffer accepted.");
	}
}
