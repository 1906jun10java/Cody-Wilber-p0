package com.revature.dao;

import com.revature.beans.Payment;

import java.sql.SQLException;

public interface PaymentDAO {
    void savePayment(Payment p) throws SQLException;
    Payment getPayment(int id) throws SQLException;
}
