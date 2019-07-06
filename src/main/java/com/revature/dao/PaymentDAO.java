package com.revature.dao;

import com.revature.beans.Car;
import com.revature.beans.Payment;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDAO {
    void savePayment(Payment p) throws SQLException;
    Payment getPayment(int id) throws SQLException;
    List<Payment> getCarPayments(Car c) throws SQLException;
}
