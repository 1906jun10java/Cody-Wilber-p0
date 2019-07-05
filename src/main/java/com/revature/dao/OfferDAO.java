package com.revature.dao;

import com.revature.beans.Offer;

import java.sql.SQLException;

public interface OfferDAO {
    void saveOffer(Offer o) throws SQLException;
    Offer getOffer(int id) throws SQLException;
}
