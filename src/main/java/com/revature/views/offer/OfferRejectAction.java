package com.revature.views.offer;

import com.revature.services.OfferService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OfferRejectAction {
	private static OfferService os = OfferService.getInstance();
	final static Logger logger = LogManager.getLogger(OfferRejectAction.class);
	
	public OfferRejectAction() {}
	
	public void run() {
		int offerId = os.getOfferIdInput();
		os.rejectOffer(os.getOffer(offerId));
		
		System.out.println("\nOffer rejected.");
		logger.info("OFFER " + offerId + " REJECTED");
	}
}
