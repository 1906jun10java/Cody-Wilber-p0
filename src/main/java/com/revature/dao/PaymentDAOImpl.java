package com.revature.dao;

import com.revature.beans.Car;
import com.revature.beans.Payment;
import com.revature.services.ConnectionService;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    private static ConnectionService cs = ConnectionService.getInstance();
    private Connection connection = cs.getConnection();

    @Override
    public void savePayment(Payment p) throws SQLException {
        String sql = "{ call INSERT_PAYMENT(?,?,?)";
        CallableStatement stmt = connection.prepareCall(sql);
        stmt.setDouble(1, p.getAmount().doubleValue());
        stmt.setInt(2, p.getCarId());
        stmt.setInt(3, p.getCustomerId());
        stmt.execute();
    }

    @Override
    public Payment getPayment(int id) throws SQLException {
        String sql = "SELECT * FROM PAYMENT WHERE PAYMENT_ID = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        Payment p = new Payment();
        if (!rs.isBeforeFirst()) {
            return null;
        }
        while (rs.next()) {
            p.setId(rs.getInt("PAYMENT_ID"));
            p.setAmount(BigDecimal.valueOf(rs.getDouble("PAYMENT_AMOUNT")));
            p.setCarId(rs.getInt("CAR_ID"));
            p.setCustomerId(rs.getInt("CUSTOMER_ID"));
        }

        return p;
    }

    @Override
    public List<Payment> getCarPayments(Car c) throws SQLException {
        String sql = "SELECT * FROM PAYMENT WHERE CAR_ID = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, c.getId());

        ResultSet rs = stmt.executeQuery();
        List<Payment> payments = new ArrayList<>();
        if (!rs.isBeforeFirst()) {
            return null;
        }
        while (rs.next()) {
            Payment p = new Payment();
            p.setId(rs.getInt("PAYMENT_ID"));
            p.setAmount(BigDecimal.valueOf(rs.getDouble("PAYMENT_AMOUNT")));
            p.setCarId(rs.getInt("CAR_ID"));
            p.setCustomerId(rs.getInt("CUSTOMER_ID"));
            payments.add(p);
        }

        return payments;
    }
}
