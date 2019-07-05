package com.revature.dao;

import com.revature.beans.Offer;
import com.revature.services.ConnectionService;

import java.math.BigDecimal;
import java.sql.*;

public class OfferDAOImpl implements OfferDAO {
    private static ConnectionService cs = ConnectionService.getInstance();
    private Connection connection = cs.getConnection();

    @Override
    public void saveOffer(Offer o) throws SQLException {
        String sql = "{ call INSERT_OFFER(?,?,?,?)";
        CallableStatement stmt = connection.prepareCall(sql);
        stmt.setString(1, o.getStatus());
        stmt.setDouble(2, o.getAmount().doubleValue());
        stmt.setInt(3, o.getCarId());
        stmt.setInt(4, o.getCustomerId());
        stmt.execute();
    }

    @Override
    public Offer getOffer(int id) throws SQLException {
        String sql = "SELECT * FROM OFFER WHERE OFFER_ID = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        Offer o = new Offer();
        if (!rs.isBeforeFirst()) {
            return null;
        }
        while (rs.next()) {
            o.setId(rs.getInt("OFFER_ID"));
            o.setStatus(rs.getString("OFFER_STATUS"));
            o.setAmount(BigDecimal.valueOf(rs.getDouble("OFFER_AMOUNT")));
            o.setCarId(rs.getInt("CAR_ID"));
            o.setCustomerId(rs.getInt("CUSTOMER_ID"));
        }

        return o;
    }
}
