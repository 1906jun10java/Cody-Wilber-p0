package com.revature.dao;

import com.revature.beans.Offer;

import java.sql.SQLException;
import java.util.List;

public interface OfferDAO {
    void saveOffer(Offer o) throws SQLException;
    Offer getOffer(int id) throws SQLException;
    List<Offer> getOffersByCar(int carId) throws SQLException;
    void updateOffer(Offer o) throws SQLException;
}
