package com.revature.dao;

import com.revature.beans.Customer;

import java.sql.SQLException;

public interface CustomerDAO {
    void saveCustomer(Customer c) throws SQLException;
    Customer getCustomer(String username) throws SQLException;
    void deleteCustomer(String username) throws SQLException;
}
