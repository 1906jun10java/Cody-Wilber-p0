package com.revature.views.offer;

import com.revature.services.OfferService;

public class OfferRejectAction {
	private static OfferService os = OfferService.getInstance();
	
	public OfferRejectAction() {}
	
	public void run() {
		int offerId = os.getOfferIdInput();
		os.rejectOffer(os.getOffer(offerId));
		
		System.out.println("\nOffer rejected.");
	}
}
